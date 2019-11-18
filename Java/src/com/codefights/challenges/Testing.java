package com.codefights.challenges;
import java.util.ArrayList;
import java.util.List;

public class Testing {
	static Object oddSumSequence(int[] x){
	    List<int []> m = new ArrayList<int []>();
	    int n = 0;
	    for(; !m.contains(x) && n++ < 4; ){
	    	for(int[] y : m){
	    		for(int e : y)
	    			System.out.print(e+", ");
	    		System.out.println();
	    	}
	        m.add(x.clone());
	        int s = 0;
	        for(int i = 0; i < x.length; i++)
	            x[i] = s += x[i]%2*x[i];
	    }
	    return m;
	}
	public static void main(String[] args) {
		System.out.println(oddSumSequence(new int[]{2, 5, 3, 8, 1}));
	}
}