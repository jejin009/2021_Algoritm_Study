package algo_2103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14496_그대그머가되어 {

	static boolean visited[];
	static int[] parent;
	static int[] distance;
	static int N, M, a, b;

	static ArrayList<Integer> arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if (from != to) {
				arr[from].add(to);
				arr[to].add(from);
			}
		}

		visited = new boolean[N + 1];
		distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[a] = 0;
		visited[a] = true;
		int index = a;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {a,0});
		while(q.isEmpty()) {
			int[]next = q.poll();
			int v = next[0];
			int weight =next[1];
			for (int i = 0; i < arr[v].size(); i++) {
				int temp = arr[v].get(i);
				if (!visited[temp]) {
					q.offer(new int[] {temp,weight+1});
					if (distance[index] + 1 < distance[temp]) {
						distance[temp] = distance[index] + 1;
					}
				}
			}
			int min = Integer.MAX_VALUE;
			int minIndex = index;
			for(int i = 0; i < N; i++) {				
				if (min > distance[i]) {
					min = distance[i];
					minIndex = i;
				}
			}
			index = minIndex;
			visited[minIndex] = true;

		}
		if (distance[b] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(distance[b]);
	}

}
