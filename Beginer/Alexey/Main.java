import java.io.*;
import java.util.*;
public class Main {
    /*
    function gcd(a, b)
    if b = 0
       return a;
    else
       return gcd(b, a mod b);
    */
    public static long gcd(long a, long b) {
        // while (a != b) {
        //     if (a > b) {
        //         return gcd(a-b, b);
        //     } else {
        //         return gcd(a, b-a);
        //     }
        // }
        // return a;
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //PrintWriter out = new PrintWriter(new File("output.txt"));
        int t = Integer.parseInt(br.readLine());
        String[] input = null;
        //System.out.println("2, 3 -> "+gcd(3,2));
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            long[] a = new long[n];
            int i = 0;
            for (String s : input) {
                a[i++] = Long.parseLong(s);
            }
            //System.out.println(Arrays.toString(a));
            Arrays.sort(a);
            long min = Long.MAX_VALUE;
            //System.out.println("->"+gcd(1000000000L, 5000000000L));
            // for (i=0; i<n-1; i++) {
            //     //System.out.println(a[i] +" " + a[i+1] + " " + gcd(a[i], a[i+1]));
            //     int c = a[i]*a[i+1] / gcd(a[i],a[i+1]);
            //     if (c < min) {
            //         min = c;
            //     }
            // }
            for (i = 0 ; i < n ; i++) {
                for (int j = i + 1 ; j < n ; j++) {
                    long c = a[i]*a[j] / gcd(a[i],a[j]);
                    if (c < min) {
                        min = c;
                    }
                }
            }
            System.out.println(min);
            //out.println(min);
        }
        //out.close();
    }
}
