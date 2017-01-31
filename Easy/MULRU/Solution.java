/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static int linear_search(int[] a, int x) {
        int index = 0;
        for (int i : a) {
            if (i == x) {
                return index;
            }
            index++;
        }
        return -1;
    }
    public static int available(int[] age) {
        int max = 0;
        int max_index = -1;
        int index = 0;
        for (int page : age) {
            if (page >= max) {
                max = page;
                max_index = index;
            }
            index++;
        }
        return max_index;
    }
    public static boolean isFull(int[] cache) {
        int count = 0;
        for (int i : cache) {
            if (i == 0) {
                count++;
            }
        }
        if (count > 0) {
            return false;
        } else {
            return true;
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
		    String[] input = br.readLine().split(" ");
		    int N = Integer.parseInt(input[0]);
		    int S = Integer.parseInt(input[1]);
		    input = br.readLine().split(" ");
		    int[] a = new int[N];
		    int count = 0;
		    for (String s : input) {
		        a[count++] = Integer.parseInt(s);
		    }
		    // Linrear Search is bad try Binary Search
		    int[] cache = new int[S];
		    int[] age = new int[S];
		    for (int page : a) {
		        int index = linear_search(cache, page);
		        //System.out.println(index + " " + page);
		        if (index >= 0) {
		            // Cache Hit
		            age[index] = 0;
		        } else {
		            // Cache Miss
		            //System.out.print(isFull(age) + "\n");
		            if (isFull(cache)) {
		                index = available(age);
		            } else {
		                index = 0;
		                for (int i : cache) {
		                    if (i == 0) {
		                        break;
		                    }
		                    index++;
		                }
		            }
		            cache[index] = page;
		            age[index] = 0;
		        }
		        for (int i=0 ; i < S ; i++) {
		            if (cache[i] != 0) {
		                age[i]++;
		            }
		        }
		        //System.out.println("Page: " + page);
		        //System.out.println(Arrays.toString(cache));
		        //System.out.println(Arrays.toString(age));
		    }
		    Arrays.sort(cache);
		    String ans = "";
		    for (int i : cache) {
		        ans += (i + " ");
		    }
		    System.out.println(ans.trim());
		}
	}
}
