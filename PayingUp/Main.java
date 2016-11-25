import java.io.*;
import java.util.*;
public class Main {
    public static boolean sumOfSubSets(int[] a, int index, int sumSoFar, int sum, int n) {
        if (index < n) {
            if (sumSoFar + a[index] > sum) {
                return sumOfSubSets(a, index+1, sumSoFar, sum, n);
            } else if (sumSoFar + a[index] == sum) {
                return true;
            } else {
                return sumOfSubSets(a, index+1, sumSoFar+a[index], sum, n) || sumOfSubSets(a, index+1, sumSoFar, sum, n);
            }
        } else {
            return false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int[] a = new int[n];
            for (int i=0; i<n ; i++) {
                a[i] = Integer.parseInt(br.readLine());
            }
            if (sumOfSubSets(a, 0, 0, m, n)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
