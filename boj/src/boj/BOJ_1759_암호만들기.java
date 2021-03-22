package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1759_암호만들기 {

	static char[] numbers;
	static boolean[] visited;
	static char[] selectedNumbers;
	static StringBuilder sb;
	static int L;
	static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		numbers = new char[C];
		visited = new boolean[C];
		selectedNumbers = new char[L];

		int i = 0;
		st = new StringTokenizer(in.readLine());
		while (st.hasMoreTokens()) {
			numbers[i++] = st.nextToken().charAt(0);
		}
		Arrays.sort(numbers);

		makeCode(0);
	}

	private static void makeCode(int toSelect) {
		if (toSelect == L) {
			sb = new StringBuilder();
			boolean flag1 = false;
			int flag2 = 0;

			for (int i = 0; i < L; i++) {
				if (selectedNumbers[i] == 'a' || selectedNumbers[i] == 'i' || selectedNumbers[i] == 'e'|| selectedNumbers[i] == 'o' || selectedNumbers[i] == 'u')
					flag1 = true;
				else
					flag2++;
				sb.append(selectedNumbers[i]);
			}
			
			if (flag1 && flag2 > 1) {
				System.out.print(sb.toString());
				System.out.println();
			}
			return;
		}

		for (int i = 0; i < C; i++) {
			if (!visited[i]) {
				if (toSelect == 0 || (toSelect > 0 && selectedNumbers[toSelect - 1] < numbers[i])) {
					selectedNumbers[toSelect] = numbers[i];
					visited[i] = true;
					makeCode(toSelect + 1);
					visited[i] = false;
				}
			}
		}
	}
}
