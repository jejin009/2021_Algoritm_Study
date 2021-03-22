package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1655 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int sum = 0;
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			int index = 0;
			int num = Integer.parseInt(br.readLine());
			numbers.add(num);
			while(true) {
				if(numbers.get(i) > num) {
					numbers.add(i, num);
					break;
				}
			}
			if(i == 1) answer = numbers.get(0) >numbers.get(1)? numbers.get(1): numbers.get(0);
			else if(i % 2 != 0) answer = numbers.get(i/2) > numbers.get(i/2 +1)? numbers.get(i/2 +1) : numbers.get(i/2);
			else answer = numbers.get(i/2);
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
