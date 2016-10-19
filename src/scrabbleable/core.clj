(ns scrabbleable.core
  (:require [clojure.java.io :as io]
            [clojure.set :as set]))

(defn find-em [word]
  (let [characters (set word)]
    (filter #(set/subset? (set %) characters)
            (line-seq (io/reader "/usr/share/dict/words")))))

(defn -main
  [word]
  (doseq [w (find-em word)]
    (println w)))
