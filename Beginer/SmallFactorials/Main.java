import java.io.*;
import java.util.*;


// TODO: Implement the divide and conquer algorithm....
//       This algorithm is brute force :(


public class Main {


    public static int[] add(int[][] table) {
        int[] carry = new int[table[0].length];
        int colIndex = 0;
        int[] returnValue = new int[table[0].length];
        for (int i=0;i<table[0].length;i++) {
            int cell = 0;
            for (int j=0;j<table.length;j++) {
                cell += table[j][i];
            }
            cell += carry[colIndex++];
            if (cell > 9) {
                returnValue[i] = cell % 10;
                carry[colIndex] = cell / 10;
            } else {
                returnValue[i] = cell;
            }
        }
        return returnValue;
    }

    public static int[] toNumArray(String a) {
        int count = 0;
        int[] A = new int[a.length()];
        for (char c : a.toCharArray()) {
            A[count++] = (int)(c - '0');
        }
        return A;
    }

    public static String multiply(String a, String b) {
        int[] A = toNumArray(a);
        int[] B = toNumArray(b);

        // System.out.println(Arrays.toString(A) + " " + Arrays.toString(B));

        int[][] table = new int[b.length()][2*a.length()];
        //int[] carry = new int[2*a.length()];

        for (int i=b.length()-1;i>=0;i--) {
            int colIndex = 0;
            int[] carry = new int[2*a.length()];
            // 0's
            for (int k=0;k<b.length()-1-i;k++) {
                table[i][colIndex++] = 0;
            }
            for (int j=a.length()-1;j>=0;j--) {
                // actual multiplication
                int cell = B[i] * A[j] + carry[colIndex];
                if (cell > 9) {
                    table[i][colIndex++] = cell % 10;
                    carry[colIndex] = cell / 10;
                } else {
                    table[i][colIndex++] = cell;
                }
                // System.out.println(colIndex);
            }
            if (carry[colIndex] > 0) {
                table[i][colIndex] = carry[colIndex];
            }
            // System.out.println("carry " + i  + " " + Arrays.toString(carry));
        }
        // System.out.println(Arrays.toString(carry));
        // for (int[] x : table) {
        //     System.out.println(Arrays.toString(x));
        // }

        int[] answer = add(table);
        // System.out.println(Arrays.toString(answer));
        String returnValue = "";
        int index = answer.length - 1;
        while (answer[index] == 0) {
            index--;
        }
        for (int i=index;i>=0;i--) {
            returnValue += answer[i];
        }
        // if (answer[answer.length-1] != 0) {
        //     returnValue += answer[answer.length-1];
        // }
        // for (int i=answer.length-2;i>=0;i--) {
        //     returnValue += answer[i];
        // }

        return returnValue;
    }

    public static void main(String[] args) throws IOException{
        // multiply("11111", "11111");
        // System.out.println(multiply("213123", "100000"));
        // multiply("123", "879");
        String[] fact = new String[101];
        fact[0] = "1";

        for (int i=1;i<=100;i++) {
            fact[i] = multiply(fact[i-1], Integer.toString(i));
            // System.out.println(i + " " + fact[i]);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            System.out.println(fact[Integer.parseInt(br.readLine())]);
        }
    }
}
