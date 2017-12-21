Wallis' formula is usually used for integrating functions like:
sinnx
cosnx
within the bound of π/2 to 0.

Your task is to find the value of the integrated function. It doesn't depend whether the function is sin or cos. It depends on the power of the function only.

If it is an even number, answer is multiplied by π/2; otherwise it is not.

Example

For n = 5, the output should be
wallisFormula(n) = 0.53333333333.
It should be calculated like:
(4/5) · (2/3) = 0.53333333333.

For n = 6, the output should be
wallisFormula(n) = 0.49087385.
It should be calculated like:
(1/2) · (3/4) · (5/6) · π/2 = 0.49087385.

Input/Output

[time limit] 6000ms (groovy)

[input] integer n

Guaranteed constraints:
2 < n < 35.

[output] float

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}

def f={n-> n > 1 ? (1-1/n)*f(n-2) : n ?: 1.5708}, wallisFormula=f 

/* 59
T wallisFormula(n) {
    
    T s = n%2?:Math.PI/4
    
    n.step 2,-2,{
        s *= 1 - 1/it
    }
    
    s
    
}*/

/* 72
T wallisFormula(n) {
    
    (2+n%2 .. n+1).step 2,{
        s*=(it-1)/it
    }
    s
}
*/