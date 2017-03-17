(ns clj-perf-tips.t05-const-var
  (:require [criterium.core :as c]))

(def ^:const a 10)

(def b 10)

(defn bench []
  (println "w/ const:")
  (c/bench
   (dotimes [_ 10000000]
     (inc a)))

  (println "w/o const:")
  (c/bench
   (dotimes [_ 10000000]
     (inc b))))
