import java.util.*;
import java.lang.*;
import java.io.*;
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
		    int n = Integer.parseInt(br.readLine());
		    if (n%4 == 1) System.out.println("ALICE"); else System.out.println("BOB");
		}
	}
}
