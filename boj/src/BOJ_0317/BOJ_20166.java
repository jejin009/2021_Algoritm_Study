package BOJ_0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_20166 {

	static int N, M, K;
	static char[][] board;
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	static int count = 0;
	static String favorites[];
	static int[] di = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dj = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		favorites = new String[K];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < K; i++) {
			favorites[i] = br.readLine();
		}

		for (int k = 0; k < K; k++) {
			if (map.containsKey(favorites[k]))
				System.out.println(map.get(favorites[k]));
			else {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						if (favorites[k].charAt(0) == board[i][j]) {
//						System.out.println(i +" " + j);
							makeString(k, 1, i, j);
//						System.out.println(count);
						}
					}
				}
				map.put(favorites[k], count);
				System.out.println(count);
				count = 0;
			}
		}

	}

	private static void makeString(int toMake, int nextc, int r, int c) {
		if (favorites[toMake].length() == nextc) {
			count++;
			return;
		}

		for (int k = 0; k < 8; k++) {
			int tempr = (r + di[k] + N) % N;
			int tempc = (c + dj[k] + M) % M;
			if (favorites[toMake].charAt(nextc) == board[tempr][tempc])
				makeString(toMake, nextc + 1, tempr, tempc);
		}
	}
}
