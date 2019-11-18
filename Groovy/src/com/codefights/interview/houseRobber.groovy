/*
You are planning to rob houses on a specific street, and you know that every house on the street has a certain amount of money hidden. The only thing stopping you from robbing all of them in one night is that adjacent houses on the street have a connected security system. The system will automatically trigger an alarm if two adjacent houses are broken into on the same night.

Given a list of non-negative integers nums representing the amount of money hidden in each house, determine the maximum amount of money you can rob in one night without triggering an alarm.

Example

For nums = [1, 1, 1], the output should be
houseRobber(nums) = 2.

The optimal way to get the most money in one night is to rob the first and the third houses for a total of 2.

Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.integer nums

An array representing the amount of money that each house on the street has.

Guaranteed constraints:
0 ≤ nums.length ≤ 100,
0 ≤ nums[i] ≤ 500.

[output] integer
*/

def houseRobber(List<Integer> nums) {
	
	int size = nums.size
	
	//what do we hold here hmmmmmmmmmmmmmmmmmmmmmmmmm, previous 2 maxes? maybe??
	List<Integer> dp = [0,0]
	
	for(int i = 0; i < size; i++){
		dp << Math.max( nums[i] + dp[-2], dp[-1] )
	}
	
	
	dp[-1]
}




/*

[1,2,3,4,5,6,7,6,5,2,7,9,3,2,6,2]




What is the max after n=4 houses?
	base case if n <= 2 then just the max from the first 2 houses right?
	
	at n = 3 we have passed 3 total houses at indices 0,1,2
	we have 2 possible scenarios, we took n-2 and n or we took n-1
	
	a(3) = 0,2 or 1 //is this correct though?? hmmmmmmm i guess it is if we stop right a this point but what if we walk one more
	
	a(4) = 0,3 or 1,3 or 0,2 hmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm i have no clue
	
	let's start from the back
	

*/



