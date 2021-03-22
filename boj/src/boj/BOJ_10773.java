package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st = new Stack<Integer>();
		int k = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < k; i++) {
			int number = Integer.parseInt(br.readLine());
			if(number == 0) st.pop();
			else st.push(number);
		}
		
		int sum = 0;
		while(!st.isEmpty())
			sum += st.pop();
		
		System.out.println(sum);
	}
}
