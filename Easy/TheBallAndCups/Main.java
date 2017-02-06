import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            int q = Integer.parseInt(input[2]);
            while (q-- > 0) {
                input = br.readLine().split(" ");
                int L = Integer.parseInt(input[0]);
                int R = Integer.parseInt(input[1]);
                if (c > R || c < L) {
                    continue;
                } else {
                    c = L + R - c;
                }
            }
            System.out.println(c);
        }
    }
}
