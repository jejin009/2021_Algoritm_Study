package BOJ_0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144 {

	static int arr1[][];
	static int arr2[][];
	static int R, C, T;
	static int ac[][];
	static int di[] = { 0, -1, 0, 1 };
	static int dj[] = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		arr1 = new int[R][C];
		arr2 = new int[R][C];
		ac = new int[2][2];
		int index = 0;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr1[i][j] = Integer.parseInt(st.nextToken());
				arr2[i][j] = arr1[i][j];
				if (arr1[i][j] == -1) {
					ac[index][0] = i;
					ac[index++][1] = j;
				}
			}
		}

		int time = 0;
		int turn = 1;
		while (time < T) {

			if (turn == 1) {
				spread(arr1, arr2);
				circulate(arr2);
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						System.out.print(arr2[i][j] + " ");
					}
					System.out.println();
				}
				turn = 2;
			} else {
				spread(arr2, arr1);
				circulate(arr1);
				turn = 1;
			}
			time++;
		}
		
		if (turn == 1) {
			System.out.println(sum(arr1));
		}
		else
			System.out.println(sum(arr2));

	}

	private static int sum(int[][] arr) {
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sum+=arr[i][j];
			}
		}
		
		return sum+2;
		
	}

	private static void circulate(int[][] arr) {
		int ti[] = { 0, -1, 0, 1 };
		int tj[] = { 1, 0, -1, 0 };
		int bi[] = { 0, 1, 0, -1 };
		int bj[] = { 1, 0, -1, 0 };
		int tempi = ac[0][0];
		int tempj = ac[0][1];
		int dust = 0;
		int temp = 0;

		for (int i = 0; i < 4; i++) {
			while (true) {
				tempi += ti[i];
				tempj += tj[i];
				if (tempi >= 0 && tempi < R && tempj >= 0 && tempj < C && arr[tempi][tempj] > -1) {
					temp = arr[tempi][tempj];
					arr[tempi][tempj] = dust;
					dust = temp;
				} else {
					tempi -= ti[i];
					tempj -= tj[i];
					break;
				}
			}
		}

		tempi = ac[1][0];
		tempj = ac[1][1];
		dust = 0;
		temp = 0;
		for (int i = 0; i < 4; i++) {
			while (true) {
				tempi += bi[i];
				tempj += bj[i];
				if (tempi >= 0 && tempi < R && tempj >= 0 && tempj < C && arr[tempi][tempj] > -1) {
					temp = arr[tempi][tempj];
					arr[tempi][tempj] = dust;
					dust = temp;
				} else {
					tempi -= bi[i];
					tempj -= bj[i];
					break;
				}
			}
		}
	}

	private static void spread(int[][] arr, int[][] arrTo) {

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				arrTo[i][j] = 0;
			}
		}
		
		arrTo[ac[0][0]][ac[0][1]] = -1; 
		arrTo[ac[1][0]][ac[1][1]] = -1; 

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] > 0) {
					int spreadCnt = 0;
					for (int mi = 0; mi < 4; mi++) {
						int tempi = i + di[mi];
						int tempj = j + dj[mi];
						if (tempi >= 0 && tempi < R && tempj >= 0 && tempj < C && arr[tempi][tempj] > -1) {
							arrTo[tempi][tempj] += arr[i][j] / 5;
							spreadCnt++;
						}
					}
					arrTo[i][j] += arr[i][j] - (arr[i][j] / 5) * spreadCnt;
					
				}
			}
		}
	}
}
