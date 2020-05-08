Object areSimilar1(a, b){
	int i,k;
	float s;
	for(int e : a)
        s += 5/e - 5/b[i] + (b[i++]!=e?k++:0);
    return s == k>>1;
}


def areSimilar2(a, b) {
	int i
	a.count{it - b[i++]} < 3 & a.sort() == b.sort()
}


n = 2
Random rand = new Random()

100_000.times{
	def a = (0..n).collect{ rand.nextInt(10)+1 }
	def b = (0..n).collect{ rand.nextInt(10)+1 }
	
	if(areSimilar1(a, b) != areSimilar2(a, b)){
		println "$a $b"
	}
}