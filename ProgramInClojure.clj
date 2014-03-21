;;;; Clojureによるプログラム
;;;; author: OHASHI Kent

(def first-prime 2)
(declare prime-filter)

;;; エラトステネスの篩(ふるい)により最大値mまでの素数のリストを取得する。
;;; mが整数でない場合、正常に動作しない。
(defn prime-numbers [m]
  (let [numbers    (range first-prime (inc m))
        primes     ()
        stop-point (Math/floor (Math/sqrt m))]
    (prime-filter numbers primes stop-point)))

(defn prime-filter [numbers primes stop-point]
  (if (empty? numbers)
    ()
    (let [n (first numbers)]
      (if (> n stop-point)
        (concat (reverse primes) numbers)
        (recur (for [x (rest numbers) :when (not= (rem x n) 0)] x)
               (cons n primes)
               stop-point)))))

;; 実行例
(println (prime-numbers 100))
