package primes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ModifiedSegmentedSeive {
	public static ArrayList<Integer> seive(int n) {
		boolean[] numbers = new boolean[n];
		Arrays.fill(numbers, true);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i=2;i<n;i++) {
			if (numbers[i]) {
				int j = 2 * i;
				while (j < n) {
					numbers[j] = false;
					j += i;
				}
			}
		}
		for (int i=2;i<n;i++) {
			if (numbers[i]) {
				primes.add(i);
			}
		}
		return primes;
	}
	public static void solution(int low, int high) {
		ArrayList<Integer> init = new ArrayList<Integer>();
		ArrayList<Integer> primes = seive((int)(Math.sqrt(high)) + 1);
		for (int prime : primes) if (prime >= low && prime != 1) init.add(prime);
		int l = low;
//		low = (int)(Math.sqrt(high)) + 1;
		boolean[] numbers = new boolean[high-low+1];
		Arrays.fill(numbers, true);
//		int l = low;
//		low = (int)(Math.sqrt(high)) + 1;

		for (int prime : primes) {
			int lowLimit = (low/prime) * prime;
			if (lowLimit < low) lowLimit += prime;
			int j = lowLimit;
			while (j < high) {
				numbers[j-low] = false;
				j += prime;
			}
		}
		for (int prime : init) System.out.println(prime);
		for (int i=l;i<high;i++) {
			if (numbers[i-l] && i != 1) System.out.println(i);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] input = br.readLine().split(" ");
			int low = Integer.parseInt(input[0]);
			int high = Integer.parseInt(input[1]);
			solution(low, high+1);
			System.out.println();
		}
	}

}
