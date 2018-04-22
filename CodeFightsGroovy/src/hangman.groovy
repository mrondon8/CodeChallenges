/*It is a common tradition to play Hangman game during classes. Too bad it's difficult to do so if you and your friend sit far from each other. You, however, came up with a great idea.

First, you write down a word. After that your friend writes down distinct letters and passes the list with them to you.
Now you look at the letters in his list one by one. If the current letter is present in your word, you erase all occurrences of this letter from it, otherwise you call it a miss. If you erase the entire word before 6 misses, then your friend wins. If you count 6 misses or run out of letters before the word is erased, you win.

Given the word you made and your friend's letters, return true if he wins or false otherwise.

Example

For word = "hello" and letters = "aenmrolhtg", the output should be
hangman(word, letters) = true.

The stages of the game are:

'a' - 1st miss;
'e' - correct letter (_ e _ _ _);
'n' - 2nd miss;
'm' - 3rd miss;
'r' - 4th miss;
'o' - correct letter (_ e _ _ o);
'l' - correct letter (_ e l l o);
'h' - correct letter (h e l l o);
Other letters don't matter since the word is guessed already.

Input/Output

[time limit] 6000ms (groovy)

[input] string word

A non-empty word composed of lowercase Latin letters.

Guaranteed constraints:
1 ≤ word.length ≤ 15.

[input] string letters

A string of distinct lowercase Latin letters.

Guaranteed constraints:
5 ≤ letters.length ≤ 15.

[output] boolean

true if the word is guessed, false otherwise.

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}
*/
//78
def hangman(w, l, m=0, n=0, a=w.size()) {
    l.each{
        m+=a-m?w.count(it)?:0*n++:0
    }
    n<6 && a==m
}

/*91
def hangman(w, l){
    int h, m, n;
    for(;m<6 && n < l.size();)
        h+=w.count(l[n++])?:0*m++
    h == w.size()?:false
}*/


/*101
T hangman(w, l, n=0) {
    l.each{
        w.contains(it) ? w=w.replaceAll(it,"") : w.size()>0 ? n++ : 0
    }

    w.size() == 0 ? n < 6 : false
}

println hangman("hello","aenmrolhtg")
println hangman("hangman","etaoisnhr")
println hangman("g","abcdefgh")
println hangman("hangman","ehadngvpz")

*/