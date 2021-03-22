package BOJ_0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16946_벽뿌수고이동하기4 {

	static int N,M, count;
	static int[][] map;
	static int[][] answer;
	static boolean[][] visit;
	static int di[] = {-1, 0, 1, 0};
	static int dj[] = {0, 1, 0, -1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		answer = new int[N][M];
		visit = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					count = 0;
					initVisit();
					countAvailable(i,j);
					map[i][j] = count;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				sb.append(map[i][j] % 10);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void initVisit() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visit[i][j] = false;
			}
		}
	}

	private static void countAvailable(int i, int j) {
		count++;
		for(int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if(ni >= 0 && ni < N && nj >= 0 && nj < M) {
				if(map[ni][nj] == 0 &&!visit[ni][nj]) {
					visit[ni][nj] = true;
					countAvailable(ni,nj);
				}
			}
		}
	}
}
