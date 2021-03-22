package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1918_후위표기식 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '*' || c == '/') {
				while (!st.isEmpty() && (st.peek() != '+' && st.peek() != '-' && st.peek() != '('))
					sb.append(st.pop());
				st.push(c);
			} else if (c == '+' || c == '-') {
				while (!st.isEmpty() && st.peek() != '(')
					sb.append(st.pop());
				st.push(c);
			} else if (c == ')') {
				while (!st.isEmpty()) {
					char next = st.pop();
					if (next == '(')
						break;
					sb.append(next);
				}
			} else
				st.push(c);
		}

		while (!st.isEmpty()) {
			sb.append(st.pop());
		}

		System.out.println(sb.toString());
	}
}
