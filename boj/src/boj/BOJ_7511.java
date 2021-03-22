package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_7511 {

	static ArrayList<Integer>[] persons;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int testcase = 1; testcase <= T; testcase++) {
			StringBuilder sb = new StringBuilder();
			int n = Integer.parseInt(br.readLine());
			persons = new ArrayList[n];
//			for (int i = 0; i < n; i++) {
//				persons[i] = new ArrayList<Integer>();
//			}
			int k = Integer.parseInt(br.readLine());

			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				if(persons[p1] == null) persons[p1] = new ArrayList<Integer>();
				if(persons[p2] == null) persons[p2] = new ArrayList<Integer>();
				persons[p1].add(p2);
				persons[p2].add(p1);
			}

			int m = Integer.parseInt(br.readLine());
			sb.append("Senario").append(testcase).append(" :\n");
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());

				boolean answer = find(p1, p2, new boolean[n]);
				if (answer)
					sb.append(1 + "\n");
				else
					sb.append(0 + "\n");
			}
			System.out.println(sb.toString());
		}
	}

	private static boolean find(int p1, int p2, boolean visited[]) {
		for (int i = 0; i < persons[p1].size(); i++) {
			if (!visited[persons[p1].get(i)]) {
				visited[persons[p1].get(i)] = true;
				if (persons[p1].get(i) == p2)
					return true;
				else if (find(persons[p1].get(i), p2, visited))
					return true;
			}
		}
		return false;
	}
}
