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
		    char[] str = br.readLine().toCharArray();
		    int i = 0;
		    boolean flag = true;
		    while (i < str.length-1) {
		        if ((str[i] == 'C' && str[i+1] == 'C') ||
		            (str[i] == 'C' && str[i+1] == 'E') || 
		            (str[i] == 'C' && str[i+1] == 'S') ||
		            (str[i] == 'E' && str[i+1] == 'S') ||
		            (str[i] == 'E' && str[i+1] == 'E') || 
		            (str[i] == 'S' && str[i+1] == 'S')
		           ) i++;
		        else {
		            flag = false;
		            break;
		        }
		    }
		    if (flag) System.out.println("yes");
		    else System.out.println("no");
		}
	}
}
