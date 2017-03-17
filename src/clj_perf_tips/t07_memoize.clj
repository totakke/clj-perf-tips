(ns clj-perf-tips.t07-memoize
  (:require [criterium.core :as c]))

(defn a [n]
        (reduce + (range (inc n))))

(def a (memoize a))

(defn b [n]
        (reduce + (range (inc n))))

(defn bench []
  (println "w/ memoize")
  (c/bench
   (dotimes [_ 1000000] (a 10)))

  (println "w/o memoize")
  (c/bench
   (dotimes [_ 1000000] (b 10))))
