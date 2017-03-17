(ns clj-perf-tips.t01-type-hint
  (:require [criterium.core :as c]))

(defn len1 [^String s]
  (.length s))

(defn len2 [s]
  (.length s))

(defn bench []
  (println "len1:")
  (c/bench
   (dotimes [_ 100000]
     (len1 "Hello, world!")))

  (println "len2:")
  (c/bench
   (dotimes [_ 100000]
     (len2 "Hello, world!"))))
