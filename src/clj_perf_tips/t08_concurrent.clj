(ns clj-perf-tips.t08-concurrent
  (:require [libra.bench :refer :all]
            [clj-perf-tips.common :refer [bench]]))

(defn inc-after [n]
  (Thread/sleep 10)
  (inc n))

(defbench t08-concurrent-bench
  (measure (bench (dorun (pmap inc-after (range 100)))) "concurrent")
  (measure (bench (dorun (map inc-after (range 100)))) "not concurrent"))
