import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int answer = 0;
            for (int i= 1;i<=n;i++) {
                String[] input = br.readLine().split(" ");
                answer ^= i;
            }
            System.out.println(answer);
        }
    }
}
