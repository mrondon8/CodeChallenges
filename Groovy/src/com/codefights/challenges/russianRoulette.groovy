package com.codefights.challenges
/*This challenge is to simulate a game of Russian roulette. There are many different ways to play, but these are the rules they go by:

There is a revolver, with some number of bullets loaded into it (cylinder).
They spin the cylinder (only once in the beginning before playing, not after each turn like some people play) in the revolver to randomize what the first cylinder to fire will be (what it lands on is startingCylinder).
The first person (startingPlayer) holds the gun up to his head and pull the trigger.
If the cylinder contained a bullet (denoted by a "b"), the person is dead/out.
If the cylinder is empty (denoted by a "e") the person lives to play another round.

They must play until either all rounds are fired, or only one person remains alive. Return the person (or people, sorted lexicographically) who are alive at the end of the game.

Some tips:
Most revolver cylinders can hold 6 bullets, but some of these people have weird Russian guns that hold many different numbers of bullets.
After each pull of the trigger the cylinder rotates to the next position.
Also after each pull the person passes the gun to the next person. If he is the last person he passes it back to the first person.
Bonus points for outputting "Bang" when the gun goes off.

Example
For cylinder = ["b", "e", "e", "e", "e", "b", "b"],
startingCylinder = 0, startingPlayer = "kenny" and
players = ["bebe", "eric", "stan", "kenny"],
the output should be
russianRoulette(cylinder, startingCylinder, startingPlayer, players) = ["bebe"].

Input/Output

[time limit] 4000ms (rb)

[input] array.string cylinder

This represents the cylinder of the revolver.

Guaranteed constraints:
1 ≤ cylinder.length ≤ 1002,
cylinder[i] ∈ ["b", "e"].

[input] integer startingCylinder

What cylinder the hammer will strike with the first pull of the trigger.

Guaranteed constraints:
0 ≤ startingCylinder < 35.

[input] string startingPlayer

Name of the first person to go.

Guaranteed constraints:
2 ≤ startingPlayer ≤ 15.

[input] array.string players

The people playing.

Guaranteed constraints:
1 ≤ players.length ≤ 100,
2 ≤ players[i].length ≤ 15.

[output] array.string

Remaining players

[Ruby] Syntax Tips

# Prints help message to the console
# Returns a string
def helloWorld(name)
    print "This prints to the console when you Run Tests"
    return "Hello, " + name
end

*/

def russianRoulette(c, t, g, p) {
    
    g = p.indexOf g
 
    (c*2)[t ..< c.size+t].sum{
        it < "e" && p[1] ? p-=p[g] : g++
        g%=p.size
    }
            
    p.sort()
}

/*
T russianRoulette(c, t, g, p) {
    
    T i = p.indexOf g
    g = c.size
    
    for( ; g-- && p[1] ; i%=p.size )
        (c*2)[t++] < "e" ? p-=p[i] : i++
            
    p.sort()
}
*/