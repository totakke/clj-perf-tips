(ns clj-perf-tips.t08-concurrent
  (:require [criterium.core :as c]))

(defn inc-after [n]
  (Thread/sleep 10)
  (inc n))

(defn bench []
  (println "concurrent")
  (c/bench
   (dorun
    (pmap inc-after (range 100))))

  (println "not concurrent")
  (c/bench
   (dorun
    (map inc-after (range 100)))))
