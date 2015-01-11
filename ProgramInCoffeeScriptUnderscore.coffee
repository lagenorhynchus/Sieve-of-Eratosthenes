###
CoffeeScript (Underscore.js)によるプログラム
###

"use strict"

_ = if require? then require("underscore") else this._

# 最初の素数
FIRST_PRIME = 2

# 整数のリストnumbersを停止点stopPointまでで素数としてフィルタリングしたリストを返却する。
#
# @param  [Array] numbers    整数リスト
# @param  [Array] primes     素数リスト
# @param  [Number] stopPoint フィルタリングの停止点
# @return [Array]            素数リスト
#
primeFilter = (numbers, primes, stopPoint) ->
  if _.isEmpty(numbers)
    return []

  [n, ns...] = numbers
  if n > stopPoint
    primes.concat(numbers)
  else
    primes.push(n)
    primeFilter(_.filter(ns, (x) ->
      x % n isnt 0
    ), primes, stopPoint)

ProgramInCoffeeScriptUnderscore = {
  # エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
  #
  # @param  [Number] max 最大値
  # @return [Array]      素数リスト
  # @throw  [TypeError]  maxが整数でない場合
  #
  primeNumbers: (max) ->
    if typeof max isnt "number" or not isFinite(max) or not /^[+-]?\d+$/.test(max)
      throw new TypeError("max must be an integer")

    numbers = _.range(FIRST_PRIME, max + 1)
    primes = []
    stopPoint = Math.floor(Math.sqrt(max))
    primeFilter(numbers, primes, stopPoint)
}
if module?.exports?
  module.exports = ProgramInCoffeeScriptUnderscore
else
  this.ProgramInCoffeeScriptUnderscore = ProgramInCoffeeScriptUnderscore

# 実行例
console.log ProgramInCoffeeScriptUnderscore.primeNumbers(100)
