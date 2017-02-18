import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			String[] inp = br.readLine().split(" ");
			int n = Integer.parseInt(inp[0]);
			int m = Integer.parseInt(inp[1]);
			inp = br.readLine().split(" ");
			int[] a = new int[n];
			int[] b = new int[m];
			int c = 0;
			for (String s : inp) {
				a[c++] = Integer.parseInt(s);
			}
			inp = br.readLine().split(" ");
			c = 0;
			for (String s : inp) {
				b[c++] = Integer.parseInt(s);
			}
			Arrays.sort(b);
			c = 0;
			for (int i : a) {
				if (Arrays.binarySearch(b, i) >= 0) {
					c++;
				}
			}
			System.out.println(c);
		}
	}

}
