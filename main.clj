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

(lookup (initial-board) "a1")
;; => \Q