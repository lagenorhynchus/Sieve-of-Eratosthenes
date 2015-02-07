%% Erlangによるプログラム

-module(program_in_erlang).
-export([prime_numbers/1]).
-export([main/0]).

%% 最初の素数
-define (FIRST_PRIME, 2).

%% エラトステネスの篩(ふるい)により最大値Maxまでの素数のリストを取得する。
%% Maxが整数でない場合、errorを発生させる。
prime_numbers(Max) ->
  if
    not is_integer(Max) ->
      error("Max must be an integer");
    Max < ?FIRST_PRIME ->
      [];
    true ->
      Numbers = lists:seq(?FIRST_PRIME, Max),
      Primes = [],
      StopPoint = trunc(math:sqrt(Max)),
      prime_filter(Numbers, Primes, StopPoint)
  end.

%% 整数のリストNumbersを停止点StopPointまでで素数としてフィルタリングしたリストを返却する。
prime_filter(Numbers, Primes, StopPoint) ->
  case Numbers of
    [] ->
      [];
    [N|_] when N > StopPoint ->
      lists:reverse(Primes) ++ Numbers;
    [N|Ns] when true ->
      prime_filter([X || X <- Ns, X rem N =/= 0], [N | Primes], StopPoint)
  end.

%% 実行例
main() ->
  io:format("~p~n", [prime_numbers(100)]).
