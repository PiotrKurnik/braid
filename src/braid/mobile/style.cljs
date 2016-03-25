(ns braid.mobile.style
  (:require [garden.core :refer [css]]
            [garden.stylesheet :refer [at-import]]
            [garden.arithmetic :as m]
            [garden.units :refer [rem vw vh]]))

(defn tee [x]
  (println x) x)

(def styles
  (let [pad (vw 5)]
    (css [:.sidebar
          {:background "red"}
          [:.content
           {:width "100%"
            :padding pad
            :box-sizing "border-box"}
           (let [icon-w "15vw"]
             [:.group
              {:display "block"
               :width "100%"
               :margin-bottom "1rem"
               :position "relative"}
              [:&.active:before
               (let [w "2vw"]
                 {:content "\"\""
                  :display "block"
                  :width w
                  :background "#eee"
                  :height icon-w
                  :position "absolute"
                  :left (m/- pad)
                  :border-radius (str 0 " " w " " w " " 0)
                  })]
              [:img
               {:width icon-w
                :height icon-w
                :background "white"
                :border-radius "0.5rem"
                :vertical-align "middle"}]
              [:.badge
               {:font-size "0.8rem"
                :padding "0 0.5em"
                :border-radius "0.5em"
                :display "inline-block"
                :line-height "1.75em"
                :background "#B53737"
                :color "white"
                :border-color "#B53737"
                :position "absolute"
                :bottom "-0.5rem"
                :right "-0.5rem"}]])]]

         [:.page
          {:position "absolute"
           :top 0
           :left 0
           :right 0
           :bottom 0
           :overflow "hidden"
           :z-index 50
           :background "#CCC"
           }]

         [:.threads
          [:.thread
           {:width "100vw"
            :height "100vh"
            :background "white" }]])))
