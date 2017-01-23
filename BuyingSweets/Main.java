import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int X = Integer.parseInt(input[1]);
            input = br.readLine().split(" ");
            int[] a = new int[N];
            int count = 0;
            int sum = 0;
            int min = Integer.MAX_VALUE;
            for (String s : input) {
                a[count++] = Integer.parseInt(s);
                sum += a[count-1];
                if (a[count-1] < min) {
                    min = a[count-1];
                }
            }
            int before = sum / X;
            int after = (sum-min) / X;
            if (before == after) {
                System.out.println(-1);
            } else {
                System.out.println(max(before, after));
            }
        }
    }
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}
