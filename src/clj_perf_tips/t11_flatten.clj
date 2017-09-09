(ns clj-perf-tips.t11-flatten
  (:require [libra.bench :refer :all]
            [libra.criterium :refer [bench]]))

(defn flatten1 [xs]
  (flatten xs))

(defn flatten2 [xs]
  (apply concat xs))

(defn flatten3 [xs]
  (mapcat identity xs))

(defbench t11-flatten-bench
  (let [coll [[1 2 3] [4 5 6]]]
    (is (bench (dotimes [_ 10000]
                 (flatten1 coll)))
        "flatten1")
    (is (bench (dotimes [_ 10000]
                 (flatten2 coll)))
        "flatten2")
    (is (bench (dotimes [_ 10000]
                 (flatten3 coll)))
        "flatten3")))
