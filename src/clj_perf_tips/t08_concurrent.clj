(ns clj-perf-tips.t08-concurrent
  (:require [libra.bench :refer :all]
            [libra.criterium :refer [bench]]))

(defn inc-after [n]
  (Thread/sleep 10)
  (inc n))

(defbench t08-concurrent-bench
  (is (bench (dorun (pmap inc-after (range 100)))) "concurrent")
  (is (bench (dorun (map inc-after (range 100)))) "not concurrent"))
