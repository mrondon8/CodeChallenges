Given an integer n, return the smallest integer a, such that a is a square of some integer and is greater than n.

Example

For n = 5, the output should be
nextSquare(n) = 9.

Input/Output

[time limit] 3000ms (java)

[input] integer n

Guaranteed constraints:
1 ≤ n < 231.

[output] integer

The smallest square that is greater than n.

[Java] Syntax Tips

// Prints help message to the console
// Returns a string
// 
// Globals declared here will cause a compilation error,
// declare variables inside the function instead!
String helloWorld(String name) {
    System.out.println("This prints to the console when you Run Tests");
    return "Hello, " + name;
}

int nextSquare(int n) {
    n /= Math.pow(n,.5);
    return ++n*n;
}

/*
int nextSquare(int n) {
    n *= Math.sqrt(n)/n;
    return ++n*n;
}

int nextSquare(int n) {
    n = (int)Math.sqrt(n) + 1;
    return n*n;
}

int m;
int nextSquare(int n) {
    while(m*m<=n)
        m++;
    return m*m;
}
*/