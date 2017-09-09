(ns clj-perf-tips.t01-type-hint
  (:require [libra.bench :refer :all]
            [libra.criterium :refer [bench]]))

(defn len1 [^String s]
  (.length s))

(defn len2 [s]
  (.length s))

(defbench t01-type-hint-bench
  (is (bench (dotimes [_ 100000]
               (len1 "Hello, world!")))
      "len1")
  (is (bench (dotimes [_ 100000]
               (len2 "Hello, world!")))
      "len2"))
