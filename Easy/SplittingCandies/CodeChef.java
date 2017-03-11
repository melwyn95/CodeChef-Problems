import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef {
	public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            long n = Long.parseLong(str[0]);
            long k = Long.parseLong(str[1]);
            if (k>0) System.out.println(n/k+" "+n%k);
            else System.out.println(0+" "+n);
        }
	}
}
