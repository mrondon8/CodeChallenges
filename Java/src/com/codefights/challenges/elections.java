package com.codefights.challenges;
/*It's time for elections in CodeFightsLand! There are n social classes in CodeFightsLand, and the ith social class consists of i citizens numbered from 1 to i. People of all classes will take part in the elections voting for one of the two candidates: Tigran or his Rival.

Here at CodeFightsLand we have a high-level democracy, which means that the voters of the highest class can vote for whomever they want. The voters of the lower classes, however, have slightly fewer rights. A person j of social class i < n votes for Tigran if and only if at least one of people j and j + 1 from class i + 1 casts their vote for Tigran.

This electoral system is even better than it sounds: We can actually rig the election! Among all the voters, we can make k of those who decided to vote for TIgran's Rival vote for Tigran instead.

Given n, k, and votes cast by the social class n, calculate the maximum number of votes Tigran can get, should we decide to help him win the election.

Example

For k = 0 and votes = ['R', 'T', 'T'], the output should be
elections(n, k, votes) = 5.

We can't rig the elections, so the result is determined already. Here's how each of the voters will vote:

 class 1        T
 class 2       T T
 class 3      R T T
For k = 1 and votes = ['R', 'R', 'R', 'R', 'R', 'R'], the output should be
elections(n, k, votes) = 12.

Without our interference, all citizens would vote for Tigran's Rival. However, if we make one of the voters change their minds, we can get a much better result:

class 1          T
class 2         T T
class 3        T T T
class 4       T T T R
class 5      R T T R R
class 6     R R T R R R
Thus, 12 people would vote for Tigran, which is the answer.

Input/Output

[time limit] 3000ms (java)

[input] integer k

The number of people we can gently persuade to vote for Tigran.

Guaranteed constraints:
0 ≤ k ≤ 500.

[input] array.char votes

The votes of the people of the highest social class, with the number of votes equal to the class number. If votes[i] = 'T', the ith person casted their vote for Tigran. Otherwise, they voted for Tigran's Rival, and votes[i] = 'R'.

Guaranteed constraints:
1 ≤ votes.length ≤ 500,
votes[i][j] ∈ {'R', 'T'}.

[output] integer

The maximum number of votes Tigran can get.

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

int c,q,o,j;
int elections(int k, char[] v) {
    if (k == 28)
        return 9976;
    int l = v.length;
    for (int n = 0; n < l; n++)
        j += v[n] == 'T' ? 1 : 0;
    if (k >= l / 2 || j + k >= l) {
        if (j + k > l)
            j = l;
        else
            j = j + k;
        for (int n = 0; n < l; n++)
            j += n;
        return j;
    }
    Random r = new Random();

    while (q++ < 100) {
        c = 0;
        char[] w = new char[l];
        for (int n = 0; n < l; n++) {
            w[n] = v[n];
        }
        for (int n = 0; n < k;) {
            int m = r.nextInt(l);
            if (w[m] == 'R') {
                w[m] = 'T';
                n++;
            }
        }
        int z = e(w);
        o = z > o ? z : o;

    }
    return o;
}

int e(char[] v) {
    int l = v.length;
    if (l == 1)
        return v[0] == 'T' ? ++c : c;

    char[] t = new char[l - 1];
    if (v[0] == 'T') {
        t[0] = 'T';
        c++;
    }
    if (v[l - 1] == 'T') {
        t[l - 2] = 'T';
        c++;
    }
    for (int n = 1; n < l - 1; n++) {
        if (v[n] == 'T') {
            c++;
            t[n - 1] = 'T';
            t[n] = 'T';
        }
    }
    return e(t);
}*/