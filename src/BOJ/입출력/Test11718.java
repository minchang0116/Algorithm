package BOJ.입출력;

import java.util.ArrayList;
import java.util.Scanner;

public class Test11718 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> inputs = new ArrayList<>();
	    
	    while (sc.hasNextLine()) {
	        String input = sc.nextLine();
	        if (input == null || input.isEmpty()) {
	            break;
	        }
	        inputs.add(input);
	    }
	    sc.close();

	    for (int i = 0; i < inputs.size(); ++i) {
	        System.out.println(inputs.get(i));
	    }
		
	}
}
