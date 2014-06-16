// JavaScriptによるプログラム
// author: OHASHI Kent

var FIRST_PRIME = 2;

// エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
// maxが整数でない場合、TypeErrorを発生させる。
var primeNumbers = function (max) {
    var numbers = [];
    var stopPoint;
    var i;

    if (typeof max !== "number" || !isFinite(max) || !max.toString().match(/^-?\d+$/)) {
        throw {
            name: "TypeError",
            message: "max must be an integer"
        };
    }

    if (max < 0) {
        return [];
    }

    for (i = FIRST_PRIME; i <= max; i += 1) {
        numbers.push(i);
    }
    stopPoint = Math.floor(Math.sqrt(max));
    return primeFilter(numbers, stopPoint);
};

var primeFilter = function (numbers, stopPoint) {
    var primes = [];
    var n;
    var isCandidate = function (x) {
        return x % n !== 0;
    };

    for (n = FIRST_PRIME; n <= stopPoint; n += 1) {
        if (numbers[0] === n) {
            primes.push(n);
            numbers.shift();
            numbers = numbers.filter(isCandidate);
        }
    }
    primes = primes.concat(numbers);
    return primes;
};

// 実行例
console.log(primeNumbers(100));
