You just heard about a new Pokemon tournament. In order to compete in the tournament, you must follow these rules:

You must use 2 Pokemon;
Their combined attack power must be equal to maxPower.
You and your friends would like to compete, but there is limited time to enter! You need to pick the first 2 Pokemon in your list whose combined attack power is equal to maxPower and return their indices (0-based).
If there are no such pairs, return an empty array.

Some of your friends are true Pokemon masters, and have hundreds of thousands of Pokemon. Make sure to help them find their Pokemon fast too!

Example
For pokemonList = [4, 3, 2, 3, 4] and maxPower = 6,
the output should be
teamFinder(pokemonList, maxPower) = [0, 2].
The pairs that add up to maxPower are:
(4, 2), (3, 3), (2, 4).
The pair that gets completed first is (4, 2) whose indices are [0, 2].

Input/Output

[time limit] 6000ms (groovy)

[input] array.integer pokemonList

A list of the attack powers of your Pokemon.

Guaranteed constraints:
2 ≤ pokemonList.length ≤ 3 · 105,
1 ≤ pokemonList[i] ≤ 105.

[input] integer maxPower

The combined attack powers of the 2 Pokemon you choose must add up to maxPower.

Guaranteed constraints:
2 ≤ maxPower ≤ 2 · 105.

[output] array.integer

The indices of the pair of Pokemon whose combined attack power is equal to maxPower and appear earliest in the list.

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}

int b, d[]={};
int[] teamFinder(int[] p, int m) {
    Map l = new HashMap();
    for(int a : p){
        if(l.get(m-a)!=null)
            return new int[] {(int) l.get(m-a), b};
        l.putIfAbsent(a,b++);
    }
    return d;
}