package com.codefights.challenges
/*
Given an array of numbers behaviors, each number representing how good a child has behaved in the last year, determine how many children will get gifts from santa. A child gets a gift if he/she has behaved better than at least half of his/her older siblings. The array is sorted by the age of the children.

Note: The oldest kid always gets a gift.

Example

For behaviors = [3, 3, 4, 5, 2, 1, 5, 5], the output should be
luckyKids(behaviors) = 2.

Only 4th and 8th kids will get gifts.

The 1st kid has behaved better than 2 older siblings, 2 < 7 / 2, so he/she won't get a gift.
The 2nd kid has behaved better than 2 older siblings, 2 < 6 / 2, so he/she won't get a gift.
The 3rd kid has behaved better than 2 older siblings, 2 < 5 / 2, so he/she won't get a gift.
The 4th kid has behaved better than 2 older siblings, 2 = 4 / 2, so he/she will get a gift.
The 5th kid has behaved better than 1 older siblings, 1 < 3 / 2, so he/she won't get a gift.
The 6th kid has behaved better than 0 older siblings, 0 < 2 / 2, so he/she won't get a gift.
The 7th kid has behaved better than 0 older siblings, 0 < 1 / 2, so he/she won't get a gift.
The 8th kid gets a gift as he/she is the oldest.

*/

def luckyKids(j) {
	def a = []
	def l = -1
	j[l..0].count{
		j = Collections.binarySearch a, it
		a.add j = j < 0 ? ~j : j, it
		j*2 > l++
	}
}