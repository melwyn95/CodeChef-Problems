import java.util.*;
import java.io.*;
public class Main {
    public static int max(int a, int b) {
        if (a > b) return a; else return b;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
		    String[] input = br.readLine().split(" ");
		    int n = Integer.parseInt(input[0]);
		    int w = Integer.parseInt(input[1]);
		    int[][] cost = new int[n][w+1];
		    int[][] a = new int[n][3];
		    int index = 0;
		    for (int i=0;i<n;i++) {
		        input = br.readLine().split(" ");
		        a[i][0] = Integer.parseInt(input[0]);
		        a[i][1] = Integer.parseInt(input[1]);
		        a[i][2] = Integer.parseInt(input[2]);
		    }
		    for (int i=0;i<=w;i++) if (i >= a[0][2]) cost[0][i] = a[0][1]*a[0][0]; else cost[0][i] = 0;
		    for (int i=1;i<n;i++) {
                for (int j=1;j<=w;j++) {
                    if (j-a[i][2] >= 0) cost[i][j] = max(cost[i-1][j], cost[i-1][j-a[i][2]]+(a[i][0]*a[i][1]));
                    else cost[i][j] = cost[i-1][j];
                }
            }
            //for (int i=0;i<n;i++) System.out.println(Arrays.toString(cost[i]));
            System.out.println(cost[n-1][w]);
		}
	}
}
