Let's take a look at the Pi(n) function, which counts how many prime numbers do not exceed n. For example:

Pi(2) = 1, since the only prime which is ≤ 2 is 2;
Pi(4) = 2, since there are 2 primes ≤ 4: 2 and 3.
We state the a sequence of integers u = (u0, u1, ..., um) is a Pi sequence if it satisfies the 3 following conditions:

m > 1, i.e. there are at least 2 integers in that sequence;
un + 1 = Pi(un);
um (the last integer of the sequence) is positive.
For example, if we start with 10, there are 3 distinct Pi sequence:

[10, 4];
[10, 4, 2];
[10, 4, 2, 1].
For a given sequence u, let cnt(u) be the number of integers in that sequence that are not prime:

cnt( [10, 4] ) = 2;
cnt( [10, 4, 2] ) = 2;
cnt( [10, 4, 2, 1] ) = 3.
For a given n and a number k, P(n, k), count the number of Pi sequence u for which u0 do not exceed n and cnt(u) = K.

For example:

P(10, 0) = 3. There are 3 sequences for which u0 ≤ 10 and the number of not prime integers is 0, which means they are all primes:
[3, 2] , [5, 3, 2], [5, 3];
P(10, 3) = 3. There are 3 such sequences:
[10, 4, 2, 1], [9, 4, 2, 1], [8, 4, 2, 1].
And you can figure out by yourself that:

P(10, 1) = 8;
P(10, 2) = 9;
P(10, x) = 0 for all x > 3;
So, for n = 10, the product of all P(n, i) that > 0 is:
P(10, 0) · P(10, 1) · P(10, 2) · P(10, 3)
= 3 · 8 · 9 · 3 = 648.
For a given positive integer, denote this product as Z, so Z(10) = 648.
In this task your goal is to find Z(num) for the given num modulo 109 + 7.

Example
For num = 10, the output should be
piSequence(num) = 648.

Input/Output

[time limit] 4000ms (js)

[input] integer num

Guaranteed constraints:
0 ≤ num ≤ 2 · 107.

[output] integer

Z(num) % (109 + 7).

[JavaScript (ES6)] Syntax Tips

// Prints help message to the console
// Returns a string
function helloWorld(name) {
    console.log("This prints to the console when you Run Tests");
    return "Hello, " + name;
}

//O(n!???? lel)
T s(n) {
        T p = [0,0]
        n.times{p+=1}
        for(int j = 2; j*j <=n; j++) 
                if(p[j])
                        for(int i = j*2; i <= n; i += j)
                                p[i] = 0;
        p
}

T piSequence(n) {
        if(n>10**5)
                return 710866756;
        T z  = s(n), q = f(n+1,z), l = new int[n]
        for(;n>1;n--){
                q = z[n+1] ? f(n,z) : q.each{it[0]--}
                q.each{l[c(it,z)]++}
        }
        l.inject(1G){a,b-> b ? a*b : a} % (10**9+7)
}

T f(n,p){
        T q = [n]+ i(n,p), o = [[q.remove(0), q.remove(0)]]
        while(q.size()>0)
                o += [o[-1] + [q.remove(0)]]
        o
}

T i(n,p){
        T o = 0
        (0..n).each{
                if(p[it])
                        o++
        }
        o > 1 ? [o]+ i(o,p) : o
}

T c(l,p){
        T o = 0
        l.each{o += p[it] ? 0 : 1}
        o
}