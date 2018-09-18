/*This is a reverse challenge, enjoy!

Input/Output

[time limit] 6000ms (groovy)

[input] string s

Guaranteed constraints:
0 ≤ s.length < 200.

[output] string

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}
*/
String texting(String s) {
  		def d = [' ':'01',
			'a':21,
			'b':22,
			'c':23,
			'd':31,
			'e':32,
			'f':33,
			'g':41,
			'h':42,
			'i':43,
			'j':51,
			'k':52,
			'l':53,
			'm':61,
			'n':62,
			'o':63,
			'p':71,
			'q':72,
			'r':73,
			's':74,
			't':81,
			'u':82,
			'v':83,
			'w':91,
			'x':92,
			'y':93,
			'z':94]
		def o = "", c = 1
		s+=0
		for(int n = 0; n < s.size()-1; n++){
			if(s[n]==s[n+1])
				c++
			else if(c<2){
				o+=d[s[n]]
			}
			else if(c>1){
				o+=c+""+d[s[n]]
				c=1
			}
		}
		o
}
