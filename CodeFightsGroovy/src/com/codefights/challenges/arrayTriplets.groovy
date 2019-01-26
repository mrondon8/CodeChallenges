int arrayTriplets1(r) {
    r.sort()
    int count = 0
    for(int i = 0; i < r.size; i++){
        for(int j = i+1; j < r.size; j++){
            for(int k = j+1; k < r.size; k++){
                def(a,b,c) = r[i,j,k]
                if(a + b > c && a + c > b && b + c > a){
                    println([a,b,c])
                    count++
                }
            }
        }
    }
    count
}
/*
a + b > c

(a - c > -b)*-1 => -a + c < b => c < a + b => a + b > c


b > c - a < b
*/
int arrayTriplets2(r) {
    r.sort()
	int count = 0
	for(int i = 0; i < r.size; i++){
		int k = i + 2
		for(int j = i + 1; j < r.size; j++){
			while(k < r.size && r[i] + r[j] > r[k])
				k++
			if(k > j)
				count += k - j - 1
		}
	}

	println count
	0
}
/*
[1, 2, 2, 5, 8, 10, 12]
[1, 2, 2]
[5, 8, 10]
[5, 8, 12]
[5, 10, 12]
[8, 10, 12]

[1, 2, 2, 4, 6, 6, 7, 19]
[1, 2, 2]
[1, 6, 6]
[2, 6, 6]
[2, 6, 7]
[2, 6, 7]
[2, 6, 6]
[2, 6, 7]
[2, 6, 7]
[4, 6, 6]
[4, 6, 7]
[4, 6, 7]
[6, 6, 7]

*/

println arrayTriplets2([1, 2, 10, 5, 12, 8, 2])

