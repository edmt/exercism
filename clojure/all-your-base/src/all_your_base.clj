(ns all-your-base)


(defn pow
  "Returns base to the power of exp"
  [base exp]
  (reduce * (repeat exp base)))


(defn custom-log
  "Returns log(N, base) where base is a parameter instead of 10 or e"
  [num base]
  (int (/ (Math/log num) (Math/log base))))


(defn to->base10
  "Returns the base 10 representation of the current number"
  [from digits]
  (->>
    (range (dec (count digits)) -1 -1)
    (map vector digits)
    (map (fn [[x y]] (* x (pow from y))))
    (reduce +)))


(defn to->baseN
  [num base]
  (loop [n num results [] exponents (range (custom-log num base) -1 -1)]
    (if (seq exponents)
      (let [value (pow base (first exponents))
            times (int (/ n value))]
        (recur (- n (* value times)) (conj results (int times)) (drop 1 exponents)))
      results)))


(defn convert
  "Test for pre-conditions"
  [from digits to]
  (cond
    (or (<= from 1) (<= to 1)) nil
    (empty? digits) '()
    (every? #{0} digits) '(0)
    (some #(or (>= %1 from) (neg? %)) digits) nil
    :else (to->baseN (to->base10 from digits) to)))
