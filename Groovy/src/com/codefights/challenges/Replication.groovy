package com.codefights.challenges
import groovy.transform.CompileStatic
import groovy.transform.Memoized

@CompileStatic
class Replication{
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
			def n = 400
			def d = 400
			//println "Pascal:\n$pascal"
			println "n: $n, d:$d"
			println "Output: ${Replication.replication1(n, d)}"
			println "Iteration Count: $count"
			def end = System.currentTimeMillis()
			println "Time : ${end - start}ms\n"
		}
	}
}
