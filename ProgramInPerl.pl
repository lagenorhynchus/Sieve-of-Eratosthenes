#
# Perlによるプログラム
# author: OHASHI Kent
#

use strict;
use warnings;

my $FIRST_PRIME = 2;

# エラトステネスの篩(ふるい)により最大値maxまでの素数のリストを取得する。
# maxが整数でない場合、例外を発生させる。
sub prime_numbers {
  my ($max) = @_;

  unless ($max =~ /^[+-]?\d+$/) {
    die "max must be an integer";
  }

  if ($max < $FIRST_PRIME) {
    return ();
  }

  my $numbers = [$FIRST_PRIME..$max];
  my $stop_point = int(sqrt($max));
  return &prime_filter($numbers, $stop_point);
}

sub prime_filter {
  my ($numbers, $stop_point) = @_;

  my @primes = ();
  for my $n ($FIRST_PRIME..$stop_point) {
    if ($numbers->[0] == $n) {
      push(@primes, $n);
      @$numbers = grep {$_ % $n != 0} @$numbers[1..$#$numbers];
    }
  }
  push(@primes, @$numbers);
  return @primes;
}

# 実行例
print join(", ", &prime_numbers(100)), "\n";
