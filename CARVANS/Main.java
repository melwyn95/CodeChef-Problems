import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] a = new int[N];
            int count = 0;
            for (String s : br.readLine().split(" ")) {
                a[count++] = Integer.parseInt(s);
            }
            count = 0;
            int min = Integer.MAX_VALUE;
            for (int i=0;i<N;i++) {
                if (a[i] <= min) {
                    count++;
                    min = a[i];
                }
            }
            System.out.println(count);
        }
    }
}
