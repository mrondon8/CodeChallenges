/*
You are given an array of integers.

You can perform additions of 2 integers (same integer can be used) at a time to come up with a new integer.

Given a target number to reach, what is the lowest number of additions needed to reach this number?

Example:
arr = [1,2,4], target = 32

We created a new number
4 + 4 = 8

now we have these numbers
[1, 2, 4, 8]
8 + 8 = 16

[1, 2, 4, 8, 16]
16 + 16 = 32

So this took 3 additions to reach our target
[1, 2, 4, 8, 16, 32]
*/

class Exponential {
    //MAX_STEPS = 100;
    constructor(arr, target) {
        this.step = 0;
        this.sequences = [arr];
        this.previous_sequences = [];
        this.target = target;
        this.arr = arr;
    }

    next() {
        if(this.step < 6) {
            this.step++;
        }
        else {
            console.log("Maximum steps reached. No answer could be found", this.target);
            return -1
        }
        
        this.previous_sequences = this.sequences;
        this.sequences = new Set();

        for(const sequence of this.previous_sequences) {
            for(let i = 0; i < sequence.length; i++) {
                for(let j = i; j < sequence.length; j++) {
                    this.sequences.add([...sequence, sequence[i] + sequence[j] ].sort((a,b)=>a-b));
                }
            }
        }
    }

    solveBrute() {
        for(const sequence of this.sequences) {
            if(sequence.indexOf(this.target) >= 0) {
                return this.step;
            }
        }
        if(this.next() < 0) {
            console.log(this.sequences);
            return -1;
        }
        return this.solveBrute();
    }

    solveDFS() {
        if(this.arr.indexOf(this.target) >= 0) {
            return 0
        }
                
        const n = this.arr.length;
        
        let min = 1e9;

        let a = this.arr;

        const seen = {};

        for(; this.sequences.length > 0; ) {
            const current = this.sequences.pop();
            const size = current.length;

            if(size > 12) {
                continue;
            }

            for(const e of current) {
                if(e + current[size-1] == this.target) {
                    min = Math.min(min, size + 1);
                    a = current;
                    console.log(min, a);
                    break;
                }
                
                if(e + current[size-1] < this.target && min > size + 1) {
                    this.sequences.push([...current, e + current[size - 1]]);
                }
                
            }

        }
        console.log([...a, this.target]);
        return min < 1e9 ? min - n : -1;
    }


}
// arr = [1];
/*
for(let i = 1; i < 200; i++) {
    console.time("solveBrute");
    const brute = new Exponential(arr, i).solveBrute();
    console.timeEnd("solveBrute");

    console.time("solveDFS");
    const dfs = new Exponential(arr, i).solveDFS();
    console.timeEnd("solveDFS");
    console.log(i, brute, dfs, brute == dfs);
    if(brute != dfs) {
        console.log("WRONG ANSWER!");
        return;
    }
}
*/
// let r = 0;
// for(let i = 1; i <= 400; i++) {
//     console.time("solveDFS");
//     const dfs = new Exponential(arr, i).solveDFS();
//     r += dfs;
//     console.log(i, dfs);
//     console.timeEnd("solveDFS");
// }
// console.log(r);


function makeTheNumber(arr, target) {
    hash = {}
    for(i=0;i < arr.length;i++)
        hash[arr[i]] = 1
    
    vis = new Array(1000).fill(1000)
    
    q = []
    for(i=0;i < arr.length;i++){
        q.push([arr[i], hash, 0])
    }
    
    i = 0
    while(i < q.length){
        [v, hash, count] = q[i]
        if (v == target)
            return count;
        else
            keys = Object.keys(hash)
            for(j=0;j < keys.length; j++){
                newVal = v + parseInt(keys[j]);
                //console.log(keys[j])
                if (vis[newVal] >= count && newVal <= target){
                    vis[newVal] = count;
                    //console.log
                    q.push([newVal,{...hash, [newVal]:1},count+1])
                }
            }
        i += 1
    }
    return -1
}

let s = 0;
for(let i = 1; i < 2; i++) {
    s += makeTheNumber([7, 17], 221)    
    console.log(i, s);
}

console.log(s);

