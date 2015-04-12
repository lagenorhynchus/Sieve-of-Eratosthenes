/**
 * TypeScriptによるプログラム
 *
 * @namespace
 */
module ProgramInTypeScript {
  "use strict";

  /**
   * 最初の素数
   *
   * @type {Number}
   */
  var FIRST_PRIME: number = 2;

  /**
   * 整数のリストnumbersを停止点stopPointまでで素数としてフィルタリングしたリストを返却する。
   *
   * @param  {Array} numbers    整数リスト
   * @param  {Number} stopPoint フィルタリングの停止点
   * @return {Array}            素数リスト
   */
  var primeFilter = function (numbers: Array<number>, stopPoint: number): Array<number> {
    var primes: Array<number> = [];
    var n: number;
    var isCandidate = (x) => {
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
   * エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
   * maxが数値でない場合、コンパイルエラーとなる。
   *
   * @param  {Number} max 最大値
   * @return {Array}      素数リスト
   * @memberOf ProgramInTypeScript
   */
  export function primeNumbers(max: number): Array<number> {
    var numbers: Array<number> = [];
    var stopPoint: number;
    var i: number;

    if (max < FIRST_PRIME) {
      return [];
    }

    for (i = FIRST_PRIME; i <= max; i += 1) {
      numbers.push(i);
    }
    stopPoint = Math.floor(Math.sqrt(max));
    return primeFilter(numbers, stopPoint);
  }

  // 実行例
  console.log(ProgramInTypeScript.primeNumbers(100));
}
