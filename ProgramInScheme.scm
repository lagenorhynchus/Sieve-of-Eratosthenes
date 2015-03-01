;;;; Schemeによるプログラム

;; 最初の素数
(define first-prime 2)

(define (prime-numbers m)
  "エラトステネスの篩(ふるい)により最大値mまでの素数のリストを取得する。
  mが自然数でない場合、正常に動作しない。"
  (let ((numbers    (iota (- m 1) first-prime))
        (primes     '())
        (stop-point (floor (sqrt m))))
    (prime-filter numbers primes stop-point)))

(define (prime-filter numbers primes stop-point)
  "整数のリストnumbersを停止点stop-pointまでで素数としてフィルタリングしたリストを返却する。"
  (if (null? numbers)
    '()
    (let ((n (car numbers)))
      (if (> n stop-point)
        (append (reverse primes) numbers)
        (prime-filter (filter (lambda (x) (not (= (mod x n) 0))) (cdr numbers))
                      (cons n primes)
                      stop-point)))))

;; 実行例
(print (prime-numbers 100))
