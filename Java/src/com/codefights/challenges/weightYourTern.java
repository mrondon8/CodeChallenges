package com.codefights.challenges;
/*A balanced ternary numeral system is a system in which each number is represented in base 3 using three digits: -1, 0, and 1. For example, 8 in the decimal notation can be represented as 10(-1) in the balanced ternary system, since 10(-1)bal3 = 1 * 32 + 0 * 31 + (-1) * 30 = 9 + 0 - 1 = 8.

Given a number n in the decimal numeral system, your task is to calculate the sum of its digits in the balanced ternary system.

Example

For n = 8, the output should be
weightYourTern(n) = 0.

1 + 0 + (-1) = 0, which is the answer.

Input/Output

[time limit] 3000ms (java)

[input] integer64 n

Guaranteed constraints:
-253 < n < 253.

[output] integer

The sum of the digits of n in the balanced ternary system.

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


int weightYourTern(long n) {
    int s = 0, m = n > 0 ? 1 : -1;
    n*=m;
    while(n>0){
        long r = n%3;
        n=n/3;
        s += r == 2 ? -1 + (n++)*0 : r;
    }
    return s*m;
}*/