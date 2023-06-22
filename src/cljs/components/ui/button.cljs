(ns components.ui.button
  (:require
   [helix.dom :as d]
   [cljs.pprint])
  (:require-macros
   [app.lib :as l]))

(def button-variants
  {:class-name
   "active:scale-95 inline-flex items-center justify-center rounded-md text-sm font-medium transition-colors focus:outline-none focus:ring-2 focus:ring-slate-400 focus:ring-offset-2 disabled:opacity-50 dark:focus:ring-slate-400 disabled:pointer-events-none dark:focus:ring-offset-slate-900"
   :variant
   {:default
    "bg-zinc-900 text-zinc-100 hover:bg-zinc-800"
    :destructive
    "text-white hover:bg-red-600 dark:hover:bg-red-600"
    :outline
    "bg-zinc-100 text-zinc-900 hover:bg-zinc-200 outline outline-1 outline-zinc-300"
    :subtle
    "hover:bg-zinc-200 bg-zinc-100 text-zinc-900"
    :ghost
    "bg-transparent hover:bg-zinc-100 text-zinc-800 data-[state=open]:bg-transparent data-[state=open]:bg-transparent"
    :link
    "bg-transparent dark:bg-transparent underline-offset-4 hover:underline text-slate-900 dark:text-slate-100 hover:bg-transparent dark:hover:bg-transparent"}
   :size
   {:default
    "h-10 py-2 px-4"
    :sm
    "h-9 px-2 rounded-md"
    :xs
    "h-8 px-1.5 rounded-sm"
    :lg
    "h-11 px-8 rounded-md"}})

(defn button-style [{:keys [variant size class-name]}]
  {:class-name (str (:class-name button-variants) " "
                    (if (nil? variant)
                      (:default (:variant button-variants))
                      (or (variant (:variant button-variants))
                          (:default (:variant button-variants)))) " "
                    (if (nil? size)
                      (:default (:size button-variants))
                      (or (size (:size button-variants))
                          (:default (:size button-variants))))
                    (if (not (nil? class-name))
                      (str " " class-name)))})

(defn button [{:keys [variant size class-name ref]}]
  (d/button {:ref ref
             :props (button-style {:variant variant :size size :class-name class-name})}))
