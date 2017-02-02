import java.io.*;
import java.util.*;

public class Main {

    public static int[] partition(int[] a, int start, int end, int n) {
        int pivot = a[start];
        int low = start + 1;
        int high = end;
        while (low <= high) {
            while (a[low] < pivot && low <= end) {
                low++;
            }
            while (a[high] > pivot && high >= start) {
                high--;
            }
            if (low < high) {
                int temp = a[low];
                a[low] = a[high];
                a[high] = temp;
            }
        }
        a[n] = high;
        a[start] = a[high];
        a[high] = pivot;
        return a;
    }

    public static int[] quickSort(int[] a, int start, int end, int n) {
        if (start < end) {
            a = partition(a, start, end, n);
            int index = a[n];
            System.out.println(index);
            // System.out.println(Arrays.toString(a));
            a = quickSort(a, start, index - 1, n);
            a = quickSort(a, index + 1, end, n);
        }
        return a;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000000;//Integer.parseInt(br.readLine());
        int[] a = new int[n+1];
        for (int i=n;i>=1;i--) {
            a[n-i] = i;//Integer.parseInt(br.readLine());
        }
        a = quickSort(a, 0, n-1, n);
        for (int i=0;i<n;i++) {
            System.out.println(a[i]);
        }
    }
}
