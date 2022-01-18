(ns interest-is-interesting)

(defn interest-rate
  "TODO: add docstring"
  [balance]
  (cond
    (< balance 0) -3.213
    (< balance 1000) 0.5
    (and (>= balance 1000) (< balance 5000)) 1.621
    (>= balance 5000) 2.475))

(defn annual-balance-update
  "TODO: add docstring"
  [balance]
  (let [rate (/ (bigdec (interest-rate balance)) 100)]
    (cond
      (< balance 0) (* balance (- 1 rate))
      :else (* balance (+ 1 rate))
    )))

(defn amount-to-donate
  "TODO: add docstring"
  [balance tax-free-percentage]
  (cond
    (> balance 0) (int (* balance (/ tax-free-percentage 100) 2))
    :else 0
  ))