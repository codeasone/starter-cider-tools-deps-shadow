(ns starter-cider-tools-deps-shadow.counter
  (:require [devcards.core :refer [defcard]]
            [uix.core.alpha :as uix])

  (:require-macros [devcards.core :refer [defcard]]))

(defn button [{:keys [on-click]} text]
  [:button {:on-click on-click}
   text])

(defn counter []
  (let [state* (uix/state 0)]
    [:<>
     [button {:on-click #(swap! state* dec)} "-"]
     [:span @state*]
     [button {:on-click #(swap! state* inc)} "+"]]))

(defcard app-card
  (uix/as-element
   [counter]))
