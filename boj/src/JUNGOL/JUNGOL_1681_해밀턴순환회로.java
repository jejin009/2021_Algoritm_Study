package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
5
0 14 4 10 20
14 0 7 8 7
4 5 0 7 16
11 7 9 0 2
18 7 17 4 0
 */


public class JUNGOL_1681_해밀턴순환회로 {

	static int N,result;
	static int min = Integer.MAX_VALUE;
	static int[][] price;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		price = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				price[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i < N; i ++) {
			visited = new boolean[N];
			result = 0;
			if(price[0][i]!=0) {
                dfs(0,i,1);
            }
		}
		
		System.out.println(min);
		
	}
	
	public static void dfs(int r, int c, int cnt) {
		visited[r] = true; 
        result += price[r][c];  
        
        if(cnt==N-1) { //모두 방문함
            result += price[c][0];   //회사로 되돌아가기
            if(price[c][0]!=0) {  //되돌아갈 수 있으면
            	min = Math.min(min, result);
            	result -= price[c][0];  
            }
            return;
        }
        
        
        for(int i = 0; i < N; i++) {
            if(!visited[i] && price[c][i]!=0 && result < min) {//i에 미방문했고 길은 있고 선택될 여지가있을떄  
                dfs(c,i,cnt+1); //현재위치 c에서 a방문
                //i방문 해제
                result -= price[c][i]; 
                visited[i] = false; 
            }
        }
    }
}
