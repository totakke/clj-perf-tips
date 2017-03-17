(ns clj-perf-tips.t06-multi-protocol
  (:require [criterium.core :as c]))

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

(defn bench []
  (println "Multimethods")
  (c/bench
   (dotimes [_ 100000]
     (sum-a (vec (range 10)))))

  (println "Protocol")
  (c/bench
   (dotimes [_ 100000]
     (sum-b (vec (range 10))))))
