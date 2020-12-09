package SW.모의역량;
public class 기능개발 {
	public static void main(String[] args) {
		int temp[] = solution(new int[] {93, 30, 55}, new int[] {1, 30, 5});
		System.out.println("hi");
		for(int i=0; i<temp.length; i++) {
			System.out.print(temp[i]+" ");
		}
	}
    public static int[] solution(int[] progresses, int[] speeds) {
    	int curIdx = 0;
    	int[] temp = new int[100];
    	int answerIdx = 0;
    	while(true) {
    		if(progresses[curIdx] >= 100) {
    			for(int i=curIdx; i<progresses.length; i++) {
    				if(progresses[i] >= 100) {
    					temp[answerIdx]++;
    					curIdx = i+1;
    				}
    				else {
    					answerIdx++;
    					break;
    				}
    			}
    		}
    		
    		if(curIdx == progresses.length) {
    			break;
    		}
    		
    		for(int i=curIdx; i<progresses.length; i++) {
    			progresses[i] += speeds[i];
    		}
    	}
    	
    	int[] answer = new int[answerIdx+1];
    	for(int i=0; i<answerIdx+1; i++) {
    		answer[i] = temp[i];
    	}
        return answer;
    }
}
