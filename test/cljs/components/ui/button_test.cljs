(ns components.ui.button-test
  (:require
   [cljs.test :refer (testing deftest is)]
   [components.ui.button :as b]))

(deftest no-supplied-options
  (testing "If called without overrides, return defaults for each key."
    (with-redefs [b/button-variants {:class-name "default"
                                     :variant {:default "default"}
                                     :size {:default "default"}}]
      (is (= (b/button-style {})
             {:class-name "default default default"})))))

(deftest variant-keyword-found
  (testing "Returns variant data for a found keyword variant"
    (with-redefs [b/button-variants {:class-name "default"
                                     :variant {:default "default"
                                               :test "test"}
                                     :size {:default "default"}}]
      (is (= (b/button-style {:variant :test})
             {:class-name "default test default"})))))

(deftest size-keyword-found
  (testing "Returns size data for given keyword size"
    (with-redefs [b/button-variants {:class-name "default"
                                     :variant {:default "default"}
                                     :size {:default "default"
                                            :test "test"}}]
      (is (= (b/button-style {:size :test})
             {:class-name "default default test"})))))

(deftest variant-keyword-not-found
  (testing "Returns default if the given keyword is not found"
    (with-redefs [b/button-variants {:class-name "default"
                                     :variant {:default "default"}
                                     :size {:default "default"}}]
      (is (= (b/button-style {:variant :test})
             {:class-name "default default default"})))))

(deftest size-keyword-not-found
  (testing "Returns default if the given keyword is not found"
    (with-redefs [b/button-variants {:class-name "default"
                                     :variant {:default "default"}
                                     :size {:default "default"}}]
      (is (= (b/button-style {:size :test})
             {:class-name "default default default"})))))

(deftest additional-class-name-injection
  (testing "Additional class names are merged into the result"
    (with-redefs [b/button-variants {:class-name "default"
                                     :variant {:default "default"}
                                     :size {:default "default"}}]
      (is (= (b/button-style {:class-name "addition"})
             {:class-name "default default default addition"})))))

;; TODO
;; adding in additional class names should override the old ones, there's a
;; tailwind method call for this if it becomes an issue

(deftest button-ref
  (testing "A supplied button ref is included in the returned component"
    (is (= (.-ref (b/button {:ref "test"}))
           "test"))))

;; TODO these haven't been used yet, I can implement them later
;; ... props (this looks to be the button content)

;; is loading injector

;; child injector
