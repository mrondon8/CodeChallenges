package com.codefights.challenges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class RestoreChemicalFormula {

static String restoreChemicalFormula(List<String> e, String f) {
	Queue<String> s = new PriorityQueue<>();
	//Stack<String> s = new Stack<>()
	s.add("");
	int size = f.length();
    f += "  ";
	String lower = f.toLowerCase();
	Set<String> elements = new HashSet<>(e);
	Set<Integer> seen = new HashSet<>();
	
	int iters = 0, adds = 0;
	
    for(; s.isEmpty() == false; ){
		iters++;
		String F = s.poll();
		//String F = s.pop()
        int i = F.length();
				
        if(i == size){
			println("Iters: " + iters);
			println("Seen size " + seen.size());
			println("Adds " + adds);
			println(F.length());
			return F;
        }

		
		String x = f.substring(i,i+1);
		String y = x + lower.substring(i+1,i+2);
		
		if(elements.contains(x) && seen.add((F+x).toLowerCase().hashCode())){
			s.add(F + x);
			adds++;
		}
		
		if(elements.contains(y) && seen.add((F+y).toLowerCase().hashCode())){
			s.add(F + y);
			adds++;
		}
			
    }
	println("No answer");
	return "";
}

	static void println(Object str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String f = "";
		for (int i = 0; i < 40_000; i++)
			f += "R";
		String[] e = new String[] { "R", "Rr" };
		restoreChemicalFormula(Arrays.asList(e), f);
		long end = System.currentTimeMillis();
		println(end - start);
	}

}
