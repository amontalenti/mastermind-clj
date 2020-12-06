(ns mastermind.estevo)

;;; core logic

(def colors #{:b :g :o :p :r :y})

(def code-length 4)

;; all core logic elided.  below the following is assumed:
;; a code is of the form [:r :g :y :b]
;; a game is of the form {:secret-code [:g :g :b :p], :guesses [{:guess [:r :r :r :r] :score {:strong 0 :weak 0}} ...]]}

(defn rand-choose
  "Selects num-items from coll randomly, returns a vector of size num-items."
  [num-items coll]
  (repeatedly num-items (partial rand-nth coll)))

(defn random-code
  "Returns a vector of 4 colors selected at random from available colors."
  []
  (vec (rand-choose 4 (vec colors))))

(defn match-mask [xs ys]
  (map = xs ys))

(defn strong-match-count [xs ys]
  (count (filter true? (match-mask xs ys))))

(defn filterer [mask xs]
  (keep #(when-not (first %) (second %)) (map vector mask xs)))

(defn key-min [key m1 m2]
  (min (get m1 key 0)
       (get m2 key 0)))

(defn weak-match-count [xs ys]
  (let [mask (match-mask xs ys)
        fxs (frequencies (filterer mask xs))
        fxy (frequencies (filterer mask ys))]
    (apply + (map #(key-min % fxs fxy) colors))))

;; xs is the secret code and ys is a guess.. or vice versa, since order doesn't matter
(defn score [xs ys]
  {:strong (strong-match-count xs ys)
   :weak (weak-match-count xs ys)})

(defn new-game []
  {:secret-code (random-code)
   :guesses []})

(defn add-guess [{:keys [secret-code] :as game} guess]
  ;; alternatively, I could calculate scores on the fly while printing them out.
  ;; I chose this because this way we can send guesses to dumb clients without
  ;; sending them the secret code
  (update game :guesses conj {:guess guess :score (score guess secret-code)}))


;;; display utils

(defn print-3-cols [& cols]
  (apply printf "%20s%20s%20s\n" cols))

(defn print-guess [{g :guess
                    {:keys [strong weak]} :score}]
  (print-3-cols g strong weak)
  (when (= strong code-length)
    (println)
    (print-3-cols "°º¤ø,¸¸,ø¤º°`°º¤ø,¸" "  *** YOU WON!! ***  " "¤º°`°º¤ø,¸¸,ø¤º°`°º¤ø,¸")))

(defn print-game [{:keys [guesses]}]
  (println)
  (print-3-cols "Guess" "Strong Matches" "Weak Matches")
  (print-3-cols "-----" "--------------" "------------")
  (doseq [g guesses]
    (print-guess g)))

(defn print-last-guess [{:keys [guesses]}]
  (print-guess (last guesses)))


(defn -main []
  (def g (new-game))
  (print-game g))

;;; PLAY HERE

(comment
  ;; start new game by evaluating this `do` block
  (do
    (def g (new-game))
    (print-game g)
    g)

  ;; make a guess by editing the vector and evaluating the `do` block
  (do
    (def g (add-guess g [:y :y :o :o]))
    (print-last-guess g))
)
