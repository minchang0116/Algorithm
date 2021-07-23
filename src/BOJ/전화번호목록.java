package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int testCase=1; testCase<=t; testCase++) {
			int n = Integer.parseInt(br.readLine());
			Trie trie = new Trie();
			boolean flag = false;
			for(int i=0; i<n; i++) {
				if(!trie.insert(br.readLine().replace(" ",""))) {
					flag = true;
				}
			}
			sb.append(flag==true?"NO\n":"YES\n");
		}
		System.out.println(sb.toString());
	}
	static class TrieNode {
        Map<Character, TrieNode> childNodes = new HashMap<>();
        boolean isLastChar;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        boolean insert(String word) {
            TrieNode thisNode = root;
            for(int i = 0; i < word.length(); i++) {
                char n = word.charAt(i);
                if(thisNode.childNodes.get(n) == null) {
                    thisNode.childNodes.put(n, new TrieNode());
                }
                thisNode = thisNode.childNodes.get(n);
                if(thisNode.isLastChar == true) return false;
            }
            if(thisNode.childNodes.size() != 0) return false;
            thisNode.isLastChar = true;
            return true;
        }
    }
}


