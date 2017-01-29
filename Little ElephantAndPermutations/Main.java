/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int localInversions(int[] a) {
        int count = 0;
        for (int i=0;i<a.length-1;i++) {
            if (a[i] > a[i+1]) {
                count++;
            }
        }
        return count;
    }

    public static int inversions(int[] a) {
        int count = 0;
        for (int i=0;i<a.length;i++) {
            for (int j=i+1;j<a.length;j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
		    int n = Integer.parseInt(br.readLine());
		    int[] a = new int[n];
		    String[] s = br.readLine().split(" ");
		    int count = 0;
		    for (String i : s) {
		        a[count++] = Integer.parseInt(i);
		    }
		    if (inversions(a) == localInversions(a)) {
		        System.out.println("YES");
		    } else {
		        System.out.println("NO");
		    }
		}
	}
}
