package PROG.lv1;

public class n진법뒤집기 {
	public static void main(String[] args) {
		n진법뒤집기 service = new n진법뒤집기();
		service.solution(45);
	}
    public int solution(int n) {
        StringBuilder number = new StringBuilder();
        
        while(true) {
        	if(n/3!=0) {
        		number.append(n%3);
        		n/=3;
        	}
        	else {
        		number.append(n%3);
        		break;
        	}
        }
        
        int answer = 0;
        int powIdx = 0;
        for(int i=number.length()-1; i>=0; i--) {
        	answer += (number.charAt(i) - '0') * Math.pow(3, powIdx++);
        }
        
        return answer;
    }
	
	
}

