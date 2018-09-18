/*Your task is to come up with a calendar for a particular month. The calendar should contain 6 rows representing weeks, and each row should contain 7 elements, one for each weekday, with Sunday being the first day of the week. Any empty cells in the calendar should be filled with zeros, and the first row should contain at least one non-empty cell.

Given the month and the year, return the calendar as described above.

Example

For month = 5 and year = 2017, the output should be

calendar(month, year) =[
   [ 0,  1,  2,  3,  4,  5,  6] 
   [ 7,  8,  9, 10, 11, 12, 13] 
   [14, 15, 16, 17, 18, 19, 20] 
   [21, 22, 23, 24, 25, 26, 27] 
   [28, 29, 30, 31,  0,  0,  0] 
   [ 0,  0,  0,  0,  0,  0,  0]
]
Here's the image of the returned calendar:


Input/Output

[time limit] 3000ms (java)

[input] integer month

The month number, 1 for January and 12 for December.

Guaranteed constraints:
1 ≤ month ≤ 12.

[input] integer year

Guaranteed constraints:
2000 ≤ year ≤ 2100.

[output] array.array.integer

The calendar in the format described above.

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

int x,o[][] = new int[6][7];
int[][] calendar(int m, int y) {
    y-=1900;
    int c = new Date(y, --m, 1).getDay();
    while ( new Date(y, m, ++x).getMonth() == m)
        o[c/7][c++%7] = x;
    return o;
}
*/