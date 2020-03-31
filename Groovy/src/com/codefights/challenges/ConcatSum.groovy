package com.codefights.challenges
/*def ccSum(r) {
	long s = 0
	r.each{
		r.each{x->
			s += "$it$x".toLong()
		}
	}
	s
}*/
//4545499854555000
def ccSum(r) {
    def counts = r.countBy{ "$it".size() }
	long m = 10**9 + 7 
	def s = 0g
    
    r*.toLong().each{
        s = (s+it*r.size)
        counts.each{k,v->
            s = (s+it*10G**k*v)
        }
    }
    s % m
}

def r = []
r = [*1..200000]
def ans = ccSum(r)
println ans


