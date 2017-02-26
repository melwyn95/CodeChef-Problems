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
		    String[] input = br.readLine().split(" ");
		    int n = Integer.parseInt(input[0]);
		    int k = Integer.parseInt(input[1]);
		    int answer = 0;
		    for (int z=0;z<n;z++) {
		        input = br.readLine().split(" ");
		        int t = Integer.parseInt(input[0]);
		        int d = Integer.parseInt(input[1]);
		        if (k > 0) {
    		        if (k > t) {
    		            k -= t;
    		            t = 0;
    		        } else {
    		            t -= k;
    		            k = 0;
    		        }
		        }
		        answer += (t * d);
		    }
		    System.out.println(answer);
		}
	}
}
