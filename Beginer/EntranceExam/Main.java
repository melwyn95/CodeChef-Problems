import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            int e = Integer.parseInt(input[2]);
            int m = Integer.parseInt(input[3]);
            long[] a = new long[n-1];
            for (int i=0;i<n-1;i++) {
                long sum = 0;
                for (String s : br.readLine().split(" ")) {
                    sum += Integer.parseInt(s);
                }
                a[i] = sum;
            }
            long sergey = 0;
            String l = br.readLine();
            if (l.length() > 1) {
                for (String s : l.split(" ")) {
                    sergey += Long.parseLong(s);
                }
            }
            Arrays.sort(a);

            //System.out.println(Arrays.toString(a));

            int index = n - k - 1;
            long answer = a[index] - sergey + 1;
            if (answer < 0) {
                answer = 0;
            }
            if (answer <= m) {
                System.out.println(answer);
            } else {
                System.out.println("Impossible");
            }
        }
    }
}
