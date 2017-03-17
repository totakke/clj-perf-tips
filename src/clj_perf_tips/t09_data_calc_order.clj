(ns clj-perf-tips.t09-data-calc-order
  (:require [criterium.core :as c]))

(def alist (list* (range 1000)))

(def avec (vec (range 1000)))

(defn bench1 []
  (println "nth to list")
  (c/bench
   (dotimes [_ 100000] (nth alist 999)))

  (println "nth to vector")
  (c/bench
   (dotimes [_ 100000] (nth avec 999))))

(defn bench2 []
  (println "last to vector")
  (c/bench
   (dotimes [_ 100000] (last avec)))

  (println "peek to vector")
  (c/bench
   (dotimes [_ 100000] (peek avec))))
