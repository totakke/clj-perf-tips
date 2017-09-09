(ns clj-perf-tips.t09-data-calc-order
  (:require [libra.bench :refer :all]
            [libra.criterium :refer [bench]]))

(def alist (list* (range 1000)))

(def avec (vec (range 1000)))

(defbench t09-data-calc-order-bench1
  (is (bench (dotimes [_ 100000] (nth alist 999))) "nth to list")
  (is (bench (dotimes [_ 100000] (nth avec 999))) "nth to vector"))

(defbench t09-data-calc-order-bench2
  (is (bench (dotimes [_ 100000] (last avec))) "last to vector")
  (is (bench (dotimes [_ 100000] (peek avec))) "peek to vector"))
