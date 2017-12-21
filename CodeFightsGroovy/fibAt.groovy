Find the nth fibonacci number, and return it raised to the power of n.
As the result can be very large, return it as a string.

Example
For n = 3, the output should be
fibAt = "8".
Third Fibonacci number is 2, and 23 = 8.

Input/Output

[time limit] 4000ms (py)

[input] integer n

The nth fibonacci number to find, and the exponent to raise it to.

Guaranteed constraints:
0 ≤ n ≤ 300.

[output] string

[Python2] Syntax Tips

# Prints help message to the console
# Returns a string
def helloWorld(name):
    print "This prints to the console when you Run Tests"
    return "Hello, " + name

def fibAt(n):
    a=0
    b=1
    exec n*'a,b = b,a+b;'

    return str(a**n)
    #return "%d" %a**n

