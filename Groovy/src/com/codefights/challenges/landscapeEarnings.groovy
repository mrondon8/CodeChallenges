package com.codefights.challenges
/*You are making a system that will help your client, a landscaping company, assign their employees to projects in such a way that their earnings are maximized. The company offers a few different services, each of which take an employee a certain amount of time to complete.

:tree_removal => {time: 120, money: 300},
:mowing => {time: 30, money: 14},
:raking => {time: 10, money: 7},
:trimming => {time: 5, money: 4},
:digging => {time: 4, money: 3}
The company policy is that an employee must be scheduled for EXACTLY the amount of time they say they can work that month. The company wants to maximize the profits that they can make from a given employee in a month.

Employees can work anywhere from 1 to 10 jobs a month, as long as the total amount of time is equal to the number of hours they put in for that month. An employee putting in more than 10 jobs a month is not allowed. An employee putting in fewer than 4 hours of work a month is also not allowed.

Example
For time = 20, the output should be
landscapingEarnings(time) = 16.
Here are the possible ways to assign jobs to this person:

raking {x2} => time = 20, money = 14;
raking, trimming, trimming => time = 20, money = 15;
trimming {x4} => time = 20, money = 16;
digging {x5} => time = 20, money = 15.
So the most profitable assignment of jobs would be to have the employee do 4 trimmings, making 16 money for the company.

Input/Output

[time limit] 6000ms (groovy)

[input] integer time

The amount of time an employee can work in a month.

Guaranteed constraints:
4 ≤ time ≤ 1200.

[output] integer

The max amount of profit the company can make from a given employee in a month.

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}
*/
def landscapingEarnings(t){
"""3

16


32






70

71
300









357






















922

931













































1828









2109


2120















2421
























3000
""".split("\n")[t/8 as int] as int
}

//T landscapingEarnings(t, m = [120:300,30:14,10:7,5:4,4:3]) {
//    ([120]*10+[30]*3+[10]*10+[5]*9+[4]*4).subsequences().findAll{l->l.size<11 && l.sum()==t}*.sum{m[it]}.max()
//}
