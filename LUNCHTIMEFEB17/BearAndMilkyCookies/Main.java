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
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
		    int n = Integer.parseInt(br.readLine());
		    String[] order = br.readLine().split(" ");
		    boolean flag = true;
    		for (int i=0;i<n-1;i++){
        	    if (order[i].equals("cookie") && order[i+1].equals("cookie")) {    		            flag = false;
        		}
		    }
		    if (order[n-1].equals("cookie")) {
		        flag = false;
		    }
		    if (flag) {
		        System.out.println("YES");
		    } else {
		        System.out.println("NO");
		    }
		}
	}
}
