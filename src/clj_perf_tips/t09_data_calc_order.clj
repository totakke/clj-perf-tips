(ns clj-perf-tips.t09-data-calc-order
  (:require [libra.bench :refer :all]
            [clj-perf-tips.common :refer [bench]]))

(def alist (list* (range 1000)))

(def avec (vec (range 1000)))

(defbench t09-data-calc-order-bench1
  (measure (bench (dotimes [_ 100000] (nth alist 999))) "nth to list")
  (measure (bench (dotimes [_ 100000] (nth avec 999))) "nth to vector"))

(defbench t09-data-calc-order-bench2
  (measure (bench (dotimes [_ 100000] (last avec))) "last to vector")
  (measure (bench (dotimes [_ 100000] (peek avec))) "peek to vector"))
