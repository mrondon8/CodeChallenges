import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lockJava {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int n = 6;
		int v1, v2, h;
		int[][] lock = new int[n][n];
		int min = Integer.MAX_VALUE;
		List<Integer> e = new ArrayList<Integer>();
		for (int i = 1; i <= n * n; i++) {
			e.add(i);
		}

		ArrayList<int[][]> out = new ArrayList<int[][]>();
		ArrayList<Integer> counts = new ArrayList<Integer>();
		//for (int z = 0; z < Integer.MAX_VALUE; z++) {
		for( ; ; ){
			v1 = v2 = 1;
			Collections.shuffle(e);
			// populate lock
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					lock[i][j] = e.get(i * n + j);

			for (int i = 0; i < n; i++) {
				v1 *= lock[i][0];
				v2 *= lock[i][n - 1];
			}

			if (v1 == v2) {
				h = 1;
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++)
						h *= lock[i][j];
					if (v1 == h && h < min) {
						min = h;
						System.out.println("["+n+"]Found new minimum: " + min);
						for(int[] row : lock){
							System.out.print("[ ");
							for(int num : row)
								System.out.print(num + " ");
							System.out.println("]");
						}
						//out.add(lock);
						//counts.add(v1);
						//System.out.println(v1);
					}
				}
			}
		}
	/*
		int c = 0;
		for (int[][] t : out) {

			for (int[] x : t) {
				System.out.print("[ ");
				for (int y : x)
					System.out.print(y + " ");
				System.out.println("]");
			}
			System.out.println();
			System.out.println(counts.get(c++));
		}
		counts.sort((a,b)-> a - b);
		counts.add(Integer.MAX_VALUE);
		System.out.println(counts);
		System.out.println(counts.get(0));
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000);
		*/
	}
}
