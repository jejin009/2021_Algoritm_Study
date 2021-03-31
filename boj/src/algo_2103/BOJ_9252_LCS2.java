package algo_2103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9252_LCS2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		StringBuilder sb = new StringBuilder();
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
		
		int r = str1.length();
		int c = str2.length();
		max = dp[r][c];
		char str[] = new char[max];
		int n = max-1;
		
		for(int i = 0; i < 7; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		while(n>=0) {
			if(dp[r][c] == dp[r][c-1] ) {
				c--;
			}else if(dp[r][c] == dp[r-1][c]) {
				r--;				
			}else if(dp[r][c] == dp[r-1][c-1]+1) {
				str[n--] = str1.charAt(r-1);
				r--;c--;
			}
		}
		System.out.println(dp[str1.length()][str2.length()]);
		if(max!=0)
			System.out.println(str);
	}
}
