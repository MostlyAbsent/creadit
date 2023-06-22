(ns utils-test
  (:require
   [cljs.test :refer (testing deftest is)]
   [utils :as u]))

(deftest count-replacement
  (testing "Confirm that counts are being injected into the format"
    (is (= (u/format-distance "minutes" 5)
           "5m"))))

(deftest token-not-found
  (testing "If the supplied token is not found in the locale, return nil"
    (is (nil? (u/format-distance {:token :test
                                  :count 5})))))

(deftest add-temporal-context
  (testing "Add temporal context with suffix ago."
    (is (= (u/add-temporal-context "test" nil)
           "test ago")))
  (testing "Optionally add prefix in"
    (is (= (u/add-temporal-context "test" :true)))))
