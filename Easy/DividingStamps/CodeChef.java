import java.util.*;
import java.lang.*;
import java.io.*;
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int actualSum = 0;
		for (String s : br.readLine().split(" ")) actualSum += Integer.parseInt(s);
		if (actualSum == ((n*(n+1))/2)) System.out.println("YES"); else System.out.println("NO");
	}
}
