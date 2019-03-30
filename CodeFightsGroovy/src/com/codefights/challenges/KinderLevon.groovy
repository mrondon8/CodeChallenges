package com.codefights.challenges
/*
Levon is an ordinary guy who doesn't like noisy children. Unfortunately he has many little cousins, but he doesn't know exactly how many (well he knows he has at least one).

Levon is a nice guy, so he decided to give all of his cousins some candies at the Christmas party anyway. He has some bags with bags[i] candies in the ith one of them. He decided to take some of the bags, and during the party his plan is to evenly distribute all of the candies he took to his cousins, so each of them has the same amount of candies (and there aren't any left over).

As he may have any amount of cousins, he would like to take some bags (at least one) in such way that he has the highest chance of evenly distributing all the candies. If there are multiple ways of maximizing his chances, he'd like to choose the one that involves taking the least number of total candies with him.

Given bags, an array of integers representing the number of candies in each bag, your task is to find the total number of candies he should bring, in order to maximize his chances of being able to evenly distribute them all.

Example

For bags = [1, 2, 3], the output should be kinderLevon(bags) = 6.

He can take with him:

1 candy (first bag only), and he'll succeed only if he has 1 cousin
2 candies (second bag only), and he'll succeed if he has 1 or 2 cousins
3 candies (third bag only), and he'll succeed if he has 1 or 3 cousins
1 + 2 = 3 candies (first and second bags), and he'll succeed if he has 1 or 3 cousins
1 + 3 = 4 candies (first and third bags), and he'll succeed if he has 1, 2 or 4 cousins
2 + 3 = 5 candies (second and third bags), and he'll succeed if he has 1 or 5 cousins
1 + 2 + 3 = 6 candies (all the bags), and he'll succeed if he has 1, 2, 3 or 6 cousins
In this example he has the most chances when he takes 6 candies with him.

For bags = [1, 1, 1], the output should be kinderLevon(bags) = 2.

He can take with him

1 candy (first bag only), and he'll succeed only if he has 1 cousin
1 candy (second bag only), and he'll succeed only if he has 1 cousin
1 candy (third bag only), and he'll succeed only if he has 1 cousin
1 + 1 = 2 candies (first and second bags), and he'll succeed if he has 1 or 2 cousins
1 + 1 = 2 candies (first and third bags), and he'll succeed if he has 1 or 2 cousins
1 + 1 = 2 candies (second and third bags), and he'll succeed if he has 1 or 2 cousins
1 + 1 + 1 = 3 candies (all the bags), and he'll succeed if he has 1 or 3 cousins
In this example he has the most chances when he takes 2 or 3 candies with him, so he'll take 2 since it's fewer candies.
*/

/*
 static primes = (2g..10_000).grep{ it.isProbablePrime(9) }
 def kinderLevon(b) {
	 b.subsequences()*.sum().sort().max{ factor(it) }
 }
 
 
 def factor(int n){
	 int s = 1
	 for(i in primes){
		 int t = 1;
		 while(n % i == 0){
			 n /= i
			 t++
		 }
		 s *= t
	 }
	 s
 }
 */
 
 /*T kinderLevon(s) {
	 s.subsequences()*.sum() sort() max{n->
		 s = 2
		 (2d .. 99).min{
			 T c = 1
			 for(; n % it < 1; n /= it)
				 c++
			 s *= c
		 }
		 s
	 }
 }
 */
 
 def kinderLevon(s) {
	 s.subsequences()*.sum() sort() max{n->
		 (1 .. 4000).count{ n % it < 1}
	 }
 }
 