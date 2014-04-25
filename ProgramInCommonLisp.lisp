;;;; Common Lispによるプログラム
;;;; author: OHASHI Kent

(defconstant +first-prime+ 2)

;;; エラトステネスの篩(ふるい)により最大値mまでの素数のリストを取得する。
;;; mが整数でない場合、正常に動作しない。
(defun prime-numbers (m)
  (let ((numbers   (loop for x from +first-prime+ to m collect x))
       (primes     ())
       (stop-point (floor (sqrt m))))
    (prime-filter numbers primes stop-point)))

(defun prime-filter (numbers primes stop-point)
  (if (null numbers)
    ()
    (let ((n (car numbers)))
      (if (> n stop-point)
        (append (reverse primes) numbers)
        (prime-filter (loop for x in (cdr numbers) when (/= (rem x n) 0) collect x)
                      (cons n primes)
                      stop-point)))))

;; 実行例
(princ (prime-numbers 100))
