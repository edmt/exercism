(ns accumulate)

(defn accumulate [func col]
  (loop [xs col results []]
    (if (seq xs)
      (recur
        (rest xs)
        (conj results (func (first xs))))
      results))
)
