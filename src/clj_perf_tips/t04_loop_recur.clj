(ns clj-perf-tips.t04-loop-recur
  (:require [libra.bench :refer :all]
            [clj-perf-tips.common :refer [bench]]))

(defn odd-sum1 []
  (loop [i 1, s 0]
    (if (< i 10000000)
      (recur (+ i 2) (+ s i))
      s)))

(defn odd-sum2 []
  (->> (range 10000000)
       (filter odd?)
       (reduce +)))

(defbench t04-loop-recur-bench
  (measure (bench (odd-sum1)) "odd-sum1")
  (measure (bench (odd-sum2)) "odd-sum2"))
