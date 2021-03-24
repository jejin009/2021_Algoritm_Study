package algo_2103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2638_치즈 {

	static int N, M;
	static int[][] plate;
	static int[] di = { 0, -1, 0, 1 };
	static int[] dj = { -1, 0, 1, 0 };
	static Queue<int[]> air = new LinkedList<int[]>();
	static Queue<int[]> cheeze = new LinkedList<int[]>();
	static boolean visited[][];
	static int time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		plate = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				plate[i][j] = Integer.parseInt(st.nextToken());
				if (plate[i][j] == 0)
					plate[i][j] = -1;
				else
					plate[i][j] = 0;
			}
		}


		int cnt = -1;
		while (cnt != 0) {
			air.add(new int[] { 0, 0 });
			visited = new boolean[N][M];
			melt();
			cnt = 0;
			time++;
			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(plate[i]));
				for (int j = 0; j < M; j++) {
					if (plate[i][j] != -1) {
						cnt++;
						plate[i][j] = 0;
					}
				}
			}
//			System.out.println();
		}
		System.out.println(time);
	}

	private static void melt() {

		while (!air.isEmpty()) {
			int[] a = air.poll();
			
			for(int i = 0; i < 4; i++) {
				int r = a[0] + di[i];
				int c = a[1] + dj[i];
				
				if(r >= 0 && r < N && c >= 0 && c < M && !visited[r][c]) {
					visited[r][c] = true;
					if(plate[r][c] == -1) {
						air.add(new int[] {r,c});
					}else if(plate[r][c] == 0) {
						visited[r][c] = false;
						plate[r][c] = 1;
					}else {
						cheeze.add(new int[] {r,c});
					}
				}
			}
		}

		while (!cheeze.isEmpty()) {
			int[] c = cheeze.poll();
			plate[c[0]][c[1]] = -1;
		}
	}
}
