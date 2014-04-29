# coding: utf-8

#
# Rubyによるプログラム
# author: OHASHI Kent
#

FIRST_PRIME = 2

# エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
# maxが整数でない場合、TypeErrorを発生させる。
def prime_numbers(max)
  if !max.is_a?(Integer)
    raise TypeError, "max must be integer"
  end

  primes = []
  if max < 0
    return primes
  end

  numbers = (FIRST_PRIME..max).to_a
  stop_point = Math.sqrt(max).to_i
  return prime_filter(numbers, primes, stop_point)
end

def prime_filter(numbers, primes, stop_point)
  (FIRST_PRIME..stop_point).each do |n|
    if numbers[0] == n
      primes << n
      numbers = numbers[1..-1].select {|x| x % n != 0}
    end
  end
  primes.concat(numbers)
  return primes
end

if __FILE__ == $0
  # 実行例
  print prime_numbers(100), "\n"
end
