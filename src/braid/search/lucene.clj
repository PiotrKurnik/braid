(ns braid.search.lucene
  (:require
   [clucie.core]
   [clucie.analysis]
   [clucie.store]))

;; TODO
;; tweak standard analyzer
;; use file store index in prod
;; only pass necessary keys to lucene
;; is there a way to have uuid stored as uuid instead of string?
;; add function to add old messages to index

;; maybe: change search to only respond with thread-ids (client then asks for threads it doesn't know)
;; autocomplete tags in search bar

(defonce analyzer (clucie.analysis/standard-analyzer))

(defonce index-store (clucie.store/memory-store))

(defn index-message! [message]
  (println "ADD TO INDEX" message)
  (clucie.core/add! index-store
                    [message]
                    [:content]
                    analyzer))


(defn search [query]
  (println "SEARCH INDEX" query)
  (->> (clucie.core/search
        index-store
        [{:content query}]
        1000 ; max-num
        analyzer
        0 ; page
        1000 ; max-num-per-page
        )
        (map (fn [message] [(java.util.UUID/fromString (message :thread-id)) (java.util.Date.)]))
        set))
  
