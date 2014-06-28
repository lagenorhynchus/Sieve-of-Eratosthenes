# coding: utf-8

# Pythonによるプログラム
# author: OHASHI Kent

from math import sqrt

FIRST_PRIME = 2


# エラトステネスの篩(ふるい)により最大値mまでの素数のリストを取得する。
# mが整数でない場合、TypeErrorを発生させる。
def prime_numbers(m):
    if not isinstance(m, int):
        raise TypeError("m must be an integer")

    if m < FIRST_PRIME:
        return []

    numbers = list(range(FIRST_PRIME, m + 1))
    stop_point = int(sqrt(m))
    return prime_filter(numbers, stop_point)


def prime_filter(numbers, stop_point):
    primes = []
    for n in range(FIRST_PRIME, stop_point + 1):
        if numbers[0] == n:
            primes.append(n)
            numbers = [x for x in numbers[1:] if x % n != 0]
    primes.extend(numbers)
    return primes


if __name__ == "__main__":
    # 実行例
    print(prime_numbers(100))
