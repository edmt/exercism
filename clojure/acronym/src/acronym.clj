(ns acronym
  (:require [clojure.string :as str]))

(defn acronym [s]
  (let [terms (->
      (str/replace s #"([A-Z][a-z])" " $1")
      (str/split #"[\s-]")
    )]

    (->>
      (filter seq terms)
      (map #(str/upper-case (first %1)))
      (str/join)
    )
  )
)
