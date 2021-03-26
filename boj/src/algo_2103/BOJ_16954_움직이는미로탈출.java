package algo_2103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ_16954_움직이는미로탈출 {

	static char[][] board = new char[8][];
	static Queue<int[]> q = new LinkedList<int[]>();
	static int wook[];
	static int walls = 0;
	static boolean flag = false;
	static int di[] = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
	static int dj[] = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 8; i++) {
			String str = br.readLine();
			board[i] = str.toCharArray();
			for(int j = 0; j < 8; j++)
				if(board[i][j] == '#') walls++;
		}
		
		

		q.add(new int[] { 7, 0 });

		int answer = play();
		System.out.println(answer);
	}

	private static int play() {
		// play
		while (!q.isEmpty()) {
			boolean[][] visited = new boolean[8][8];
			int size = q.size();
			while (size-- != 0) {
				int wook[] = q.poll();
				int r = wook[0];
				int c = wook[1];

				if (board[r][c] == '#')
					continue;
				if(walls == 0) return 1;
				
				visited[r][c] = false;
				for (int k = 0; k < 9; k++) {
					int newr = r + di[k];
					int newc = c + dj[k];
					// 움직일 곳에 벽이 없으면
					if (newr >= 0 && newr < 8 && newc >= 0 && newc < 8 && board[newr][newc] == '.'
							&& !visited[newr][newc]) {
						if (newr == 0 && newc == 7)
							return 1;
						q.add(new int[] { newr, newc });
						visited[newr][newc] = true;
					}
				}
			}
			walls = 0;
			for (int i = 6; i > 0; i--) {
				for (int j = 0; j < 8; j++) {
					if (board[i][j] == '#') {
						board[i + 1][j] = '#';
						board[i][j] = '.';
						walls++;
					}
				}
			}
			board[0] = new char[] { '.', '.', '.', '.', '.', '.', '.', '.' };
		}

		return 0;
	}
}
