package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액_2470 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int nums[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순 정렬
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		int j = N - 1;
		for (int i = 0; i < j;) {
			if (nums[i] + nums[j] < 0) { // 음수면 왼쪽이 오른쪽으로 이동
				if (Math.abs(nums[i] + nums[j]) < min) {
					min = Math.abs(nums[i] + nums[j]);
					left = nums[i];
					right = nums[j];
				}
				i++;
			} else if (nums[i] + nums[j] > 0) {
				if (Math.abs(nums[i] + nums[j]) < min) {
					min = Math.abs(nums[i] + nums[j]);
					left = nums[i];
					right = nums[j];
				}
				j--;
			}
			else {
				left = nums[i];
				right= nums[j];
				break;
			}
		}

		System.out.println(left + " " + right);
	}
}
