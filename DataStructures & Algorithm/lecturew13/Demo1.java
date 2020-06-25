//	Pg.28 Memoization using arrays and hashmap (Very Important concept)

package lecturew13;

import java.util.HashMap;
import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int cache[] = new int[Integer.MAX_VALUE / 10];
		// HashMap<Integer, Integer> map = new HashMap<>();
		while (true) {
			long startTime = System.nanoTime();

			System.out.println("Enter the Prime Number");

			int n = s.nextInt();

			// if(map.get(n)!=null) {
			if (cache[n] != 0) {
				System.out.println("Cache Prime No " + n);
				long endTime = System.nanoTime();
				System.out.println((endTime - startTime) + "ns CACHE ");
				continue;
			}

			boolean isPrime = true;

			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					System.out.println("Not a Prime No");
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				System.out.println("Prime No " + n);
				cache[n] = n;
				// map.put(n, n);
			}

			long endTime = System.nanoTime();

			System.out.println((endTime - startTime) + "ns");
			System.out.println("Press q to quit");
			String choice = s.next();

			if (choice.equals("q")) {
				return;
			}
		}
	}
}
