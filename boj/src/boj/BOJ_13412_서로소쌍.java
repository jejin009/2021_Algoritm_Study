package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13412_서로소쌍 {

	static int[] set2;
	static int[] set1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			int number = Integer.parseInt(br.readLine());
			int pivot = number / 2 + 1;
			int cnt = 0;

			for (int i = 2; i < pivot; i++) {
				if (number % i == 0) {
					int n = number / i;
					set1 = new int[pivot];
					set2 = new int[pivot];
					find(i,set1);
					find(n,set2);
					if(solution(pivot)) cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

	private static boolean solution(int pivot) {
		int answer = 1;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < pivot; i++) {
			if(set1[i] != 0 && set2[i] != 0 ) {
				min = Math.min(set1[i], set2[i]);
				answer *= (min *i);
			}
		}
		if(answer == 1)return true;
		else return false;
	}

	private static void find(int num, int[] set) {
		int cnt = 0;
		for (int i = 2; i < num / 2; i++) {
			if (num % i == 0) {
				find(num/i, set);
				find(i, set);
				cnt++;
			}
		}
		if(cnt == 0) {
			set[num]++;
			return;
		}
	}
}
