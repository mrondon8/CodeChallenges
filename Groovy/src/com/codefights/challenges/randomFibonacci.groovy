def randomFibonacci(int n){
	def r = [1,1]
	def q = [r]
	def a = [1]
	
	println "0 1"
	println "1 1"
	n.times{
	    def temp = []
		int i = 0
	    for(; i < q.size; ){
	        def t = q[i++]
	        temp << [t[1], t.sum()]
	        temp << [t[1], t[1]-t[0]]
	    }
	    q = temp
	    //println q
	    a << q.sum{Math.abs(it[1])} / q.size 
		println "${it+2} ${a[-1]} ${a[-1]/a[-2]} ${q*.max().max()}"
	}

}

@groovy.transform.CompileStatic
def fibA(int n){
	def r = [(1L<<32) + 1L]
	int i = 0, j = 1 << n
	long m = (1L<<31) - 1
	long s = (1L < 32)
	for(; i < j; i++){
		long t = r[i]
		long a = t >> 32
		long b = (long)(t & m)
		r << ( (b<<32) + (a+b) )
		
	}
	i = 0
	r.each{
		println "${i++} ${it>>32} ${it&m}"
	}
	0
}

def start = 0
def end = 0
int n = 15

//start = System.currentTimeMillis()
//randomFibonacci(n)
//end = System.currentTimeMillis()
//println "Time ${end - start}"

start = System.currentTimeMillis()
fibA(n+5)
end = System.currentTimeMillis()
println "Time ${end - start}"