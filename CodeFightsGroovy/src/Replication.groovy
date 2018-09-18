import groovy.transform.CompileStatic
import groovy.transform.Memoized

@CompileStatic
class Replication{
	/*
	 Brute Force
	 static START = System.currentTimeMillis()
	 def replication1(int n, int d){
	 def start = System.currentTimeMillis()
	 Set s = [[1]*n]
	 //println "Initial Set: $s"
	 d.times{
	 Set t = []
	 for(e in s){
	 n.times{i->
	 def temp = [*e]
	 temp[i]++
	 t << temp.sort()
	 }
	 }
	 s = t
	 //println "$it: $s"
	 }
	 def end = System.currentTimeMillis()
	 println end - start
	 println end - START
	 s*.max().sum()/s.size()
	 }
	 */

	/* Combinations
	 def combination(n, k){
	 factorial(n)/factorial(k)/factorial(n-k)
	 }
	 def factorial(n){
	 n ? n*factorial(n-1) : 1g
	 }
	 def split(n, d){
	 if(d < 0 || n < 1)
	 0
	 else if(n==1)
	 n + d
	 else
	 combination(n+d-1, d) + (0..n).sum{k-> combination(n,k)*split(n-k, d-n+k)}
	 }
	 def replication1(n, d){
	 split(n, d)/combination(n+d-1, d)
	 }
	 */


	//	static List<List<Double>> pascal
	//	static int count = 0
	//	static {
	//		pascal = [[1], [1d, 1d]]
	//		2000.times{ j->
	//			List<Double> row = [1d]
	//			def i = 0
	//			for(; i <= j; i++){
	//				row << (pascal[-1][i] + pascal[-1][i+1])
	//			}
	//			row << 1d
	//			pascal << row
	//		}
	//	}
	//My fastest method
	static int size = 2000
	static double[][] pascal = new double[size+2][size+2]
	static int count = 0
	static {
		pascal[0][0] = 1
		pascal[1][0] = 1
		pascal[1][1] = 1
		size.times{ j->
			pascal[j+2][0] = 1
			int i = 0
			for(; i <= j + 1; i++){
				pascal[j+2][i+1] = pascal[j+1][i] + pascal[j+1][i+1]
			}
		}
	}
	@groovy.transform.Memoized
	static double split(int n, int d){
		count++
		if(n < 1 || d < 0)
			0
		else if(n==1)
			n + d
		else{
			double s = pascal[n+d-1][d];
			for(int k = 0; k <= n; k++)
				s += split(n-k, d-n+k)*pascal[n][k]
			s
		}
	}

	static def replication1(int n, int d){
		split(n, d)/pascal[n+d-1][d]
	}

	static void main(String[] args){
		//def r = new Replication()
		1.times{
			def start = System.currentTimeMillis()
			def n = 513
			def d = 513
			//println "Pascal:\n$pascal"
			println "n: $n, d:$d"
			println "Output: ${Replication.replication1(n, d)}"
			println "Iteration Count: $count"
			def end = System.currentTimeMillis()
			println "Time : ${end - start}ms\n"
		}
	}
}
