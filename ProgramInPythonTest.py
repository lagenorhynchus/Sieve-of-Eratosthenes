# Pythonによるプログラムのテスト

import ProgramInPython
import unittest


class ProgramInPythonTest(unittest.TestCase):
    def test_prime_numbersで最大値2までの素数のリストが返却される(self):
        m = 2

        expected = [2]
        actual = ProgramInPython.prime_numbers(m)
        self.assertEqual(actual, expected)

    def test_prime_numbersで最大値1までの素数のリストが返却される(self):
        m = 1

        expected = []
        actual = ProgramInPython.prime_numbers(m)
        self.assertEqual(actual, expected)

    def test_prime_numbersで最大値13までの素数のリストが返却される(self):
        m = 13

        expected = [2, 3, 5, 7, 11, 13]
        actual = ProgramInPython.prime_numbers(m)
        self.assertEqual(actual, expected)

    def test_prime_numbersで最大値15までの素数のリストが返却される(self):
        m = 15

        expected = [2, 3, 5, 7, 11, 13]
        actual = ProgramInPython.prime_numbers(m)
        self.assertEqual(actual, expected)

    def test_prime_numbersで最大値0までの素数のリストが返却される(self):
        m = 0

        expected = []
        actual = ProgramInPython.prime_numbers(m)
        self.assertEqual(actual, expected)

    def test_prime_numbersで最大値マイナス1までの素数のリストが返却される(self):
        m = -1

        expected = []
        actual = ProgramInPython.prime_numbers(m)
        self.assertEqual(actual, expected)

    def test_prime_numbersでmが整数でない場合TypeErrorが発生する(self):
        m = "2"

        with self.assertRaises(TypeError):
            ProgramInPython.prime_numbers(m)


if __name__ == "__main__":
    unittest.main()
