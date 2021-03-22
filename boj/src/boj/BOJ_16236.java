package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {

	static int N;
	static int[][] sea;
	static boolean[][] visitedsea;
	static int[] di = { 0, -1, 0, 1 };
	static int[] dj = { -1, 0, 1, 0 };
	static ArrayList<int[]> toEat = new ArrayList<int[]>();
	static Queue<int[]> toMove = new LinkedList<int[]>();
	static boolean callMom = false;
	static Shark shark = null;

	static class Shark {
		int y;
		int x;
		int size;
		int eaten;

		public Shark(int i, int j) {
			this.y = i;
			this.x = j;
			this.size = 2;
			this.eaten = 0;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		sea = new int[N][N];
		visitedsea = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				if (sea[i][j] == 9) {
					sea[i][j] = 0;
					shark = new Shark(i, j);
				}
			}
		}

		hunt(0, shark.y, shark.x);

	}

	private static void hunt(int dist, int tempi, int tempj) {
		//엄마 불렀음
		if (callMom)
			return;
		//먹을게 있을 때
		if (toEat.size() > 0) {
			int min = 0;
			for (int k = 1; k < toEat.size(); k++) {
				if (toEat.get(k)[2] < toEat.get(min)[2]) {
					min = k;
				} else if (toEat.get(min)[2] == toEat.get(k)[2]) {
					if (toEat.get(k)[0] < toEat.get(min)[0]
							|| (toEat.get(k)[0] == toEat.get(min)[0] && toEat.get(k)[1] < toEat.get(min)[1])) {
						min = k;
					}
				}
			}
			
			//상어 위치 바꿔줌
			shark.y = toEat.get(min)[0];
			shark.x = toEat.get(min)[1];
			sea[toEat.get(min)[0]][toEat.get(min)[1]] = 0;
			shark.eaten++;
			if (shark.eaten == shark.size) {
				shark.size++;
				shark.eaten = 0;
				toEat.clear();
				initVisited();
			}
			
			return;
		}

		//아직 먹을게 없을때. 다음 단계로!
		
		for (int i = 0; i < 4; i++) {
			//사방탐색
			tempi = shark.y + di[i];
			tempj = shark.x + dj[i];
			
			//갈 수 없는 탐색일때. 더이상 갈 수 없으므로 visitied처리
			if (tempi < 0 || tempi >= N || tempj < 0 || tempj >= N || visitedsea[tempi][tempj] || sea[tempi][tempj] > shark.size) {
				visitedsea[tempi][tempj] = true;
				continue;
			} else {
				//움직일 수 있는 길일때는 다음번에 움직이기 위 해 큐에 담아둠. 그리고 사방탐색 마저 진행
				toMove.add(new int[] { tempi, tempj});
				
				if (sea[tempi][tempj] < shark.size) {
					//먹을 수 있는 물고기가 있는 길일 경우에는 toEat에 넣어둠. 위치 비교해야해서
					toEat.add(new int[] { tempi, tempj, dist });
				}

			}
		}
		
		//사방탐색했는데 지나갈 수 없는길임. 전부 물고기가 크거나 막힌 방향, 내가 실제로 지나온길일떄.
		if(toMove.size() == 0) {
			callMom = true;
			return;
		}
		else {
			for(int i = 0; i < toMove.size(); i++) {
				int[] temp = toMove.poll();
				hunt(dist+1, temp[0], temp[1]);
			}
		}
	}

	private static void initVisited() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visitedsea[i][j] = false;
			}
		}
	}
}
