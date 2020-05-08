import java.util.stream.IntStream


/*
 * Given a number n how many different ways can you use the divisors of n to sum up to n mod 1e9+7?

For example:
n = 4
divisors = 1, 2, 4

1 + 1 + 1 + 1 = 4

2 + 1 + 1 = 4
1 + 2 + 1 = 4
1 + 1 + 2 = 4

2 + 2 = 4

4 = 4
 */

@groovy.transform.CompileStatic
def divCo(int n) {
    int[] dp = new int[n+1]
    List<Integer> divs = []
	int m = 10**9 + 7
    
    for(int i = 1; i <= n; i++){
        if(n % i < 1){
            dp[i]++
            divs << i
        }
        int sum = 0
        for(int div : divs){
            sum = (sum + dp[i - div]) % m
        }
        dp[i] = (dp[i] + sum) % m
    }

    dp[n]
}

//(1..10).each{	println "n: $it ans: ${divCo(it)}" }
long s, e, S = System.currentTimeMillis(), E

IntStream.range(1441440, 1441440+1).parallel().mapToObj{n->
	s = System.currentTimeMillis()
	ans = divCo(n)
	e = System.currentTimeMillis()
	def time = e - s
	//println "n: $n ans: $ans time: $time"
	[n, ans, time]
}.toArray().sort{it[2]}.each{n, ans, time->	println "n: $n ans: $ans time: $time"}

E = System.currentTimeMillis()

println "Total time ${E-S}"

//n: 524248 ans: 123935039 time: 952
//n: 524094 ans: 113128333 time: 996
//n: 524208 ans: 218989196 time: 1067