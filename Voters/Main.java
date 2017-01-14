/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static boolean binary_search(int[] a, int start, int end, int element) {
        if (start <= end) {
            int mid = (start + end) / 2;
            //System.out.print(a[mid]);
            if (a[mid] == element) {
                return true;
            } else {
                if (a[mid] < element) {
                    return binary_search(a, mid + 1, end, element);
                } else if (a[mid] > element) {
                    return binary_search(a, start, mid - 1, element);
                }
            }
        }
        return false;
    }


	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n1 = Integer.parseInt(input[0]);
		int n2 = Integer.parseInt(input[1]);
		int n3 = Integer.parseInt(input[2]);
		int[] a1 = new int[n1];
		int[] a2 = new int[n2];
		int[] a3 = new int[n3];
		for (int i=0 ; i < n1 ; i++) {
		    a1[i] = Integer.parseInt(br.readLine().trim());
		}
		for (int i=0 ; i < n2 ; i++) {
		    a2[i] = Integer.parseInt(br.readLine().trim());
		}
		for (int i=0 ; i < n3 ; i++) {
		    a3[i] = Integer.parseInt(br.readLine().trim());
		}

		//System.out.println(Arrays.toString(a1));
		//System.out.println(Arrays.toString(a2));
		//System.out.println(Arrays.toString(a3));

		int size_final = n1 + n2 + n3;
		/*if (n1 > n2 && n1 > n3) {
		    size_final += n1;
		    if (n2 > n3) size_final += n2;
		    else size_final += n3;
		} else if (n2 > n1 && n2 > n3) {
		    size_final += n2;
		    if (n1 > n3) size_final += n1;
		    else size_final += n3;
		} else if (n3 > n2 && n3 > n1) {
		    size_final += n3;
		    if (n1 > n2) size_final += n1;
		    else size_final += n2;
		}*/
		int[] final_answer = new int[size_final];
		int count = 0;
		for (int i=0 ; i < a1.length ; i++) {
		    if (binary_search(a2, 0, a2.length-1, a1[i]) || binary_search(a3, 0, a3.length-1, a1[i])) {
		        final_answer[count++] = a1[i];
		    }
		}
		for (int i=0 ; i < a2.length ; i++) {
		    if (binary_search(a3, 0, a3.length-1, a2[i]) && !binary_search(a1, 0, a1.length-1, a2[i])) {
		        final_answer[count++] = a2[i];
		    }
		}
		Arrays.sort(final_answer, 0, count);
		System.out.println(count);
		for (int i=0 ; i < count ; i++) {
		    System.out.println(final_answer[i]);
		}
	}
}
