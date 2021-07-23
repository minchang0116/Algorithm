package PROG.lv2;

public class 멀쩡한사각형 {

	public static void main(String[] args) {
		멀쩡한사각형 service = new 멀쩡한사각형();
		System.out.println(service.solution(8, 12));
	}

    public long solution(int w,int h) {
        long answer = 0;
        for(int i = 0; i < w; i++) 
            answer += (Long.valueOf(h) * i) / Long.valueOf(w);
         
        return answer * 2;
    }
}
