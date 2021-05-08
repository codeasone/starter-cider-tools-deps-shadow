(ns shadow.user
  (:require [compojure.handler :as handler]
            [ring.adapter.jetty :as jetty]
            [starter-cider-tools-deps-shadow.server :as server]))

(def site (handler/site server/app))

(defonce ^:dynamic server nil)

(defn stop
  []
  (when server
    (.stop server)))

(defn start
  [& [port]]
  (stop)
  (alter-var-root
   #'server
   (constantly
    (jetty/run-jetty #'site
                     {:port (Long. (or port 5000))
                      :join? false}))))
