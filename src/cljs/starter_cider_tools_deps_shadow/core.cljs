(ns starter-cider-tools-deps-shadow.core
  (:require [starter-cider-tools-deps-shadow.counter :as counter]
            [uix.dom.alpha :as uix.dom]))

(defn app []
  [counter/counter])

(defn ^:dev/after-load start []
  (js/console.log "start")
  (uix.dom/render [app] (.getElementById js/document "app")))

(defn ^:export init []
  (js/console.log "init")
  (start))

(defn ^:dev/before-load stop []
  (js/console.log "stop"))
