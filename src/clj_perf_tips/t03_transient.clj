(ns clj-perf-tips.t03-transient
  (:require [criterium.core :as c]))

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

(defn bench []
  (println "fn1:")
  (c/bench (dorun (fn1 1000000)))

  (println "fn2:")
  (c/bench (dorun (fn2 1000000))))
