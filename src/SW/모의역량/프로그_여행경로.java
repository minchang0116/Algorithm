package SW.모의역량;

import java.util.Arrays;

public class 프로그_여행경로 {
	public static void main(String[] args) {
		String temp[] = solution(new String[][] {{"ICN","JFK"}, {"HND", "IAD"}, {"JFK","HND"}});
		for(int i=0; i<4; i++) {
			System.out.println(temp[i]);
		}
	}
	
    public static String[] solution(String[][] tickets) {
    	Ticket tempTickets[] = new Ticket[tickets.length];
    	for(int i=0; i<tickets.length; i++) {
    		tempTickets[i] = new Ticket(tickets[i][0], tickets[i][1]);
    	}
    	Arrays.sort(tempTickets);
    	checked = new int[tempTickets.length];
    	for(int i=0; i<checked.length; i++) {
    		if(tempTickets[i].a.equals("ICN")) {
    			checked[i] = 1;
    			if(dfs(tempTickets, i,2)) break;
    			checked[i] = 0;
    		}
    	}
        String[] answer = new String[checked.length+1];
        for(int i=0; i<checked.length; i++) {
        	if(checked[i]-1==0) {
        		answer[checked[i]-1] = tempTickets[i].a;
        		answer[checked[i]] = tempTickets[i].b;
        	}
        	else {
        		answer[checked[i]] = tempTickets[i].b;
        	}
        }
        return answer;
    }
    
    static int checked[];
    static boolean flag;
    private static boolean dfs(Ticket[] tempTickets, int preIdx ,int cnt) {
    	if(cnt == checked.length+1) { // 티켓의 수 +1 (1부터 시작했으니깐)
    		return true;
    	}
		for(int i=0; i<checked.length; i++) {
			if(checked[i] == 0) { // 아직 안쓴 티켓
				if(tempTickets[preIdx].b.equals(tempTickets[i].a)) { // 이전의 도착지와 현재의 출발지
					checked[i] = cnt;
					if(dfs(tempTickets, i,cnt+1)) return true;
					checked[i] = 0;
				}
			}
		}
		return false;
	}

	private static class Ticket implements Comparable<Ticket>{
    	String a;
    	String b;

    	public Ticket(String a, String b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
    	public int compareTo(Ticket o) {
    		if(a.equals(o.a)) {
    			return b.compareTo(o.b);
    		}
    		return a.compareTo(o.a);
    	}
    }
}

