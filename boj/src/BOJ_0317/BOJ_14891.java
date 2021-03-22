package BOJ_0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14891 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList[] wheels = new ArrayList[4];

		for (int i = 0; i < 4; i++) {
			wheels[i] = new ArrayList<Integer>();
			String str = br.readLine();
			for (int j = 0; j < 8; j++)
				wheels[i].add(str.charAt(j) - '0');
		}
		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int toTurn = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken());
			int toRight = (int) wheels[toTurn].get(2);
			int toLeft = (int) wheels[toTurn].get(6);
			
			if(dir == 1) {
				int temp = (int) wheels[toTurn].get(wheels[toTurn].size() - 1);
				wheels[toTurn].remove(wheels[toTurn].size() - 1);
				wheels[toTurn].add(0, temp);
			}else {
				int temp = (int) wheels[toTurn].get(0);
				wheels[toTurn].remove(0);
				wheels[toTurn].add(temp);
			}

			int nextWheel = toTurn -1;
			int nextDir = dir == 1 ? -1 : 1;
			while (nextWheel >= 0) {
				if ((int) wheels[nextWheel].get(2) == toLeft) {
					break;
				} else {
					toLeft = (int) wheels[nextWheel].get(6);
					if (nextDir == -1) {
						int temp = (int) wheels[nextWheel].get(0);
						wheels[nextWheel].remove(0);
						wheels[nextWheel].add(temp);
					} else {
						int temp = (int) wheels[nextWheel].get(wheels[nextWheel].size() - 1);
						wheels[nextWheel].remove(wheels[nextWheel].size() - 1);
						wheels[nextWheel].add(0, temp);
					}
					nextWheel--;
					nextDir *= -1;
				}
			}

			nextWheel = toTurn + 1;
			nextDir = dir == 1 ? -1 : 1;
			while (nextWheel < 4) {
				if ((int) wheels[nextWheel].get(6) == toRight) {
					break;
				} else {
					toRight = (int) wheels[nextWheel].get(2);
					if (nextDir == -1) {
						int temp = (int) wheels[nextWheel].get(0);
						wheels[nextWheel].remove(0);
						wheels[nextWheel].add(temp);
					} else {
						int temp = (int) wheels[nextWheel].get(wheels[nextWheel].size() - 1);
						wheels[nextWheel].remove(wheels[nextWheel].size() - 1);
						wheels[nextWheel].add(0, temp);
					}
					nextWheel++;
					nextDir *= -1;
				}
				
			}

			
//			for(ArrayList<Integer>temp : wheels) {
//				System.out.println(Arrays.toString(temp.toArray()));
//			}
//			System.out.println();
		}

		int score = 0;
		for (int i = 0; i < 4; i++) {
//			System.out.println((int)wheels[i].get(0));
			if ((int) wheels[i].get(0) == 1)
				score += Math.pow(2, i);
		}
		System.out.println(score);
	}
}
