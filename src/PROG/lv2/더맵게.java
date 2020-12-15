package PROG.lv2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 더맵게 {
	public static void main(String[] args) {
		더맵게 service = new 더맵게();
		System.out.println(service.solution(new int[] {1,2,3,9,10,12}, 7));
	}
	
	// k는 10억 scoville은 100만
    public int solution(int[] scoville, int K) {
    	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
    		@Override
    		public int compare(Integer o1, Integer o2) {
    			return Integer.compare(o1, o2);
    		}
		});
    	for(int i=0; i<scoville.length; i++) {
    		pq.offer(scoville[i]);
    	}
    	
    	int answer = 0;
    	while(true) {
    		int a = pq.poll();
    		if(a >= K) {
    			break;
    		}
    		if(pq.isEmpty()) {
    			answer = -1;
    			break;
    		}
    		answer++;
    		int b = pq.poll();
    		int c = a + b*2;
    		pq.offer(c);
    	}
        return answer;
    }
}
