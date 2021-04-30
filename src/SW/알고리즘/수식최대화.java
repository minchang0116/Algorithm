package SW.알고리즘;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class 수식최대화 {
	public static void main(String[] args) {
		수식최대화 service = new 수식최대화();
		System.out.println(service.solution("100-200*300-500+20"));
	}

	public long solution(String expression) {
		ArrayList<Long> numbers = new ArrayList<Long>();
		ArrayList<Character> operator = new ArrayList<Character>();

		StringTokenizer st = new StringTokenizer(expression, "+|-|*|/");
		while (st.hasMoreTokens()) {
			numbers.add(Long.parseLong(st.nextToken()));
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) < '0' || expression.charAt(i) > '9') {
				operator.add(expression.charAt(i));
			}
		}

		char order[] = new char[4];
		boolean check[] = new boolean[4];
		max =0;
		permu(0, 0, order, numbers, operator, check);
		long answer = max;
		return answer;
	}

	// 0=+, 1=-, 2=*, 3=/
	static long max;
	private void permu(int idx, int cnt, char[] order, ArrayList<Long> numbers, ArrayList<Character> operator,
			boolean[] check) {
		if (cnt == 4) {
			ArrayList<Long> copyNumbers = new ArrayList<Long>();
			copyNumbers.addAll(numbers);
			ArrayList<Character> copyOperator = new ArrayList<Character>();
			copyOperator.addAll(operator);

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < copyOperator.size(); j++) {
					if (order[i] == copyOperator.get(j)) {
						if(order[i] == '+') {
							copyNumbers.set(j, copyNumbers.get(j)+copyNumbers.get(j+1));
						}
						else if(order[i] =='-') {
							copyNumbers.set(j, copyNumbers.get(j)-copyNumbers.get(j+1));
						}
						else if(order[i] == '*') {
							copyNumbers.set(j, copyNumbers.get(j)*copyNumbers.get(j+1));
						}
						else {
							copyNumbers.set(j, copyNumbers.get(j)/copyNumbers.get(j+1));
						}
						copyNumbers.remove(j+1);
						copyOperator.remove(j);
						j--;
					}
				}
			}
			if( Math.abs(copyNumbers.get(0)) > max) {
				max = Math.abs(copyNumbers.get(0));
			}
		}

		for (int i = 0; i < 4; i++) {
			if (check[i] == false) {
				check[i] = true;
				if (i == 0) {
					order[cnt] = '+';
				} else if (i == 1) {
					order[cnt] = '-';
				} else if (i == 2) {
					order[cnt] = '*';
				} else if (i == 3) {
					order[cnt] = '/';
				}
				permu(i + 1, cnt + 1, order, numbers, operator, check);
				check[i] = false;
			}
		}
	}
}
