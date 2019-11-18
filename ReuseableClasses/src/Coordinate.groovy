public class Coordinate{
	int x;
	int y;
	
	public Coordinate(int x, int y){
		this.x = x
		this.y = y
	}
	
	public double distance(Coordinate other){
		( (this.x - other.x)**2 + (this.y - other.y)**2 )**0.5
	}
	
		
	public static void main(String[] args){
		println "Hello World!"
		
		Coordinate c1 = new Coordinate(1,1)
		Coordinate c2 = new Coordinate(2,2)
		
		println c1.distance(c2)
	}
}

