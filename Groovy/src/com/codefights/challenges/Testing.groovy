def biggestPlus(List<String> m) {
    m = ["0"*5000, *(1..998).collect{"0" + "1"*4998 + "0"}, "0"*5000]
    biggestPlus1(m)
}

@groovy.transform.CompileStatic
def biggestPlus1(List<String> m) {
    long start = System.currentTimeMillis();
    //height and width of m, and max value to track
    int h = m.size(), w = m[0].size(), max = 0
    //dp arrays for heights up and down
    def dphu = new int[h][w]
    def dphd = new int[h][w]
    //dp arrays for widths left and right
    def dpwl = new int[h][w]
    def dpwr = new int[h][w]

    for(int i = 0; i < h; i++){
        for(int j = 0; j < w; j++){
            if(m[i][j] == "1"){
                dpwl[i][j]++
                if(j-1 >= 0){
                    dpwl[i][j] += dpwl[i][j-1]
                }
                dphu[i][j]++
                if(i-1 >= 0){
                    dphu[i][j] += dphu[i-1][j]
                }
            }
            if(m[h + ~i][w + ~j] == "1"){
                dpwr[h + ~i][w + ~j]++
                if(j-1 >= 0){
                    dpwr[h + ~i][w + ~j] += dpwr[h + ~i][w - j]
                }
                dphd[h + ~i][w + ~j]++                
                if(i-1 >= 0){
                    dphd[h + ~i][w + ~j] += dphd[h - i][w + ~j]
                }
            }
        }
    }
    
    // println "height up"
    // for(int[] e : dphu) println e
    // println "height down"
    // for(int[] e : dphd) println e
    // println "width left"
    // for(int[] e : dpwl) println e
    // println "width right"
    // for(int[] e : dpwr) println e

    for(int i = 0; i < h; i++){
        for(int j = 0; j < w; j++){
            int min = Math.min(Math.min(dphu[i][j], dphd[i][j]), Math.min(dpwl[i][j], dpwr[i][j]))
            max = Math.max(max, min-1)
        }
    }
    long end = System.currentTimeMillis();
    println "n**2\nAnswer: $max\nTime:${end-start} ms"
    return max
}

@groovy.transform.CompileStatic
def biggestPlus2(List<String> m) {
    long start = System.currentTimeMillis();
    int h = m.size(), w = m[0].size(), max = 0
    def dp = new int[h+1][w+1]
    for(int i = 0; i < h && h-i > max; i++){
        for(int j = 0; j < w && w-j > max; j++){
            if(m[i][j] == "1" && max < i && max < j && max < h-i && max < w-j){
                for(int o = 1; i-o >= 0 && i+o < h 
                            && j-o >= 0 && j+o < w
                            && m[i-o][j] == "1" && m[i+o][j] == "1" 
                            && m[i][j-o] == "1" && m[i][j+o] == "1"
                            ; o++){
                    max = Math.max(max, ++dp[i][j])
                }
            }
        }
    }
    long end = System.currentTimeMillis()
    println "n**3\nAnswer: $max\nTime:${end-start} ms"
    return max
}


biggestPlus()