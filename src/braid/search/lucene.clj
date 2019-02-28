(ns braid.search.lucene
  (:require
   [clucie.core]
   [clucie.analysis]
   [clucie.store]
   [clojure.string :as str]
   [braid.core.server.conf :refer [config]]))


;; TODO
;; use file store index in prod
;; add function to add old messages to index
;; return tag search in braid.search.server

 
;; LATER
;; show error when qp-parser fails
;; fix search bar drop characters
;; fix 'timeout' message when do long/bad search followed by a good one
;; only pass necessary keys to lucene
;; when searching, show ui underneath showing query parser rules  ? * ~ 
;; is there a way to have uuid stored as uuid instead of string?
;; maybe: change search to only respond with thread-ids (client then asks for threads it doesn't know)
;; autocomplete tags in search bar

(defonce analyzer (clucie.analysis/standard-analyzer))

                                        ;"/home/piotr/ClojureProjects/braid/lucene-dir"

#_(defonce index-store (clucie.store/disk-store
                      (config :lucene-dir)))



(defonce index-store (clucie.store/memory-store ))

(defn index-message! [message]
  (println "ADD TO INDEX" message)
  (clucie.core/add! index-store
                    [message]
                    [:content]
                    analyzer))

(defn search [query]
  (->> (clucie.core/qp-search
        index-store
        [{:content query}]
        1000 ; max-num
        analyzer
        0 ; page
        1000 ; max-num-per-page
        )
        (map (fn [message] [(java.util.UUID/fromString (message :thread-id)) (java.util.Date.)]))
        set))
  
