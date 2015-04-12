/*
 * Cによるプログラム
 */

#include <stdio.h>

#define FIRST_PRIME 2
#define NUMBERS 150000
#define PRIMES 10000

void primeNumbers(int primes[]);
void primeFilter(int numbers[], int primes[]);

/*
 * エラトステネスの篩(ふるい)により素数配列primesに値を設定する。
 */
void primeNumbers(int primes[])
{
  int i;
  int numbers[NUMBERS];

  for (i = 0; i < NUMBERS; ++i) {
    numbers[i] = FIRST_PRIME + i;
  }
  primeFilter(numbers, primes);
}

/*
 * 整数配列numbersのうち素数をprimesに設定する。
 */
void primeFilter(int numbers[], int primes[]) {
  int i;
  int j;

  for (i = 0; i < NUMBERS; ++i) {
    if (numbers[i] != -1) {
      for (j = 2 * numbers[i] - FIRST_PRIME; j < NUMBERS; j += numbers[i]) {
        numbers[j] = -1;
      }
    }
  }

  j = 0;
  for (i = 0; i < NUMBERS && j < PRIMES; ++i) {
    if (numbers[i] != -1) {
      primes[j] = numbers[i];
      ++j;
    }
  }
}

int main(int argc, const char *argv[])
{
  /* 実行例 */
  int i;
  int primes[PRIMES];

  primeNumbers(primes);
  for (i = 0; primes[i] <= 100; i++) {
    printf("%d\n", primes[i]);
  }

  return 0;
}
