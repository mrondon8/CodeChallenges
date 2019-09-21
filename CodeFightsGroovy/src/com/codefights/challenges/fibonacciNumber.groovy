//Palindrome Binary

/*
For n >= 2 
a(2^n-1) = 2^(2n-2) - 1 
a(2^n) = 2^(2n-2) + 1
a(2^n+1) = 2^(2n-2) + 2^(n-1) + 1
a(2^n + 2^(n-1)) = 2^(2n-1) + 1
*/


def fib(n){
	int a=0,b=1
	for(;n--;)
		b = a + (a=b)
	return a
}

int fib2(n,k){
	Math.round(1.62**n / k)
}

println( (1..5000).findAll{k->
	(1..15).every{n->
		fib(n) == fib2(n,k/1000)
	}
})

println((1..30).collect{
	it/2
})