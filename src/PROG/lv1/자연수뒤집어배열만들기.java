package PROG.lv1;

public class 자연수뒤집어배열만들기 {
	public static void main(String[] args) {
		자연수뒤집어배열만들기 service = new 자연수뒤집어배열만들기();
		service.solution(12345);
	}
	
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        sb.reverse();
        int[] answer = new int[sb.length()];
        for(int i=0; i<sb.length(); i++) {
        	answer[i] = sb.charAt(i) - '0';
        }
        return answer;
    }
}
