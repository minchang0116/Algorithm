package PROG.lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

//10:03 ~ 10:57
//나두
public class 베스트앨범 {
	static HashMap<String, Integer> map;
	static int count =0;
	public static void main(String[] args) {
		
		map = new HashMap<String, Integer>();
		String[] s = {"classic", "pop", "classic", "classic", "pop"};
		int[] p = { 500, 600, 150, 800, 2500 };
		int answer[] = solution(s, p);
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	
    public static int[] solution(String[] genres, int[] plays) {
    	for(int i=0; i<genres.length; i++) {
    		if(map.containsKey(genres[i]) == true) { // 있으면 누적
    			map.put(genres[i], map.get(genres[i]) + plays[i]);
    		}
    		else {
    			map.put(genres[i], plays[i]);
    		}
    	}
		// Map.Entry 리스트 작성
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());

		// 비교함수 Comparator를 사용하여 내림 차순으로 정렬
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			// compare로 값을 비교
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2)
			{
				// 내림 차순으로 정렬
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
		
		int[] answer = new int [map.size()*2];
		int answerIdx = 0;
		// 결과 출력
		boolean checked[] = new boolean[plays.length];
		for(Entry<String, Integer> entry : list_entries) {
			String temp = entry.getKey();
			int cnt =0;
			while(true) {
				int max =0;
				int idx =-1;
				for(int i=0; i<genres.length; i++) {
					if(temp.equals(genres[i]) == true && checked[i] == false) {
						if(max < plays[i]) {
							max = plays[i];
							idx=i;
						}
					}
				}
				
				if(idx == -1) {
					break;
				}
				else {
					answer[answerIdx++] = idx;
					checked[idx] = true;
					cnt++;
					count++;
				}
				
				if(cnt == 2) {
					break;
				}
			}
		}
		int temp[] = new int[count];
		for(int i=0; i<count; i++) {
			temp[i] = answer[i];
		}
        return temp;
    }
}
