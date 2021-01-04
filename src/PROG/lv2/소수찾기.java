package PROG.lv2;

import java.util.HashSet;

public class 소수찾기 {
	public static void main(String[] args) {
		소수찾기 service = new 소수찾기();
		System.out.println(service.solution("011"));
	}

	int answer = 0;
	HashSet<Integer> hs = new HashSet<Integer>();
    
	public int solution(String numbers) {
    	char arr[] = numbers.toCharArray();
    	char output[] = new char[numbers.length()];
    	boolean select[] = new boolean[arr.length];
    	permutation(arr, output, select, 0);
        return this.answer;
    }
    
	private void permutation(char[] arr, char[] output, boolean[] select, int cnt) {
		if(cnt >= 1) {
			if(isPrime(output, cnt)) {
				this.answer++;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			if(select[i] == true) continue;
			select[i] = true;
			output[cnt] = arr[i]; 
			permutation(arr, output, select, cnt+1);
			select[i] = false;
		}
	}
	
	private boolean isPrime(char[] output, int cnt) {
		if(output[0] == '0') return false;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<cnt; i++) {
			sb.append(output[i]);
		}
		int temp = Integer.parseInt(sb.toString());
		if(hs.contains(temp) || temp == 1) return false;
		hs.add(temp);
		
		for(int i=2; i*i<temp; i++) {
			if(temp%i == 0) return false;
		}
		return true;
	}
}
