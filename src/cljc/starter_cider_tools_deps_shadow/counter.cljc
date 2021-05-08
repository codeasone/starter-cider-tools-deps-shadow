(ns starter-cider-tools-deps-shadow.counter
  (:require [uix.core.alpha :as uix]))

(defn button [{:keys [on-click]} text]
  [:button {:on-click on-click}
   text])

(defn counter []
  (let [state* (uix/state 0)]
    [:<>
     [button {:on-click #(swap! state* dec)} "-"]
     [:span @state*]
     [button {:on-click #(swap! state* inc)} "+"]]))
