import java.io.*;
import java.util.*;

class Main {
    public static int MAX = 100 + 7;
    public static ArrayList<Integer> primes = new ArrayList<Integer>();
    public static int[] answer = new int[18225];
    public static String[] toPrint = new String[18225];
    public static boolean[] numbers = new boolean[MAX];
    public static int count = 0;

    public static void seive() {
        for (int i=2;i<MAX;i++) {
            if (!numbers[i]) {
                primes.add(i);
                int j = i * 2;
                while (j < MAX) {
                    numbers[j] = true;
                    j += i;
                }
            }
        }
    }

    public static int binarySearch(int[] a, int start, int end, int x) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (a[mid] == x) {
                return mid;
            } else {
                if (x < a[mid]) {
                    return binarySearch(a, start, mid-1, x);
                } else {
                    return binarySearch(a, mid+1, end, x);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        seive();
        //System.out.println(Arrays.asList(primes).toString());
        count = 0;
        for (int p1:primes) {
            for (int p2:primes) {
                for (int p3:primes) {
                    // System.out.println(p1 + " " + p2 + " " + p3);
                    int chef = p1 + p2 * p2 + p3 * p3 * p3;
                    if (chef <= 1000007) {
                        answer[count] = chef;
                        toPrint[count++] = p1+" "+p2+" "+p3;
                        //count++;
                    }
                }
            }
        }
        Arrays.sort(answer);
        //System.out.println(Arrays.toString(answer));
        //System.out.println(answer.size());
        int index = -1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            index = binarySearch(answer, 0, 18225-1, n);
            if (index >= 0) {
                System.out.println(toPrint[index]);
            } else {
                System.out.println("0 0 0");
            }
        }
    }
}
