package com.codefights.challenges

class MakeString {

	/*
	 * Boolean makeString(List<String> chars, String target){
    //Sort the input pairs so we can try to use the lowest pair first
    chars = chars*.split("")*.sort()*.join("").sort()
    
    //Sort the target so we can compare vs the sorted chars
    List<String> sortedTarget = target.grep().sort()
    
    //println "Chars $chars\nTarget ${sortedTarget}"
    //Lets try a greedy approach
    //This fails a case like [["aa", "ab", "ac", "ag", "gg"], "agacb"]
    //So let's try to add some logic by adding the counts of each variable into a map
    Map<String, Integer> counts = ("a".."z").collectEntries{e->
        [e , chars.count{pair -> pair.find(e)}] 
    }
    
    //println "Counts $counts"
    
    def result = sortedTarget.every{e->
        //println "\nChecking if $e is in chars"
        List<String> pairs = chars.findAll{pair -> pair =~ e}
        if(pairs.isEmpty())
            return false
        //println "Found pairs $pairs in chars"
        String minPair = pairs.max{pair->
            String other = pair - e
            //counts[other] - target.count(other)
            target.count(other)*-9999 + counts[other]
        }
        //println "Found $minPair in pairs"
        if(minPair[0] == minPair[1])
            counts[minPair[0]]--
        else{
            counts[minPair[0]]--
            counts[minPair[1]]--
        }
        //println "Counts $counts"
        chars.remove(minPair)
        //println chars
        target = target.replaceFirst(e, "")
        true
    }
    
    return result
}	
	 */
	static Boolean makeStringBf(List<String> chars, String target, int log){
		//Sort the input pairs so we can try to use the lowest pair first
		chars = chars*.split("")*.sort()*.join("").sort()
		
		//Sort the target so we can compare vs the sorted chars
		List<String> sortedTarget = target.grep().sort()
		
		if(log){
			println "Chars $chars\nTarget ${sortedTarget}"
		}
		//Lets try a greedy approach
		//This fails a case like [["aa", "ab", "ac", "ag", "gg"], "agacb"]
		//So let's try to add some logic by adding the counts of each variable into a map
		Map<String, Integer> counts = ("a".."z").collectEntries{e->
			[e , chars.count{pair -> pair.find(e)}] 
		}
		
		if(log){
			println "Inital values"
			println "Counts $counts"
			println "$sortedTarget"
			println "Loop-----\n"
		}
		
		target = target.split("").sort().join("")
		def result = sortedTarget.every{e->
			List<String> pairs = chars.findAll{pair -> pair =~ e}
			if(pairs.isEmpty())
				return false
			
			if(log){
				println "Found pairs $pairs in chars"
			}
			
			Set<String> possiblePairs = []
			
			pairs.sort{pair->
				String other = pair - e
				//pick one with least remaining letters in target
				//tie break on counts left in chars
				target.count(other)*-9999 + counts[other]
			}
			
			
			
			if(log){
				println "Picked $minPair"
			}
			if(minPair[0] == minPair[1])
				counts[minPair[0]]--
			else{
				counts[minPair[0]]--
				counts[minPair[1]]--
			}
			if(log){
				println "Counts $counts\n"
			}
			chars.remove(minPair)
			
			target = target.replaceFirst(e, "")
			true
		}
		
		return result
	}
	
	static Boolean makeString(List<String> chars, String target){
		//implement a smart version
		
		//Make a map with the lower sorted char as key and all of it's
		//corresponding higher order chars in a list
		Map<String, List<String>> pool = [:].withDefault{ [] }
		
		//Set of all seen letters
		Set<String> letters = []
		
		//Fill the map and set
		chars.each{
			def(a, b) = it.split("").sort()
			pool[a] << b
			letters << a << b
		}
		
		//Sort the values in ascending order
		//pool*.value*.sort()
		
		//Sort the target string in ascending order
		List<String> sortedTarget = target.grep().sort()
		
		//println pool
		
		//Iterate the sorted target one character at a time
		for(v in sortedTarget){
			//check if there is a letter smaller than the current one
			//and if that letter has the current as the first value in it's list
			for(w in letters){
				if(w < v && pool[w] && pool[w][0] == v){
					pool[w].remove(0)
					v = ""
					break
				}
			}
			
			for(; v != ""; ){
				//println "$v ${pool[v]}"
				if (pool[v] == [] || pool[v].size == 0)
					return false
				def w = pool[v].remove(0)
				if (v == w) {
					break
				} else if (v < w) {
					pool[w] << v
					break
				} else if (v > w) {
					v = w
				}
			}
			//println pool
		}
		
		return true
	}
	
	public static void main(String[] a){
		
		String alphabet = ("a".."z").join("")
		Random rand = new Random()
		/*
		List tests = [
			//[["ba","bb", "zz", "bz", "bb", "zz"], "bbzzz"],
			//[["xx", "az", "xx"], "xaz"],
			//[["ba", "dc", "az", "yz"], "zzca"],
			//[["ba", "dc", "az"], "zca"],
			//[["aa", "ab", "ac", "ag", "gg"], "agacb"],
			//[["ab", "ag", "bg", "ab"], "abbg"],
			//[["ol", "zm", "ld", "xo", "yn", "im", "ss", "jn", "cq", "nc", "zd", "tw", "ih", "tw", "rz"], "ozlxyisjcnztitr"],
			//[["ls", "ux", "lt", "fp", "pa",  "nj", "xw", "ra", "tb", "ao",  "zh", "xw", "ih", "sr", "di",  "th", "ba", "lq", "re", "nl",  "tv", "dw", "eg", "jo", "dc",  "ye", "pw", "bd", "jq", "tf"], "lulfpnxrtazxisdtblrntdejdypbjt"]
			[["dj", "dw", "io", "jk", "mw", "pu"], "djkopw"]
		]
		
		tests.each{
			def a1, a2
			println "Testing $it"
			println "Kov ${a1 = MakeString.makeString(*it)}"
			println "Mig ${a2 = MakeString.makeStringBf(*it, 1)}"
			println "Compare ${a1 == a2}\n"
		}
		return
		*/
		
		for (int x = 0; x < 10_000; x++) {
			String t = (0..1_000).collect{ alphabet[rand.nextInt(26)] }.join("")
			List<String> s = t.collect{e -> alphabet[rand.nextInt(26)]+alphabet[rand.nextInt(26)] }
			println "Testing [\"${s.join('", "')}\"]"
			println "Testing \"${t}\""
			return;
			if (MakeString.makeStringBf(s, t, 0) == false) {
				MakeString.makeStringBf(s, t, 1)
				break
			}
		}
		
		
		/*
		String alphabet = ("a".."z").join("")
		Random rand = new Random()
		
		def a1
		def a2
		def i = 100
		def n
		def r = 3
		for(; i--; ){
			def it = []
			it << (0..6).collect{
				alphabet[rand.nextInt(r), rand.nextInt(r)]
			}
			it << (0..5).collect{
				alphabet[rand.nextInt(r)]
			}.join("")
			
			//println "Testing [\"${it[0].join('", "')}\"], \"${it[1]}\""
			a1 = MakeString.makeString(*it)
			a2 = MakeString.makeStringBf(*it)
			//println "Kov $a1"
			//println "Mig $a2"
			if(a1 != a2){
				println "Error!!!!!!!!!!!!!!!!!!!!"
				println "Testing [\"${it[0].join('", "')}\"], \"${it[1]}\""
				println "Kov $a1"
				println "Mig $a2"
			}
		}
		*/
		
	}
}
