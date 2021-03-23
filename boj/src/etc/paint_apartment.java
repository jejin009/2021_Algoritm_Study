package etc;

public class paint_apartment {

	
	public static void main(String[] args) {
		int dp[] = new int[8];
		
		dp[0] = 2;
		dp[1] = 3;
		
		for(int i = 2; i < 8; i++)
			dp[i] = dp[i-1] + dp[i-2];
		
		System.out.println(dp[7]);
	}
}
