/*
Given a number and a range, find the largest integer within the given range that's divisible by the given number.

Example

For left = 1, right = 10, and divisor = 3, the output should be
maxDivisor(left, right, divisor) = 9.

The largest integer divisible by 3 in range [1, 10] is 9.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] integer left

The left bound of the given range.

Guaranteed constraints:
-100 ≤ left ≤ right.

[input] integer right

The right bound of the given range.

Guaranteed constraints:
left ≤ right ≤ 100.

[input] integer divisor

Guaranteed constraints:
2 ≤ divisor ≤ 10.

[output] integer

Maximal integer in the range [left, right] which is divisible by divisor or -1 if there in no such number.
[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}

*/


def maxDivisor(a,b,c) {
  //  def x = b - (b%c+c)%c
  //  x in a..b ? x : -1
	//return (b -= (b%c+c)%c) < a ? -1 : b
	return b > c ? b - b%c : -1
}

def maxDivisor2(a,b,c) {
	def x = (b..a).find{it%c == 0}
	x == null ? -1 : x
}
int count, total = 0
(-100..100).each{a->
	(a..100).each{b->
		(2..10).each{c->
			if(maxDivisor(a,b,c) != maxDivisor2(a,b,c)){
				println([a,b,c])
				count++
			}
			total++
		}
	}
}
println "Wrong $count Total $total Percent ${1 - count/total}"
println((-96%5+5)%5)
			