package aw222zr_assignment1;

public class sumMain {

	// It seems to me, that a better way to compute the sum would be to just use a
	// for loop. Such as this:
	// int sum = 0;
	// for (int i = 1; i <= n; i++) {sum += i;}
	// System.out.println(sum);
	// This way of computing the sum seems to only make things more complicated. But
	// perhaps this also depends upon the situation.
	// In certain situations, maybe computing the sum as I do below, makes more
	// sense. It is, however, hard for me to imagine when this would be so.

	public static void main(String[] args) {
		// Program for computing sums recursively. Enter int of where recursive calls
		// should start in 'n'.
		// Also enter BaseCase.
		int n = 8;
		int baseCase = 15;
		intRecursion(n, baseCase);
	}

	public static boolean intRecursion(int n, int stopCase) {
		if (n < 0) {
			System.out.println("Negative numbers not allowed as input. Program shutdown. Enter new integer.");
			System.exit(1);
		}

		System.out.println("Current 'N': " + n);
		int mainSum = firstCalc(n) + secondCalc(n);
		System.out.println("MainSum(1+2+3...+N) is equal to: " + mainSum + "\n");

		if (n == stopCase) {
			System.exit(1);
		} else {
			n++;
			intRecursion(n, stopCase);
		}
		return false;
	}

	public static int firstCalc(int n) {
		int sum = 0;

		for (int i = 1; i <= n / 2; i++) {
			sum += i;
		}

		System.out.println("First Calculation: " + sum);
		return sum;
	}

	public static int secondCalc(int n) {
		int sum = 0;

		for (int i = 1; i <= n; i++) {

			sum += ((n / 2) + i);

			if ((n / 2) + i == n) {
				break;
			}
		}

		System.out.println("Second Calculation: " + sum);
		return sum;
	}
}
