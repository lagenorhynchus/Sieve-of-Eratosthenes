package com.github.lagenorhynchus.number;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 素数生成クラス
 * <p>
 * 素数のリストを生成する。
 */
public class PrimeGenerator {
  /**
   * インスタンス化を認めない。
   */
  private PrimeGenerator() {}

  /**
   * 最初の素数
   */
  public static final int FIRST_PRIME = 2;

  /**
   * 指定された最大値までの素数のリストを生成する。
   *
   * @param  max 最大値(範囲の終端)
   * @return   素数リスト
   */
  public static List<Integer> range(final int max) {
    if (max < FIRST_PRIME) {
      return new ArrayList<>();
    }

    final List<Integer> numbers = IntStream.rangeClosed(FIRST_PRIME, max)
      .collect(ArrayList::new, List::add, List::addAll);
    final int stopPoint = (int) Math.sqrt(max);
    return primeFilter(numbers, stopPoint);
  }

  /**
   * 指定された範囲の素数のリストを生成する。
   *
   * @param  from 範囲の始端
   * @param  to   範囲の終端
   * @return    素数リスト
   */
  public static List<Integer> range(final int from, final int to) {
    final List<Integer> primesFrom = range(from - 1);
    final List<Integer> primesTo = range(to);

    return primesTo.stream()
      .filter(a -> primesFrom.stream().noneMatch(b -> b == a))
      .collect(toList());
  }

  /**
   * エラトステネスの篩アルゴリズムにより、停止点までの範囲でフィルタ処理を行い、素数のリストを抽出する。
   *
   * @param  numbers   整数リスト
   * @param  stopPoint 停止点
   * @return       素数リスト
   */
  private static List<Integer> primeFilter(List<Integer> numbers, final int stopPoint) {
    final List<Integer> primes = new ArrayList<>();
    for (int i = FIRST_PRIME; i <= stopPoint; i++) {
      if (numbers.get(0) == i) {
        final int n = i;
        primes.add(n);
        numbers.remove(0);
        numbers = numbers.stream()
          .filter(x -> x % n != 0)
          .collect(toList());
      }
    }
    primes.addAll(numbers);
    return primes;
  }

  public static void main(final String[] args) {
    // 実行例
    System.out.println("最初の素数: " + PrimeGenerator.FIRST_PRIME);
    System.out.println("1000までの素数: " + PrimeGenerator.range(1000));
    System.out.println("100～1000の範囲の素数: " + PrimeGenerator.range(100, 1000));
  }
}
