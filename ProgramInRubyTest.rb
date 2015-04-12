#
# Rubyによるプログラムのテスト
#

require "test/unit"
require "./ProgramInRuby"

class ProgramInRubyTest < Test::Unit::TestCase
  def test_prime_numbersで最大値2までの素数の配列が返却される
    max = 2

    expected = [2]
    actual = ProgramInRuby.prime_numbers(max)
    assert_equal(actual, expected)
  end

  def test_prime_numbersで最大値1までの素数の配列が返却される
    max = 1

    expected = []
    actual = ProgramInRuby.prime_numbers(max)
    assert_equal(actual, expected)
  end

  def test_prime_numbersで最大値13までの素数の配列が返却される
    max = 13

    expected = [2, 3, 5, 7, 11, 13]
    actual = ProgramInRuby.prime_numbers(max)
    assert_equal(actual, expected)
  end

  def test_prime_numbersで最大値15までの素数の配列が返却される
    max = 15

    expected = [2, 3, 5, 7, 11, 13]
    actual = ProgramInRuby.prime_numbers(max)
    assert_equal(actual, expected)
  end

  def test_prime_numbersで最大値0までの素数の配列が返却される
    max = 0

    expected = []
    actual = ProgramInRuby.prime_numbers(max)
    assert_equal(actual, expected)
  end

  def test_prime_numbersで最大値マイナス1までの素数の配列が返却される
    max = -1

    expected = []
    actual = ProgramInRuby.prime_numbers(max)
    assert_equal(actual, expected)
  end

  def test_prime_numbersでmaxが整数でない場合TypeErrorが発生する
    max = "2"

    assert_raise(TypeError) do
      ProgramInRuby.prime_numbers(max)
    end
  end
end
