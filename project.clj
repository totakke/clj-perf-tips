(defproject clj-perf-tips "0.1.0-SNAPSHOT"
  :description "Clojure performance tips"
  :url "http://qiita.com/totakke/items/e0464da6a269cfc5de6b"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [criterium "0.4.4"]
                 [net.totakke/libra "0.1.1"]]
  :plugins [[net.totakke/lein-libra "0.1.1"]]
  :libra {:bench-paths ["src"]})
