(ns clj-perf-tips.t05-const-var
  (:require [libra.bench :refer :all]
            [libra.criterium :refer [bench]]))

(def ^:const a 10)

(def b 10)

(defbench t05-const-var-bench
  (is (bench (dotimes [_ 10000000]
               (inc a)))
      "w/ const")
  (is (bench (dotimes [_ 10000000]
               (inc b)))
      "w/o const"))
