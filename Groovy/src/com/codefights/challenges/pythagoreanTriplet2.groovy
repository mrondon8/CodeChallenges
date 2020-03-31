def pythagoreanTriplet(int n){
	int x = n/3
	int y = n/2
	int a = 1, b
	for(; a < x; a++)
		for(b = a+1; b < y; b++)
			if(a*a + b*b == (n-a-b)**2)
				return [a, b, n-a-b]
	return 0
}

def pythagoreanTriplet2(int s){
	/* a = k*(m*m - n*n)
	 * b = k*(2*m*n)
	 * c = k*(m*m + n*n)
	 * s = a + b + c = s
	 * s = k*(m*m - n*n) + k*(2*m*n) + k*(m*m + n*n)
	 * s = k*(m*m - n*n + 2*m*n + m*m + n*n)
	 * s = k*(2*m*m + 2*m*n)
	 * s = 2*k*(m*m + m*n)
	 * s = 2*k*m*(m + n)
	 */
	(1..s**0.5).grep{
		s % it < 1
	}.collect{m->
		def n = s/2/m - m
		def a,b,c
		[m > n, m, n, a = m*m - n*n, b = 2*m*n, c = m*m + n*n, s/(a+b+c), s]
	}.find{it[0]}
}

def pythagoreanTriplet3(int s){
    //odd sums have no answer
    if(s&1)
        return -1
    
    int m,n,r
    int c = s >> 1
    for(m=1; m < c**0.5; m++)
        for(n=1; n < m; n++ )
            if(c%(m*(m+n)) == 0*r++)
                return c/(m*(m+n))*(m*m+n*n)
				
	return -1
}
//@groovy.transform.CompileStatic
def pythagoreanTriplet4(long s){
	//odd sums have no answer
	if(s&1)
		return -1
	
	int m, n
	int c = s >> 1
	int t = 1 + (int)Math.sqrt(c)
	Set<Integer> r = []
	for(m=1; m < t; m++)
		for(n = 1+(m&1); n < m; n += 2 )
			if(c%(m*(m+n)) < 1)
				r.add(c.intdiv(m*(m+n))*(m*m+n*n))
	//return [r, r.sum(0L), r.grep{long x-> new BigInteger(x).isProbablePrime(32)}]
}
/*int n = 0
for(; n < 1_000_000; n++){
	if(pythagoreanTriplet3(n) != pythagoreanTriplet4(n))
		println n
	if(n%10_000 == 0)
		println "On $n"
}*/

//println( [pythagoreanTriplet2(374), pythagoreanTriplet(374), pythagoreanTriplet3(374), 157] )
//println( [pythagoreanTriplet2(608), pythagoreanTriplet(608), pythagoreanTriplet3(608), 265] )
//println( [pythagoreanTriplet2(8576), pythagoreanTriplet(8576), pythagoreanTriplet3(8576), 4105] )
//println( [pythagoreanTriplet2(1326), pythagoreanTriplet(1326), pythagoreanTriplet3(1326), 555] )
//println( [pythagoreanTriplet2(13038), pythagoreanTriplet(13038), pythagoreanTriplet3(13038), 5475] )
//println( [pythagoreanTriplet2(75444), pythagoreanTriplet(75444), pythagoreanTriplet3(75444), 31435] )

def start, end, result, result2, n, m, results = []
def rand = new Random()
100.times{
	n = rand.nextInt(Integer.MAX_VALUE as int)
	n -= n&1
	start = System.currentTimeMillis()
	result = pythagoreanTriplet4(n)
	end = System.currentTimeMillis()
	println("Time: ${end - start}ms $n $result")
	if(result[0])
		results << [end-start, n, result]
}

results.sort{it[0]}.each{println it}
