package 프로그.그리디;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
	public static void main(String[] args) {
		단속카메라 service = new 단속카메라();
		System.out.println(service.solution(new int[][] { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } }));
	}

	public int solution(int[][] routes) {
		Arrays.sort(routes, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});

		int answer = 1;
		int cur = routes.length - 1;
		for (int i = routes.length - 1; i >= 1; i--) {
			if (routes[i - 1][1] < routes[cur][0]) { // 포함하지않으면
				answer++;
				cur = i-1;
			}
		}
		return answer;
	}
}
