package etc;

public class stick {

	public static void main(String[] args) {
		int dp[] = new int[6];
		
		dp[0] = 2;
		dp[1] = 5;
		
		for(int i = 2; i < 6; i++) {
			dp[i] = dp[i-1]*2 + dp[i-2];
		}
			
		
		System.out.println(dp[5]);
	}
}
