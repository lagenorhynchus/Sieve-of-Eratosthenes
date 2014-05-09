/*
 * Scalaによるプログラム
 * author: OHASHI Kent
 */

import scala.annotation.tailrec
import scala.math.sqrt

object ProgramInScala {
  private val FirstPrime: Int = 2

  /*
   * エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
   * maxが整数でない場合、コンパイルエラーとなる。
   */
  def primeNumbers(max: Int): List[Int] = {
    val numbers   = List.range(FirstPrime, max+1)
    val primes    = List()
    val stopPoint = sqrt(max).toInt
    primeFilter(numbers, primes, stopPoint)
  }

  @tailrec
  private def primeFilter(numbers: List[Int], primes: List[Int], stopPoint: Int): List[Int] = {
    numbers match {
      case Nil     => List()
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
