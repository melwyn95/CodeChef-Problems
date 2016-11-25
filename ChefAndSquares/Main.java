import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        //PrintWriter out = new PrintWriter(new File("output.txt"));
        int t = Integer.parseInt(br.readLine());
        String[] input = null;
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] a = new int[n][n];
            for (int i = 0 ;i < n; i++) {
                a[i][i] = n;
                for (int j = 1 ;j < n-i; j++) {
                    a[i][i+j] = n - j;
                }
                for (int j = i-1,k = 1;j >= 0; j--, k++) {
                    a[i][j] = k;
                }
            }
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
        }
        //out.close();
    }
}
