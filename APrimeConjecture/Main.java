import java.io.*;
import java.util.*;

class Main {
    public static int MAX = 200 + 7;
    public static ArrayList<Integer> primes = new ArrayList<Integer>();
    public static int[] answer = new int[52900+1];
    public static String[] toPrint = new String[52900+1];
    public static boolean[] numbers = new boolean[MAX];
    public static int count = 0;

    public static void seive() {
        for (int i=2;i<MAX;i++) {
            if (!numbers[i]) {
                //count++;
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

    public static int[] quickSort(int[] a, int start, int end) {
        if (start < end) {
            a = partition(a, start, end);
            int pivotIndex = a[52900];
            //System.out.println("Pivot Index: " + pivotIndex + " Start: " + start + " End: " + end);
            //System.out.println(Arrays.toString(answer));
            a = quickSort(a, start, pivotIndex-1);
            a = quickSort(a, pivotIndex+1, end);
        }
        return a;
    }

    public static int[] partition(int[] a, int start, int end) {
        // System.out.println("Start: " + start + " End: " + end);
        int pivot = a[start];
        String pivotString = toPrint[start];
        int low = start + 1;
        int high = end;
        while (low <= high) {
            //System.out.println("low: " + low + " high: " + high);
            while (pivot >= a[low] && low <= end) {
                low++;
            }
            while (pivot < a[high] && high >= start) {
                high--;
            }
            if (low < high) {
                //swap low and high
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
                String t = toPrint[low];
                toPrint[low] = toPrint[high];
                toPrint[high] = t;
            }
        }
        // swap low and pivot
        a[start] = a[high];
        a[high] = pivot;
        toPrint[start] = toPrint[high];
        toPrint[high] = pivotString;
        a[52900] = high;
        return a;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        seive();
        count = 0;
        for (int p1:primes) {
            for (int p2:primes) {
                for (int p3:primes) {
                    // System.out.println(p1 + " " + p2 + " " + p3);
                    int chef = p1 + p2 * p2 + p3 * p3 * p3;
                    if (chef <= 1000007) {
                        answer[count] = chef;
                        toPrint[count++] = p1+" "+p2+" "+p3;
                        // count++;
                    }
                }
            }
        }
        // System.out.println(count);
        //System.out.println(Arrays.toString(answer));
        answer = quickSort(answer, 0, 52900-1);
        int index = -1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            index = binarySearch(answer, 0, 52900-1, n);
            if (index >= 0) {
                System.out.println(toPrint[index]);
            } else {
                System.out.println("0 0 0");
            }
        }
    }
}
