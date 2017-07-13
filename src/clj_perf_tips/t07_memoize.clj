(ns clj-perf-tips.t07-memoize
  (:require [libra.bench :refer :all]
            [clj-perf-tips.common :refer [bench]]))

(defn a [n]
        (reduce + (range (inc n))))

(def a (memoize a))

(defn b [n]
        (reduce + (range (inc n))))

(defbench t07-memoize-bench
  (measure (bench (dotimes [_ 1000000] (a 10))) "w/ memoize")
  (measure (bench (dotimes [_ 1000000] (b 10))) "w/o memoize"))
