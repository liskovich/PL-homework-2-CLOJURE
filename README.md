# Clojure text processing

## Implemented functions:

- `word_count` - returns the number of words in a text file.
    To run, execute `clj -m word_count input_files/sample_text.txt` in your command line.
- `word_frequencies` - returns the map of all words in a text file as keys and their frequency in text as values (NOTE: words like "test", "Test" and "TEST" will be treated as the same word).
  To run, execute `clj -m word_frequencies input_files/sample_text.txt` in your command line.
- `sentiment_analysis` - returns the emotionality and sentiment score of the words in a text file.
  To run, execute `clj -m sentiment_analysis input_files/sample_text.txt` in your command line.

## How to run?

**IMPORTANT NOTE:**
This program was developed in Intellij IDEA, with the help of **Cursive** plugin for Clojure.

**Prerequisites:**

- You need to have `clojure cli tools installed on your machine`. For more info, check out the: [official clojure installation page](https://clojure.org/guides/install_clojure).
- In order to run the `sentiment_analysis` example, you need to have a RapidAPI key for the **Twinword Sentiment Analysis API**, check it out: [here](https://rapidapi.com/twinword/api/sentiment-analysis).

**Running programs:**

(`word_count` and `word_frequencies`):
- cd into the root directory of the project.
- run the command in format: `clj -m <command> input_files/sample_text.txt`, where command is the name of the program (see above).

(`sentiment_analysis`):
- open file `sentiment_analysis.clj`, find the code lines:
    ```clojure
  (defn call-sentiment-api [text] (client/get "https://twinword-sentiment-analysis.p.rapidapi.com/analyze/"
                                            {:headers
                                             {:X-RapidAPI-Key "<PLACE_API_KEY_HERE>"
                                              :X-RapidAPI-Host "twinword-sentiment-analysis.p.rapidapi.com"}
                                             :query-params {:text text}}))
  ```
- replace the `<PLACE_API_KEY_HERE>` with your RapidAPI key.
- cd into the root directory of the project.
- run the command: `clj -m sentiment_analysis input_files/sample_text.txt`.