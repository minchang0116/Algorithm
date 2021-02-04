package PROG.lv2;

public class 방금그곡 {
	public static void main(String[] args) {
		방금그곡 service = new 방금그곡();
//		System.out.println(service.solution("ABCDEFG", new String[] {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
		System.out.println(service.solution("A#BC#D#EF#G", new String[] {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
//		System.out.println(service.solution("CC#BCC#BCC#BCC#B", new String[] {"23:00,23:59,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
//		System.out.println(service.solution("ABC", new String[] {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
	}
    public String solution(String m, String[] musicinfos) {
    	String answer = "(None)";
    	int maxMinuate= 0;
    	m = m.replace("C#", "c").replace("D#", "d").replace("E#", "e").replace("F#", "f").replace("G#","g").replace("A#","a");
        for(int i=0; i<musicinfos.length; i++) {
        	String arr[] = musicinfos[i].split(",");
        	String startTime[] = arr[0].split(":");
        	String endTime[] = arr[1].split(":");
        	int hour = Integer.parseInt(endTime[0]) - Integer.parseInt(startTime[0]);
        	int minuate = hour * 60 + Integer.parseInt(endTime[1]) - Integer.parseInt(startTime[1]);
        	String title = arr[2];
        	String melody = arr[3].replace("C#", "c").replace("D#", "d").replace("E#", "e").replace("F#", "f").replace("G#","g").replace("A#","a");
        	char temp[] = new char[minuate];
        	for(int j=0; j<minuate; j++) {
        		temp[j] = melody.charAt(j%melody.length());
        	}
        	if(String.valueOf(temp).contains(m)) {
        		if(maxMinuate < minuate) {
        			maxMinuate = minuate;
        			answer = title;
        		}
        	}
        }
        return answer;
    }
}
