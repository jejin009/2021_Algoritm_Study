package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1722_순열의순서 {

	static int[] selected;
	static boolean[] visited;
	static String answer;
	static int n;
	static int k;
	static ArrayList<String> numbers= new ArrayList<String>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		selected = new int[n+1];
		visited = new boolean[n+1];
		int menu = sc.nextInt();
		
		if(menu == 1) {
			k = sc.nextInt();
			permutation(0);
			System.out.println(numbers.get(k-1));
		}
		else if(menu == 2) {
			for(int i = 0; i <n; i++) 
				sb.append(sc.nextInt()).append(" ");
			sb.substring(0,sb.length()-1);
			
			answer = sb.toString();
			permutation(0);
			
			for(int i = 0; i < numbers.size(); i++) {
				if(answer.equals(numbers.get(i))) {
					System.out.println(i + 1);
					break;
				}
			}
		}
		
		
	}
	private static void permutation(int toSelect) {
		if(toSelect == n) {
			sb = new StringBuilder();
			for(int i = 0; i <n; i++)
				sb.append(selected[i]).append(" ");
			
			numbers.add(sb.toString());
			
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				selected[toSelect] = i;
				visited[i] = true;
				permutation(toSelect+1);
				visited[i] = false;
			}
		}
			
	}
	private static void permutation2(int toSelect) {
		if(toSelect == n) {
			sb = new StringBuilder();
			for(int i = 0; i <n; i++)
				sb.append(selected[i]).append(" ");
			
			if(answer.equals(sb.toString()));
			numbers.add(sb.toString());
			
			return;
		}
		
		for(int i = 1; i <= n; i++) {
			if(!visited[i]) {
				selected[toSelect] = i;
				visited[i] = true;
				permutation(toSelect+1);
				visited[i] = false;
			}
		}
		
	}
}
