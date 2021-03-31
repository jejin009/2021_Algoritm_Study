package algo_2103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12026_BOJ거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int blocks[] = new int[N];
		int dp[] = new int[N];
		for(int i = 0; i < N; i++) {
			if(str.charAt(i) == 'B') blocks[i] = 0;
			else if(str.charAt(i) == 'O') blocks[i] = 1;
			else blocks[i] = 2;
		}
		for(int i = 1; i < N; i++) {
			dp[i] = -1;
			int min = Integer.MAX_VALUE;
			for(int j = i-1; j>=0; j--) {
				if(dp[j] != -1 && (blocks[i]-1 == blocks[j] || blocks[i]+2 == blocks[j])) {
					int energy = (int)Math.pow(i-j, 2);
					if(energy + dp[j] < min) {
						min = energy+dp[j];
						dp[i] = energy + dp[j];
					}
				}
			}
		}
		System.out.println(dp[N-1]);
	}
}
