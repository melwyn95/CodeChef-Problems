import java.io.*;
import java.util.*;
public class Main{

	public static boolean isEqual(int[] a) {
		for (int i=0;i<a.length-1;i++) {
			if (a[i] != a[i+1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] in = br.readLine().split(" ");
			int[] a = new int[n];
			int count = 0;
			int sum = 0;
			for (String s : in) {
				a[count++] = Integer.parseInt(s);
				sum += a[count-1];
			}
			if (sum%n != 0) {
				System.out.println(-1);
				continue;
			}

			int times = 0;
			while (!isEqual(a)){
				int min = Integer.MAX_VALUE;int minIndex = -1;
				int max = -1;int maxIndex = -1;
				for (int i=0;i<n;i++) {
				    if (a[i] > max) { max = a[i]; maxIndex = i; }
				    if (a[i] < min) { min = a[i]; minIndex = i; }
				}
				int r = (int) Math.ceil((a[maxIndex]-a[minIndex])/2);
				a[minIndex] += r;
				a[maxIndex] -= r;
				times++;
			}
            System.out.println(times);
		}
	}
}
