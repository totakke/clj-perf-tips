(ns clj-perf-tips.t04-loop-recur
  (:require [criterium.core :as c]))

(defn odd-sum1 []
  (loop [i 1, s 0]
    (if (< i 10000000)
      (recur (+ i 2) (+ s i))
      s)))

(defn odd-sum2 []
  (->> (range 10000000)
       (filter odd?)
       (reduce +)))

(defn bench []
  (println "odd-sum1:")
  (c/bench (odd-sum1))

  (println "odd-sum2:")
  (c/bench (odd-sum2)))
