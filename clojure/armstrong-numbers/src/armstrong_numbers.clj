(ns armstrong-numbers)

(defn pow [base exp]
  (reduce * (repeat exp base))
)

(defn armstrong? [num]
  (let [num-as-string (str num)
        exp (count num-as-string)]

    (->> (str num)
         (map (fn [digit] (pow (long (Character/digit digit 10)) exp)))
         (reduce +)
         (= num)
    )
  )
)