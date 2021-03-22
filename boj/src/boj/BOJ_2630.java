package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {

	static int papers[][];
	static int blue;
	static int white;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		papers = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j ++) 
				papers[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int x = cut(0,0,n);
		
		System.out.println(white + "\n" +blue);
	}
	private static int cut(int x, int y,int n) {
		if(n == 1) {
			return papers[y][x];
		}
		
		int a = cut(x, y, n/2);
		int b = cut(x, y + n/2, n/2);
		int c = cut(x+n/2, y, n/2);
		int d = cut(x+n/2, y+n/2, n/2);
		int sum = a+b+c+d;
		
		if(sum == 0) return 0;
		else if(sum == 4) return 1;
		
		else {
			if(a == 0) white++;
			else if(a == 1) blue++;
			if(b == 0) white++;
			else if(b == 1) blue++;
			if(c == 0) white++;
			else if(c == 1) blue++;
			if(d == 0) white++;
			else if(d == 1) blue++;
			
			return 5;
		}
	}
}
