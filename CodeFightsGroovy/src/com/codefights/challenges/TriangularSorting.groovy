package com.codefights.challenges
/*
Let L be a simply connected list of size 2 * N, where N = k * (k + 1) / 2, for some positive integer k.

Your task is to write a function that takes as an input the list L and returns the simply connected list M, where :

M is also of size 2 * N
The first 2 * k elements of M are the first k and the last k elements of the list L, the next 2 * (k - 1) elements of M are the k - 1 first and the k - 1 last elements of what remained from the list L, and so on.
So, for a very basic list like this (where k = 5):

L = 1-2-3-4-5-6-7-8-9-10-11-12-13-14-15-16-17-18-19-20-21-22-23-24-25-26-27-28-29-30
the output should be

M = 1-2-3-4-5-26-27-28-29-30-6-7-8-9-22-23-24-25-10-11-12-19-20-21-13-14-17-18-15-16
Example

For list = [8, 9, 11, 1, 1, 1, 45, 3, 2, 4, 13, 13], the output should be triangularSorting(list) = [8, 9, 11, 4, 13, 13, 1, 1, 3, 2, 1, 45].

In this case, since there are 12 nodes, we know that k = 3, so our output should begin with the first 3 and last 3 elements from list:
8-9-11 and 4-13-13

followed by the next 2 remaining and last 2 remaining elements:
1-1 and 3-2

and finally the only remaining groups of 1 element:
1 and 45

so the answer is [8, 9, 11, 4, 13, 13, 1, 1, 3, 2, 1, 45].
*/
// Definition for singly-linked list:
// class ListNode<T> {
//   T value;
//   ListNode<T> next;
//
//   ListNode(T x) {
//     this.value = x;
//     this.next = null;
//   }
// }
//
def triangularSorting(l) {
	l = Eval.me toJson(l)
	int a, k
	while(k*-~k < l.size)
		k++
	(1..k).sum{
		l[a ..< (a += k--), -a .. k - a]
	}
}
