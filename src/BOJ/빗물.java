package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빗물 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		빗물 service = new 빗물();
		System.out.println(
				service.solution(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), br.readLine()));
	}

	public int solution(int H, int W, String block) {
		int answer = 0;
		StringTokenizer st = new StringTokenizer(block);
		int arr[] = new int[W];
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int left, right;
		for (int i = 1; i < arr.length - 1; i++) {
			left = right = arr[i];
			// 왼쪽 벽의 최댓값
			for (int j = 0; j < i; j++) {
				if (left < arr[j])
					left = arr[j];
			}
			// 오른쪽 벽의 최댓값
			for (int j = i + 1; j < arr.length; j++) {
				if (right < arr[j])
					right = arr[j];
			}
			answer += Math.min(left, right) - arr[i];
		}

		return answer;
	}
}
