;;;; Common Lispによるプログラム

;; 最初の素数
(defconstant +first-prime+ 2)

(defun prime-numbers (m)
  "エラトステネスの篩(ふるい)により最大値mまでの素数のリストを取得する。
  mが整数でない場合、正常に動作しない。"
  (let ((numbers    (loop for x from +first-prime+ to m collect x))
        (primes     '())
        (stop-point (floor (sqrt m))))
    (prime-filter numbers primes stop-point)))

(defun prime-filter (numbers primes stop-point)
  "整数のリストnumbersを停止点stop-pointまでで素数としてフィルタリングしたリストを返却する。"
  (if (null numbers)
    '()
    (let ((n (car numbers)))
      (if (> n stop-point)
        (append (reverse primes) numbers)
        (prime-filter (loop for x in (cdr numbers) when (/= (mod x n) 0) collect x)
                      (cons n primes)
                      stop-point)))))

;; 実行例
(princ (prime-numbers 100))
