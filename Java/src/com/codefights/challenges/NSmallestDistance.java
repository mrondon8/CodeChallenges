package com.codefights.challenges;

import java.util.Arrays;
import java.util.List;

public class NSmallestDistance {
	public static int smallestDistancePair(Integer[] nums, int k) {
		Arrays.sort(nums);
		int low = 0;
		int n = nums.length;
		int high = nums[n - 1] - nums[0];
		while (low < high) {
			int cnt = 0;
			int mid = (high + low) / 2;
			int left = 0;
			for (int right = 0; right < n; right++) {
				while (nums[right] - nums[left] > mid) {
					left++;
				}
				cnt += right - left;
			}
			if (cnt >= k) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}
	
	public static void main(String[] args) {
		int i = 5000, c=0;
		Integer[] r = new Integer[i];
		for(int j = 0; j < i; j++){
			r[j] = c += j;
		}
		List<Integer> x = Arrays.asList(r);
		System.out.println(x);
		long start, end;
		start = System.currentTimeMillis();
		int ans = smallestDistancePair(r, r.length/2);
		end = System.currentTimeMillis();
		System.out.println("Answer is " + ans + " in " + (end-start) + " milliseconds.");
	}
}
