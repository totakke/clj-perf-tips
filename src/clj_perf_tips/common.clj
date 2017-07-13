(ns clj-perf-tips.common
  (:require [criterium.core :as c]))

(defmacro bench
  [expr]
  `(let [result# (c/benchmark ~expr {})]
     {:time (* (first (:mean result#)) 1e9)
      :sd (* (first (:sample-variance result#)) 1e9)}))
