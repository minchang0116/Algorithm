package PROG.lv2;

public class 주식가격 {
	public static void main(String[] args) {
		주식가격 service = new 주식가격();
		System.out.println(service.solution(new int[] {1,2,3,2,3}));
	}
	
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length; i++) {
        	for(int j=i+1; j<prices.length; j++) {
        		answer[i] = j-i;
        		if(prices[i] > prices[j]) {
        			break;
        		}
        	}
        }
        return answer;
    }
}
