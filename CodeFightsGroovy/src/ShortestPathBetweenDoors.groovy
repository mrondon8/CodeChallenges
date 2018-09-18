def shortestPathBetweenDoors(m){
	//initialize 2d distance array
	def distance_array = new int[m.size][m[0].size]
	
	//find starting and ending points
	def start_end = []
	for(int i = 0; i < m.size; i++)
		for(int j = 0; j < m.size; j++)
			if(m[i][j] == 2)
				start_end << [i, j]
	
	//set start point to 0,0
	def(start,end) = start_end
	m[start[0]][start[1]] = 1
	distance_array[start[0]][start[1]] = 0
	
	//make a queue? array?
	List nodes = new LinkedList()
	nodes.add(start)
	def count = 0
	
	while(nodes){
		//take first element
		def front = nodes.remove()
		//log "checking $front"
		//is it the end?
		if(front == end)
			return distance_array[front[0]][front[1]]
		
		//check up, valid position, not a trap, and not in visited
		if(front[0]-1 >= 0 && m[front[0]-1][front[1]] != 1){
			//node up is valid
			//log "adding up"
			distance_array[front[0]-1][front[1]] += distance_array[front[0]][front[1]] + 1
			nodes.add([front[0]-1,front[1]])
			m[front[0]-1][front[1]] = 1
		}
		//check down, valid position, not a trap, and not in visited
		if(front[0]+1 < m.size && m[front[0]+1][front[1]] != 1){
			//node down is valid
			//log "adding down"
			distance_array[front[0]+1][front[1]] += distance_array[front[0]][front[1]] + 1
			nodes.add([front[0]+1,front[1]])
			m[front[0]+1][front[1]] = 1
		}
		//check left, valid position, not a trap, and not in visited
		if(front[1]-1 >= 0 && m[front[0]][front[1]-1] != 1){
			//node left is valid
			//log "adding left"
			distance_array[front[0]][front[1]-1] += distance_array[front[0]][front[1]] + 1
			nodes.add([front[0],front[1]-1])
			m[front[0]][front[1]-1] = 1
		}
		//check right, valid position, not a trap, and not in visited
		if(front[1]+1 < m.size && m[front[0]][front[1]+1] != 1){
			//node right is valid
			//log "adding right"
			distance_array[front[0]][front[1]+1] += distance_array[front[0]][front[1]] + 1
			nodes.add([front[0],front[1]+1])
			m[front[0]][front[1]+1] = 1
		}
		
		if(1){
		log "node $front"
		distance_array.each{log it}
		log ""
		}
	}
	
	
}


def log(s){
	println s
}


def m = []
def n = 5

n.times{ m << [0]*(n+5)}
m[0][0] = 2
m[n-1][n-1] = 2

def start = System.currentTimeMillis()
println shortestPathBetweenDoors(m)
def end = System.currentTimeMillis()
println end-start
