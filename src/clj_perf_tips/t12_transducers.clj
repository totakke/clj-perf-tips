(ns clj-perf-tips.t12-transducers
  (:require [criterium.core :as c]))

(defn a [n]
  (->> (range n)
       (filter even?)
       (map inc)
       (remove #(zero? (mod % 3)))
       (map #(* % %))
       (reduce +)))

(defn b [n]
  (let [xf (comp (filter even?)
                 (map inc)
                 (remove #(zero? (mod % 3)))
                 (map #(* % %)))]
    (transduce xf + (range n))))

(defn bench []
  (println "w/o transducers")
  (c/bench
   (dotimes [_ 1000]
     (a 1000)))

  (println "w/ transcuders")
  (c/bench
   (dotimes [_ 1000]
     (b 1000))))
