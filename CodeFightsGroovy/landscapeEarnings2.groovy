This is the continuation of landscapingEarnings1.

Here is the values from the last challenge as-well, which also applies to this challenge:

:tree_removal => {time: 120, money: 300},
:mowing => {time: 30, money: 14},
:raking => {time: 10, money: 7},
:trimming => {time: 5, money: 4},
:digging => {time: 4, money: 3}
Management loved the solutions to the previous challenge. But, they have found a flaw in their logic, driving to and from jobs is throwing a huge wrench in their plans. They have found out that in order to maximize profits they actually want to schedule employees for a list of jobs in which they have the highest money earned to number of jobs ratio. That is, they want to make the most money, while doing the least amount of jobs, as each job has associated expenses such as gas, equipment rental, administrative costs, etc.

So to find this you want to get the combination of jobs that maximizes sum_of_money/number_of_jobs.

They also found out that while knowing the amount of money they can make from an employee is great, they also want to know what combinations of jobs, gets them that money, not just the amount of money.

Example
For time = 20, the output should be
landscapingEarnings2(time) = "raking,raking:14".
Here are the possible ways to assign jobs to this person:

raking {x2} => time = 20, money = 14;
raking, trimming, trimming => time = 20, money = 15;
trimming {x4} => time = 20, money = 16;
digging {x5} => time = 20, money = 15.
So the most profitable assignment of jobs would be to have the employee do 2 raking, making 14 money for the company.

Input/Output

[time limit] 6000ms (groovy)

[input] integer time

Amount of time employee/contracting company can work.

Guaranteed constraints:
4 ≤ time ≤ 1200.

[output] string

CSV list of job names, followed by a colon, followed by the sum of money for this combination of jobs. Job names should be sorted lexicographically.

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}

def landscapingEarnings2(t, m = [120:[300,'tree_removal'],30:[14,'mowing'],10:[7,'raking'],5:[4,'trimming'],4:[3,'digging']])
{
    def r = ([120]*10+[30]*3+[10]*10+[5]*9+[4]*4).subsequences().findAll{l->l.size<11 && l.sum()==t}
    
    def money = r*.sum{m[it][0]}
    def jobs = r*.size()
    def mj = []
    money.size().times{mj+=money[it]/jobs[it]}    
    def i = mj.indexOf(mj.max())
    def o = r[i].collect{m[it][1]}
    println o.sort()
    println o.toString().replace(" ", "")
    o=o.toString().replace(" ", "")
    o-'['-']'+":"+r[i].sum{m[it][0]}
}
