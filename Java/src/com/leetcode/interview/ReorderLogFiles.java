package com.leetcode.interview;

import java.util.Arrays;

public class ReorderLogFiles {
	public static String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, (a, b) -> {
			if (Character.isDigit(a.charAt(a.length() - 1)) && Character.isDigit(b.charAt(b.length() - 1)))
				return 0;
			else if (Character.isDigit(a.charAt(a.length() - 1)))
				return 1;
			else if (Character.isDigit(b.charAt(b.length() - 1))) {
				return -1;
			} else {
				return (a.replaceFirst("(\\w+) (.+)", "$2 $1").compareTo(b.replaceFirst("(\\w+) (.+)", "$2 $1")));
			}
		});
		return logs;
	}

	public static void main(String[] args) {
		args = reorderLogFiles(
				new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" });

		for (String e : args)
			System.out.println(e);

		System.out.println("");
		args = reorderLogFiles(
				new String[] { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" });

		for (String e : args)
			System.out.println(e);
	}
}
