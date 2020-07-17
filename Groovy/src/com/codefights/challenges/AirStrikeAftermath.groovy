//https://app.codesignal.com/challenge/WunfbcJNKBc44s298
class Point implements Comparable<Point>{
	int x, y, z;
	String toString(){
		"[$x, $y, $z]"
	}

	int compareTo(Point o){
		this.x <=> o.x ?: this.y <=> o.y
	}

	@Override
	boolean equals(Object o){
		Point O = (Point)o
		this.x == O.x && this.y == O.y
	}
	
	@Override
	int hashCode(){
		this.x * 1_000_000 + this.y
	}

    double distance(Point p){
        (this.x - p.x)**2 + (this.y - p.y)**2
    }
}

def airStrikeAftermath(List<List<Integer>> soldiers, List<List<Integer>> trenches, int maxDistance) {
    //sort the soldiers and trenches by x, y points
    List<Point> soldierLocations = soldiers.collect{x, y-> new Point([x: x, y: y])}.sort()
    List<Point> trenchLocations = trenches.collect{x, y, z-> new Point([x: x, y: y, z: z])}.sort()
    //println trenchLocations
    

    Map<Integer, List<Integer>> soldierTrenchReach = [:].withDefault{ new ArrayList<Integer>() }
    Map<Integer, List<Integer>> soldiersThatCanReachNTrenches = [:].withDefault{ new ArrayList<Integer>() }
    
    int k = 0
    soldierLocations.eachWithIndex{s, i->
        int f = 0, trenchesReached = 0
        for(int z = k; z < trenchLocations.size(); z++){
            Point t = trenchLocations[z]
            int d = s.distance(t)
            if(d <= maxDistance**2){
                soldierTrenchReach[i] << z
                trenchesReached++
            }
            if(t.x - s.x > maxDistance){
                break
            }
            if(f == 0){
                if(s.x - t.x < maxDistance){
                    k = z
                    f = 1
                }
            }
        }
        soldiersThatCanReachNTrenches[trenchesReached] << i
    }
    //return 0
    int safeSoldierCount = 0
    (1..trenchLocations.size()).each{int canReachNTrenches->
        
        Map<Integer, List<Integer>> z = [:]
        soldiersThatCanReachNTrenches[canReachNTrenches].each{int soldierIndex->
            //int trenchIndex = 0
            int maxCapacityTrenchIndex = -1
            int maxCapacityTrenchValue = 1
            soldierTrenchReach[soldierIndex].each{int trenchIndex->
                if(trenchLocations[trenchIndex].z >= maxCapacityTrenchValue){
                    maxCapacityTrenchIndex = trenchIndex
                    maxCapacityTrenchValue = trenchLocations[trenchIndex].z
                }
                trenchIndex++
            }
            if(maxCapacityTrenchIndex >= 0){
                trenchLocations[maxCapacityTrenchIndex].z--
                safeSoldierCount++
            }
        }
    }

    return safeSoldierCount
}

/*
//int n = 1_000, soldierCount = 20000, trenchCount = 10000, trenchSize = 50, distance = 500
int n = 10, soldierCount = 20, trenchCount = 5, trenchSize = 5, distance = 5
def rand = new Random()
100.times{
	def a = []
	def b = []
	def c = rand.nextInt(distance) + 1
	rand.nextInt(soldierCount).times{
		a << [rand.nextInt(n), rand.nextInt(n)]
	}
	rand.nextInt(trenchCount).times{
		b << [rand.nextInt(n), rand.nextInt(n), rand.nextInt(trenchSize) + 2]
	}
	
	long start, end, total
	start = System.currentTimeMillis()	
	def x = airStrikeAftermath(a, b, c)
	end = System.currentTimeMillis()
	total = end - start
	println total
	def file = new File("C:/Development/test/$it-$total"+".txt")
	file << "$a\n\n$b\n\n$c\n\n$x"
	
	
	def x = airStrikeAftermath(a, b, c)
	def y = airStrikeAftermath2(a, b, c)
	
	if( Math.abs(x - y) >= 1 ){
		println "--${Math.abs(x - y)}\nSoldiers: \n$a\n Trenches: \n$b\n maxD: \n$c\n Answers: $x vs $y\n airStrikeAftermath($a, $b, $c)"
	}
}*/


def(a,b,c) = new File("C:/Development/test/14-61763.txt").text.split("\n\n")

a = (a =~ /\[.+?\]/).collect{ Eval.me( it.replace("[[", "[").replace("]]", "]") ) }
println "done a"
b = (b =~ /\[.+?\]/).collect{ Eval.me( it.replace("[[", "[").replace("]]", "]") ) }
println "done b"

println airStrikeAftermath(a, b, c as int)
