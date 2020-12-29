package PROG.lv3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
	public static void main(String[] args) {
		이중우선순위큐 service = new 이중우선순위큐();
		System.out.println(Arrays.toString(service.solution(new String[] {"I 16","D 1"})));
		System.out.println(Arrays.toString(service.solution(new String[] {"I 7","I 5","I -5","D -1"})));
	}
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        int insertCnt = 0;
        int deleteCnt = 0;
        for(int i=0; i<operations.length; i++) {
        	String operation[] = operations[i].split(" ");
        	if(operation[0].equals("I")) {
        		minHeap.offer(Integer.parseInt(operation[1]));
        		maxHeap.offer(Integer.parseInt(operation[1]));
        		insertCnt++;
        	}
        	else if(!maxHeap.isEmpty()){
        		if(operation[1].equals("1")) {
        			maxHeap.poll();
        		}else {
        			minHeap.poll();
        		}
        		deleteCnt++;
        	}
        	
        	if(insertCnt == deleteCnt) { // 큐가 비었다면 클리어
        		minHeap.clear();
        		maxHeap.clear();
        	}
        }
        
        int[] answer = new int[2];
        if(!maxHeap.isEmpty()) {
        	answer[0] = maxHeap.peek();
        	answer[1] = minHeap.peek();
        }
        return answer;
    }
}
