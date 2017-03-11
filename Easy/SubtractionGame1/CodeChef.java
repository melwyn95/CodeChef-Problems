import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a%b);
    }
    public static int reduce(int[] a, int i) {
        if (i==0) return gcd(a[i], 0);
        else {
            int acc = reduce(a, i-1);
            return gcd(acc, a[i]);
        }
    }
	public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] a = new int[n];
            int i = 0;
            for (String s : str) {
                a[i++] = Integer.parseInt(s);
            }
            System.out.println(reduce(a, n-1));
        }
	}
}
