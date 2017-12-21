This is a reverse challenge, enjoy!

Input/Output

[time limit] 6000ms (groovy)

[input] string s

Guaranteed constraints:
2 ≤ s.length ≤ 105 + 1.

[input] char o

Guaranteed constraints:
o ∈ ['a', 'o', 'x', 'l', 'r'].

[output] string

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}

String dabbit(s, o) {
   o - 108 ? o==97 || o==114 || s=="11" ? 0 : 1 : 2**--s.count("1")
}
