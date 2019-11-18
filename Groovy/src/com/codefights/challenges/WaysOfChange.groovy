package com.codefights.challenges
/*
You are a cashier in a supermarket. In your cash register you have an unlimited number of coins worth 1, 2, 5 and 10 cents.

Today there are only a few customers in the store and you are bored. So to entertain yourself, when returning the change, you consider how many different combinations of coins you could use.

Note: The order of the coins doesn't matter, so for example, 2, 2, 1 is considered the same as 2, 1, 2.

Given amount, an integer representing the amount of change owed to the customer, your task is to find the number of ways you could return the change.

Example

For amount = 4, the output should be waysOfChange(amount) = 3.

4 cents could be returned in the following ways:

1, 1, 1, 1
2, 1, 1
2, 2
So since there are 3 possible combinations, the answer is 3.

For amount = 0, the output should be waysOfChange(amount) = 1.

The customer must have paid using the exact amount because we don't owe them any change. No coins will be given, and there's only one way this can be done, so the answer is 1.
*/
//71

def waysOfChange(n){
	def d = [1]*1e6
	for(e in [1,4,9])
		for(x in d)
			e < n ? d[++e] += x : 0
	d[n]
}


//70
/*
def f = {n, m=3->
	m*n ? n < 1 ? 0 : f(n, m-1) + f(n-[2,5,10][m-1], m) : 1
}, waysOfChange = f
*/