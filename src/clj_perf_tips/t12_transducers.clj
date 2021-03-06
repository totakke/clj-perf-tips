(ns clj-perf-tips.t12-transducers
  (:require [libra.bench :refer :all]
            [libra.criterium :refer [bench]]))

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

(defbench t12-transducers-bench
  (is (bench (dotimes [_ 1000] (a 1000))) "w/o transducers")
  (is (bench (dotimes [_ 1000] (b 1000))) "w/ transcuders"))
