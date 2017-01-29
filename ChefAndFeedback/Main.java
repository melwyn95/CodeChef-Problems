/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{

    public static boolean match(char[] a) {
        for (int i=0;i<a.length-2;i++) {
            if ((a[i] == '0' && a[i+1] == '1' && a[i+2] == '0') || (a[i] == '1' && a[i+1] == '0' && a[i+2] == '1')) {
                return true;
            }
        }
        return false;
    }

	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
		    if (match(br.readLine().toCharArray())) {
		        System.out.println("Good");
		    } else {
		        System.out.println("Bad");
		    }
		}
	}
}
