
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] tree;
	static int[] lazy;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int q = Integer.parseInt(input[1]);
		tree = new int[4*n];
		lazy = new int[4*n];
		while (q-- > 0) {
			input = br.readLine().split(" ");
			int op = Integer.parseInt(input[0]);
			int l = Integer.parseInt(input[1]);
			int r = Integer.parseInt(input[2]);
			if (op == 0) {
				// update
				lazyUpdate(0, l, r, 0, n-1);
			} else {
				// query
				System.out.println(lazyQuery(0, l, r, 0, n-1));
			}
//			System.out.println(Arrays.toString(tree));
//			System.out.println(Arrays.toString(lazy));
//			System.out.println("_____________________");
		}
	}





	public static void lazyUpdate(int root, int left, int right, int start, int end) {
		if (lazy[root] != 0) {
			tree[root] = (end-start+1) - tree[root];
			if (start != end) {
				lazy[2*root+1] = ((end-start+1)/2) - lazy[2*root+1];
				lazy[2*root+2] =  ((end-start+1)/2) - lazy[2*root+2];
			}
			lazy[root] = 0;
		}
		if (start > end || right < start || left > end) return;
		if (start >= left && end <= right) {
			tree[root] = (end-start+1) - tree[root];
			if (start != end) {
				lazy[2*root+1] = ((end-start+1)/2) - lazy[2*root+1];
				lazy[2*root+2] = ((end-start+1)/2) - lazy[2*root+2];
			}
			return;
		}
		int mid = (start + end) / 2;
		lazyUpdate(2*root+1, left, right, start, mid);
		lazyUpdate(2*root+2, left, right, mid+1, end);
		tree[root] = tree[2*root+1] + tree[2*root+2];
	}

	public static int lazyQuery(int root, int left, int right, int start, int end) {
		if (start > end || left > end || right < start)
			return 0;
		if (lazy[root] != 0) {
			tree[root] = (end-start+1) - tree[root];
			if (start != end) {
				lazy[2*root+1] = ((end-start+1)/2) - lazy[2*root+1];
				lazy[2*root+2] =  ((end-start+1)/2) - lazy[2*root+2];
			}
			lazy[root] = 0;
		}
		if (start >= left && end <= right) {
			return tree[root];
		} else {
			int mid = (start + end) / 2;
			int leftSum = lazyQuery(2*root+1, left, right, start, mid);
			int rightSum = lazyQuery(2*root+2, left, right, mid+1, end);
			return leftSum + rightSum;
		}
	}
}
