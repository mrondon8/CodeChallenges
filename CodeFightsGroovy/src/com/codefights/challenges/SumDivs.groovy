
@groovy.transform.CompileStatic
long sumDivs(long n) {
    long s = 0
    int mod = 1000000007
	long root = (long)Math.sqrt(n)
	long rootSum = root*(root+1) >> 1L
	//println root
    for(double i = 1; i <= root; i++){
        s = (s + (long)((long)(n/i)*i)) % mod
    }
	//println s
    double d = 2
    for(long i = n; i > root; i = (long)(n/d++)){
        s = (s + (i*(i+1)>>1L) - rootSum) % mod
    }
    s
}


long sumDivs2(long n) {
    long s = 0
    int mod = 1000000007
	long root = (long)Math.sqrt(n)
	long rootSum = root*(root+1) >> 1L
    for(double i = 1; i <= root; i++){
        s += (long)((long)(n/i)*i)
		s %= mod;
    }
    long d = 2
    for(def i = n; i > root; i = Math.floorDiv(n, d++)){
        s = (long)(s + ((i*(i+1)/2 as BigInteger)) - rootSum) % mod
    }
    long end = System.currentTimeMillis()
    s
}
long n = 1e15
long start = System.currentTimeMillis()
println sumDivs( n )
long end = System.currentTimeMillis()
println end - start

start = System.currentTimeMillis()
println sumDivs2( n )
end = System.currentTimeMillis()
println end - start

//100000000
//401854020
//413142932
//3429
	
	