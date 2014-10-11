"""Pythonによるプログラム"""

from math import sqrt

# 最初の素数
_FIRST_PRIME = 2


def prime_numbers(m):
    """エラトステネスの篩(ふるい)により最大値mまでの素数のリストを取得する。

    Args:
        m: 最大値
    Returns:
        素数リスト
    Raises:
        TypeError: mが整数でない場合
    """
    if not isinstance(m, int):
        raise TypeError("m must be an integer")

    if m < _FIRST_PRIME:
        return []

    numbers = list(range(_FIRST_PRIME, m + 1))
    stop_point = int(sqrt(m))
    return _prime_filter(numbers, stop_point)


def _prime_filter(numbers, stop_point):
    """整数のリストnumbersを停止点stop_pointまでで素数としてフィルタリングしたリストを返却する。

    Args:
        numbers:　整数リスト
        stop_point: フィルタリングの停止点
    Returns:
        素数リスト
    """
    primes = []
    for n in range(_FIRST_PRIME, stop_point + 1):
        if numbers[0] == n:
            primes.append(n)
            numbers = [x for x in numbers[1:] if x % n != 0]
    primes.extend(numbers)
    return primes


if __name__ == "__main__":
    # 実行例
    print(prime_numbers(100))
