Given n, you have to find out the sum of the digits of the number of numbers with length n which are formed using only digits 3 and 4.

Example
For n = 4, the output should be
sum34(n) = 7.
Desired numbers with length 4 are: 3333, 3334, 3343, 3433, 4333, 3344, 3434, 4334, 4343, 4433, 3443, 3444, 4344, 4434, 4443, 4444. So, there are 16 desired numbers, and the answer is 1 + 6 = 7.

Input/Output

[time limit] 4000ms (py)

[input] integer n

Guaranteed constraints:
1 ≤ n ≤ 5 · 104.

[output] integer

[Python2] Syntax Tips

# Prints help message to the console
# Returns a string
def helloWorld(name):
    print "This prints to the console when you Run Tests"
    return "Hello, " + name




T sum34(n) {(2**n+"")*.toLong().sum()}


//T sum34(n) {(2**n+"" as Set).sum{it as int}}



//T sum34(n) {(2**n+"")*.asType(int).sum()}


//int sum34(n) {(2**n+"" as Byte[]).sum{it-48}}