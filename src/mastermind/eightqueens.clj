(ns mastermind.core)

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

(defn print-board [board]
  (dorun (map println (partition 8 board))))

(def board (initial-board))

(defn mastermind []
  (println)
  (println "Initial chessboard state:")
  (println "-------------------------")
  (print-board board)

  (println)
  (println "Lookup cell at a1:")
  (println "------------------")
  (println (lookup board "a1"))

  (defn find-queens [board]
  (doseq [cell (map-indexed vector board)]
    (if (= (nth cell 1) \Q)
      (prn cell))))

  (println)
  (println "Location of the queens:")
  (println "-----------------------")
  (find-queens board))
