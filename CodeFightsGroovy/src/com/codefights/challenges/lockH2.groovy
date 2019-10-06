package com.codefights.challenges

/* @kov bechmark (on local env) for n's:
 * n = 1 => 1
 * n = 2 => 0
 * n = 3 => 72
 * 72
[1, 8, 9, 2, 4, 3, 6]
[1, 8, 9, 2, 4, 6, 3]
[3, 6, 4, 2, 9, 1, 8]
[3, 6, 4, 2, 9, 8, 1]
[6, 3, 4, 2, 9, 1, 8]
[6, 3, 4, 2, 9, 8, 1]
[8, 1, 9, 2, 4, 3, 6]
[8, 1, 9, 2, 4, 6, 3]

 * n = 4 => 360
 * n = 5 => 4320
 * n = 6 => 60480; 95ms
 * n = 7 => 1209600; 3471ms
 * n = 8 => 25945920; 464.775s
 * n = 9 => 518918400: 152.837min (but it's maybe not the lowest value. I'm used 1..64 range of numbers).
 */

def n = 4
def r = 1..n*n

List stack = []
r.each{stack << [it]}

def map = [:].withDefault{[]}

for(; !stack.isEmpty(); ){
	
	def current = stack.pop()
	
	if(current.size() < 3*n-2){
		r.each{
			if( !(it in current) )
				stack << current + it
		}
	}
	else{
		def a = current[0..n-1].inject(1){x,y->x*y}
		def b = current[n-1..2*n-1].inject(1){x,y->x*y}
		def c = current[2*n-1..-1].inject(1){x,y->x*y}
		if(a==b && b==c)
			map[a] << current
	}
}

map.each{k,v-> 
	println k
	v.each{println it}
}