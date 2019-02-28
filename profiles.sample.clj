; Rename this file to profiles.clj
; Run `lein with-profile +braid repl`

{:braid
 {:env
  {;; for invite emails:
   :mailgun-domain "braid.mysite.com"
   :mailgun-password "my_mailgun_key"
   :site-url "http://localhost:5555"
   :hmac-secret "foobar"
   ;; for avatar and file uploads
   :aws-domain "braid.mysite.com"
   :aws-access-key "my_aws_key"
   :aws-secret-key "my_aws_secret"
   ;; for link info extraction
   :embedly-key "embedly api key"
   ;; for github login
   :github-client-id "..."
   :github-client-secret "..."
   :google-maps-api-key "" 
   :lucene-dir "/home/piotr/ClojureProjects/lucene-dir"
   }
  }
 }
