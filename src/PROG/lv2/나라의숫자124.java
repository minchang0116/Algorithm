package PROG.lv2;


public class 나라의숫자124 {
	public static void main(String[] args) {
		나라의숫자124 service = new 나라의숫자124();
		System.out.println(service.solution(10));
	}
    public String solution(int n) {
        String answer = "";
        int number[] = {4,1,2};
        StringBuilder sb = new StringBuilder();
        while(n != 0) {
        	if(n%3 == 0) // 3의 배수이면
        	{
        		sb.insert(0, number[0]);
        		n = n/3 -1;
        	}
        	else{
        		sb.insert(0, number[n%3]);
        		n = n/3;
        	}
        }
        answer = sb.toString();
        return answer;
    }
}
