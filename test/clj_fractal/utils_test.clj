(ns clj-fractal.utils-test
  (:require [clojure.test :refer :all]
            [clj-fractal.utils :refer :all]))

(deftest test-nest-while-function
  (testing "Should produce empty list of initial value"
    (is (empty? (nest-while (fn [x] (> x 16)) (fn [x] (/ x 2)) 8))))
  (testing "Should produce list with one element."
    (is (= '(32) (nest-while (fn [x] (> x 16)) (fn [x] (/ x 2)) 32)))))


(deftest test-average-function
  (testing "should not produce exception on empty list"
    (is (= 0.0 (average []))))
  (testing "list with one elemnt should equal to itself"
    (is (= 3.0 (average [3.0]))))
  (testing "list average of more elements"
    (is (= 2.5 (average [2.0 3.0])))))

(deftest test-sd-function
  (testing "should produce 0.0 instead of raise exception on empty list"
    (is (= 0.0 (sd []))))
  (testing "should produce 0.0 on one element list"
    (is (= 0.0 (sd [3.0]))))
  (testing "should produce 0.0 on all equal list"
    (is (= 0.0 (sd [4 4 4 4 4]))))
  (testing "normal case"
    (is (= 0.816496580927726 (sd [1 2 3])))))
