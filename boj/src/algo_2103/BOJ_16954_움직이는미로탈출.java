package algo_2103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_16954_움직이는미로탈출 {

	static char[][] board = new char[8][];
	static ArrayList<int[]> walls = new ArrayList<int[]>();
	static int wook[];
	static boolean flag = false;
	static int di[] = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
	static int dj[] = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 8; i++) {
			String str = br.readLine();
//			board[i] = str.toCharArray();
			for (int j = 0; j < 8; j++)
				if (str.charAt(j) == '#') {
					walls.add(new int[] { i, j });
				}
		}

//		for (int i = 0; i < 7; i++) {
//			int newr = 7 + di[i];
//			int newc = 0 + dj[i];
//			if (newr >= 0 && newr < 8 && newc >= 0 && newc < 8) {
//				play(7, 0, walls.size());
//			}
//		}
		play(7,0,walls.size());
		if (flag)
			System.out.println(1);
		else
			System.out.println(0);
	}

	private static void play(int r, int c, int num) {
//		System.out.println(r + " " + c);
		// 되돌아감
		if (flag)
			return;

		// 도착함!!
		if (r == 0 && c == 7) {
			flag = true;
			return;
		}

		// play
		for (int i = 0; i < 9; i++) {
			int newr = r + di[i];
			int newc = c + dj[i];
			int newNum = num;
			boolean crushed = false;
			//움직인 곳에 벽이 있으면 실패
			for (int j = 0; j < num; j++) {
				if (newr == walls.get(j)[0] && newc == walls.get(j)[1]) {
					crushed = true;
					break;
				}
			}
			if (newr >= 0 && newr < 8 && newc >= 0 && newc < 8 && !crushed) {
				for (int j = 0; j < num; j++)
					walls.get(j)[0] = walls.get(j)[0] + 1;
				for (int j = 0; j < num; j++) {
					if (walls.get(j)[0] > 7) {
						newNum = j;
						break;
					}
				}
				play(newr, newc, newNum);
				for (int j = 0; j < num; j++)
					walls.get(j)[0] = walls.get(j)[0] - 1;
			}
		}
	}
}
