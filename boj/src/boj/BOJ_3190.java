package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3190 {

	static int[][] board;
	static Queue<int[]> snake = new LinkedList<int[]>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		board = new int[N + 1][N + 1];
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			board[y][x] = 2;
		}

		int L = Integer.parseInt(br.readLine());
		int i = 1, j = 1;
		int direction = 2;
		boolean flag = false;
		int time = 0;
		snake.offer(new int[] {1,1});
		
		for (int t = 0; t < L; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);

			for (int s = 0; s < sec; s++) {
				if (direction == 0) j--;
				else if (direction == 1) i--;
				else if (direction == 2) j++;
				else if (direction == 3) i++;
				
				if (i > N || j > N || i < 1 || j < 1|| board[i][j] == 1) {
					flag = true;
					break;
				}
				
				if(board[i][j] == 0) {
					int[] temp = snake.poll();
					board[temp[0]][temp[1]] = 0;
				}
				board[i][j] = 1;
				snake.offer(new int[] { i, j });
				time++;
			}
			if (flag) break;
			
			time++;
			if (dir == 'D')
				direction = (direction + 1) % 4;
			else if (dir == 'L') {
				if (--direction == -1)
					direction = 3;
			}
		}
		System.out.println(time);

	}
}
