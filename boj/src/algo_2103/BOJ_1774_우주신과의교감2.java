package algo_2103;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1774_우주신과의교감2 {
	
	static class Edge implements Comparable<Edge>{
		int from, to;
		double weight;

		public Edge(int x, int y, double weight2) {
			super();
			this.from = x;
			this.to = y;
			this.weight = weight2;
		}

		@Override
        public int compareTo(Edge o) {
            if (weight > o.weight) return 1;
            else return -1;
        }

		@Override
		public String toString() {
			return "[" + from + ", " + to + ", " + weight + " ]";
		}
		
		
		
	}

	static int N,M;
	static int parents[];
	static Edge edges[];
	static ArrayList<Edge> edgelist = new ArrayList<Edge>();

	static int findSet(int a) {
		if(parents[a] == a) return a;
//		return findSet(parents[a]); //path compression 전
		return parents[a] = findSet(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = findSet(a); 
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		if(aRoot < bRoot)	parents[bRoot] = aRoot;
		else parents[aRoot] = bRoot;
		return true;
	}
	private static boolean isSameParent(int x, int y) {
        return findSet(x) == findSet(y);
    }
	static public void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parents = new int[N];
		edges = new Edge[N];
		
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(r,c,0);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
            union(from, to);
        }
		
		
		//거리 계산
        for (int i = 0; i < edges.length; i++) {
            Edge v1 = edges[i];
            for (int j = i + 1; j < edges.length; j++) {
                Edge v2 = edges[j];
                double weight = Math.sqrt(Math.pow(v1.from - v2.from, 2) + Math.pow(v1.to - v2.to, 2));
                edgelist.add(new Edge(i, j, weight));
            }
        }
		
		Collections.sort(edgelist);
		
		double result = 0;
		for (int i = 0; i < edgelist.size(); i++) {
            Edge v = edgelist.get(i);
    		
    		if (!isSameParent(v.from, v.to)) {
                result += v.weight;
                union(v.from, v.to);
            }
        }
        System.out.println(String.format("%.2f", result));
 
	}
}

