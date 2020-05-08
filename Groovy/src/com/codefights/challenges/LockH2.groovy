package com.codefights.challenges

public class LockH2{
	
	public List<Integer> primeFactorization(int n){
		List<Integer> factors = []
		int i = 2
		for(; n > 1; ){
			if(n % i < 1){
				factors << i
				n = n.intdiv(i)
			}
			else{
				i++
			}
		}
		return factors
	}
	
	public static void main(String[] args){
		LockH2 lock = new LockH2()
		def primes = [1]
		
		println( lock.primeFactorization(518918400).countBy{it} )
		println( (1..81).sum(lock.&primeFactorization).countBy{it} )
	}
}

//n=4
//[2:15, 3:6, 5:3, 7:2, 11:1, 13:1]
//360
//[2:3, 3:2, 5:1]

//n=5
//[2:22, 3:10, 5:6, 7:3, 11:2, 13:1, 17:1, 19:1, 23:1]
//4320
//[2:5, 3:3, 5:1]

//n=6
//[2:34, 3:17, 5:8, 7:5, 11:3, 13:2, 17:2, 19:1, 23:1, 29:1, 31:1]
//60480
//[2:6, 3:3, 5:1, 7:1]

//n=7
//[2:46, 3:22, 5:10, 7:8, 11:4, 13:3, 17:2, 19:2, 23:2, 29:1, 31:1, 37:1, 41:1, 43:1, 47:1]
//1209600
//[2:8, 3:3, 5:2, 7:1]

//n=8
//[2:63, 3:30, 5:14, 7:10, 11:5, 13:4, 17:3, 19:3, 23:2, 29:2, 31:2, 37:1, 41:1, 43:1, 47:1, 53:1, 59:1, 61:1]
//25945920
//[2:6, 3:4, 5:1, 7:1, 11:1, 13:1]

//n=9
//[2:78, 3:40, 5:19, 7:12, 11:7, 13:6, 17:4, 19:4, 23:3, 29:2, 31:2, 37:2, 41:1, 43:1, 47:1, 53:1, 59:1, 61:1, 67:1, 71:1, 73:1, 79:1]
//518918400
//[2:8, 3:4, 5:2, 7:1, 11:1, 13:1]
