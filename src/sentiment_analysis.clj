(ns sentiment_analysis
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]))

(defn sentiment-analysis [file-path]
  (with-open [reader (clojure.java.io/reader file-path)]
    (let [lines (line-seq reader)
          trimmed-lines (map clojure.string/trim lines)
          acc (clojure.string/join ". " trimmed-lines)]
      acc)))

(defn call-sentiment-api [text] (client/get "https://twinword-sentiment-analysis.p.rapidapi.com/analyze/"
                                            {:headers
                                             {:X-RapidAPI-Key "<PLACE_API_KEY_HERE>"
                                              :X-RapidAPI-Host "twinword-sentiment-analysis.p.rapidapi.com"}
                                             :query-params {:text text}}))

(defn -main [& args]
  (if (empty? args)
    (println "Output:")
    (let [file-path (first args) analysis-result ( call-sentiment-api (sentiment-analysis file-path))]
      (println "Sentiment analysis result:\n")
      (let [body (get analysis-result :body)
            parsed-body (json/read-str body :key-fn keyword)
            type (get parsed-body :type)
            score (get parsed-body :score)]
        (println "Text emotionality:" type)
        (println "Sentiment score:" score))
      )
    )
  )

; in console, run:
; clj -m sentiment_analysis input_files/sample_text.txt