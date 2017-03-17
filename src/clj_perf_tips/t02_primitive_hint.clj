(ns clj-perf-tips.t02-primitive-hint
  (:require [criterium.core :as c]))

(defn calc1 [^long x]
  (* (+ x 5) 2))

(defn calc2 [x]
  (* (+ x 5) 2))

(defn bench []
  (println "calc1:")
  (c/bench
   (dotimes [_ 1000000]
     (calc1 2)))

  (println "calc2:")
  (c/bench
   (dotimes [_ 1000000]
     (calc2 2))))
