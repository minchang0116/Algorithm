package PROG.lv2;

import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public String[] solution(String[] record) {
        HashMap<String, String> hs = new HashMap<>();
        ArrayList<String[]> temp = new ArrayList<>();
        
        for(int i=0; i<record.length; i++){
            String cur[] = record[i].split(" ");
            if(cur[0].equals("Enter")){
                hs.put(cur[1], cur[2]);
                temp.add(new String[]{cur[1], "님이 들어왔습니다."});
            }
            else if(cur[0].equals("Leave")){
                temp.add(new String[]{cur[1], "님이 나갔습니다."});
            }
            else if(cur[0].equals("Change")){
                hs.put(cur[1], cur[2]);
            }
        }
        String[] answer = new String[temp.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = hs.get(temp.get(i)[0])+temp.get(i)[1];
        }    
    
        return answer;
    }
}
