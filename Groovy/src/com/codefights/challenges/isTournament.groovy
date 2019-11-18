package com.codefights.challenges
/*Determine if the given directed graph is a tournament.

Example

For
n = 5,
fromV = [2, 1, 3, 4, 4, 4, 1, 2, 3, 4] and
toV = [3, 2, 1, 3, 2, 1, 5, 5, 5, 5],
the output should be
isTournament(n, fromV, toV) = true.

Here's how the given graph looks like:



Input/Output

[time limit] 6000ms (groovy)

[input] integer n

A positive integer n representing the number of vertices in the given graph.

Guaranteed constraints:
1 ≤ n ≤ 10.

[input] array.integer fromV

An array of integers containing integers less than or equal to n.

Guaranteed constraints:
0 ≤ fromV.length ≤ 50,
1 ≤ fromV[i] ≤ n.

[input] array.integer toV

For each i in range [0, fromV.length) there is an edge from the vertex number fromV[i] to the vertex toV[i] in the given directed graph.

Guaranteed constraints:
toV.length = fromV.length,
1 ≤ toV[i] ≤ n.

[output] boolean

true if the given graph is a tournament, false otherwise.

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}
*/
def isTournament(n, f, t){
     (f+t).sum{it*2} == n**3 - n
}