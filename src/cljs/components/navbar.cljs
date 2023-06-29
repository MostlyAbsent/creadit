(ns components.navbar
  (:require
   ["react-router-dom" :as rr]
   [components.icons :as icons]
   [helix.core :refer [$]]
   [helix.dom :as d]
   [components.ui.button :as b])
  (:require-macros
   [app.lib :as l]))

(l/defnc navbar []
  (d/div
   {:class "fixed top-0 inset-x-0 h-fit bg-zinc-100 border-b border-zinc-300 z-[10] py-2"}
   (d/div
    {:class "container max-w-7xl h-full mx-auto flex items-center justify-between gap-2"}
    ($ rr/Link
       {:to "/"
        :class "flex gap-2 items-center"}
       ($ icons/logo  {:class "w-8 h-8 sm:h-6 sm:w-6"})
       (d/p
        {:class "hidden text-zinc-700 text-sm font-medium md:block"} "Creadit"))
    ($ rr/Link
     {:to "/sign-in"
      :class (b/button-variants {})}
     "Sign In"))))
