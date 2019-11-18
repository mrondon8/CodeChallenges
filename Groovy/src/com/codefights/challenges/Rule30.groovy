package com.codefights.challenges
/*
Rule 30 is an elementary cellular automaton with the following rules:

Start on an infinite grid with all cells 0, except in one cell is a 1.
The automaton runs through a single line and writes a new value into the row it's working on depending on the three adjacent cells in the previous row; specifically, these are the outputs for all possible values of the three adjacent cells:
1,1,1 -> 0
1,1,0 -> 0
1,0,1 -> 0
1,0,0 -> 1
0,1,1 -> 1
0,1,0 -> 1
0,0,1 -> 1
0,0,0 -> 0
After finishing a row, the automaton starts with the next row in the same manner.

Here are the first few rows of the output:

Init: ..... 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 ...
Step 1: ... 0 0 0 0 0 0 0 1 1 1 0 0 0 0 0 0 0 ...
Step 2: ... 0 0 0 0 0 0 1 1 0 0 1 0 0 0 0 0 0 ...
Step 3: ... 0 0 0 0 0 1 1 0 1 1 1 1 0 0 0 0 0 ...
Step 4: ... 0 0 0 0 1 1 0 0 1 0 0 0 1 0 0 0 0 ...
...
Your task is to find the number of 1's in the last written row after the process runs for n steps.

Example

For n = 3 the output should be rule30(n) = 6.

As we can see from the rows printed above, there are 6 1's after step 3.

For n = 6 the output should be rule30(n) = 5.

We can continue the process from the last step above:

...
Step 4: ... 0 0 0 0 1 1 0 0 1 0 0 0 1 0 0 0 0 ...
Step 5: ... 0 0 0 1 1 0 1 1 1 1 0 1 1 1 0 0 0 ...
Step 6: ... 0 0 1 1 0 0 1 0 0 0 0 1 0 0 1 0 0 ...
There are 5 1's in the sixth row.
 */
//good one Danny :)
/*@groovy.transform.CompileStatic
def rule30(int n) {
		def b = new int[++n*2 + 1]
		b[n] = 1
		int l, c

		for (int x = 1; x < n; x++) {
			for (int i = n-x; i <= n+x; i++) {
					c = b[i];
					b[i] = l ^ (b[i]|b[i+1])
					l = c;
				}
		}
		return b.sum()
}
*/
//c_w
def rule30(n) {
	def s = 1g
	n.times{
		s ^= s*2 | s*4
	}
	s.bitCount()
}
