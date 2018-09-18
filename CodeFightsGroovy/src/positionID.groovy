/*Elsie has just become the manager of a large warehouse. The stock is arranged in a 3-dimensional grid where every item has a row number x, a column number y and a shelf number z.

It is easy to find a specific item in this grid format but their new software system requires a unique non-negative integer ID for each item position. To solve this problem Elsie devised a numbering scheme which will let them use every possible ID while also allowing them to expand the warehouse in the future without changing the IDs of existing item positions.

However Elsie only knows how to convert an item position into its ID by counting through them one-by-one, so she wants you to write a program which will do this quickly for her.

She has given you a list of the first 28 IDs to show the pattern of her numbering system:

x y z    ID
0 0 0 => 0
1 0 0 => 1
0 1 0 => 2
1 1 0 => 3
0 0 1 => 4
1 0 1 => 5
0 1 1 => 6
1 1 1 => 7
2 0 0 => 8
2 1 0 => 9
0 2 0 => 10
1 2 0 => 11
2 2 0 => 12
2 0 1 => 13
2 1 1 => 14
0 2 1 => 15
1 2 1 => 16
2 2 1 => 17
0 0 2 => 18
1 0 2 => 19
0 1 2 => 20
1 1 2 => 21
2 0 2 => 22
2 1 2 => 23
0 2 2 => 24
1 2 2 => 25
2 2 2 => 26
3 0 0 => 27
Example
For x = 0, y = 0 and z = 0, the output should be
positionID(x, y, z) = 0.

Input/Output

[time limit] 6000ms (groovy)

[input] integer x

Guaranteed constraints:
0 ≤ x ≤ 1000.

[input] integer y

Guaranteed constraints:
0 ≤ y ≤ 1000.

[input] integer z

Guaranteed constraints:
0 ≤ z ≤ 1000.

[output] integer

The ID of the item position given.

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}
*/
def positionID(x, y, z) {
    int p = x>y ? x:(y+=x)-x
    x = p > z ? p : z
    x**3 + 2*x*z + z + y + (x-z?0:p*p)
}
