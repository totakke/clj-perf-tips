(ns clj-perf-tips.t11-flatten
  (:require [criterium.core :as c]))

(defn flatten1 [xs]
  (flatten xs))

(defn flatten2 [xs]
  (apply concat xs))

(defn flatten3 [xs]
  (mapcat identity xs))

(defn bench []
  (let [coll [[1 2 3] [4 5 6]]]
    (println "flatten1:")
    (c/bench
     (dotimes [_ 10000]
       (flatten1 coll)))

    (println "flatten2:")
    (c/bench
     (dotimes [_ 10000]
       (flatten2 coll)))

    (println "flatten3:")
    (c/bench
     (dotimes [_ 10000]
       (flatten3 coll)))))
