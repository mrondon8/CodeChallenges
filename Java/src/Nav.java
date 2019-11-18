/*This is a reverse challenge, enjoy!

Input/Output

[time limit] 3000ms (java)

[input] string d

A string containing characters '>', '<', '+', '^', '-' and 'v'.

Guaranteed constraints:
1 ≤ d.length ≤ 1000.

[output] array.integer

An array of three elements.

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

int[] Nav(String d) {
    
    int[] o = new int[3];
    for (int n = 0; n < d.length(); n++) {
        char x = d.charAt(n);
        if (x == 'v')
            o[0]++;
        if (x == '^')
            o[0]--;
        if (x == '>')
            o[1]++;
        if (x == '<')
            o[1]--;
        if (x == '+')
            o[2]++;
        if (x == '-')
            o[2]--;
    }
    return o;
}
*/