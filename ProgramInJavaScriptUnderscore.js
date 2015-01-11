(function () {
  "use strict";

  /**
   * underscore
   *
   * @type {Object}
   */
  var _ = typeof require !== "undefined" ? require("underscore") : this._;

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
   * @param  {Array} primes     素数リスト
   * @param  {Number} stopPoint フィルタリングの停止点
   * @return {Array}            素数リスト
   */
  var primeFilter = function primeFilter (numbers, primes, stopPoint) {
    var n;

    if (_.isEmpty(numbers)) {
      return [];
    }

    n = _.first(numbers);
    if (n > stopPoint) {
      return primes.concat(numbers);
    } else {
      primes.push(n);
      return primeFilter(_.filter(_.rest(numbers), function (x) {
        return x % n !== 0;
      }), primes, stopPoint);
    }
  };

  /**
   * JavaScript (Underscore.js)によるプログラム
   *
   * @namespace
   */
  var ProgramInJavaScriptUnderscore =  {
    /**
     * エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
     *
     * @param  {Number} max 最大値
     * @return {Array}      素数リスト
     * @throws {TypeError}  maxが整数でない場合
     * @memberOf ProgramInJavaScriptUnderscore
     */
    primeNumbers: function (max) {
      var numbers;
      var primes = [];
      var stopPoint;

      if (typeof max !== "number" || !_.isFinite(max) || !/^[+-]?\d+$/.test(max)) {
        throw new TypeError("max must be an integer");
      }

      numbers = _.range(FIRST_PRIME, max + 1);
      stopPoint = Math.floor(Math.sqrt(max));
      return primeFilter(numbers, primes, stopPoint);
    }
  };
  if (typeof module !== "undefined" && module.exports) {
    module.exports = ProgramInJavaScriptUnderscore;
  } else {
    this.ProgramInJavaScriptUnderscore = ProgramInJavaScriptUnderscore;
  }

  // 実行例
  console.log(ProgramInJavaScriptUnderscore.primeNumbers(100));
}.call(this));
