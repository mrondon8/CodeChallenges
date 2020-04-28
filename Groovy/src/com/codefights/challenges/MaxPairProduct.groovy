@groovy.transform.CompileStatic
long maxPairProduct(List<Long> a) {
    long start = System.currentTimeMillis()
    Long max = a.max()
	Long min = a.min()
	Map<Long, Integer> counts = a.countBy{it}
	//println "counts: $counts"
    Map<Long, Integer> d = new HashMap<>();
    Set<Long> s = new HashSet<>(a)
	List<Long> bs = s.toList().sort() + Long.MAX_VALUE
    if(s.contains(1L))
        return max
    //println "bs: $bs"
	//println bs.size()
    println "Building map with min value ${min} and max value ${max}"
    for(long n : s){
		//println "Running map loop for $n"
        long i = 1
        for(; true; ){
            if(s.contains(i)){
				//println "Increase map count of ${n*i} by ${counts.get(i)}"
                d.put(n*i, d.getOrDefault(n*i, 0) + counts.get(i))
            }
			//println "Searching for next value in array that is larger than $n*$i = ${n*i}"
			int index = Collections.binarySearch(bs, n*i)
			index = index < 0 ? ~index : index+1
			double value = bs.getAt(index)
			if(value == Long.MAX_VALUE) break;
			//println "Value ${value} found at index ${index} is greater than ${n*i}"
			//println "Incrementing i=$i to $value/$n = ${value/n}"
			i = Math.ceil(value/n) as long
			//println "---------------------"
        }
		//println "********************************"
    }
    println "Map built"
	//println d
    List<Long> r = []
	
    for(Long v : s){
        if(d[v]>1)
            r << v
    }
	long end = System.currentTimeMillis()
    //println r
	println "Test time ${end - start} ms"
    r.max() ?: -1
}
boolean flag = true
def input
while(flag){
	def random = new Random()
	//input = (1..4e4).grep{(it+0g).isProbablePrime(20)}
	//Collections.shuffle(input)
	
	long prime = (10_000_000..1e7+100000).find{(it+0g).isProbablePrime(30) }
	input = (1..1e5).collect{ Math.random()*1e15 } + [3,7,21, prime, prime, prime*prime]
	//println input
	Collections.shuffle(input*=10)
	
	println "Input size ${input.size}"
	def ans = maxPairProduct(input*.toLong())
	println "Answer $ans"
	flag = 0 
}

def file = new File("C:/Development/test.txt")
file.text = ""
file << input.toString().replace(" ","")