package swap_nodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Shopping {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] input = br.readLine().split(" ");
			int[] a = new int[n];
			int index = 0;
			for (String s : input) {
				a[index++] = Integer.parseInt(s);
			}
			Arrays.sort(a);
			int answer = 0;
			int i = n;
			if (n - 4 >= 0) {
				for (i = n - 4; i >= 0; i -= 4) {
					answer += (a[i + 2] + a[i + 3]);
					if (i - 4 < 0) {
						break;
					}
				}
			}
			if (i > 0) {
				if (i == 1) {
					answer += a[0];
				} else if (i == 2) {
					answer += (a[0] + a[1]);
				} else if (i == 3) {
					answer += (a[1] + a[2]);
				}
			}
			System.out.println(answer);
		}

	}

}
