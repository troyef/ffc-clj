(ns ffc.core
  (:use [compojure.core :only (defroutes GET)]
        [ring.adapter.jetty :as ring])
  (:use [hiccup.page :only (html5)])
  (:use [ffc.riverdata :as riverdata]) )
  
  (defn index []
    (html5
      [:head
        [:title "Hello World"]]
      [:body
        [:div {:id "content"} "Hello World"]]))
  
  (defroutes routes
    (GET "/raw/:river" [river] (riverdata/raw river))
    (GET "/:river" [river] (riverdata/current river)))

  (defn -main []
    (run-jetty #'routes {:port 8080 :join? false}))
