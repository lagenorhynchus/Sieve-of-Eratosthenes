/*
 * Java 8によるプログラム
 * author: OHASHI Kent
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProgramInJava8 {
  private static final int FIRST_PRIME = 2;

  /*
   * エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
   * maxが整数でない場合、コンパイルエラーとなる。
   */
  public static List<Integer> primeNumbers(int max) {
    if (max < FIRST_PRIME) {
      return new ArrayList<>();
    }

    List<Integer> numbers = IntStream.rangeClosed(FIRST_PRIME, max)
      .collect(
        ArrayList::new,
        List::add,
        (left, right) -> left.addAll(right));
    int stopPoint = (int) Math.sqrt(max);
    return primeFilter(numbers, stopPoint);
  }

  private static List<Integer> primeFilter(List<Integer> numbers, int stopPoint) {
    List<Integer> primes = new ArrayList<>();
    for (int i = FIRST_PRIME; i <= stopPoint; i++) {
      if (numbers.get(0) == i) {
        final int n = i;
        primes.add(n);
        numbers.remove(0);
        numbers = numbers.stream()
          .filter(x -> x % n != 0)
          .collect(Collectors.toList());
      }
    }
    primes.addAll(numbers);
    return primes;
  }

  public static void main(String[] args) {
    // 実行例
    System.out.println(primeNumbers(100));
  }
}
