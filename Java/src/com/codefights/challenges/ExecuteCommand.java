package com.codefights.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExecuteCommand {
	public static void main(String[] args) throws IOException {
		InputStream in = Runtime.getRuntime().exec("cmd /c dir").getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String s = "";
		for(; (s = br.readLine()) != null; )
			System.out.println(s);
		
	}
}
