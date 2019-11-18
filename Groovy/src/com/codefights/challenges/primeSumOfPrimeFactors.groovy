/*Given an integer n, your task is to check if the sum of the prime factors of n is a prime.
Example
For n = 148, the output should be primeSumOfPrimeFactors(n) = true.
148 has prime factors 2, 2 and 37. Their sum is 41, which is prime, so the answer is true.
For n = 8, the output should be primeSumOfPrimeFactors(n) = false.
8 has prime factors 2, 2, and 2, which sum to 6. Since 6 isn't a prime (6 = 2 * 3), the answer is false.
Input / Output
[execution time limit] 4 seconds (rb)
[input] integer n
An integer value.
Guaranteed constraints:
1 ≤ n ≤ 109
[output] boolean
Return true if the sum of the prime factors of the given numbers is prime, false otherwise.
*/

def primeSumOfPrimeFactors(int n){
	int i = 2
	def factors = []
	while(n > 1){
		if(n%i){
			i++
		}else{
			factors << i
			n /= i
		}
	}
	factors.sum(0g).isProbablePrime(9)
}

println( (1..20).collect{ primeSumOfPrimeFactors(it) } )