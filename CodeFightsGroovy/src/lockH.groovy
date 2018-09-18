int n = 5
println n
def lock = new int[n][n]

def e = [*1 .. n*n]
//def p = e.permutations()

//println e
def out = []
//for(r in p){
r = e
for(int z = 0; z < 100_000_000; z++){
	Collections.shuffle(r)
	//populate lock
	for(int i = 0; i < n; i++)
		for(int j = 0; j < n; j++)
			lock[i][j] = r[i*n + j]

	//lock.each{println it}
	//check lock
	//horizontal
	def v1 = lock.collect{it[0]}.inject{a,b -> a*b}
	def v2 = lock.collect{it[-1]}.inject{a,b -> a*b}
	
	if(v1 == v2){
		if(lock.find{it.inject{a,b -> a*b} == v1}){
			println(lock)
			println([v1,v2])
			out << [lock,v1]
		}
	}
}

println "min"
println(out.min{it[1]})