(ns starter-cider-tools-deps-shadow.server
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [hiccup.page :refer [html5 include-js]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.util.response :refer [not-found]]))

(defn index-html []
  (html5
   [:head
    [:meta {:charset "UTF-8"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1"}]
    [:title "shadow-cljs + UIX"]]
   [:body
    [:h1 "shadow-cljs + UIX"]
    [:div {:id "app"}]
    (include-js "http://localhost:8123/js/main.js")
    [:script "starter_cider_tools_deps_shadow.core.init();"]]))

(defn devcards-html []
  (html5
   [:head
    [:meta {:charset "UTF-8"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1"}]
    [:title "Devcards"]]
   [:body
    [:div {:id "app"}]
    (include-js "http://localhost:8123/js/devcards/main.js")
    [:script "starter_cider_tools_deps_shadow.devcards.init();"]]))

(defroutes routes
  (GET "/" [] (index-html))
  (GET "/devcards" [] (devcards-html))
  (route/not-found (not-found "Not found")))

(def app
  (-> routes
      (wrap-resource "public")))
