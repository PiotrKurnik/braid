(ns braid.search.lucene
  (:require
   [clucie.core]
   [clucie.analysis]
   [clucie.store]))

;; TODO
;; use file store index in prod
;; only pass necessary keys to lucene


(def analyzer (clucie.analysis/standard-analyzer))

(def index-store (clucie.store/memory-store))

(defn add-message! [message]
  (clucie.core/add! index-store
                    [message]
                    [:content]
                    analyzer))


(defn search [query]
  (->> (clucie.core/search
        index-store
        [{:content query}]
        1000 ; max-num
        analyzer
        0 ; page
        1000 ; max-num-per-page)
        (map :thread-id)
        set)))
  
