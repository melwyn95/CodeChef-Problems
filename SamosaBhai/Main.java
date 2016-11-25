import java.io.*;
import java.util.*;

public class Main {
    public static long power(int x, int n, int p) {
        long res = 1;
        x = x % p;
        while (n > 0) {
            if (n % 2 != 0){
                res = (res * x) % p;
            }
            n = n / 2;
            x = (x * x) % p;
        }
        return res;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String[] input = null;
        while (t-- > 0) {
            input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            long cost = 0;
            input = br.readLine().split(" ");
            int[] a = new int[n];
            int index = 0;
            for (String s : input) {
                a[index++] = Integer.parseInt(s);
            }
            for (int i = 0 ; i < n ; i++) {
                for (int j = i + 1 ; j < n ; j++) {
                    // System.out.println("-->"+a[i]+" "+a[j]);
                    // System.out.println(Math.abs(a[i]-a[j]));
                    cost += power(Math.abs(a[i]-a[j]), k, 1000000007);
                }
            }
            // System.out.println(n + " " + k);
            // System.out.println(Arrays.toString(a));
            System.out.println((cost * 2) % 1000000007);
        }
    }
}
