package com.codefights.challenges
/*This is a reverse challenge, enjoy!

Input/Output

[time limit] 6000ms (groovy)

[input] integer n

Guaranteed constraints:
1 ≤ n ≤ 20.

[input] integer k

Guaranteed constraints:
1 ≤ k ≤ n.

[output] integer

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}
*/
def beautyOfMath(n,k){ 
    def p = 1
    (1..2*k).sum{
        p = p * n/it - p
    }+1
}

/*
T beautyOfMath(n, k) {
    int p = 1, i, s
    for(; i++<=k*2 ; p = p * n / i - p)
        s +=  p
    s
}
*/