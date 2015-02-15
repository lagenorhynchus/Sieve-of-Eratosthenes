/**
 * Groovyによるプログラム
 */
class ProgramInGroovy {
  /** 最初の素数 */
  private static final int FIRST_PRIME = 2

  /**
   * エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
   * maxが整数でない場合、実行時に例外が発生する。
   *
   * @param  max 最大値
   * @return     素数リスト
   */
  static List<Integer> primeNumbers(int max) {
    if (max < FIRST_PRIME) {
      return []
    }

    def numbers = FIRST_PRIME..max
    def stopPoint = Math.sqrt(max) as int
    primeFilter(numbers, stopPoint)
  }

  /**
   * 整数のリストnumbersを停止点stopPointまでで素数としてフィルタリングしたリストを返却する。
   *
   * @param  numbers   整数リスト
   * @param  stopPoint フィルタリングの停止点
   * @return           素数リスト
   */
  private static List<Integer> primeFilter(List<Integer> numbers, int stopPoint) {
    def primes = []
    (FIRST_PRIME..stopPoint).each { n ->
      if (!numbers.isEmpty() && numbers.head() == n) {
        primes << n
        numbers = numbers.tail().findAll { x -> x % n != 0 }
      }
    }
    primes.addAll(numbers)
    primes
  }

  // 実行例
  static void main(String[] args) {
    println primeNumbers(100)
  }
}
