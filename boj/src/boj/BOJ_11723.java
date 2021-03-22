package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> set = new HashSet<Integer>();
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			if(oper.equals("add")) {
				set.add(Integer.parseInt(st.nextToken()));
			}else if(oper.equals("remove")) {
				set.remove(Integer.parseInt(st.nextToken()));
			}else if(oper.equals("check")) {
				if(set.contains(Integer.parseInt(st.nextToken()))) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}else if(oper.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				if(set.contains(x)) set.remove(x);
				else set.add(x);
			}else if(oper.equals("all")) {
				set.clear();
				for(int j = 1; j < 21; j++) set.add(j);
			}else set.clear();
		}
		System.out.println(sb.toString());
	}
}
