package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_15500_이상한하노이 {

	static Stack<Integer> first = new Stack<Integer>();
	static Stack<Integer> second = new Stack<Integer>();
	static Stack<Integer> third = new Stack<Integer>();
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		int next = N;
		int cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			first.push(Integer.parseInt(st.nextToken()));
		}

		while (third.size() != N) {
			if (first.contains(next)) {
				while(true) {
					cnt++;
					if(first.peek() == next) {
						sb.append("1 3\n");
						third.push(first.pop());
						break;
					}
					
					second.push(first.pop());
					sb.append("1 2\n");
					
				}
			}
			else if (second.contains(next)) {
				while(true) {
					cnt++;
					if(second.peek() == next) {
						third.push(second.pop());
						sb.append("2 3\n");
						break;
					}
					first.push(second.pop());
					sb.append("2 1\n");
				}
			}
			
			next--;
		}
		System.out.println(cnt);
		System.out.println(sb.toString());
	}
	
}
