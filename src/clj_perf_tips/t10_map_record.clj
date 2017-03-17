(ns clj-perf-tips.t10-map-record
  (:require [criterium.core :as c]))

(def p1 {:x 10, :y 20, :z 30})

(defrecord Point [x y z])

(def p2 (->Point 10 20 30))

(defn bench []
  (println "map")
  (c/bench
   (dotimes [_ 10000000] (:y p1)))

  (println "record w/ keyword access")
  (c/bench
   (dotimes [_ 10000000] (:y p2)))

  (println "record w/ Java access")
  (c/bench
   (dotimes [_ 10000000] (.y ^Point p2))))
