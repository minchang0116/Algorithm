package PROG.lv2;

import java.util.Arrays;
import java.util.Comparator;

public class 전화번호목록 {
	public static void main(String[] args) {
		전화번호목록 service = new 전화번호목록();
		System.out.println(service.solution(new String[] {"119", "97674223", "1195524421"}));
	}
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 일단 정렬을 해, 문자열 길이순으로 하고 길이가 같으면 문자순서로 오름차순
        Arrays.sort(phone_book, new Comparator<String>() {
        	public int compare(String o1, String o2) {
        		if(o1.length() != o2.length()) {
        			return Integer.compare(o1.length(), o2.length());
        		}
        		return o1.compareTo(o2);
        	};
        }
        );
        for(int i=0; i<phone_book.length; i++) {
        	for(int j=i+1; j<phone_book.length; j++) {
        		String temp= phone_book[j].substring(0, phone_book[i].length());
        		if(phone_book[i].equals(temp)) {
        			return false;
        		}
        	}
        }
        return answer;
    }
}
