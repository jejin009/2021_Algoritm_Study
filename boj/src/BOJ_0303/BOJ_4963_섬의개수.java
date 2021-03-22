package BOJ_0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {

	static int di[] = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
	static int dj[] = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
	static int[][] island;
	static int w, h, count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		int count = 2;
		
		int island[][] = new int[h][w];
		for(int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j++) {
				int land = Integer.parseInt(st.nextToken());
				island[i][j] = land;
			}
		}
		
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				if(island[i][j] == 1)
					isIsland(i,j,Integer.MAX_VALUE);
			}
		}
		
	}
	private static void isIsland(int i, int j, int min) {
		for(int k = 0; k < 8; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni >= 0 && ni < w && nj >= 0 && nj < h) {
				if(island[ni][nj] != 0) {
//					min = 
//					break;
				}
			}
		}
	}
}
