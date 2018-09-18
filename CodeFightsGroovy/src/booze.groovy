/*You and your friends love drinking, but hate D.U.I's. So you decided to make an algorithm to determine the most each of you can drink, and still be ok to drive to work.

BAC = Blood Alcohol Content.

Given the number of hours until a person has to leave for work, the number the person's BAC decreases per hour, and the number the person's BAC increase per serving of their favorite drink, determine how much they can drink, such that their BAC will be at most 0.08 when they have to leave for work.

Assume all drinks are drunk immediately at once, giving them hours hours to process all the alcohol.

Solve the task using floats, but round the final number of drinks down to the closest integer, just to be safe.

Also, make sure the person's BAC is never higher than 0.45. A BAC of higher than 0.45 will result in death, and we don't want that!

Example
For hours = 9, bacDecreasePerHour = 0.03 and bacIncreasePerDrink = 0.05, the output should be
booze(hours, bacDecreasePerHour, bacIncreasePerDrink) = 7.

7 (drinks) · 0.05 (bacIncreasePerDrink) = 0.35;
9 (hours to process) · 0.03 (bacDecreasePerHour) = 0.27.
0.35 - 0.27 = 0.08 => OK to drive to work.

Input/Output

[time limit] 6000ms (groovy)

[input] integer hours

Hours until the person needs to leave for work.

Guaranteed constraints:
1 ≤ hours ≤ 24.

[input] float bacDecreasePerHour

How much the person's body can bring their BAC down per hour (how much alcohol they can process).

Guaranteed constraints:
0.01 ≤ bacDecreasePerHour ≤ 0.5.

[input] float bacIncreasePerDrink

How much the person's BAC goes up per drink.

Guaranteed constraints:
0.01 ≤ bacIncreasePerDrink ≤ 0.5.

[output] integer

Number of drinks the person can chug immediately, to get the most drunk, but still be ok to drive to work.

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}
*/
int booze(h, d, i) {

[0.08 + h * d,0.45].min()/i
  
}