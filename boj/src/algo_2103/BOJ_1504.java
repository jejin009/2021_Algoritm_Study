package algo_2103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {

	static int N, E, v1, v2;
	static int min;
	static boolean found = false;
	static boolean visited[];
	static ArrayList<int[]>[] graph;
	static int distance[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		distance = new int[N + 1];

		for (int i = 1; i <= N; i++)
			distance[i] = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++)
			graph[i] = new ArrayList<int[]>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			graph[from].add(new int[] { to, weight });
			graph[to].add(new int[] { from, weight });
		}
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		
		int d1 = dij(1, v1);
		int d2 = dij(v1, v2);
		int d3 = dij(v2, N);
		if (d1 != -1 && d2 != -1 && d3 != -1)
			min = d1 + d2 + d3;
//		System.out.println(v1);
		
		d1 = dij(1, v2);
		d3 = dij(v1, N);
		if (d1 != -1 && d2 != -1 && d3 != -1)
			min = Math.min(min, d1 + d2 + d3);

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	private static int dij(int from, int to) {
//		PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<T>() {
//			
//		});
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++)
			distance[i] = Integer.MAX_VALUE;
		distance[from] = 0;
		int v = from;
		visited[1] = true;
		
		while (v != to && graph[v].size() != 0) {
			for (int j = 0; j < graph[v].size(); j++) {
				int nextv = graph[v].get(j)[0];
				int val = graph[v].get(j)[1] + distance[v];
				if (distance[nextv] > val) {
					distance[nextv] = val;
				}
			}
			int tempMin = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				if (tempMin > distance[i] && !visited[i]) {
					tempMin = distance[i];
					v = i;
				}
			}
			visited[v] = true;
		}
		
		if (!visited[to])
			return -1;
		return distance[to];
	}
}
