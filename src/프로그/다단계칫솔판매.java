package 프로그;

import java.util.Arrays;
import java.util.HashMap;

public class 다단계칫솔판매 {
	public static void main(String[] args) {
		다단계칫솔판매 service = new 다단계칫솔판매();
		System.out.println(Arrays.toString(service.solution(
				new String[] {"john", "mary", "edward", "sam", "emily", "jaimie", "tod","young"},
				new String[] {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
				new String[] {"young", "john", "tod", "emily", "mary"},
				new int[] {12, 4, 2, 5, 10})));
	}
	
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Integer> hs = new HashMap<>();
        Node person[] = new Node[enroll.length+1];
        for(int i=0; i<enroll.length+1; i++){
            person[i] = new Node();    
        } 
        enroll(enroll, hs);
        union(enroll, referral, hs, person);        
        calculate(seller, amount, hs, person);
        int[] answer = new int[enroll.length];
        for(int i=0; i<enroll.length; i++){
            answer[i] = person[i+1].result;
        }
        return answer;
    }
    
    private void calculate(String[] seller, int[] amount, HashMap<String,Integer> hs ,Node[] person){
        int sellerSize = seller.length;
        for(int i=0; i<sellerSize; i++){
        	int value = 100*amount[i];
            int remain = value * 10 / 100;
            if(remain > 0){
                 person[hs.get(seller[i])].result += (value - remain);
                 dfs(person[hs.get(seller[i])].parent, remain);
            }
            else{
                 person[hs.get(seller[i])].result += value;            
            }
        }
    }
    
    private void dfs(Node cur, int value){
    	if(cur.parent == null) {
    		return;
    	}
        int remain = value * 10 / 100;
        if(remain > 0) {
            cur.result += value - remain;
            dfs(cur.parent, remain);
        }
        else{
            cur.result += value;
        }
    }
    
    private void union(String[] enroll, String[] referral, HashMap<String,Integer> hs, Node[] person){
        int personSize = enroll.length; 
        for(int i=0; i<personSize; i++){
            if(referral[i].equals("-")){
                person[hs.get(enroll[i])].parent = person[0];
            }
            else{
                person[hs.get(enroll[i])].parent = person[hs.get(referral[i])];
            }
        }
    }
    
    private void enroll(String[] enroll, HashMap<String,Integer> hs){
        hs.put("center", 0);
        int idx = 1;
        for(String name : enroll){
            hs.put(name, idx++);
        }
    }
    
    class Node{
        Node parent;
        int result;
        int amount;
    }
}
