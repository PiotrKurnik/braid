(ns braid.core.client.gateway.forms.user-auth.styles
  (:require
   [braid.core.client.gateway.styles-vars :as vars]
   [braid.core.client.ui.styles.fontawesome :as fontawesome]
   [braid.core.client.ui.styles.mixins :as mixins]))

(defn user-auth-styles []
  [:.gateway

   [:>.user-auth

    [:p
     (vars/small-text-mixin)

     [:button
      (vars/small-button-mixin)]]

    [:.auth-providers
     {:display "inline"}

     [:>button
      {:margin "0 0.5em"}

      [:&::before
       {:margin "0 0.35em 0 0.15em"}]

      [:&.google
       [:&::before
        (fontawesome/mixin :google)]]

      [:&.github
       [:&::before
        (fontawesome/mixin :github)]]

      [:&.facebook
       [:&::before
        (fontawesome/mixin :facebook)]]]]

    [:.option

     [:&.password
      [:input
       {:width "15em"}]]

     [:&.email
      [:input
       {:width "15em"}]]]

    [:&.authed-user

     [:>.profile
      (vars/padded-with-border-mixin)
      {:height "3rem"}

      [:>.avatar
       {:float "left"
        :height "3rem"
        :width "3rem"
        :margin-right "0.5em"}]

      [:>.info
       {:margin [["0.25rem" 0]]
        :line-height "1.25rem"
        :color vars/secondary-text-color
        :font-size "0.8em"}

       [:>.nickname
        {:color vars/primary-text-color
         :font-weight "bold"}]

       [:>.email
        {}]]]

     [:>p
      {:text-align "center"
       :margin-top "2rem"}]]

    [:&.checking
     :&.authorizing

     [:>div
      (vars/padded-with-border-mixin)
      {:height "3rem"}

      [:>span
       {:font-size "0.8em"
        :color vars/secondary-text-color}]

      [:&::before
       mixins/spin
       (fontawesome/mixin :spinner)
       {:display "inline-block"
        :margin-right "0.5em"
        :font-size "2rem"
        :vertical-align "middle"
        :color vars/accent-color}]]]

    [:&.returning-user
     :&.new-user
     :&.request-password-reset

     [:>form
      {:position "relative"}

      [:>fieldset

       [:>p
        {:position "absolute"
         :top 0
         :right 0
         :margin 0
         :line-height "2rem"}]]]]]])

(defn alternative-login-styles []
  [:.gateway
   [:button vars/small-button-mixin]
   ]
  )

