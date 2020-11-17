package SW.모의역량;

public class 카펫 {
	public static void main(String[] args) {
		System.out.println(solution(10,2));
	}
	
    public static int[] solution(int brown, int yellow) {
    	int sum = brown + yellow;
    	for(int i=1; i<sum/2; i++) {
    		if(sum%i == 0) { //나누어 떨어지면
    			int a = sum/i; // 가로길이
    			int b = i; // 세로길이
    			if((a-2)*(b-2) == yellow){
    				int[] answer = {a, b};
    		        return answer;
    			}
    		}
    	}
    	return new int[] {-1, -1};
    }
}
