package BOJ.binarySearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10816 {

	static int arr[];
	static int find[];
	
	private static int lowerBound(int target) {
	    int begin = 0;
	    int end = arr.length;
	    
	    while(begin < end) {
	        int mid = (begin + end) / 2;
	        
	        if(arr[mid] >= target) {
	            end = mid;
	        }
	        else {
	            begin = mid + 1;
	        }
	    }
	    return end;
	}

	private static int upperBound(int target) {
	    int begin = 0;
	    int end = arr.length;
	    
	    while(begin < end) {
	        int mid = (begin + end) / 2;
	        
	        if(arr[mid] <= target) {
	            begin = mid + 1;
	        }
	        else {
	            end = mid;
	        }
	    }
	    return end;
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
			System.out.print(upperBound(find[i]) - lowerBound(find[i]) + " ");
		}

	}
}
