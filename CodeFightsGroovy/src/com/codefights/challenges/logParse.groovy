package com.codefights.challenges
import java.text.SimpleDateFormat

/*You're a software engineer at the company manufacturing doodads. The doodads are sold online through the website that uses analytics service to track each sold item. Unfortunately the analytics service is pretty dumb, and stores the information in a weird and not very convenient format: as a bunch of logs, with each log having the format <period_start>,<period_end>,<users_visited>,<profit_made>. These intervals even overlap sometimes! However, the management doesn't seem to care about any of this.

What the management does care about, is the profit. Your task is to analyze the logs, and find the entry that has the the lowest per capita profit, i.e. with the lowest <profit_made> / <users_visited> / <period_length> value. Return the period start and end timestamps as the answer.

It is guaranteed that the answer is unique. If logs list is empty, return an empty array instead.

Example

For

logs = ["2017-08-11T17:07:46,2017-08-11T17:07:47,10,100", 
        "2017-08-12T17:07:46,2017-08-13T17:07:46,1004,23000"]
the output should be
logParse(logs) = [1502557666, 1502644066].

There are two log entries:

The first log's start timestamp is 1502471266, and the final timestamp is 1502471267. Its per capita profit is 100 / (10 * (end_time - start_time)) = 10.
The second log's start timestamp is 1502557666, and the final timestamp is 1502644066. Its per capita profit is 23000 / (1004 * (end_time - start_time)) ~ 0.0002651, which is definitely smaller than 10. This log entry is of interest to the management, and should be returned as the answer.
Thus, the final answer is [1502557666, 1502644066].

Input/Output

[time limit] 6000ms (groovy)

[input] array.string logs

Log entries, with each log given in the format
"<period_start>,<period_end>,<users_visited>,<profit_made>".

<period_start> and <period_end> are given in the format <YYYY>-<MM>-<DD>T<hh>:<mm>:<ss>. They are guaranteed to be valid, and describe time between the years of 2017 and 2023.

Guaranteed constraints:
0 ≤ log.length ≤ 500,
1 ≤ users_visited ≤ 108,
0 ≤ profit_made ≤ 106.

[output] array.integer

Epoch start and end of the interval with the lowest per capita profit.

[Groovy] Syntax Tips

// Prints help message to the console
// Returns a string
String helloWorld(String name) {
  print("Hello");
  return "Hello, " + name;
}

*/
double m=9,t;
SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

long[] logParse(String[] l) throws Exception {
    long[] o = new long[2];
    if (l.length == 0)
        return new long[0];

    for (String s : l) {
        String[] a = s.split(",");
                
        t = new Long(a[3]) / (new Long(a[2]) * (p(a[1]) -p(a[0]))/1.0);
        
        if (t < m) {
            m = t;
            o[0] = (p(a[0]));
            o[1] = (p(a[1]));
        }
    }
    return o;
}

long p(String s) throws Exception{
    return d.parse(s).getTime()/1000;
}