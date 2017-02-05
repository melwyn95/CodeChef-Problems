import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]) - 1;
            int q = Integer.parseInt(input[2]);
            while (q-- > 0) {
                input = br.readLine().split(" ");
                int L = Integer.parseInt(input[0]) - 1;
                int R = Integer.parseInt(input[1]) - 1;
                if (c > R || c < L) {
                    continue;
                } else {
                    int mid = (L+R)/2;
                    if ((L + R)%2 != 0) {
                        // odd
                        if (c < mid) {
                            // left of mid
                            c = R - c;
                        } else {
                            // right of mid
                            c = L + R - c;
                        }
                    } else {
                        // even
                        if (c < mid) {
                            c = R - c - 1;
                        } else {
                            c = L + R - c - 1;
                        }
                    }
                    System.out.println("Mid: " + mid);
                    System.out.println("C: " + c);
                }
            }
            System.out.println(c + 1);
        }
    }
}
