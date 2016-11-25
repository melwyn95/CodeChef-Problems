import java.io.*;
import java.util.*;
public class Main {
    public static boolean[] primes = new boolean[10007];

    public static int[] seive() {
        int[] prime = new int[1229];
        primes[0] = !false;
        primes[1] = !false;
        for (int i=2 ;i <= 100; i++) {
            if (!primes[i]) {
                for (int j=i*i ;j <= 10000; j += i) {
                    primes[j] = !false;
                }
            }
        }
        int count = 0;
        for (int i=0 ;i<=10000; i++) {
            if (!primes[i]) {
                prime[count++] = i;
            }
        }
        //System.out.println("Primes = " + count);
        return prime;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] prime = new int[1229];
        int[] answer = new int[10007];
        prime = seive();

        //for (int p = 1 ; p <= 10000 ; p+=2) {
            // int limit = 0;
            // for (int i=0 ;i < 1229 && prime[i] <= p; i++) {
            //         limit = i;
            // }
            // int levy = 0;
            for (int i=0; i < 1229 ; i++) {
                for (int j=0; j < 1229 ; j++) {
                    if ((prime[i] + 2 * prime[j]) <= 10000) {
                        //if ((prime[i] + 2 * prime[j]) == p) {
                            answer[prime[i] + 2 * prime[j]]++;
                            //levy++;
                        //}
                    } else {
                        break;
                    }
                }
            }
            //answer[p] = levy;
        //}

        System.out.println(Arrays.toString(answer));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(answer[n]);
        }
        //     int limit = 0;
        //     int n = Integer.parseInt(br.readLine());
        //     if ((n & 1) == 0) {
        //         continue;
        //     }
        //     for (int i=0 ;i < 1229 && prime[i] <= n; i++) {
        //         limit = i;
        //     }
        //     //System.out.println("Limit : " + limit);
        //     //System.out.println(Arrays.toString(seive()));
        //     int levy = 0;
        //     for (int i=0; i <= limit ; i++) {
        //         for (int j=0; j <= limit ; j++) {
        //             if ((prime[i] + 2 * prime[j]) <= n) {
        //                 if ((prime[i] + 2 * prime[j]) == n) {
        //                     levy++;
        //                 }
        //             } else {
        //                 break;
        //             }
        //         }
        //     }
        //     System.out.println(levy);
        // }
    }
}
