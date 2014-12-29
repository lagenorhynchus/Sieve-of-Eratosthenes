###
CoffeeScriptによるプログラム
###

ProgramInCoffeeScript = do ->
  # 最初の素数
  FIRST_PRIME = 2

  # 整数のリストnumbersを停止点stopPointまでで素数としてフィルタリングしたリストを返却する。
  #
  # @param  [Array] numbers    整数リスト
  # @param  [Number] stopPoint フィルタリングの停止点
  # @return [Array]            素数リスト
  #
  primeFilter = (numbers, stopPoint) ->
    primes = []
    isCandidate = (x) ->
      x % n isnt 0

    for n in [FIRST_PRIME..stopPoint]
      if numbers[0] is n
        primes.push(n)
        numbers = numbers.slice(1).filter(isCandidate)
    primes.concat(numbers)

  {
    # エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
    #
    # @param  [Number] max 最大値
    # @return [Array]      素数リスト
    # @throw  [TypeError]  maxが整数でない場合
    #
    primeNumbers: (max) ->
      numbers = []

      if typeof max isnt "number" or not isFinite(max) or not /^[+-]?\d+$/.test(max)
        throw new TypeError("max must be an integer")

      if max < FIRST_PRIME
        return []

      numbers = [FIRST_PRIME..max]
      stopPoint = Math.floor(Math.sqrt(max))
      primeFilter(numbers, stopPoint)
  }

# 実行例
console.log ProgramInCoffeeScript.primeNumbers(100)
