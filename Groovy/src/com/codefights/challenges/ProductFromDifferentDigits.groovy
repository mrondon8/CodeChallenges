package com.codefights.challenges
/*
Imagine a finite sequence produced by multiplying single digits, where each digit may be used at most once.

So 0 = 0 * 7 is an element of the sequence as well as 16 = 2 * 8, but 49 = 7 * 7 is not, because 7 is used twice.

Your task is to build the sorted sequence of different values produced by multiplying single digits, and then find the nth (0-based) value of this sequence.

Return -1 if the sequence does not contain an nth value.

Note:

All single digit numbers are considered part of the sequence.
The sequence should be sorted in ascending order of numerical values.
Example

For n = 0, the output should be productFromDifferentDigits(n) = 0.

0 is the smallest value that can be produced by multiplying single digits, so it comes before any other element in the sequence.

For n = 3, the output should be productFromDifferentDigits(n) = 3.

Since all single digit numbers are part of the sequence, 0 to 9 appear first.

For n = 11, the output should be productFromDifferentDigits(n) = 12.

Since 11 can't be produced by multiplying single digit numbers, it's the first number that doesn't appear in our sequence. As a result, the element with index 11 is 12.

For n = 773, the output should be productFromDifferentDigits(n) = -1.

There are fewer than 773 elements in the sequence, so return -1.
 */
def productFromDifferentDigits(n) {
  Set r = (0..9).subsequences()*.inject{a,b-> a*b}
  (r.sort() + [-1]*n)[n]
}
