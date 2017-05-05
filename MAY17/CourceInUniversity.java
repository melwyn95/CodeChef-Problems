/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int min(int a, int b) {
        if (a < b) return a;
        return b;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
		    int n = Integer.parseInt(br.readLine());
		    String[] inp = br.readLine().split(" ");
		    int[] a = new int[n];
		    for (int i=0;i<n;i++) {
		        a[i] = Integer.parseInt(inp[i]);
		    }
		    int answer = 1;
		    for (int i=1;i<n;i++) {
		        answer = min(answer, i-a[i])+1;
		    }
		    System.out.println(answer);
		}
	}
}
