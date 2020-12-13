package PROG.lv2;

public class 큰수만들기 {
	public static void main(String[] args) {
		큰수만들기 service = new 큰수만들기();

		System.out.println(service.solution("77413258", 2));
	}
	public String solution(String number, int k) {
		
		char arr[] = new char[number.length()-k];
		// 뒤에 값들을 미리 넣어줌
		for(int i=0; i<arr.length; i++) {
			arr[i] = number.charAt(number.length()-(number.length()-k)+i);
		}
		
		int idx =0;
		int cur=0;
		while(true) {
			boolean flag = false;
			char max = 0;
			for(int i=cur; i<number.length() - (arr.length-idx); i++) { // 전체 길이에서 k만큼 뺀 인덱스 까지 최댓값을 찾음
				if(max < number.charAt(i)) {
					max = number.charAt(i);
					cur = i+1;
					flag = true;
				}
			}
			
			if(flag == false) {
				break;
			}
			if(arr[idx] <= max) {
				arr[idx++]  = max; 
			}
			if(idx == arr.length) {
				break;
			}
		}
		String answer = new String(arr);
		return answer;
	}
}
