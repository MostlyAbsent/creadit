(ns app.core
  (:require
   ["react-dom/client" :as rdom]
   [helix.core :refer [$]]
   [helix.dom :as d])
  (:require-macros
   [app.lib :as l]))

(l/defnc app []
  (d/h1
   {:class-name "text-red-400"}
   "hellope"))

(defn ^:export init []
  (defonce root (rdom/createRoot (js/document.getElementById "app")))
  (.render root ($ app)))
