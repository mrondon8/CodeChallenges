package com.codefights.challenges
/*
Tonight a lot of snow have fallen, so you and your friends decided to make a snowman! But all of you love math a lot, so you thought that a simple snowman would be too boring - some math can make it more interesting. You came up with the following idea: snowman will consist of k main snowballs, and each of them will be constructed from several small snowballs, which amount for each main snowball should be the number from a Fibonacci sequence: F0 = 1, F1 = 1, F2 = 2, F3 = 3, ..., Fi = Fi - 1 + Fi - 2, ...

So, given n - the total number of small snowballs and k - the number of main snowballs, from which a snowman should be constructed, you need to find how many small snowballs is needed for each main snowball. It's guaranteed that n small snowballs can be distributed among k main snowballs in the required way.

Example

For n = 14 and k = 3, the output can be fibonacciSnowman(n, k) = [1, 5, 8].

1, 5 and 8 are the numbers from Fibonacci sequence, their amount is 3 and their sum is 14.
Also correct answers are [3, 3, 8] and all permutations of these two arrays.
*/
def fibonacciSnowman(n, x) {
	(x .. 1).sum{
		x = 1
		def y = 1
		
		while(y < n - it + 2)
			y = x + (x = y)
		
		n -= x
		
		[x]
	}
}
