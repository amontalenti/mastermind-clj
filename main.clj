(ns recurse)

(defn initial-board []
 ; eight queens on a board
 [ \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \- \- \- \- \- \- \- \-
   \Q \Q \Q \Q \Q \Q \Q \Q])

(defn lookup [board pos]
  (let [[file rank] (map int pos)
        [fc rc]     (map int [\a \0])
        f (- file fc)
        r (* 8 (- 8 (- rank rc)))
        index (+ f r)]
    (board index)))

(def board (initial-board))

(lookup (initial-board) "a1")
;; => \Q

(defn print-board [board]
  (dorun (map println (partition 8 board))))

(println "Initial chessboard state:")
(println "-------------------------")
(print-board board)