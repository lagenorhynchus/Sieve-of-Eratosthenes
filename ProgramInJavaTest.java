/*
 * Javaによるプログラムのテスト
 */

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ProgramInJavaTest {
  @Test
  public void primeNumbersで最大値2までの素数のリストが返却される() {
    int max = 2;

    List<Integer> expected = Arrays.asList(2);
    List<Integer> actual = ProgramInJava.primeNumbers(max);
    assertThat(actual, is(expected));
  }

  @Test
  public void primeNumbersで最大値1までの素数のリストが返却される() {
    int max = 1;

    List<Integer> expected = new ArrayList<>();
    List<Integer> actual = ProgramInJava.primeNumbers(max);
    assertThat(actual, is(expected));
  }

  @Test
  public void primeNumbersで最大値13までの素数のリストが返却される() {
    int max = 13;

    List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11, 13);
    List<Integer> actual = ProgramInJava.primeNumbers(max);
    assertThat(actual, is(expected));
  }

  @Test
  public void primeNumbersで最大値15までの素数のリストが返却される() {
    int max = 15;

    List<Integer> expected = Arrays.asList(2, 3, 5, 7, 11, 13);
    List<Integer> actual = ProgramInJava.primeNumbers(max);
    assertThat(actual, is(expected));
  }

  @Test
  public void primeNumbersで最大値0までの素数のリストが返却される() {
    int max = 0;

    List<Integer> expected = new ArrayList<>();
    List<Integer> actual = ProgramInJava.primeNumbers(max);
    assertThat(actual, is(expected));
  }

  @Test
  public void primeNumbersで最大値マイナス1までの素数のリストが返却される() {
    int max = -1;

    List<Integer> expected = new ArrayList<>();
    List<Integer> actual = ProgramInJava.primeNumbers(max);
    assertThat(actual, is(expected));
  }
}
