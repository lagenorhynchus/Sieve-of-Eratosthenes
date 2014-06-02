// JavaScriptによるプログラム
// author: OHASHI Kent

var FIRST_PRIME = 2;

// エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
// maxが数値でない場合、TypeErrorを発生させる。
var primeNumbers = function (max) {
    var numbers = [];
    var stopPoint = 0;
    var i = 0;

    if (typeof max !== "number" || !isFinite(max)) {
        throw {
            name: "TypeError",
            message: "max must be a number"
        };
    }

    if (max < 0) {
        return [];
    }

    for (i = FIRST_PRIME; i <= max; i++) {
        numbers.push(i);
    }
    stopPoint = Math.sqrt(Math.floor(max));
    return primeFilter(numbers, stopPoint);
};

var primeFilter = function (numbers, stopPoint) {
    var primes = [];
    var n = 0;

    for (n = FIRST_PRIME; n <= stopPoint; n++) {
        if (numbers[0] === n) {
            primes.push(n);
            numbers.shift();
            numbers = numbers.filter(function (x) {
                return (x % n !== 0);
            });
        }
    }
    primes = primes.concat(numbers);
    return primes;
};

// 実行例
document.writeln(primeNumbers(100));
