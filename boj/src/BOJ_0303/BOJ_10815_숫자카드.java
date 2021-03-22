package BOJ_0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_숫자카드 {

	static int N, M;
	static int[] cards;
	static boolean flag;
	static int index, toSearch;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cards = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i  = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(cards);
//		System.out.println(Arrays.toString(cards));
		
		M = Integer.parseInt(br.readLine());
//		answer = new boolean[M];
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			toSearch = Integer.parseInt(st.nextToken());
			index = i;
			flag = false;
			if(search(0, N)) sb.append(1);
			else sb.append(0);
			sb.append(" ");
		}
		
		System.out.println(sb.toString());

		
	}
	private static boolean search(int start, int end) {
		if(start == end - 1) {
			if(cards[start] == toSearch) {
				flag = true;
				return flag;
			}
			else return false;
		}
		else {
			int mid = (start+end)/2;
			if(toSearch < cards[mid]) {
				search(start, mid);
			}else if(toSearch > cards[mid]) {
				search(mid,end);
			}else {
				flag = true;
			}
			return flag;
		}
	}
}
