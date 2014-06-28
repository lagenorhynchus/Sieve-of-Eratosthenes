/*
 * Javaによるプログラム
 * author: OHASHI Kent
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

public class ProgramInJava {
    private static final int FIRST_PRIME = 2;

    /*
     * エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
     * maxが整数でない場合、コンパイルエラーとなる。
     */
    public static List<Integer> primeNumbers(int max) {
        if (max < FIRST_PRIME) {
            return new ArrayList<>();
        }

        List<Integer> numbers = new LinkedList<>();
        for (int i = FIRST_PRIME; i <= max; i++) {
            numbers.add(i);
        }
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
                CollectionUtils.filter(numbers, new Predicate<Integer>() {
                    @Override
                    public boolean evaluate(Integer x) {
                        return x % n != 0;
                    }
                });
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
