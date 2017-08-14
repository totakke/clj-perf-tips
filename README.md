# Clojure performance tips

1. [Type hints](https://github.com/totakke/clj-perf-tips/blob/master/src/clj_perf_tips/t01_type_hint.clj)
2. [Primitive hints](https://github.com/totakke/clj-perf-tips/blob/master/src/clj_perf_tips/t02_primitive_hint.clj)
3. [Transient](https://github.com/totakke/clj-perf-tips/blob/master/src/clj_perf_tips/t03_transient.clj)
4. [Loop/recur](https://github.com/totakke/clj-perf-tips/blob/master/src/clj_perf_tips/t04_loop_recur.clj)
5. [Const](https://github.com/totakke/clj-perf-tips/blob/master/src/clj_perf_tips/t05_const_var.clj)
6. [Multimethods vs. Protocol](https://github.com/totakke/clj-perf-tips/blob/master/src/clj_perf_tips/t06_multi_protocol.clj)
7. [Memoize](https://github.com/totakke/clj-perf-tips/blob/master/src/clj_perf_tips/t07_memoize.clj)
8. [Concurrency](https://github.com/totakke/clj-perf-tips/blob/master/src/clj_perf_tips/t08_concurrent.clj)
9. [Calculation order of data types](https://github.com/totakke/clj-perf-tips/blob/master/src/clj_perf_tips/t09_data_calc_order.clj)
10. [Map vs. Record](https://github.com/totakke/clj-perf-tips/blob/master/src/clj_perf_tips/t10_map_record.clj)
11. [Flatten in various ways](https://github.com/totakke/clj-perf-tips/blob/master/src/clj_perf_tips/t11_flatten.clj)
12. [Transducers](https://github.com/totakke/clj-perf-tips/blob/master/src/clj_perf_tips/t12_transducers.clj)

To run all benchmarks,

```console
$ lein libra
```

To run an individual benchmark,

```console
$ lein libra :only clj-perf-tips.t01-type-hint
```
