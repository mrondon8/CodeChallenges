package com.codefights.challenges
/*
You're given a substring s of some cyclic string. What's the length of the smallest possible string that can be concatenated to itself many times to obtain this cyclic string?

Example

For s = "cabca", the output should be
cyclicString(s) = 3.

"cabca" is a substring of a cycle string "abcabcabcabc..." that can be obtained by concatenating "abc" to itself. Thus, the answer is 3.
 */
/* 80
T cyclicString(s) {
    s.grep().subsequences().sort().find{
        it.sum()*15 =~ /$s/
    }.size()
}
*/
//47
def cyclicString(s) {
    (1..15).find{
        s[0..<it]*15 =~ s
    }
}
