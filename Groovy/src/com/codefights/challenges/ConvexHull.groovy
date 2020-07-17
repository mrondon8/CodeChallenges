package com.codefights.challenges

public class ConvexHull{


	static int cross(Point o, Point a, Point b) {
		(a.x - o.x) * (b.y - o.y) - (a.y - o.y) * (b.x - o.x)
	}
	
	static def convexHull(List<Point> points){
		if(points.size < 3)
			return -1
		//sort points
		points.sort()
		
		def lhull = []
		//build lower hull
		points.each{Point p->
			for(; lhull.size > 1 && cross(lhull[-2], lhull[-1], p) <= 0; )
				lhull.removeLast()
			lhull << p
		}
		
		def uhull = []
		//build lower hull
		points.reverse().each{Point p->
			for(; uhull.size > 1 && cross(uhull[-2], uhull[-1], p) <= 0; )
				uhull.removeLast()
			uhull << p
		}
		def hull = lhull.init() + uhull.init()
		println "h size ${hull.size()}"
		
		hull.sum{Point p -> p.z}
	}

	public static void main(String[] args){
		Set points = []
		def n = 30_000
		def m = 900
		def rand = new Random()
		def zz = 2_000_000_000
		
		int j
		n.times{i->
			int y = zz - i*i
			points << new Point([x:i, y:y, z:rand.nextInt(m)+1])
		}
		println points.toString().replace(" ", "")
		println points.size()
		println points.toString().replace(" ", "").size()
		println convexHull(points.toList())
	}
}

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
}