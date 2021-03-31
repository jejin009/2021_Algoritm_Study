package algo_2103;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11025_요세푸스문제3 {
	static int N, K;
	static int[] dp;
	static Queue<Integer> circle = new LinkedList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		dp = new int[N + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 1;
		dp[4] = 1;
		for(int i = 2; i <= N; i++) {
			int val = dp[i-1] + K;
			while(i < val) val -= i;
			dp[i] = val;
		}
		System.out.println(dp[N]);
	}
}
