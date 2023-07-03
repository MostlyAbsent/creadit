(ns components.user-auth-form
  (:require-macros
   [app.lib :as l])
  (:require
   [helix.dom :as d]
   [utils :as u]
   [components.ui.button :as b]))

(l/defnc user-auth-form [{:keys [class-name]}]
  (d/div
   {:class (b/button-style {:size :sm
                            :class-name (u/tw-merge class-name "flex justify-center mx-auto")})}
   "Google"))
