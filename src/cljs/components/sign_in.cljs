(ns components.sign-in
  (:require-macros
   [app.lib :as l])
  (:require
   ["react-router-dom" :as rr]
   [helix.dom :as d]
   [helix.core :refer [$]]
   [components.ui.button :as b]
   [components.user-auth-form :as uaf]
   [components.icons :as icons]))

(defn sign-in-pop-up []
  (d/div
   {:class "container mx-auto flex w-full flex-col justify-center space-y-6 sm:w-[400px]"}
   (d/div
    {:class "flex flex-col space-y-2 text-center"}
    ($ icons/logo
       {:class "mx-auto h-6 w-6"})
    (d/h1
     {:class "text-2xl font-semibold tracking-tight"}
     "Welcome Back")
    (d/p
     {:class "text-sm max-w-xs mx-auto"}
     "By continuing, you are setting up a Creadit account and agree to our User Agreement and Privacy Policy.")
    ($ uaf/user-auth-form {:class-name "w-full"})
    (d/p
     {:class "px-8 text-center text-sm text-zinc-700"}
     "New to Creadit? "
     ($ rr/Link
        {:to "/sign-up"
         :class "hover:text-zinc-800 text-sm underline underline-offset-4"}
        "Sign Up")))))

(l/defnc sign-in-page []
  (d/div
   {:class "absolute inset-0"}
   (d/div
    {:class "h-full max-w-2xl mx-auto flex flex-col item-center justify-center gap-20"}
    ($ rr/Link
       {:to "/"
        :class (b/button-style {:variant :ghost
                                :class-name "self-start -mt-20"})}
       "Home")
    (sign-in-pop-up))))
