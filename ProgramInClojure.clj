;;;; Clojureによるプログラム
;;;; author: OHASHI Kent

(ns ProgramInClojure)

(declare prime-filter)

(def ^:private
  first-prime
  "最初の素数"
  2)

(defn prime-numbers
  "エラトステネスの篩(ふるい)により最大値mまでの素数のリストを取得する。
  mが整数でない場合、正常に動作しない。"
  [m]
  (let [numbers    (range first-prime (inc m))
        primes     ()
        stop-point (Math/floor (Math/sqrt m))]
    (prime-filter numbers primes stop-point)))

(defn- prime-filter
  "整数のリストnumbersを停止点stop-pointまでで素数としてフィルタリングしたリストを返却する。"
  [numbers primes stop-point]
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
