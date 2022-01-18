(ns anagram
  (:require [clojure.string :as str]))

(defn anagram? [word prospect]
  (and
    (not= word prospect)
    (= (sort word) (sort prospect)))
)

(defn anagrams-for [word prospect-list]
  (filter #(anagram? (str/upper-case word) (str/upper-case %1)) prospect-list)
)
