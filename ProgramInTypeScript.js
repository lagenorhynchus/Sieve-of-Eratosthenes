/**
 * TypeScriptによるプログラム
 *
 * @namespace
 */
var ProgramInTypeScript;
(function (ProgramInTypeScript) {
    "use strict";
    /**
     * 最初の素数
     *
     * @type {Number}
     */
    var FIRST_PRIME = 2;
    /**
     * 整数の配列numbersを停止点stopPointまでで素数としてフィルタリングした配列を返却する。
     *
     * @param  {Array} numbers    整数配列
     * @param  {Number} stopPoint フィルタリングの停止点
     * @return {Array}            素数配列
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
     * エラトステネスの篩(ふるい)により最大値maxまでの素数の配列を取得する。
     * maxが数値でない場合、コンパイルエラーとなる。
     *
     * @param  {Number} max 最大値
     * @return {Array}      素数配列
     * @memberOf ProgramInTypeScript
     */
    function primeNumbers(max) {
        var numbers = [];
        var stopPoint;
        var i;
        if (max < FIRST_PRIME) {
            return [];
        }
        for (i = FIRST_PRIME; i <= max; i += 1) {
            numbers.push(i);
        }
        stopPoint = Math.floor(Math.sqrt(max));
        return primeFilter(numbers, stopPoint);
    }
    ProgramInTypeScript.primeNumbers = primeNumbers;
    // 実行例
    console.log(ProgramInTypeScript.primeNumbers(100));
})(ProgramInTypeScript || (ProgramInTypeScript = {}));
