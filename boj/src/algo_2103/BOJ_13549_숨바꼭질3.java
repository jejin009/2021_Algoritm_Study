package algo_2103;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_13549_숨바꼭질3 {

	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int sec = 0;
		boolean visited[] = new boolean[100001];
		q.offer(N);
		q.offer(0);
		visited[N] = true;
		while(!q.isEmpty()) {
			int subin = q.poll();
			sec = q.poll();
			
			if(subin == K) break;
			
			int next = subin*2;
			if(next>=0 && next <= 100000 && !visited[next] ) {
				q.add(next);
				q.add(sec);
				visited[next] = true;
			}

			next = subin-1;
			if(next>=0 && next <= 100000 && !visited[next] ) {
				q.add(next);
				q.add(sec+1);
				visited[next] = true;
			}
			
			next = subin+1;
			if(next>=0 && next <= 100000 && !visited[next] ) {
				q.add(next);
				q.add(sec+1);
				visited[next] = true;
			}
			
		}
		
		System.out.println(sec);
		
		
	}
}
