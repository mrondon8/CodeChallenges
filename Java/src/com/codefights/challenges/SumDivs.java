package com.codefights.challenges;

public class SumDivs {
	static long sumDivs(long n) {
	    long s = 0;
	    int mod = 1000000007;
		long root = (long)Math.sqrt(n);
		System.out.println(root);
		long rootSum = root*(root+1)/2;
	    for(long i = 1; i <= root; i++){
			s += n/i*i;
			s %= mod;
	    }
	    System.out.println(s);
	    long d = 2;
	    for(long i = n; i > root; i = n/d++){
	        s = (s + (i*(i+1)>>1) - rootSum) % mod;
	    }
	    return s;
	}

	public static void main(String[] args) {
		
	
	long start = System.currentTimeMillis();

	System.out.println( sumDivs( 10000000000000000L ) );
	
	long end = System.currentTimeMillis();
	System.out.println(end - start);
	}


}

//100000000
//402223556
//308353304
//3316


//378353304



