package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1914_하노이탑 {

	static int N;
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N <= 20) {
			hanoi(1,2,3, N);
			System.out.println(cnt);
			System.out.println(sb.toString());
		}
	}
	private static void hanoi(int start, int temp, int end, int n) {

		if(n ==0)return;
		hanoi(start,end,temp, n - 1);
		sb.append(start).append(" ").append(end).append("\n");
		cnt++;
		hanoi(temp, start, end, n - 1);
	}
}
