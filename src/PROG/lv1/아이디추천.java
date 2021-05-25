package PROG.lv1;

public class 아이디추천 {
	public static void main(String[] args) {
		아이디추천 service = new 아이디추천();
		System.out.println(service.solution("...!@BaT#*..y.a."));
		System.out.println(service.solution("=.="));
	}

	/*
	 * 아이디의 길이는 3자 이상 15자 이하여야 합니다. 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수
	 * 있습니다. 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
	 * 
	 */
	public String solution(String new_id) {
		// 1단계
		String answer = new_id.toLowerCase();
		// 2단계 기본 메타 문자
		answer = answer.replaceAll("[^0-9a-z-_.]", "");
		// 3단계 수량자
		answer = answer.replaceAll("[.]{2,}", ".");
		// 4단계
		answer = answer.replaceAll("^[.]|[.]$", "");
		// 5단계
		if (answer.isEmpty()) {
			answer = "a";
		}

		// 6단계
		if (answer.length() >= 16) {
			answer = answer.substring(0, 15);
			answer = answer.replaceAll("[.]$", "");
		}

//		// 7단계
//		if (answer.length() <= 2) {  
//            while (answer.length() < 3) {
//            	answer += answer.charAt(answer.length()-1);
//            }
//        }
		
		// 7단계
		if (answer.length() <= 2) {  
			answer = String.format("%-3s", answer).replace(' ', answer.charAt(answer.length()-1));
		}
		return answer;
	}
}

