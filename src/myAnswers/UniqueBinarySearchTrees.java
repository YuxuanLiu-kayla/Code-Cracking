package myAnswers;

public class UniqueBinarySearchTrees {
	
	public int numTrees(int n) {
		
		// Base case
		int num = 0;
		if (n == 1) {
			num++;
			return num;
		}
		if (n == 2) {
			num += 2;
			return num;
		}
		
		// Recursion
		else {  // 3 <= n <= 19
			num += numTrees(n - 1) * 2;
			if (n % 2 == 0) {  // n is an even integer
				for (int i = 2; i <= n / 2; i++) {
					num += numTrees(n - i) * numTrees(i - 1) * 2;
				}
			}
			else {  // n is an odd integer
				for (int j = 2; j <= n / 2; j++) {  // 3 / 2 = 1
					num += numTrees(n - j) * numTrees(j - 1) * 2;
				}
				num += Math.pow(numTrees(n / 2), 2);
			}
			return num;
		}
	}


}
