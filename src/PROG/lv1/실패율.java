package PROG.lv1;

import java.util.Arrays;
import java.util.Comparator;

public class 실패율 {
	public static void main(String[] args) {
		실패율 service = new 실패율();
		System.out.println(Arrays.toString(service.solution(5, new int[] { 2, 1, 2, 6, 2, 4, 3, 3 })));
	}

	public int[] solution(int N, int[] stages) {
		Stage[] stage = new Stage[N];
		double sum = stages.length;
		for (int s = 0; s < N; s++) {
			stage[s] = new Stage(s+1);
			if (sum == 0) {
				stage[s].failureRate = 0;
				continue;
			}

			double fail = 0;
			for (int i = 0; i < stages.length; i++) {
				if (s+1 == stages[i]) {
					fail++;
				}
			}
			stage[s].failureRate = fail / sum;
			sum -= fail;
		}
		
		Arrays.sort(stage, new Comparator<Stage>() {
			@Override
			public int compare(Stage o1, Stage o2) {
				if(o1.failureRate == o2.failureRate) {
					return Double.compare(o1.no, o2.no);
				}
				return Double.compare(o2.failureRate, o1.failureRate);
			}
		});
		int[] answer = new int[N];
		for(int i=0; i<N; i++) {
			answer[i] = stage[i].no;
		}
		return answer;
	}

	static class Stage {
		int no;
		double failureRate;

		public Stage(int no) {
			this.no = no;
			this.failureRate = 0;
		}
	}
}
