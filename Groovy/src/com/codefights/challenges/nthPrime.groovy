def sieve(n){
	def bound = n*100 + 10
    def isPrime  = new BitSet(bound)
    isPrime[0..1] = false
    isPrime[2..bound] = true
    (2..(Math.sqrt(bound))).each { pc ->
        if (isPrime[pc]) {
            ((pc**2)..bound).step(pc) { isPrime[it] = false }
        }
    }
    (0..bound).findAll { isPrime[it] }[n]
}

@groovy.transform.CompileStatic
def sieve2(n){
	int max = 179_424_673
	BitSet isPrime  = new BitSet(max)
	isPrime.set(0, max)
	for(int i = 3; i*i < max; i+=3){
		if(isPrime.get(i.intdiv(3))){
			int p = (i+1) | 1
			for(int j = (int) (p*p).intdiv(3); j < max; j += 2*p)
				isPrime.clear(j)
			for(int j = (int) (p*(p-2*(i&1)+4)).intdiv(3); j < max; j += 2*p)
				isPrime.clear(j)
		}
	}
	int c = 0;
	for(int i = 0; i < max; i++){
		if(isPrime[i])
			c++
		if(c == n){
			n = 0
			println i * 3 + 1 | 1
		}
	}
	return c
}

//1299721
//2252


def start, end, n
n = 10_000_000
start = System.currentTimeMillis()
//println sieve(n)
end = System.currentTimeMillis()
println end - start
start = System.currentTimeMillis()
println sieve2(n)
end = System.currentTimeMillis()
println end - start