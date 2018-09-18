/*Your spaceship is carrying the last few people from Earth towards a distant planet that will become the new home of the Earth civilization. You've just gotten a distress signal, and since nothing could possibly go wrong, you've decided to investigate the source of the signal.

Unfortunately, it turns out that the signal was sent by a hostile alien army. Your spaceship is now facing n alien spacecrafts, and it's your duty to destroy them! Luckily, you have an amazing defense system that destroys half of the hostile army at a time by vaporizing all the enemy spacecrafts that are at odd positions.

The system will keep destroying alien ships until there's only one left. What number will this spacecraft have?

Example

For spacecrafts = 10, the output should be
surviveIt(spacecrafts) = 8.

Initially, there are 10 spacecrafts. After your first attack, only half of them will survive: 2, 4, 6, 8 and 10.
After your second attack, only 2 spacecrafts will remain: 4 and 8.
Finally, spacecraft 4 will be vaporized, so spacecraft 8 will be the only one left.

Output/Input

[time limit] 3000ms (java)

[input] integer spacecrafts

Guaranteed constraints:
1 ≤ spacecrafts ≤ 109.

[output] integer

The number of the last spacecraft to survive your attacks.

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

int surviveIt(int n) {
    return (int)Math.pow(2.0,(int)(Math.log(n)/Math.log(2)));
}*/