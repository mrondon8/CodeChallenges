package com.codefights.challenges
@groovy.transform.CompileStatic
class QuantumLabCorrection{
	static def quantumLabCorrection(List<List<Integer>> f, int a, int k) {
		LinkedHashSet<Integer> s = []
		s.add(a)
		List<Integer> list = []
		List<List<Integer>> x = []
		for(List l in f){
			List<Integer> t = []
			def n = 0
			for(e in l){
				n++
				e ? t.add(n-1) : -1
			}
			x.add(t)
		}
		int n = 0
		while(!s.empty && n < k){
			def t = s.first()
			s.remove(t)
			//list << t
			for(e in x[t])
				s.add(e) && n++
		}
		//println list
		s ? s[k + ~n] : -1
	}

	public static void main(String[] args){
		def start = System.currentTimeMillis()
		Random rand = new Random()
		def n = 30
		def r = (0..n).collect{ (0..n).collect{ rand.nextInt(2) } }
		println r
		println quantumLabCorrection(r, 1, 1_000_000)
		//println quantumLabCorrection([[1,0,0,1],  [0,1,1,0], [1,1,0,1], [1,0,1,1]],2,31)
		def end = System.currentTimeMillis()
		println end - start
	}
}