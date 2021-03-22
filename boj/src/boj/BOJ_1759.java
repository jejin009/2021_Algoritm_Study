package boj;

import java.util.Scanner;

public class BOJ_1759 {

	static int L, C;
	static int[] numbers;
	static int[]selected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		
		numbers = new int[C];
		selected = new int[L];
		for(int i = 0; i < C; i++) {
			numbers[i] = sc.nextInt();
		}
		permutation(0,0);
	}
	private static void permutation(int cnt, int start) {
		if(cnt==L) {
			for(int i = 0 ;i < L; i++) {
				System.out.print(selected[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < C; i++) {
			selected[cnt] = i;
			permutation(cnt+1, i+1);
		}
	}
}
