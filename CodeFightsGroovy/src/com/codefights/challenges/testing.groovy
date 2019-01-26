/*int arrayTriplets(r) {
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
}*/
/*
a + b > c

(a - c > -b)*-1 => -a + c < b => c < a + b => a + b > c


b > c - a < b
*/
int arrayTriplets(r) {
    r.sort()
    println r
    int count = 0
    int size = r.size
    for(int i = 0; i < r.size; i++){
        println "Starting checks with ${r[i]}"
        for(int j = size-1; j > i+1; j--){
            println "checking ${r[j]} - ${r[i]} < ${r[i+1]}"
            if( r[j] - r[i] < r[i+1] ){
                println "true adding ${j-i} to count "
                count += j - i
                j = i
            }
        }
    }
    count
}
/*
[1, 2, 2, 5, 8, 10, 12]
[1, 2, 2]
[5, 8, 10]
[5, 8, 12]
[5, 10, 12]
[8, 10, 12]
*/

arrayTriplets([1, 2, 10, 5, 12, 8, 2])