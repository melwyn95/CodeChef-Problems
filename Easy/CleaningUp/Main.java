import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            String[] input = null;
            while (t-- > 0) {
                input = br.readLine().split(" ");
                int n = Integer.parseInt(input[0]);
                int m = Integer.parseInt(input[1]);
                int[] a = new int[n];
                if (n == 0) {
                    br.readLine();
                    System.out.println();
                    System.out.println();
                    continue;
                }
                if (m > 0) {
                    input = br.readLine().split(" ");
                    for (String s : input) {
                        a[Integer.parseInt(s) - 1] = 1;
                    }
                } else {
                    br.readLine();
                }
                ArrayList<Integer> chef = new ArrayList<Integer>();
                ArrayList<Integer> assistant = new ArrayList<Integer>();
                boolean flag = false;
                for (int i=0;i<n;i++) {
                    if (a[i] == 0) {
                        if (flag) {
                            assistant.add(i+1);
                            flag = false;
                        } else {
                            chef.add(i+1);
                            flag = true;
                        }

                    }
                }
                String chefToPrint = "";
                String assistantToPrint = "";
                if (chef.size() > 0) {
                    for (int i : chef) {
                        chefToPrint += (i + " ");
                    }
                    System.out.println(chefToPrint.trim());
                } else {
                    System.out.println();
                }
                if (assistant.size() > 0) {
                    for (int i : assistant) {
                        assistantToPrint += (i + " ");
                    }
                    System.out.println(assistantToPrint.trim());
                } else {
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println();
        }
    }
}
