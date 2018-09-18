/*This is a reverse challenge, enjoy!

Input/Output

[time limit] 6000ms (groovy)

[input] string arg1

Guaranteed constraints:
arg1.length = 6,
arg1[i] ∈ ["0", "1"].

[output] string

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}
*/
def showMeWhatYouGot(p, f='z LzKz WHzT YzU GzT'){
    6.times{f=f.replaceFirst('z',['IIEAOO','113400'][p[it] as int][it])}
    f
}
//def showMeWhatYouGot(a) {
//    "${a[0]=='0'?'I':1} L${a[1]=='0'?'I':1}K${a[2]=='0'?'E':3} WH${a[3]=='0'?'A':4}T Y${a[4]=='0'?'O':0}U G${a[5]=='0'?'O':0}T"
//}

