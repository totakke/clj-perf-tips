(ns clj-perf-tips.t06-multi-protocol
  (:require [libra.bench :refer :all]
            [libra.criterium :refer [bench]]))

(defmulti sum-a class)

(defmethod sum-a clojure.lang.PersistentVector
  [coll]
  (reduce + coll))

(defmethod sum-a clojure.lang.PersistentList
  [coll]
  (reduce + coll))

(defprotocol Summable
  (sum-b [this]))

(extend-protocol Summable
  clojure.lang.PersistentVector
  (sum-b [coll] (reduce + coll))
  clojure.lang.PersistentList
  (sum-b [coll] (reduce + coll)))

(defbench t06-multi-protocol-bench
  (is (bench (dotimes [_ 100000]
               (sum-a (vec (range 10)))))
      "Multimethods")
  (is (bench (dotimes [_ 100000]
               (sum-b (vec (range 10)))))
      "Protocol"))
