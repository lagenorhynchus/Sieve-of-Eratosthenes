(function () {
  "use strict";

  /**
   * 最初の素数
   *
   * @type {Number}
   */
  var FIRST_PRIME = 2;

  /**
   * 整数のリストnumbersを停止点stopPointまでで素数としてフィルタリングしたリストを返却する。
   *
   * @param  {Array} numbers    整数リスト
   * @param  {Number} stopPoint フィルタリングの停止点
   * @return {Array}            素数リスト
   */
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

  /**
   * JavaScriptによるプログラム
   *
   * @namespace
   */
  var ProgramInJavaScript = {
    /**
     * エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
     *
     * @param  {Number} max 最大値
     * @return {Array}      素数リスト
     * @throws {TypeError}  maxが整数でない場合
     * @memberOf ProgramInJavaScript
     */
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
  if (typeof module !== "undefined" && module.exports) {
    module.exports = ProgramInJavaScript;
  } else {
    this.ProgramInJavaScript = ProgramInJavaScript;
  }

  // 実行例
  console.log(ProgramInJavaScript.primeNumbers(100));
}.call(this));
