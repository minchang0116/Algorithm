package 프로그.그리디;

public class 체육복_1 {
	public static void main(String[] args) {
		System.out.println(solution(30,new int[] {3,4}, new int[] {4,2}));
	}
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        boolean lostCheck[] = new boolean[n+2];
        for(int i=0; i<lost.length; i++) {
        	lostCheck[lost[i]] = true;
        }
        
        for(int i=0; i<reserve.length; i++) {
        	if(lostCheck[reserve[i]] == true) {
        		lostCheck[reserve[i]] = false;
        		reserve[i] = -1;
        		answer++;
        	}
        }
        
        for(int i=0; i<reserve.length; i++) {
        	if(reserve[i] == -1) continue;
        	if(lostCheck[reserve[i]-1] == true) {
        		lostCheck[reserve[i]-1] = false;
        		answer++;
        	}
        	else if(lostCheck[reserve[i]+1] == true) {
        		lostCheck[reserve[i]+1] = false;
        		answer++;
        	}
        }
        return answer;
    }
}
