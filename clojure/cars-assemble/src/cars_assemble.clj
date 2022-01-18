(ns cars-assemble)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (let [cars-produced-by-hour 221]
    (cond
    	 (= speed 0) (* speed cars-produced-by-hour 0.0)
    	 (and (>= speed 1) (<= speed 4)) (* speed cars-produced-by-hour 1.0)
    	 (and (>= speed 5) (<= speed 8)) (* speed cars-produced-by-hour 0.9)
    	 (= speed 9) (* speed cars-produced-by-hour 0.8)
    	 (= speed 10) (* speed cars-produced-by-hour 0.77)
    )
  )
)

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (->
    (production-rate speed)
    (/ 60)
    (int)
  )
)
