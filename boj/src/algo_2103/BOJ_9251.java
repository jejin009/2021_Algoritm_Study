package algo_2103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int[][] dp = new int[str1.length()+1][str2.length()+1];
		int max = 0;
		for (int i = 1; i <= str1.length(); i++) {
			char a = str1.charAt(i-1);
			for (int j = 1; j <= str2.length(); j++) {
				char b = str2.charAt(j-1);
				if(a != b) {
					int temp = Math.max(dp[i][j-1], dp[i-1][j]);
					dp[i][j] = temp;
				}
				else{
					dp[i][j] = dp[i-1][j-1]+1;
				}
			}
		}		
		System.out.println(dp[str1.length()][str2.length()]);
	}
}
