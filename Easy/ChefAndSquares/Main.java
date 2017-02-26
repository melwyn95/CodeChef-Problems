package swap_nodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Squares {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[][] a = new int[N][N];
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					a[i][j] = ((N+1)/2+i+j)%N + 1;
				}
			}
			for (int[] i : a) {
				String s = "";
				for (int j : i) {
					s += (j + " ");
				}
				System.out.println(s.trim());
			}
		}
	}

}
