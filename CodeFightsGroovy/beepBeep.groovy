Setup:

BEEP BEEP goes your alarm as you wake for the fourth time this morning.

You think to yourself, Why on earth did I set my alarm so early?, and fumble around until you manage to hit the snooze button and fall back asleep. But this is exactly why you set your alarm so early - you're a chronic snoozer!

You want to get the most continuous sleep possible but need to be up before a certain time w to go to work (measured in minutes). You decide to optimize this process by setting the times for your alarm clock (in ascending order).

Restrictions:

The earliest you can set your alarm is t = 0, otherwise your neighbors will complain.
You can only set you alarm for integer times from 0 to w - 1, inclusive, since your alarm only displays minutes.
You should have at least a 99% chance of getting up before time w.
Your goals (in order of most to least important) are:
Minimize the number of alarms
Maximize the times of the alarms
Maximize the time of the first alarm
Maximize the time of the second alarm
Etc...
Math:

The likelihood you wake up to each alarm is determined by your Sleepiness Probability, p.
The first time your alarm goes off, you will go back to sleep with probability p.
Every other time your alarm goes off, you will go back to sleep with probability pt + 2, where t is the time since you last woke up to an alarm, measured in minutes.
If it is impossible to get up with a probability of at least 99% in time, return an empty array.

Example

For w = 30 and p = 0.8, the output should be
beepBeep(w, p) = [11, 29].
You can't get up with just one alarm since you would only have a 20% chance of getting up.
With two alarms at times x and y, where x < y, the probability you go back to sleep after both alarms is:
0.8 · 0.8y - x + 2 = 0.8y - x + 3.
When y = x + 18, this probability is 0.821 = 0.009223 < 0.01, making the probability that you get up ≥ 99%. If y < x + 18, the probability of failure would be > 0.01, which is too high.
Thus you can get up in time with 2 alarms if the time between them is at least 18 minutes. From here, to maximize the time of the first alarm, pick y = 30 - 1 and x = y - 18, so x = 11 and y = 29, for the answer of [11, 29].

For w = 8 and p = 0.8, the output should be
beepBeep(w, p) = [0, 1, 2, 3, 4, 5, 6, 7].
Any arrangement of 7 alarms or less has > 1% chance of falling asleep after all the alarms, but using all 8 possible alarms produces a probability of failure of:
0.8 · 0.81 + 2 · 0.81 + 2 · 0.81 + 2 · 0.81 + 2 · 0.81 + 2 · 0.81 + 2 · 0.81 + 2 = 0.007379.
Since this is < 1%, using all 8 alarms yields a success rate of > 99%, making the answer [0, 1, 2, 3, 4, 5, 6, 7].

[time limit] 6000ms (groovy)

[input] integer w

The time you need to be awake by in order to get to work on time (in minutes).

Guaranteed constraints:
1 ≤ w ≤ 60.

[input] float p

Your Sleepiness Probability

Guaranteed constraints:
0 ≤ p ≤ 1.

[output] array.integer

The times (minutes) at which you should set alarms in order to satisfy the Restrictions and accomplish the goals in the order listed, sorted from least to greatest, or an empty array if this is impossible.

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}

T beepBeep(w, p) {
    T d
    p=(1..--w).find{r->
        d=(r..w).find{
            p**(it + 2 * r + 1) < 0.01 
        }
    }
    
    p&&w ? d-1 ? [w-d]+(w-p+1 ..w) : w-1 ? [w] : 0..1 : []
}


/*
def beepBeep(w, p) {
    def d
    def a = (1..w-1).find{alarms->
        d=(0..w-1).grep{delta->
            p**(delta + 2 * alarms + 1) < 0.01 && delta >= alarms
        }
        d.size()>0
    }
    println ([d[0],a])
    if(!a)
        return []
    else if(d[0]==1)
        return w==2?[0,1]:[w-1]
    else 
        [w-d[0]-1]+((w-a)..w-1)
    
}*/