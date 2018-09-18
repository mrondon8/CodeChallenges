//def multiplyToSingleDigit(a, l) {
//	(1..l).grep{int n->
//		def e = n
//		def i = 10
//        while(n <= l && i--){
//			if(n < 10)
//				return
//            def p = 1
//            for(; n; n /= 10d)
//                p *= n%10 + a
//            n = p
//		}
//		1
//	}
//}

def multiplyToSingleDigit(a, l) {
	def r = []
	def e = 1
	(1..l).grep{int n->
		(0..9).any{
			def p = 1
			for(; n; n /= 10d)
				p *= n%10 + a
			n = p
			!(9 < n && n <= l)
		}
		n > 9
	}
}
(0..3).each{
	def start = System.currentTimeMillis()
	multiplyToSingleDigit(it, 1_000_000)
	//println multiplyToSingleDigit(2, 21)
	def end = System.currentTimeMillis()

	println "$it: Time: ${end - start}ms"
}