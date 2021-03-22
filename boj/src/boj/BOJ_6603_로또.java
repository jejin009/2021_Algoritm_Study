package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {

	static int[] numbers;
	static boolean[] visited;
	static int[] selectedNumbers = new int[6];
	static int k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			k = Integer.parseInt(st.nextToken());
			if (k == 0)
				break;

			numbers = new int[k];
			visited = new boolean[k];
			for (int i = 0; i < k; i++)
				numbers[i] = Integer.parseInt(st.nextToken());

			lotto(0, 0);
			System.out.println();
		}
	}

	private static void lotto(int toSelect, int start) {
		if(toSelect == 6) {
			for(int i = 0; i < 6; i++) {
				System.out.print(selectedNumbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < k; i++) {
			selectedNumbers[toSelect] = numbers[i];
			lotto(toSelect+1, i+1);
		}
	}
}
