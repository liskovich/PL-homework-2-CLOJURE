(ns word_count)

(defn count-words [file-path]
  (with-open [reader (clojure.java.io/reader file-path)]
    (let [words (reduce + (map (fn [line] (count (re-seq #"\S+" line))) (line-seq reader)))]
      words)))

(defn -main [& args]
  (if (empty? args)
    (println "Output:")
    (let [file-path (first args) word-count (count-words file-path)]
      (println "Word count: " word-count)
      )
    )
  )

; in console, run:
; clj -m word_count input_files/sample_text.txt