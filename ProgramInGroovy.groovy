/*
 * Groovyによるプログラム
 * author: OHASHI Kent
 */

class ProgramInGroovy {
    private static final int FIRST_PRIME = 2

    /*
     * エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
     * maxが整数でない場合、コンパイルエラーとなる。
     */
    static List primeNumbers(int max) {
        if (max < FIRST_PRIME) {
            return []
        }

        def numbers = FIRST_PRIME..max
        def stopPoint = Math.sqrt(max) as int
        return primeFilter(numbers, stopPoint)
    }

    private static List primeFilter(List numbers, int stopPoint) {
        def primes = []
        (FIRST_PRIME..stopPoint).each {n ->
            if (!numbers.isEmpty() && numbers.head() == n) {
                primes << n
                numbers = numbers.tail().findAll {x -> x % n != 0}
            }
        }
        primes.addAll(numbers)
        return primes
    }

    // 実行例
    static void main(String[] args) {
        println primeNumbers(100)
    }
}
