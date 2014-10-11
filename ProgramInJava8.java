import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Java 8によるプログラム
 */
public class ProgramInJava8 {
  /**
   * 最初の素数
   */
  private static final int FIRST_PRIME = 2;

  /**
   * エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
   * maxが整数でない場合、コンパイルエラーとなる。
   *
   * @param  max 最大値
   * @return     素数リスト
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

  /**
   * 整数のリストnumbersを停止点stopPointまでで素数としてフィルタリングしたリストを返却する。
   *
   * @param  numbers   整数リスト
   * @param  stopPoint フィルタリングの停止点
   * @return           素数リスト
   */
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

  /**
   * mainメソッド
   *
   * @param args コマンドライン引数
   */
  public static void main(String[] args) {
    // 実行例
    System.out.println(primeNumbers(100));
  }
}
