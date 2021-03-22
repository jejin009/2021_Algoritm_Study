package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_16922 {

	static int[] roman = {1,5,10,50};
	static int n;
	static int cnt;
	static int[] selected;
	static ArrayList<Integer> result = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		selected = new int[n];
		permutation(0,0);
		System.out.println(cnt);
	}

	private static void permutation(int toSelect, int start) {
		if(toSelect == n) {
			int sum = 0;
			for(int i = 0 ; i < n; i++)
				sum +=  selected[i];
			if(!result.contains(sum)) {
				result.add(sum);
				cnt++;
			}
			return;
		}
		
		for(int i = start; i < 4; i++) {
			selected[toSelect] = roman[i];
			permutation(toSelect + 1, i);
		}
	}
}
