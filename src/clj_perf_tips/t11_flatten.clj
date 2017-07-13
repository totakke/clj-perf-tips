(ns clj-perf-tips.t11-flatten
  (:require [libra.bench :refer :all]
            [clj-perf-tips.common :refer [bench]]))

(defn flatten1 [xs]
  (flatten xs))

(defn flatten2 [xs]
  (apply concat xs))

(defn flatten3 [xs]
  (mapcat identity xs))

(defbench t11-flatten-bench
  (let [coll [[1 2 3] [4 5 6]]]
    (measure (bench (dotimes [_ 10000]
                      (flatten1 coll)))
             "flatten1")
    (measure (bench (dotimes [_ 10000]
                      (flatten2 coll)))
             "flatten2")
    (measure (bench (dotimes [_ 10000]
                      (flatten3 coll)))
             "flatten3")))
