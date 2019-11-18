package com.codefights.challenges
/*
At the end of last semester, your goal was to simply maintain your current letter grade. You thought about it and decided that it would be even better if you can advance your grade by a letter or more if possible.

Like the finalSlacker challenge, you will be provided the weights in an array: homework first, quizzes second, and tests third. You will also be provided the scores in the same order. All homework assignments are graded out of 10 points, quizzes are out of 5 points, and tests are out of 100 points.

The following grading scale is used:

A: [90%, 100%]
B: [80%, 90%)
C: [70%, 80%)
D: [60%, 70%)
F: [0%, 60%)
Given weights and scores, your task is to find the minimum score (rounded up to the nearest integer) that you'd need to achieve on the final test, in order to maintain or increase your current letter grade as much as possible.

Example

For weights = [10, 15, 75] and scores = [[10,10,10,10,10,10,10,10,10,10], [5,5,5,5,5], [100,96,90]], the output should be finalSlacker2(weights, scores) = 61.

Your grade is already at a 96.5, which is an "A". It would make the most sense to maintain the "A", so you can afford to get 61 points on the final exam and still keep your "A".

For weights = [10, 15, 75] and scores = [[10,10,10,10,10,10,10,9,8,7], [5,5,5,5,5], [77,80,70,50]], the output should be finalSlacker2(weights, scores) = 94.

Your current grade is 76.3375, which is a "C". You can advance to 80, a "B", by scoring 94 points on the final exam.

For weights = [25, 25, 50] and scores = [[9,9,8,7,7,6,8,5,4,7,3], [3,3,2,3,1], [88,66,50]], the output should be finalSlacker2(weights, scores) = 48.

Your current grade is 62.59, and it would take 128 on the final exam to bring it up to 70. So it is better to maintain the current grade by aiming for 48 on the final exam.

For weights = [1, 1, 98]and scores = [[0,0,0,0,0,0,0,0,0,0,0,0], [0,0,0,0,0], [69]], the output should be finalSlacker2(weights, scores) = 95.

Your current grade is 67.92, and it would be possible to bring it up to 80 by getting a 95 on the final exam
 */
def finalSlacker2(w, s) {

    s[2] << 0

    (0..99).max{
        s[2][-1] = it
        (9..6).find{
            def i = 0
            it < s.sum{ 
                w[i] * it.sum() / it.size / [2,1,20][i++]/50 
            }
        }
    }
    
}
