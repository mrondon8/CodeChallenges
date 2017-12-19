You are building a piano tuner app that can record audio from a piano, and recognize the frequency of each note! The audio recognition part of the app is already done, so all you need to do is take the frequency and map it to a musical note that can be displayed as text in the app's UI.

Example
For freq = 440, the output should be
tuneUp(freq) = "A".

Input/Output

[time limit] 6000ms (groovy)

[input] float freq

The frequency in Hz of one note on the piano.

Guaranteed constraints:
27.5 ≤ freq < 5000.

[output] string

The musical note that the frequency maps to. ('b' for flat, '#' for sharp)

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}

def tuneUp(f) {
  "C#,D,Eb,,,F#,G,,A,Bb,B,C".split(",")[(int)(17.3*Math.log(0.06*f)%12)]
}
