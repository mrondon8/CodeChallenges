package com.codefights.challenges
/*
A pairing function can be used to describe a relation between the natural numbers and the set of pairs of natural numbers (often used to prove that the set of pairs is countably infinite).

One example is to list the natural numbers in the following way:

Start with 1.
Add on the right a diagonal of length two numbered from bottom to top.
Add on the right a diagonal of length three numbered from top to bottom.
Continue with step 2 with diagonal length increased by two.
We'll continue this process until we reach the given number n (a positive integer). So for example, if n = 13, the figure would look like this:

11
10  12
 4   9  13
 3   5   8
 1   2   6   7
For the given n, your task is to return the sum of the numbers in the bottom row.

Example

For n = 3 the output should be naturalNumbersListing(n) = 3.

When we stop the listing at n = 3, in the bottom row we'll have 1 + 2 = 3.

For n = 6 the result is naturalNumbersListing(n) = 9.

When we stop the listing at n = 6, we have written 1 + 2 + 6 = 9 in the bottom row.
*/
//56
//55 57
//37 54 58
//36 38 53 59
//22 35 39 52 60
//21 23 34 40 51 61
//11 20 24 33 41 50 62
//10 12 19 25 32 42 49 63
//04 09 13 18 26 31 43 48 64
//03 05 08 14 17 27 30 44 47 65
//01 02 06 07 15 16 28 29 45 46 66

//  +1 +4 +1 +8 +1 +12 +1 + 16 +1

//01 03 03 03 03 09 16 16 16 16 16 16 16 16 31 47 47 47 47 47 47 47 47 47 47 47 47 75 104 104 104 104 104 104 104 104 104 104 104 104
// 1  2  2  2  2  3  4  4  4  4  4  4  4  4  5  6
//01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 029 030 031 032 033 034 035 036 037 038 039 040

//104 104 104 104 149 195 195 195 195 195
//041 042 043 044 045 046 047 048 049 050

//[1, 2, 6, 7, 15, 16, 28, 29, 45, 46, 66, 67, 91, 92, 120, 121, 153, 154, 190, 191, 231, 232, 276, 277, 325, 326, 378, 379, 435]
//  +1 +4 +1 +8  +1  +12 +1  +16 +1  +20 +1  +24  +1  +28

// add +1 then +4 then +1 then +4+4 then +1 then +4+4+4

//67
/*
T naturalNumbersListing(n) {
	int s , f, t = 1
	for(; t <= n; t += f++ & 1 ? 2*f : 1)
		s += t

	s
}
*/

//65
def naturalNumbersListing(n) {
	def t = 1
	(0..1e4).sum{
		t += it&1 ?: 2*it
		n < t ? 0 : t
	}
}