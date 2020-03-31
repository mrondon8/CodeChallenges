package com.codefights.challenges;

import java.util.BitSet;

public class NthPrime {
	int NthPrime(int n){
		int max = n*18;
		BitSet isPrime  = new BitSet(max);
		isPrime.set(0, max);
		for(int i = 3; i*i < max; i+=3){
			if(isPrime.get(i/3)){
				int p = (i+1) | 1;
				for(int j = (p*p)/3; j < max; j += 2*p)
					isPrime.clear(j);
				for(int j = (p*(p-2*(i&1)+4))/3; j < max; j += 2*p)
					isPrime.clear(j);
			}
		}
		int c = 0;
		for(int i = 0; i < max; i++){
			if(isPrime.get(i))
				c++;
			if(c == n)
				return i * 3 + 1 | 1;
		}
		return -1;
	}
}
