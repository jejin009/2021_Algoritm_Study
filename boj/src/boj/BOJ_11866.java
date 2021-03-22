package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11866 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>();
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int sum = 1;
		
		for(int i = 1; i <= n; i++) {
			q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!q.isEmpty()) {
			int person = q.poll();
			if(sum%k != 0) 
				q.offer(person);
			else 
				sb.append(person + ", ");
			sum++;
		}
		sb.setLength(sb.length() - 2);
		sb.append(">");
		System.out.println(sb.toString());
	}
}
