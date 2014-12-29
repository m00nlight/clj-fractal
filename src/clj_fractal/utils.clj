(ns clj-fractal.utils)

(defn nest-while
  "Generate list based on the evaluate an function on the initial value
repeatedly until some condition does not meet."
  [p? f v]
  (letfn [(help [val acc]
            (if (not (p? val))
              (reverse acc)
              (recur (f val) (cons val acc))))]
    (help v '())))


(defn average
  "Calculate the average of value of an list"
  [coll]
  (if (empty? coll)
    0.0
    (/ (reduce + coll) (* 1.0 (count coll)))))


(defn sd
  "Calculate the standard deviation of the list."
  [coll]
  (let [avg (average coll)]
    (Math/sqrt (average (map #(* (- % avg) (- % avg))
                             coll)))))
