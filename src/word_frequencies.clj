(ns word_frequencies)

(defn word-frequencies [file-path]
  (with-open [reader (clojure.java.io/reader file-path)]
    (let [result (reduce (fn [acc line]
                           (let [words (map clojure.string/lower-case (clojure.string/split line #"\s+"))]
                             (reduce (fn [inner-acc word] (update inner-acc word (fnil + 0) 1)) acc words)
                             )
                           )
                         {} (line-seq reader)
                         )
          ]
      result)
    )
  )

(defn -main [& args]
  (if (empty? args)
    (println "Output:")
    (let [file-path (first args) word-freq (word-frequencies file-path)]
      (println "Word frequencies: ")
      (prn word-freq)
      )
    )
  )

; in console, run:
; clj -m word_frequencies input_files/sample_text.txt