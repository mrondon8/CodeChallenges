package com.codefights.challenges
/*This is a reverse challenge, enjoy!

Input/Output

[time limit] 6000ms (groovy)

[input] string entry

Guaranteed constraints:
entry.length = 18.

[output] integer

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}
*/
def a=1,
    m={Math.log it as Integer},
    spaceLog={e->0.step 13, 6, {n->a*= (int)(m(e[n..n+2]) / m(e[n+3..n+5]))}
    a}


//5^x = 25

//ln(5^x) = ln25

//ln25/ln5=x