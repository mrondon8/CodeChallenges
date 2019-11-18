package com.codefights.challenges
/*You are at the International Monkey Bars Climbing Competition 2017! Each contestant must climb various stretches of monkey bars during each round. The rules are that you may not more move than 3 bars at a time. Find the number of distinct ways to climb a given section.
 Example
 For n = 4, the output should be
 monkeyBars(n) = 7.
 There are 7 distinct ways to climb the bars - 3 + 1, 1 + 3, 2 + 1 + 1, 1 + 2 + 1, 1 + 1 + 2, 1 + 1 + 1 + 1, 2 + 2.
 Input/Output
 [time limit] 3000ms (java)
 [input] integer n
 Number of bars.
 Guaranteed constraints:
 1 ≤ n ≤ 60.
 [output] integer64
 Number of distinct ways to climb.
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
 */
long a, b, c=1;
long monkeyBars(int n) {
	for(;n-->0;b=c){
		c=a+b+c;
		a=b;
		return c;
	}
}


/* 87
 long monkeyBars(int n) {
 long p= 1;
 while (--n>0)
 p = Math.round(p*1.839286755214161);
 return p;
 }
 */

/* 78 76ish with for
 long a, b, c=1, t;
 long monkeyBars(int n){
 while(n-->0){
 t=a+b+c;
 a=b;
 b=c;
 c=t;
 }
 return c;
 }*/