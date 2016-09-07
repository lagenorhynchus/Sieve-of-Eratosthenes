package main

import (
	"fmt"
	"math"
)

const firstPrime = 2

func PrimeNumbers(max int) []int {
	if max < firstPrime {
		return []int{}
	}

	numbers := make([]int, max-firstPrime+1)
	for i, n := 0, firstPrime; n <= max; i, n = i+1, n+1 {
		numbers[i] = n
	}
	stopPoint := int(math.Sqrt(float64(max)))
	return primeFilter(numbers, stopPoint)
}

func primeFilter(numbers []int, stopPoint int) []int {
	var primes []int
	for n := firstPrime; n <= stopPoint; n++ {
		if numbers[0] == n {
			primes = append(primes, n)
			var ns []int
			for _, x := range numbers[1:] {
				if x%n != 0 {
					ns = append(ns, x)
				}
			}
			numbers = ns
		}
	}
	return append(primes, numbers...)
}

func main() {
	fmt.Println(PrimeNumbers(100))
}
