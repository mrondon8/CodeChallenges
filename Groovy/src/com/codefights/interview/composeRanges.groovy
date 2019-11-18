/*
Given a sorted integer array that does not contain any duplicates, return a summary of the number ranges it contains.

Example

For nums = [-1, 0, 1, 2, 6, 7, 9], the output should be
composeRanges(nums) = ["-1->2", "6->7", "9"].

Input/Output

[execution time limit] 6 seconds (groovy)

[input] array.integer nums

A sorted array of unique integers.

Guaranteed constraints:
0 ≤ nums.length ≤ 15,
-(231 - 1) ≤ nums[i] ≤ 231 - 1.

[output] array.string
*/
def composeRanges(List<Integer> nums) {
	if(nums.isEmpty())
		return []
	
	List ranges = []
	int current = nums[0]
	int currentRange = current
	
	for(int i = 1; i < nums.size; i++){
		//check if the current number is 1 greater than current if it is then increment current
		if(nums[i] == current+1)
			current++
		//otherwise then our current range has stopped
		//add the value to ranges
		//reset current to this value
		else{
			ranges << (currentRange==current ? "$current" : "$currentRange->$current")
			current = nums[i]
			currentRange = current
		}
	}
	
	//after the loop we have 2 cases, either a range or no range
	if(nums[-1] == currentRange)
		ranges << "$current"
	else
		ranges << currentRange + "->$current"
		
	
	ranges
}
