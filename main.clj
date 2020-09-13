(ns recurse)

(defn sum-them []
  (def numbers [1 2 3 4 5 6 7 8 9 10])
  (apply + numbers))

;---

(defn initial-board []
 [ \r \n \b \q \k \b \n \r
   \p \p \p \p \p \p \p \p 
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \P \P \P \P \P \P \P \P 
   \R \N \B \Q \K \B \N \R])

(defn lookup3 [board pos]
  (let [[file rank] (map int pos)
        [fc rc]     (map int [\a \0])
        f (- file fc)
        r (* 8 (- 8 (- rank rc)))
        index (+ f r)]
    (board index)))

(lookup3 (initial-board) "a1")
;; => \R

;---

(def date-regex #"(\d{1,2})\/(\d{1,2})\/(\d{4})")

(defn match-date [date]
  (let [rem (re-matcher date-regex date)]
    (when (.find rem)
      (let [[whole m d] rem]
        {:date whole :month m :day d}))))

(match-date "12/02/2020")
;;=> {:month "12", :day "02"}

;---

(def colors [:violet \v :blue \b :green \g :yellow \y :orange \o :red \r])

(defn mastermind-board []
  [ \0 \0 \0 \0
    \0 \0 \0 \0
    \0 \0 \0 \0
  ]
)

""

(mastermind-board)

colors