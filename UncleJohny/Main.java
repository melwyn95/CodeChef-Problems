import java.io.*;
import java.util.*;
public class Main {
    public static int temp = -1;
    public static int binarySearch(int[] a, int n, int l, int h, int lim) {
        if (l == h) {
            if (a[l] == n) {
                return l;
            } else {
                return -1;
            }
        } else {
            int mid = (l + h) / 2;
            if (a[mid] == n) {
                return mid;
            } else if (n < a[mid]) {
                return binarySearch(a, n, l, mid-1);
            } else {
                return binarySearch(a, n, mid+1, h);
            }
        }
    }
    public static int[] partition(int[] a, int low, int high, int last) {
        //System.out.println("Before Partition-> "+Arrays.toString(a)+" low="+low+" high="+high);
        int down = low + 1;
        int up = high;
        int pivot = a[low];
        while (down <= up) {
            while (a[down] < pivot && down <= high) {
                down++;
            }
            while (a[up] > pivot && up >= low) {
                up--;
            }
            if (down < up) {
                temp = a[down];
                a[down] = a[up];
                a[up] = temp;
            }
        }
        a[low] = a[up];
        a[up] = pivot;
        a[last] = up;
        //System.out.println("After Partition-> "+Arrays.toString(a)+" low="+low+" high="+high);
        return a;
    }
    public static int[] quickSort(int[] a, int low, int high, int last) {
        //System.out.println("QuickSort-> "+Arrays.toString(a)+" low="+low+" high="+high);
        if (low < high) {
            a = partition(a, low, high, last);
            int part = a[last];
            a = quickSort(a, low, part-1, last);
            a = quickSort(a, part+1, high, last);
            return a;
        }
        return a;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] a = new int[n+1];
            for (int i=0;i<n;i++) {
                a[i] = Integer.parseInt(input[i]);
            }
            int k = Integer.parseInt(br.readLine());
            int song = a[k-1];
            a = quickSort(a, 0, n-1, n);
            System.out.println(binarySearch(a, song, 0, n)+1);
        }


        //System.out.println(Arrays.toString(quickSort(new int[]{5, 4, 3, 2, 1, -1}, 0, 5-1, 5)));
        //System.out.println("BinarySearch-> "+binarySearch(new int[]{1, 2, 3, 4, 5}, 4, 0, 5));
    }
}
