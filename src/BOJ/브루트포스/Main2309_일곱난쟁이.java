package BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2309_일곱난쟁이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9];
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		numbers = new int[9];
		combi(0,0,0);
		for(int i=0; i<7; i++) {
			System.out.println(numbers[i]);
		}
	}
	
	static int numbers[];
	static int arr[];
	static int flag;
	static void combi(int idx, int cnt, int sum) {
		if (flag == 1 || (cnt== 7 && sum == 100) ) {
			flag = 1;
			return;
		}
		
		for(int i=idx; i<9; i++) {
			numbers[cnt] = arr[i];
			combi(i+1, cnt+1 , sum+arr[i]);
			if(flag == 1) {
				return;
			}
		}
	}
}
