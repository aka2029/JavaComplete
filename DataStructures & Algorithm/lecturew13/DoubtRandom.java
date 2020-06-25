//	HackerRank's Problem

package lecturew13;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DoubtRandom {

	// Complete the superDigit function below.
	static int superDigit(String n, int k) {

		if (n.length() == 1) {
			System.out.println(n);
			int ret = Integer.valueOf(n);
			return ret;
		}
		int x = 0;
		int y;
		for (int i = 0; i < n.length(); i++) {
			y = x + (n.charAt(i) - '0');
			x = y;
		}
		if (n.length() != 0 && k != 0) {
			int s = x * k;
			k = 0;
			String p = Integer.toString(s);
			return superDigit(p, k);
		} else {
			int s = x;
			String p = Integer.toString(s);
			return superDigit(p, k);

		}
//return k;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");

		String n = nk[0];

		int k = Integer.parseInt(nk[1]);

		int result = superDigit(n, k);
		System.out.println("Result is " + result);
		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();

		// bufferedWriter.close();

		scanner.close();
	}
}
