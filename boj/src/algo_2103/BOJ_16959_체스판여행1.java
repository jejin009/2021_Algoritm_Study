package algo_2103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16959_체스판여행1 {

	static class pos {
		int r, c;
		int count;
		int piece;

		public pos(int r, int c, int count, int piece) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
			this.piece = piece;
		}

	}

	static int N, N2;
	static int board[][];
	static boolean visited[][];
	static int[] start;
	static int[] knightR = { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int[] knightC = { -1, 1, 2, 2, 1, -1, -2, -2 };
	static int[] bishopR = { -1, -1, 1, 1 };
	static int[] bishopC = { -1, 1, 1, -1 };
	static int[] rookR = { -1, 0, 1, 0 };
	static int[] rookC = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		N2 = N * N;
		board = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1)
					start = new int[] { i, j };
			}
		}

		int answer = bfs();
		System.out.println(answer);
	}

	private static int bfs() {
		int cnt = 0;
		
		for (int i = 2; i <= N2; i++) {
			Queue<pos> q = new LinkedList<pos>();
			ArrayList<pos> toPick = new ArrayList<pos>();
			int[] mins = new int[3];
			visited = new boolean[N][N];
			boolean found = false;
			int piece = 0;
			q.offer(new pos(start[0], start[1], cnt, piece));

			while (!q.isEmpty() && !found) {
				pos next = q.poll();

				// 나이트 말로 갈 수 있는 곳
				for (int k = 0; k < 8; k++) {
					int r = next.r + knightR[k];
					int c = next.c + knightC[k];
					if (r >= 0 && r < N && c >= 0 && c < N && !visited[r][c]) {
						if (board[r][c] == i) {
							found = true;
							start = new int[] { r, c };
							int tempC = next.count + 1;
							if (next.piece != 0)
								tempC++;
							toPick.add(new pos(r, c, tempC, 0));
							mins[0] = tempC;
							piece = 0;
							break;
						}
						q.offer(new pos(r, c, next.count + 1, 0));
						visited[r][c] = true;
					}
				}

				// 비숍으로 갈 수 있는 곳
				for (int k = 0; k < 4; k++) {
					int mul = 1;
					int r = next.r + bishopR[k];
					int c = next.c + bishopC[k];
					while (mul < N) {
						r *= mul;
						c *= mul;
						mul++;
						if (r >= 0 && r < N && c >= 0 && c < N && !visited[r][c]) {
							if (board[r][c] == i) {
								found = true;
								start = new int[] { r, c };
								int tempC = next.count + 1;
								if (next.piece != 1)
									tempC++;
								toPick.add(new pos(r, c, tempC, 1));
								mins[1] = tempC;
								piece = 1;
								break;
							}
							q.offer(new pos(r, c, next.count + 1, 1));
							visited[r][c] = true;
						}
					}
				}
				// 룩으로 갈 수 있는 곳
				for (int k = 0; k < 4; k++) {
					int mul = 1;
					int r = next.r + rookR[k];
					int c = next.c + rookC[k];
					while (mul < N) {
						r *= mul;
						c *= mul;
						mul++;
						if (r >= 0 && r < N && c >= 0 && c < N && !visited[r][c]) {
							if (board[r][c] == i) {
								found = true;
								start = new int[] { r, c };
								int tempC = next.count + 1;
								if (next.piece != 2)
									tempC++;
								toPick.add(new pos(r, c, tempC, 2));
								mins[2] = tempC;
								piece = 2;
								break;
							}
							q.offer(new pos(r, c, next.count + 1, 2));
							visited[r][c] = true;
						}
					}

				}
				
				if(found) {
					int min = Integer.MAX_VALUE;
					int minIndex = 0;
					for(int mm = 0; mm < toPick.size(); mm++) {
						pos temp = toPick.get(mm);
						if(min > temp.count) {
							min = temp.count;
							minIndex = mm;
						}
					}
					start = new int[] { toPick.get(minIndex).r, toPick.get(minIndex).c,min,toPick.get(minIndex).piece };
					cnt = min;
				}
			}
		}
		return cnt;
	}
}
