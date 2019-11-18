class SumDigitsCount {
	// n, sum --> value of inputs
	// out --> output array
	// index --> index of next digit to be
	// filled in output array
	static void findNDigitNumsUtil(int length, int sum, char out[], int index) {
		// Base case
		if (index > length || sum < 0)
			return;

		// If number becomes N-digit
		if (index == length) {
			// if sum of its digits is equal to given sum,
			// print it
			if (sum == 0) {
				out[index] = ' ';
				System.out.println(out);
			}
			return;
		}

		// Traverse through every digit. Note that
		// here we're considering leading 0's as digits
		for (int i = 0; i <= 9; i++) {
			// append current digit to number
			out[index] = (char) (i + '0');

			// recurse for next digit with reduced sum
			findNDigitNumsUtil(length, sum - i, out, index + 1);
		}
	}

	// This is mainly a wrapper over findNDigitNumsUtil.
	// It explicitly handles leading digit
	static void findNDigitNums(int n, int sum) {
		// output array to store N-digit numbers
		char[] out = new char[n + 1];

		// fill 1st position by every digit from 1 to 9 and
		// calls findNDigitNumsUtil() for remaining positions
		for (int i = 1; i <= 9; i++) {
			out[0] = (char) (i + '0');
			findNDigitNumsUtil(n, sum - i, out, 1);
		}
	}

	
	public static void main(String[] args) {
		int n = 3, sum = 4;
		findNDigitNums(n, sum);
	}
}

// 