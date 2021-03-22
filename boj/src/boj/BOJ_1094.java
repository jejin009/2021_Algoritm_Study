package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_1094 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> sticks = new ArrayList<Integer>();
		int X = Integer.parseInt(br.readLine());
		int sum= 64;
		sticks.add(64);
		while(sum > X) {
			Collections.sort(sticks);
			int shortstick = sticks.get(0);
			if((sum - shortstick/2) >= X) {
				sticks.set(0, shortstick/2);
				sum -= shortstick/2;
			}else {
				sticks.set(0, shortstick/2);
				sticks.add(0,shortstick/2);
			}
		}
		System.out.println(sticks.size());
	}
}
