/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{

    public static int solution(int[] a, int k) {
        k = k<(a.length-k)?k:(a.length-k);
        Arrays.sort(a);
        int sumL = 0;
        for (int i=0;i<k;i++) {
            sumL += a[i];
        }
        int sumR = 0;
        for (int i=k;i<a.length;i++) {
            sumR += a[i];
        }
        return Math.abs(sumR-sumL);
    }

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
		    String[] input = br.readLine().split(" ");
		    int n = Integer.parseInt(input[0]);
		    int k = Integer.parseInt(input[1]);
		    input = br.readLine().split(" ");
		    int[] a = new int[n];
		    int count = 0;
		    for (String i : input) {
		        a[count++] = Integer.parseInt(i);
		    }
		    System.out.println(solution(a, k));
		}
	}
}
