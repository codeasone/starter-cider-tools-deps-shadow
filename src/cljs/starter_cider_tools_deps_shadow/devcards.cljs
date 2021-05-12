(ns starter-cider-tools-deps-shadow.devcards
  (:require [devcards.core :as dc]
            [starter-cider-tools-deps-shadow.counter]))

(defn ^:export init []
  (enable-console-print!)
  (prn "Starting devcards...")
  (dc/start-devcard-ui!))
