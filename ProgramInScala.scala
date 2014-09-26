import scala.annotation.tailrec
import scala.math.sqrt

/**
 * Scalaによるプログラム
 *
 * @author  OHASHI Kent
 * @version 1.0
 */
object ProgramInScala {
  /** 最初の素数 */
  private val FirstPrime: Int = 2

  /**
   * エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
   * maxが整数でない場合、コンパイルエラーとなる。
   *
   * @param  max 最大値
   * @return     素数リスト
   */
  def primeNumbers(max: Int): List[Int] = {
    val numbers = List.range(FirstPrime, max + 1)
    val primes = List()
    val stopPoint = sqrt(max).toInt
    primeFilter(numbers, primes, stopPoint)
  }

  /**
   * 整数のリストnumbersを停止点stopPointまでで素数としてフィルタリングしたリストを返却する。
   *
   * @param  numbers   整数リスト
   * @param  primes    素数リスト
   * @param  stopPoint フィルタリングの停止点
   * @return           素数リスト
   */
  @tailrec
  private def primeFilter(numbers: List[Int], primes: List[Int], stopPoint: Int): List[Int] = {
    numbers match {
      case Nil =>
        List()
      case n :: ns =>
        if (n > stopPoint) {
          primes.reverse ::: numbers
        } else {
          primeFilter(ns.filter(_ % n != 0), n :: primes, stopPoint)
        }
    }
  }

  def main(args: Array[String]): Unit = {
    // 実行例
    println(primeNumbers(100))
  }
}
