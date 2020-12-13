package PROG.lv2;

public class 조이스틱 {
	public static void main(String[] args) {
		조이스틱 service = new 조이스틱();
		service.solution("JEROEN");
	}
    public int solution(String name) {
    	boolean check[] = new boolean[name.length()];
    	int answer = 0;
    	// 각 위치에서의 조이스틱 조작값
    	for(int i=0; i<name.length(); i++) {
    		if(name.charAt(i) == 'A') check[i] = true;
    		int up = name.charAt(i) - 'A';
    		int down = 'Z' - name.charAt(i) + 1;
    		answer += Math.min(up, down);
    	}
    	
    	// "JAAN" check[] = { false, true, true, false}
    	
    	solve(); // 모든 위치에서 오른쪽으로 가는것과 왼쪽으로 가는 것을 비교해서 가장 작은값을 뽑아낸다.
    	
    	
        return answer;
    }
    
    // 'A가 아닐때까지 오른쪽으로 가고, 거기서 다시 왼쪽으로 가는 경우
    // 이렇게 쭉 오른쪽으로 가봄
    
    // 'A'가 아닐때까지 왼쪽으로 가고, 거기서 다시 오른쪽으로 가는경우
    // 이렇게 쭉 왼쪽으로 가봄 
	private void solve(int cur, String name) {
		int cnt = cur;
		for(int i=cur; i<name.length(); i++) {
			
		}
	}
}
