package SW.알고리즘;

public class 키패드누르기 {

	public static void main(String[] args) {
		키패드누르기 service = new 키패드누르기();
		System.out.println(service.solution(new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, "right"));
		
	}

	public String solution(int[] numbers, String hand) {
		int phone[][] = new int[12][2];
		// 폰 넘버의 좌표
		for (int i = 1; i <= 9; i++) {
			phone[i][0] = (i - 1) / 3 + 1;
			phone[i][1] = i % 3 == 0 ? 3 : i%3;
		}
		phone[0][0] = 4;
		phone[0][1] = 2;
		phone[10][0] = 4;
		phone[10][1] = 1;
		phone[11][0] = 4;
		phone[11][1] = 3;
		
		int leftNumber = 10;
		int rightNumber = 11;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				leftNumber = numbers[i];
				sb.append("L");
				continue;
			}
			else if( numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				rightNumber = numbers[i];
				sb.append("R");
				continue;
			}
			
			int left = distance(numbers[i], leftNumber, phone);
			int right = distance(numbers[i], rightNumber, phone);
			if(left == right) {
				if(hand.equals("left")) {
					leftNumber = numbers[i];
					sb.append("L");
				}
				else {
					rightNumber = numbers[i];
					sb.append("R");
				}
			}
			else if(left < right) {
				leftNumber = numbers[i];
				sb.append("L");
			}
			else {
				rightNumber = numbers[i];
				sb.append("R");
			}
		}

		String answer = sb.toString();
		return answer;
	}

	private int distance(int number, int prevNumber, int[][] phone) {
		return Math.abs(phone[number][0] - phone[prevNumber][0]) +Math.abs(phone[number][1]- phone[prevNumber][1]);
	}

}
