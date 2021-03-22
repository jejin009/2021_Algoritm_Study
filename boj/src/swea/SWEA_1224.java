package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1224 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> back = new Stack<Character>();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int testcase = 1;testcase <= 10; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			
			StringBuilder sb = new StringBuilder();
			String str = br.readLine();
			
			for(int i = 0; i < n; i++) {
				char next = str.charAt(i);
				
				if(next == '+') {
					while(!back.isEmpty()) {
						if(back.peek() == '(') break;
						else sb.append(back.pop());
					}
					back.push(next);
				}
				else if(next == '*') {
					while(!back.isEmpty()) {
						if( back.peek() == '(' || back.peek() == '+') break;
						else sb.append(back.pop());
					}
					back.push(next);
				}
				else if(next == ')') {
					while(!back.isEmpty()) {
						char temp = back.pop();
						if(temp == '(') break;
						else sb.append(temp);
					}
				}
				else back.push(next);
				
			}
			while(!back.isEmpty()) 
				sb.append(back.pop());
			
			String backStr = sb.toString();
			
			for(int j = 0; j < backStr.length(); j++) {
				char next = backStr.charAt(j);
				if(next == '+') stack.push(stack.pop() + stack.pop());
				else if(next == '*') stack.push(stack.pop() * stack.pop());
				else stack.push(next - '0');
			}
			
			System.out.println("#" + testcase + " " + stack.pop());
		}
		
	}
}
