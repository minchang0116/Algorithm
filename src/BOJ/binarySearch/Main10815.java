package BOJ.binarySearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10815 {

	static int arr[];
	static int find[];

	static int binarySearch(int find, int left, int right) {
		if(left > right) {
			return 0;
		}
		int mid = (left+right)/2;
		if(arr[mid] < find) {
			return binarySearch(find, mid+1, right);
		}
		else if(arr[mid] >find) {
			return binarySearch(find, left, mid-1);
		}
		else {
			return 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		find = new int[M];
		for (int i = 0; i < M; i++) {
			find[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		for (int i = 0; i < M; i++) {
			System.out.print(binarySearch(find[i],0, N-1) + " ");
		}

	}
}
