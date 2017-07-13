(ns clj-perf-tips.t10-map-record
  (:require [libra.bench :refer :all]
            [clj-perf-tips.common :refer [bench]]))

(def p1 {:x 10, :y 20, :z 30})

(defrecord Point [x y z])

(def p2 (->Point 10 20 30))

(defbench t10-map-record-bench
  (measure (bench (dotimes [_ 10000000] (:y p1))) "map")
  (measure (bench (dotimes [_ 10000000] (:y p2))) "record w/ keyword access")
  (measure (bench (dotimes [_ 10000000] (.y ^Point p2))) "record w/ Java access"))
