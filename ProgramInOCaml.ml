(* OCamlによるプログラム *)

module ProgramInOCaml : sig
  val prime_numbers : int -> int list
end = struct
  (* 最初の素数 *)
  let first_prime = 2

  (*
   * 整数のリストnumbersを停止点stop_pointまでで素数としてフィルタリングしたリストを返却する。
   *)
  let rec prime_filter numbers primes stop_point =
    match numbers with
    | [] -> []
    | n :: ns ->
      if n > stop_point
        then List.rev primes @ numbers
        else prime_filter (List.filter (fun x -> x mod n <> 0) ns) (n :: primes) stop_point

  let range first last =
    let rec ran f l a =
      if f > l
        then a
        else ran f (l - 1) (l :: a) in
    ran first last []

  (*
   * エラトステネスの篩(ふるい)により最大値mまでの素数のリストを取得する。
   * mが整数でない場合、コンパイルエラーとなる。
   *)
  let prime_numbers m =
    let numbers = range first_prime m in
    let primes = [] in
    let stop_point = int_of_float (sqrt (float_of_int m)) in
    prime_filter numbers primes stop_point
end

(* 実行例 *)
let () =
  let primes = List.map string_of_int (ProgramInOCaml.prime_numbers 100) in
  print_endline ("[" ^ (String.concat "; " primes) ^ "]")
