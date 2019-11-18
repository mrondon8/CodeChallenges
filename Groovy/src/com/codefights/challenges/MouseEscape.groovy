package com.codefights.challenges

class MouseEscape {
	final char DOOR = 'O'
	final char HURDLE = 'X'
	final char CHEESE = 'C'
	final char SPACE = '_'
	final char MOUSE = '&'

	def mouseEscape(List<List<Character>> board, int steps) {
		//find the mouse coordinates
		def mouseCoordinates = findObjectCoordinates(board, MOUSE)
		//find the exit coordinates of the maze
		def doorCoordinates = findObjectCoordinates(board, DOOR)
		//find the cheese
		def cheeseCoordinates = findObjectCoordinates(board, CHEESE)

		//queue so we can keep track of where to visit
		Queue queue = new ArrayDeque()
		queue.add(mouseCoordinates)
		board[mouseCoordinates[0]][mouseCoordinates[1]] = 0

		//moves that we will max at each step, right left down up
		List<List<Integer>> moves = [[0, 1], [0, -1], [1, 0], [-1, 0]]
		//keep track of how many steps we have taken
		int distance = 0
		int distanceToCheese = 0
		int reachedDoor = 0

		//loop until the queue is empty
		while(queue.isEmpty() == false){
			def(currentX, currentY) = queue.poll()
			distance = board[currentX][currentY]

			for(move in moves){
				def(dx,dy) = move
				dx += currentX
				dy += currentY
				//check out of bounds then check if it is a space
				if(dx >= 0 && dy >=0 && dx < board.size && dy < board[0].size){
					if(board[dx][dy] == SPACE){
						queue.add([dx, dy])
						board[dx][dy] = distance+1
					}
					else if(board[dx][dy] == CHEESE){
						queue.add([dx, dy])
						board[dx][dy] = distanceToCheese = distance+1
					}
					else if([dx, dy]== doorCoordinates){
						reachedDoor = 1
						break
					}
				}
			}
		}
		//if we reached the door in less steps than max we can exit
		if(reachedDoor > 0 && distance < steps){
			return true
		}
		//if we got to the cheese then try again starting from cheese
		else if(distanceToCheese > 0 && distanceToCheese <= steps){
			queue.clear()
			queue.add(cheeseCoordinates)
			board[cheeseCoordinates[0]][cheeseCoordinates[1]] = 0

			distance = 0

			//loop until the queue is empty
			while(queue.isEmpty() == false){
				//board.each{println it}
				println ""
				def(currentX, currentY) = queue.poll()
				distance = board[currentX][currentY]

				for(move in moves){
					def(dx,dy) = move
					dx += currentX
					dy += currentY
					//check out of bounds then check if it is a space
					if(dx >= 0 && dy >= 0 && dx < board.size && dy < board[0].size){
						if(board[dx][dy] == SPACE || board[dx][dy].class == Integer.class && board[dx][dy] > 0){
							queue.add([dx, dy])
							board[dx][dy] = distance-1
						}
						else if([dx, dy]== doorCoordinates){
							board.each{println it}
							println distanceToCheese
							return distanceToCheese + -(distance-1)
						}
					}
				}
			}
		}

		return false
	}

	/**
	 *   Find the location of the object
	 */

	List<List<Integer>> findObjectCoordinates(List<List<Character>> board, char obj){
		int x, y
		for(; x < board.size; x++)
			for(y=0; y < board[0].size; y++)
				if(board[x][y] == obj)
					return [x, y]
		return [-1, -1]
	}

	public static void main(String[] args){
		def m = new MouseEscape()
		//		def r = m.mouseEscape([
		//			["_", "_", "&", "_", "_"],
		//			["_", "_", "_", "_", "_"],
		//			["_", "X", "_", "C", "_"],
		//			["_", "X", "_", "X", "_"],
		//			["_", "O", "X", "_", "_"]
		//		], 6)
		//def r = m.mouseEscape( [["_", "_", "&", "_", "_"], ["_", "_", "_", "_", "_"], ["_", "X", "_", "C", "_"], ["_", "X", "_", "X", "_"], ["_", "O", "X", "_", "_"]],
		def r = m.mouseEscape([
			["C", "_", "_", "_"],
			["_", "_", "X", "_"],
			["_", "X", "X", "_"],
			["_", "X", "X", "_"],
			["_", "_", "_", "_"],
			["_", "_", "X", "_"],
			["_", "_", "X", "_"],
			["_", "&", "X", "O"]
		],
		8)
		println r
	}
}
