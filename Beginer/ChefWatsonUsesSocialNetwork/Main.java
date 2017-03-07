import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static class Message {
		int id;
		int popularity;
		String message;
		Message(int id, int popularity, String message) {
			this.id = id;
			this.popularity = popularity;
			this.message = message;
		}
		public String toString() {
			return message;
		}
	}

	static class Heap {
		Message[] array;
		int count;
		int capacity;

		Heap(int capacity) {
			this.capacity = capacity;
			this.array = new Message[capacity];
			this.count = 0;
		}

		void insert(Message message) {
			this.count++;
			int i = this.count - 1;
			if (this.count != 1) {
				while (i > 0 && message.popularity > this.array[(i-1)/2].popularity) {
					this.array[i] = this.array[(i-1)/ 2];
					i = (i-1)/2;
				}
			}
			this.array[i] = message;
		}

		Message getMax() {
			if (this.count == 0) return null;
			Message max = this.array[0];
			this.array[0] = this.array[this.count - 1];
			this.count--;
			percolateDown(0);
			return max;
		}

		void percolateDown(int i) {
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			int max = i;
			// Research on comparable interface and comparator
			if (left < this.count && this.array[left].popularity > this.array[max].popularity)
				max = left;
			if (right < this.count && this.array[right].popularity > this.array[max].popularity)
				max = right;
			if (max != i) {
				Message temp = this.array[i];
				this.array[i] = this.array[max];
				this.array[max] = temp;
				percolateDown(max);
			}
		}
	}

	public static boolean contains(int[] a, int x) {
		for (int i : a) if (i == x) return true;
		return false;
	}

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String[] input = br.readLine().split(" ");
		 int n = Integer.parseInt(input[0]);
		 int m = Integer.parseInt(input[1]);
		 input = br.readLine().split(" ");
		 int[] specialFriends = new int[n];
		 for (int i=0;i<n;i++) {
			 specialFriends[i] = Integer.parseInt(input[i]);
		 }
		 Heap specialHeap = new Heap(1000);
		 Heap normalHeap = new Heap(1000);
		 for (int i=0;i<m;i++) {
			 input = br.readLine().split(" ");
			 int id = Integer.parseInt(input[0]);
			 int popularity = Integer.parseInt(input[1]);
			 String message = input[2];
			 if (contains(specialFriends, id)) {
				 specialHeap.insert(new Message(id, popularity, message));
			 } else {
				 normalHeap.insert(new Message(id, popularity, message));
			 }
		 }
		 while (specialHeap.count > 0) System.out.println(specialHeap.getMax());
		 while (normalHeap.count > 0) System.out.println(normalHeap.getMax());

	}
}
