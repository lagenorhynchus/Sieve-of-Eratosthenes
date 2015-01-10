#
# Rubyによるプログラム
#

module ProgramInRuby
  # 最初の素数
  FIRST_PRIME = 2

  module_function

  # エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
  # maxが整数でない場合、TypeErrorを発生させる。
  def prime_numbers(max)
    unless max.is_a?(Integer)
      raise TypeError, "max must be an integer"
    end

    if max < FIRST_PRIME
      return []
    end

    numbers = (FIRST_PRIME..max).to_a
    stop_point = Math.sqrt(max).to_i
    prime_filter(numbers, stop_point)
  end

  # 整数のリストnumbersを停止点stop_pointまでで素数としてフィルタリングしたリストを返却する。
  def prime_filter(numbers, stop_point)
    primes = []
    (FIRST_PRIME..stop_point).each do |n|
      if numbers[0] == n
        primes << n
        numbers = numbers[1..-1].select { |x| x % n != 0 }
      end
    end
    primes.concat(numbers)
    primes
  end

  private_class_method :prime_filter
end

if __FILE__ == $0
  # 実行例
  print ProgramInRuby.prime_numbers(100), "\n"
end
