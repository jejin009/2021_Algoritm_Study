package algo_2103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11779_최소비용구하기2 {

	static int n,m,v1,v2;
	static ArrayList<int[]> path[];
	static int[] distance;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		path = new ArrayList[n + 1];
		distance = new int[n + 1];

		for (int i = 1; i <= n; i++)
			distance[i] = Integer.MAX_VALUE;

		for (int i = 1; i <= n; i++)
			path[i] = new ArrayList<int[]>();
			
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			path[from].add(new int[] { to, weight });
			path[to].add(new int[] { from, weight });
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		
	}
}
