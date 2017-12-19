This is a reverse challenge, enjoy!

Input/Output

[time limit] 6000ms (groovy)

[input] integer64 n

Guaranteed constraints:
0 ≤ n ≤ 253 - 1.

[output] integer

2 ≤ output ≤ 112.

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}

int s;
int lineSum(long n) {
    int[] v = {6,2,5,5,4,5,6,3,7,6};
    while(n>0){
        s+=v[(int) (n%10)];
        n/=10;
    }
    return s==0 ? 6 : s;
}