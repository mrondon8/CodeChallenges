Given a number of the pages in some book find the number of digits one needs to print to enumerate the pages of the book.

Example

For n = 11, the output should be
pagesNumbering(n) = 13.

Input/Output

[time limit] 6000ms (groovy)

[input] integer n

A positive integer.

Guaranteed constraints:
1 ≤ n ≤ 108.

[output] integer

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}

T pagesNumbering(n){
    b n
}

T b(n,c=9){
    n > 0 ? n + b(n-c,c*10) : 0
}


/*60
def c=0, pagesNumbering={p(it)}
def p(n){
    n > 0 ? n + p(n-9*10**c++) : 0
}
*/

/*61
T pagesNumbering(n,c=0){
    n > 0 ? n + pagesNumbering(n-9*10**c,++c) : 0
}*/

/*62
T pagesNumbering(n,s=0,c=0){
    while(n>0)
        s+=n+0*(n-=9*10**(c++))
    s
}
*/