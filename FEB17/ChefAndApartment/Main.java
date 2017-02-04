import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i=0;i<n;i++) {
                a[i] = Integer.parseInt(input[i]);
            }
            boolean penalty = false;
            int amount = 1000 * n;
            for (int i=0;i<n;i++) {
                if (a[i] == 0) {
                    penalty = true;
                    amount += 100;
                } else {
                    amount -= 1000;
                    if (penalty) {
                        //penalty = false;
                        amount += 100;
                    }
                }
            }
            System.out.println(amount);
        }
    }
}
