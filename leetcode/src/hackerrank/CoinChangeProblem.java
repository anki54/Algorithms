package hackerrank;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

class Result {

	/*
	 * Complete the 'getWays' function below.
	 *
	 * The function is expected to return a LONG_INTEGER. The function accepts
	 * following parameters: 1. INTEGER n 2. LONG_INTEGER_ARRAY c
	 * Returns all the possible ways for adding an (unlimited) amount of coins to a target sum.
	 * https://prismoskills.appspot.com/lessons/Dynamic_Programming/Chapter_03_-_Max_ways_in_which_coins_can_make_a_sum.jsp 
	 */
	
	public static long getWays(int n, List<Long> c) {
		// Write your code here
		// holds the number of coins needed to break a value 
		HashMap<Long, Long> coinBreak = new HashMap<>();
		// coin used is exactly the value of the target sum hence only 1 coin.
		coinBreak.put((long) 0, (long) 1);

		for (Long coin : c) {
			for (long sumcoin = coin; sumcoin <= n; sumcoin++) {
				long res = (coinBreak.get(sumcoin) != null ? coinBreak.get(sumcoin) : (long) 0)
						+ (coinBreak.get(sumcoin - coin) != null ? coinBreak.get(sumcoin - coin) : (long) 0);
				coinBreak.put(sumcoin, res);
				System.out.println(coinBreak);
			}
		}
		return (coinBreak.get((long) n) != null ? coinBreak.get((long) n) : 0);
	}

}

public class CoinChangeProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int m = Integer.parseInt(firstMultipleInput[1]);

		List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong)
				.collect(toList());

		// Print the number of ways of making change for 'n' units using coins having
		// the values given by 'c'

		long ways = Result.getWays(n, c);

		bufferedWriter.write(String.valueOf(ways));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
