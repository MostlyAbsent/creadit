(ns app.core
  (:require
   ["react" :as r]
   ["react-dom/client" :as rdom]
   [components.navbar :refer [navbar]]
   [helix.core :refer [$ provider]]
   [reitit.frontend :as rf]
   [helix.hooks :as h]
   [reitit.frontend.easy :as rfe]
   [reitit.coercion.spec :as rss]
   [helix.dom :as d])
  (:require-macros
   [app.lib :as l]))

(def match (atom nil))

(l/defnc home []
  (d/div "home"))

(l/defnc app []
  (d/div
   {:class-name "bg-white text-slate-900 antialiased light"}
   ($ navbar)
   (d/div
    {:class-name "min-h-screen pt-12 bg-slate-50 antialiased"}
    (d/div
     {:class-name "container max-w-7xl h-full pt-12"}
     (if @match
       (let [view (:view (:data @match))]
         ($ view)))))))

(def routes
  [["/"
    {:name ::homepage
     :view home}]])

(defn ^:export init []
  (rfe/start!
   (rf/router routes {:data {:coercion rss/coercion}})
   (fn [m] (reset! match m))
   {:use-fragment true})
  (defonce root (rdom/createRoot (js/document.getElementById "app")))
  (.render root ($ app)))
