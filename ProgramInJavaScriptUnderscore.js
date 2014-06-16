// JavaScript (Underscore.js)によるプログラム
// author: OHASHI Kent

var FIRST_PRIME = 2;

// エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
// maxが整数でない場合、TypeErrorを発生させる。
var primeNumbers = function (max) {
    var numbers;
    var primes = [];
    var stopPoint;

    if (typeof max !== "number" || !isFinite(max) || !max.toString().match(/^[+-]?\d+$/)) {
        throw {
            name: "TypeError",
            message: "max must be an integer"
        };
    }

    numbers = _.range(FIRST_PRIME, max + 1);
    stopPoint = Math.floor(Math.sqrt(max));
    return primeFilter(numbers, primes, stopPoint);
};

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

// 実行例
console.log(primeNumbers(100));
