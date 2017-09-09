(ns clj-perf-tips.t02-primitive-hint
  (:require [libra.bench :refer :all]
            [libra.criterium :refer [bench]]))

(defn calc1 [^long x]
  (* (+ x 5) 2))

(defn calc2 [x]
  (* (+ x 5) 2))

(defbench t02-primitive-hint-bench
  (is (bench (dotimes [_ 1000000]
               (calc1 2)))
      "calc1")
  (is (bench (dotimes [_ 1000000]
               (calc2 2)))
      "calc2"))
