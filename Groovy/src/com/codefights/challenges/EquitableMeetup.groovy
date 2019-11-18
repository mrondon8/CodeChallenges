package com.codefights.challenges
/*
 * https://app.codesignal.com/challenge/Hd8f7gmnfa7HzXjbN
 * You and your friends are planning out your Halloween night experience! You all have your costumes ready to go, and you've decided on a rendezvous point where you'll all meet, then go trick-or-treating.
 You'd all like to meet up as soon as possible, but you're also all interested in picking up some candy along the way. So you decide on the following plan:
 Each of you will visit at least one house on your way toward the rendezvous point.
 Eventually each of you will stop visiting houses, but until then no houses will be skipped.
 You decide that fairness is most important, so the goal will be for everyone to visit houses in such a way that the total candy spread is minimized (ie: the maximum amount of candy collected by any friend minus the minimum amount of candy collected by any friend is the smallest possible).
 From extensive research and prior encounters, you're all aware of how much candy will be given out at each house. Since each of you will be walking different routes before meeting up, the amounts given by each house, on each friend's path, are represented by friendsRoutes, where friendsRoutes[i][j] is the amount of candy given by the jth house that the ith friend will encounter.
 Your task is to find how many houses each friend should visit before going directly to the rendezvous point.
 If there are multiple ways to minimize the spread, choose the option that involves visiting fewer houses (so that you can meet up earlier).
 friendsRoutes is not necessarily a rectangular matrix.
 Example
 For
 friendsRoutes = [[1,2,1,1,1,1], 
 [5,4,7,4,5,9], 
 [3,3,3,3,3,3,3,3,3]]
 the output should be equitableMeetup(friendsRoutes) = [4, 1, 2].
 Since each friend must visit at least one house each, the friends will collect 1, 5, and 3 respectively, so the initial spread is 5 - 1 = 4.*/
class EquitableMeetup{
	// first attempt greedy way doesn't work
	def equitableMeetup2(f) {
		println "Friends"
		f.each{println it}
		//indicex visited
		def c = [0]*f.size
		//collected sum
		def s = f*.get(0)
		//range
		def r = range(s)
		def o = [:]
		o[r] = [*c]
		//Loop forever break when stepping through any house does not decrease the range
		while(1){
			println "Indices: $c, Sum: $s, Range: $r"
			//Hold previous range
			int temp = r
			//Try to step through all friends
			for(int i = 0; i < f.size; i++){
				if(f[i][c[i]+1] == null){
					println "This friend is over"
					continue
				}
				//Increment this index by one
				c[i]++
				//Increase the sum of this friend by index
				s[i] += f[i][c[i]]
				println "Stepping through $i, new sums: $s, current range $r, new range ${range(s)}, indices: $c"
				//Check if the range stayed the same or increased
				if(r < range(s)){
					//If it did then undo this step
					s[i] -= f[i][c[i]]
					c[i]--
				}
				else{
					//Keep the new range
					i--
					r = range(s)
					//Change min indices for this range
					println "Checking current sums for this range: $o ${o[r]} $c"
					if( (o[r] != null ? o[r].sum() : 1e9) > c.sum())
						o[r] = [*c]
				}
			}
			//return indices if it hasn't changed
			if(temp == r){
				println "Range didn't change returning"
				return o[r]*.plus(1)
			}
		}
	}


	//2nd attempt by staying on lowest min instead of going in sequence
	def equitableMeetup(f) {
		//println "Friends"
		//f.each{println it}
		//indicex visited
		def c = [0]*f.size

		//collected sum
		def s = f*.get(0)

		//range
		def r = range(s)

		def o = [:]
		o[r] = [*c]

		//Loop forever break when stepping through any house does not decrease the range
		while(1){
			//println "Indices: $c, Sum: $s, Range: $r"
			//Hold previous range
			int temp = r
			int i = (0..<s.size).min{ s[it] }

			if(f[i][c[i]+1] == null){
				return o.min{ it.key }.value*.plus(1)
			}
			//Increment this index by one
			c[i]++
			//Increase the sum of this friend by index
			s[i] += f[i][c[i]]

			//println "Stepping through $i, new sums: $s, current range $r, new range ${range(s)}, indices: $c"
			//Keep the new range
			r = range(s)

			//Change min indices for this range
			//println "Checking current sums for this range: map:$o, map this range: ${o[r]} indices: $c"
			if( (o[r] != null ? o[r].sum() : 1e9) > c.sum())
				o[r] = [*c]

		}
	}

	def range(r){
		r.max() - r.min()
	}


	public static void main(String[] args){
		def e = new EquitableMeetup()
		def t = []
		def n = 30
		def m = 1e4
		n.times{
			def rand = new Random()
			t << (0..m).collect{ rand.nextInt(1000) }
		}
		println t.size
		def start = System.currentTimeMillis()
		println(e.equitableMeetup(t))
		def end = System.currentTimeMillis()
		println end - start
		//println(e.equitableMeetup([[1, 2, 1, 1, 1, 1], [5, 4, 7, 4, 5, 9], [3, 3, 3, 3, 3, 3, 3, 3, 3]]))
		//println(e.equitableMeetup([[1], [7,1,9,5,2,3,1,4,1,1,2,5], [5,9,3,4,2], [2,2,2,2,2,9,2]]))
		//println(e.equitableMeetup([			[25, 40, 23, 59, 40, 43, 94, 30, 78, 87],			[25, 83, 63, 100, 58, 17, 74, 73, 25, 51],			[76, 71, 16, 76, 45, 83, 99, 48, 66, 15],			[65, 86, 89, 73, 95, 23, 13, 34, 37, 63],			[14, 42, 25, 62, 38, 95, 82, 70, 19, 49]		]))
	}
}

