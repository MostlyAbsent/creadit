(ns app.core
  (:require
   ["react-dom/client" :as rdom]
   ["lucide-react" :refer [BookMarked]]
   [helix.core :refer [$]]
   [helix.dom :as d])
  (:require-macros
   [app.lib :as l]))

(l/defnc app []
  (d/div (d/h1
          {:class-name "text-red-400"}
          "hellope")
         ($ BookMarked)))

(defn ^:export init []
  (defonce root (rdom/createRoot (js/document.getElementById "app")))
  (.render root ($ app)))
