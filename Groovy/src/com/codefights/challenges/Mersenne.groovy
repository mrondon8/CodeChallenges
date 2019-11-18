package com.codefights.challenges
/*
 Consider a number m = 2p - 1, where p is prime. If m is itself prime it is known as a Mersenne prime.
 
 Given p determine whether this exponent yields a Mersenne prime.
 
 Example
 
 For p = 3, the output should be
 mersenne(p) = true.
 m = 23 - 1 = 7, and 7 is prime.
 
 For p = 11, the output should be
 mersenne(p) = false.
  = 211 - 1 = 2047, and 2047 is NOT prime.
 
 Input/Output
 
 [time limit] 6000ms (groovy)
 [input] integer p
 
 A prime number.
 
 Guaranteed constraints:
 2 < p < 1500.
 
 [output] boolean
 
 true if 2p - 1 is prime, false otherwise.
  */
 

def mersenne(p) {
	(2**p-1g).isProbablePrime 9
}

println mersenne(5)
println 89%5
