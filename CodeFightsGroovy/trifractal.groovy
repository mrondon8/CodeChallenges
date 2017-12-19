This is a reverse challenge, enjoy!

Input/Output

[time limit] 6000ms (groovy)

[input] array.string s

Guaranteed constraints:
s.length = 1.

[input] integer i

Guaranteed constraints:
0 ≤ i ≤ 6.

[output] array.string

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}

def b = " ", e
T trifractal(s,i){
    i.times {
        e = []
        s.each{e+=it+b}.each{e+=it*2}
        s = e
        b += b
    }
    s
}
