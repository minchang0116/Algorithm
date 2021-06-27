package PROG.lv1;

public class 문자열내p와y의개수 {
	public static void main(String[] args) {
		문자열내p와y의개수 service = new 문자열내p와y의개수();
		service.solution("pPoooyY");
	}
    boolean solution(String s) {
        s = s.toLowerCase();
        int pCnt =0;
        int yCnt =0;
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i) == 'p') {
        		pCnt++;
        	}
        	else if(s.charAt(i) == 'y') {
        		yCnt++;
        	}
        }
        
        if(pCnt == yCnt) {
        	return true;
        }
        else {
        	return false;
        }
    }
}
