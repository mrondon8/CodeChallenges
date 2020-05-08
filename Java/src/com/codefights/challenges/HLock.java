package com.codefights.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HLock {
	Map<Integer, List<Long>> map;
	boolean[] ngs;

	void dfs(int pos, int prod, int rem, int lim, long ptn) {
		if (rem == 0) {
			if (!map.containsKey(prod))
				map.put(prod, new ArrayList<>());
			map.get(prod).add(ptn);
		} else {
			for (int i = pos; i <= lim; i++) {
				if (ngs[i])
					continue;
				dfs(i + 1, prod * i, rem - 1, lim, ptn | 1L << i);
			}
		}
	}

	int zLock(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			// ab=bc=cd
			// a=c so NG
			return 0;
		}

		int lim = n * n;
		ngs = new boolean[lim + 1];
		outer: for (int i = 1; i <= n * n; i++) {
			if (i * 2 > n * n) {
				for (int j = 2; j < i; j++) {
					if (i % j == 0)
						continue outer;
				}
				ngs[i] = true;
			}
		}

		// B's candidates
		map = new HashMap<>();
		dfs(1, 1, n - 2, n * n, 0L);
		Map<Integer, List<Long>> bcan = map;

		// A and C's candidates
		map = new HashMap<>();
		dfs(1, 1, n - 1, n * n, 0L);
		Map<Integer, List<Long>> acan = map;

		int ret = Integer.MAX_VALUE;
		for (int key : bcan.keySet()) {
			for (long B : bcan.get(key)) {
				List<long[]> ptns = new ArrayList<>();
				for (int i = 1; i <= n * n; i++) {
					if (B << ~i >= 0) {
						int val = key * i;
						if (acan.get(val) != null) {
							for (long A : acan.get(val)) {
								if ((A & B) == 0 && A << ~i >= 0) {
									ptns.add(new long[] { A | 1L << i, i });
								}
							}
						}
					}
				}
				for (int i = 0; i < ptns.size(); i++) {
					long[] x = ptns.get(i);
					for (int j = i + 1; j < ptns.size(); j++) {
						long[] y = ptns.get(j);
						if (key * x[1] * y[1] >= ret)
							break;
						if ((x[0] & y[0]) == 0) {
							int prod = (int) (key * x[1] * y[1]);
							ret = Math.min(ret, prod);
							break;
						}
					}
				}
			}
		}

		// Aa = aBb = bC
		// A = Bb
		// aB = C
		return ret;
	}

	
	public static void main(String[] args) {
		HLock h = new HLock();
		System.out.println(h.zLock(4));
	}
}