(ns components.icons
  (:require
   ["lucide-react" :refer [Biohazard]]
   [helix.core :refer [$ defnc]]))

(defn logo [props]
  ($ Biohazard {:class "" & props
                :width nil
                :height nil}))
