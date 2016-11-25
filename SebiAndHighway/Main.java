import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        String[] input = null;
        while (t-- > 0) {
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int sg = Integer.parseInt(input[1]);
            int fg = Integer.parseInt(input[2]);
            int d = Integer.parseInt(input[3]);
            int time = Integer.parseInt(input[4]);

            double distanceMeters = d * 50;
            double distanceKiloMeters = distanceMeters / 1000.0f;

            double extraSpeed = (3600 * (double)distanceKiloMeters) / (double)time;

            double newSpeed = s + extraSpeed;
            //double newSpeed = s + (double)(180 * (double)d) / (double)time;

            // System.out.println("Extra Speed : " + extraSpeed);
            // System.out.println("New Speed : " + newSpeed + " Distance Meters : " + distanceMeters);

            double sebiError = newSpeed - sg;
            double fatherError = newSpeed - fg;

            // System.out.println("Father Error : " + fatherError);
            // System.out.println("Sebi Error : " + sebiError);


            if (Math.abs(sebiError) == Math.abs(fatherError)) {
                System.out.println("DRAW");
            } else if (Math.abs(sebiError) < Math.abs(fatherError)) {
                System.out.println("SEBI");
            } else if (Math.abs(fatherError) < Math.abs(sebiError)) {
                System.out.println("FATHER");
            }
        }

    }
}
