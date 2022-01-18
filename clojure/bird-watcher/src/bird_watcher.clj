(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today [birds] (last birds))

(defn inc-bird [birds]
  (let [today-index (dec (count birds))]
    (update birds today-index inc)))

(defn day-without-birds? [birds]
  (true? (some zero? birds)))

;user=> (reduce + (take 6 [5, 9, 12, 6, 8, 8, 17]))
;user=> (apply + (take 6 [5, 9, 12, 6, 8, 8, 17]))
(defn n-days-count [birds n]
  (apply + (take n birds)))

(defn busy-days [birds]
  (count (filter #(>= %1 5) birds)))

(defn odd-week? [birds]
  (or (= [1 0 1 0 1 0 1] birds) (= [0 1 0 1 0 1 0] birds)))
