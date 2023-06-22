(ns utils
  (:require ["date-fns" :as df]))

(def format-distance-locale
  {"minutes" "{{count}}m"
   "hours" "{{count}}h"
   "days" "{{count}}d"
   "weeks" "{{count}}w"
   "months" "{{count}}m"
   "years" "{{count}}y"})

(defn format-distance [token count]
  (if (not (nil? (get format-distance-locale token)))
    (.replace (get format-distance-locale token) "{{count}}" (.toString count))
    nil))

(defn add-temporal-context [distance comparison]
  (if (not (nil? comparison))
    (str "in" " " distance)
    (if (= distance "just now")
      distance
      (str distance " " "ago"))))

(defn format-time-to-now [date comparison]
  (let [[count token] (-> (df/formatDistanceToNowStrict date)
                          (.split " "))]
    (-> (format-distance token count)
        (add-temporal-context comparison))))
