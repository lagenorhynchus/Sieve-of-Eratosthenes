// JavaScript (Underscore.js)によるプログラムのテスト

QUnit.test("primeNumbersで最大値2までの素数の配列が返却される", function (assert) {
  var max = 2;

  var expected = [2];
  var actual = ProgramInJavaScriptUnderscore.primeNumbers(max);
  assert.deepEqual(actual, expected);
});

QUnit.test("primeNumbersで最大値1までの素数の配列が返却される", function (assert) {
  var max = 1;

  var expected = [];
  var actual = ProgramInJavaScriptUnderscore.primeNumbers(max);
  assert.deepEqual(actual, expected);
});

QUnit.test("primeNumbersで最大値13までの素数の配列が返却される", function (assert) {
  var max = 13;

  var expected = [2, 3, 5, 7, 11, 13];
  var actual = ProgramInJavaScriptUnderscore.primeNumbers(max);
  assert.deepEqual(actual, expected);
});

QUnit.test("primeNumbersで最大値15までの素数の配列が返却される", function (assert) {
  var max = 15;

  var expected = [2, 3, 5, 7, 11, 13];
  var actual = ProgramInJavaScriptUnderscore.primeNumbers(max);
  assert.deepEqual(actual, expected);
});

QUnit.test("primeNumbersで最大値0までの素数の配列が返却される", function (assert) {
  var max = 0;

  var expected = [];
  var actual = ProgramInJavaScriptUnderscore.primeNumbers(max);
  assert.deepEqual(actual, expected);
});

QUnit.test("primeNumbersで最大値マイナス1までの素数の配列が返却される", function (assert) {
  var max = -1;

  var expected = [];
  var actual = ProgramInJavaScriptUnderscore.primeNumbers(max);
  assert.deepEqual(actual, expected);
});

QUnit.test("primeNumbersでmaxが整数でない場合TypeErrorが発生する", function (assert) {
  var max = "2";

  assert.throws(function () {
    ProgramInJavaScriptUnderscore.primeNumbers(max);
  }, TypeError);
});
