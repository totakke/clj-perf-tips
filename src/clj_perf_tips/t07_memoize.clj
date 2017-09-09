(ns clj-perf-tips.t07-memoize
  (:require [libra.bench :refer :all]
            [libra.criterium :refer [bench]]))

(defn a [n]
        (reduce + (range (inc n))))

(def a (memoize a))

(defn b [n]
        (reduce + (range (inc n))))

(defbench t07-memoize-bench
  (is (bench (dotimes [_ 1000000] (a 10))) "w/ memoize")
  (is (bench (dotimes [_ 1000000] (b 10))) "w/o memoize"))
