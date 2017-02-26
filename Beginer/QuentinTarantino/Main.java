/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
		    int n = Integer.parseInt(br.readLine());
		    String[] input = br.readLine().split(" ");
		    int[] a = new int[n];
		    int[] chps = new int[500];
		    int index = 0;
		    for (String s : input) {
		        a[index++] = Integer.parseInt(s);
		        chps[a[index-1]-1] += 1;
		    }
		    boolean sorted = true;
		    boolean dropped = false;
		    for (int i=0;i<n-1;i++) {
		        if (a[i] > a[i+1]) {
		            sorted = false;
		            break;
		        }
		    }
		    if (!sorted) {
    		    for (int i=0;i<n;i++) {
    		        if (chps[i] != 1) {
    		            dropped = true;
    		            break;
    		        }
    		    }
		    }
		    if (!sorted && !dropped) {
		        System.out.println("yes");
		    } else {
		        System.out.println("no");
		    }
		}
	}
}
