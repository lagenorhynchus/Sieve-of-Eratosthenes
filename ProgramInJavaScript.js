// JavaScriptによるプログラム
// author: OHASHI Kent

var ProgramInJavaScript = (function () {
  var FIRST_PRIME = 2;

  var primeFilter = function (numbers, stopPoint) {
    var primes = [];
    var n;
    var isCandidate = function (x) {
      return x % n !== 0;
    };

    for (n = FIRST_PRIME; n <= stopPoint; n += 1) {
      if (numbers[0] === n) {
        primes.push(n);
        numbers = numbers.slice(1).filter(isCandidate);
      }
    }
    primes = primes.concat(numbers);
    return primes;
  };

  return {
    // エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
    // maxが整数でない場合、TypeErrorを発生させる。
    primeNumbers: function (max) {
      var numbers = [];
      var stopPoint;
      var i;

      if (typeof max !== "number" || !isFinite(max) || !/^[+-]?\d+$/.test(max)) {
        throw new TypeError("max must be an integer");
      }

      if (max < FIRST_PRIME) {
        return [];
      }

      for (i = FIRST_PRIME; i <= max; i += 1) {
        numbers.push(i);
      }
      stopPoint = Math.floor(Math.sqrt(max));
      return primeFilter(numbers, stopPoint);
    }
  };
}());

// 実行例
console.log(ProgramInJavaScript.primeNumbers(100));
