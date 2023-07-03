(ns app.core
  (:require
   ["react" :as r]
   [helix.core :refer [$]]
   ["react-router-dom" :as rr]
   ["react-dom/client" :as rdom]
   [components.navbar :refer [navbar]]
   [components.sign-in :refer [sign-in-page]]
   [helix.hooks :as h]
   [helix.dom :as d])
  (:require-macros
   [app.lib :as l]))

(l/defnc home []
  (d/div "Home"))

(l/defnc app []
  ($ rr/BrowserRouter
     (d/section
      {:class-name "bg-white text-slate-900 antialiased light"}
      (d/div
       {:class-name "min-h-screen pt-12 bg-slate-50 antialiased"}
      ($ navbar)
       (d/div
        {:class-name "container max-w-7xl mx-auto h-full pt-12"}
        ($ rr/Routes
           ($ rr/Route
              {:path "/"
               :element ($ home)})
           ($ rr/Route
              {:path "/sign-in"
               :element ($ sign-in-page)})))))))

(defn ^:export init []
  (defonce root (rdom/createRoot (js/document.getElementById "app")))
  (.render root ($ app)))
