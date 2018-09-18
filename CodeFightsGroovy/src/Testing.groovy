def marvelousNumber(n) {

	int s = n.size()
	//Check if size is even or odd
	if(s & 1){
		//If the size is odd the number has to be of size + 1 since a marvelousNumber
		//by definition cannot be odd size
		//and the biggest number after this will always be in the form of 44...77....
		s >>= 1
		s++
		"4"*s+"7"*s
	}
	else if(n[0..s/2] >= "7"*((s>>1)+1)){
		s >>= 1
		s++
		"4"*s+"7"*s
	}
	else{
		if("7"*(s>>1) + "4"*(s>>1) < n){
			s >>= 1
			s++
			return         "4"*s+"7"*s
		}
		def l = 0
		def i = 0
		def stack = ["7", "4"]
		while(l++ < 1_000_000){
			//println stack
			def x = stack.pop()

			if(x.size() == s && x.count("4") == x.size()/2 && x >= n)
				return x
			else if(x.count("4") <= s/2 && x.count("7") <= s/2){
				if(x.size() < s){
					stack << x + "7"
					stack << x + "4"
				}
			}

		}
		"0"
	}

}