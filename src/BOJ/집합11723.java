package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 집합11723 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int bitset = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String instruction[] = br.readLine().split(" ");
			if(instruction[0].equals("add")) {
				bitset = bitset | (1 << Integer.parseInt(instruction[1]));
			}
			else if(instruction[0].equals("remove")) {
				bitset = bitset & ~(1 << Integer.parseInt(instruction[1]));
			}
			else if(instruction[0].equals("check")) {
				sb.append((bitset & (1 << Integer.parseInt(instruction[1]))) == 0 
						? "0\n" : "1\n");					
			}
			else if(instruction[0].equals("toggle")) {
				bitset = bitset ^ (1 << Integer.parseInt(instruction[1]));
			}
			else if(instruction[0].equals("all")) {
				bitset = bitset | ~0;
			}
			else if(instruction[0].equals("empty")) {
				bitset = 0;
			}
		}
		System.out.println(sb.toString());
	}
}
