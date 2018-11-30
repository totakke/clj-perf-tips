# Clojure Performance Tips

1. [Type hints](src/clj_perf_tips/t01_type_hint.clj) (`clj-perf-tips.t01-type-hint`)
2. [Primitive hints](src/clj_perf_tips/t02_primitive_hint.clj) (`clj-perf-tips/t02-primitive-hint`)
3. [Transient](src/clj_perf_tips/t03_transient.clj) (`clj-perf-tips/t03-transient`)
4. [Loop/recur](src/clj_perf_tips/t04_loop_recur.clj) (`clj-perf-tips/t04-loop-recur`)
5. [Const](src/clj_perf_tips/t05_const_var.clj) (`clj-perf-tips/t05-const-var`)
6. [Multimethods vs. Protocol](src/clj_perf_tips/t06_multi_protocol.clj) (`clj-perf-tips/t06-multi-protocol`)
7. [Memoize](src/clj_perf_tips/t07_memoize.clj) (`clj-perf-tips/t07-memoize`)
8. [Concurrency](src/clj_perf_tips/t08_concurrent.clj) (`clj-perf-tips/t08-concurrent`)
9. [Calculation order of data types](src/clj_perf_tips/t09_data_calc_order.clj) (`clj-perf-tips/t09-data-calc-order`)
10. [Map vs. Record](src/clj_perf_tips/t10_map_record.clj) (`clj-perf-tips/t10-map-record`)
11. [Flatten in various ways](src/clj_perf_tips/t11_flatten.clj) (`clj-perf-tips/t11-flatten`)
12. [Transducers](src/clj_perf_tips/t12_transducers.clj) (`clj-perf-tips/t12-transducers`)

To run a benchmark,

```console
$ lein libra :only clj-perf-tips.t01-type-hint
```

To run all benchmarks,

```console
$ lein libra
```
