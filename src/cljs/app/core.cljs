(ns app.core
  (:require
   ["react" :as r]
   [helix.core :refer [$]]
   ["react-router-dom" :as rr]
   ["react-dom/client" :as rdom]
   [components.navbar :refer [navbar]]
   [helix.hooks :as h]
   [helix.dom :as d])
  (:require-macros
   [app.lib :as l]))

(l/defnc home []
  (d/div "home"))

(l/defnc sign-in []
  (d/div "sign in"))

(l/defnc app []
  ($ rr/BrowserRouter
     (d/section
      {:class-name "bg-white text-slate-900 antialiased light"}
      ($ navbar)
      (d/div
       {:class-name "min-h-screen pt-12 bg-slate-50 antialiased"}
       ($ rr/Routes
          ($ rr/Route
             {:path "/"
              :element ($ home)})
          ($ rr/Route
             {:path "/sign-in"
              :element ($ sign-in)}))))))

(defn ^:export init []
  (defonce root (rdom/createRoot (js/document.getElementById "app")))
  (.render root ($ app)))
