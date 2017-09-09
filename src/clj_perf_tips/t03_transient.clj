(ns clj-perf-tips.t03-transient
  (:require [libra.bench :refer :all]
            [libra.criterium :refer [bench]]))

;; w/ transient
(defn fn1 [n]
  (loop [i n, v (transient [])]
    (if (pos? i)
      (recur (dec i) (conj! v i))
      (persistent! v))))

;; w/o transient
(defn fn2 [n]
  (loop [i n, v []]
    (if (pos? i)
      (recur (dec i) (conj v i))
      v)))

(defbench t03-transient-bench
  (is (bench (dorun (fn1 1000000))) "w/ transient")
  (is (bench (dorun (fn2 1000000))) "w/o transient"))
