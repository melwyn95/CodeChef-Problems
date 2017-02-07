import java.io.*;
import java.util.*;

public class Main {
    public static float volume(float b, float p, float s) {
        return b*b*b-p*b*b+s*b;
    }
    public static float max(float a, float b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            float p = (float) Integer.parseInt(input[0]) / 4;
            float s = (float) Integer.parseInt(input[1]) / 2;
            float b_low = (float)(2 * p + Math.sqrt(4*p*p - 4*3*s)) / 6;
            float b_high = (float)(2 * p - Math.sqrt(4*p*p - 4*3*s)) / 6;
            System.out.printf("%.2f\n", max(volume(b_low, p, s), volume(b_high, p, s)));
        }
    }
}
