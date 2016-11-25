import java.io.*;
import java.util.*;

public class Main {
    public static int temp = -1;
    public static int binarySearch(int[] a, int n, int l, int h, int lim) {
        if (l == h) {
            if (l < lim && a[l] == n) {
                return l;
            } else {
                return -1;
            }
        } else {
            int mid = (l + h) / 2;
            if (a[mid] == n) {
                return mid;
            } else if (n < a[mid]) {
                return binarySearch(a, n, l, mid-1, lim);
            } else {
                return binarySearch(a, n, mid+1, h, lim);
            }
        }
    }
    public static int[] partition(int[] a, int low, int high, int last) {
        int down = low + 1;
        int up = high;
        int pivot = a[low];
        while (down <= up) {
            while (a[down] <= pivot && down <= high) {
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
        return a;
    }
    public static int[] quickSort(int[] a, int low, int high, int last) {
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
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);
            int n3 = Integer.parseInt(input[2]);
            int[] a = new int[n1];//{23, 30, 42, 57, 90};
            int[] b = new int[n2];//{21, 23, 35, 57, 90, 92};
            int[] c = new int[n3];//{21, 23, 30, 57, 90};
            int n4 =n1 + n2 + n3;
            int[] d = new int[n4];
            int index = 0;
            for (int i=0;i<n1;i++) {
                a[index++] = Integer.parseInt(br.readLine());
            }
            index = 0;
            for (int i=0;i<n2;i++) {
                b[index++] = Integer.parseInt(br.readLine());
            }
            index = 0;
            for (int i=0;i<n3;i++) {
                c[index++] = Integer.parseInt(br.readLine());
            }
            index = 0;
            for (int i=0;i<n1;i++) {
                if (binarySearch(b, a[i], 0, n2, n2) != -1) {
                    d[index++] = a[i];
                }
                if (binarySearch(c, a[i], 0, n3, n3) != -1) {
                    d[index++] = a[i];
                }
            }
            for (int i=0;i<n2;i++) {
                if (binarySearch(c, b[i], 0, n3, n3) != -1) {
                    d[index++] = b[i];
                }
            }
            d = quickSort(d, 0, index-1, index);
            String output = "";
            int count = 0;
            for (int i=0;i<index-1;i++) {
                if (d[i] != d[i+1]) {
                    output += d[i] + " ";
                    count++;
                }
            }
            count++;
            output += d[index-1] + " ";
            System.out.println(count);
            for (String s : output.split(" ")) {
                if (!s.equals(" ")) {
                    System.out.println(s);
                }
            }
        } catch(Exception e) {
            System.out.println();
        }
    }
}
