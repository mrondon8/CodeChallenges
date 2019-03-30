package com.codefights.challenges
/*
Even after New Year city streets look great: houses are decorated with different lights and make you feel happier. So now, you went out from your house for a walk and got to a main street of your city.

Across the street there are n houses, each of which is decorated in some color: ith house is decorated in lights[i] color. You decided to call a contiguous subarray of houses charming if it contains exactly two different colors which alternate: contiguous subarray [i, j] is charming if lights[i] = lights[i + 2] = lights[i + 4] = ..., lights[i + 1] = lights[i + 3] = lights[i + 5] = ..., and lights[i] != lights[i + 1].

Now you want to find the length of the longest charming subsequence.
*/
def cityStreetLights(l) {
	if(l.size == 1)
		return 1
	
	int max = 0
	int temp = 0

	for(int i = 0; i < l.size; i++){
		if(l[i] == l[i+2] && l[i] != l[i+1]){
			temp = temp ? temp + 1 : 2
		}else{
			max = max > temp ? max : temp
			temp = 0
		}
	}
	
	if( (max == 0) && l[-1] != l[-2] )
		max = 1
	
	max + 1
}
