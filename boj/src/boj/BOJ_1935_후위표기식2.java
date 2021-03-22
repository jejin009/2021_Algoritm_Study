package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1935_후위표기식2 {

	static double[] operand;
 	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Double> st = new Stack<Double>(); 
		int N = Integer.parseInt(br.readLine());
		
		operand = new double[N];
		String str = br.readLine();
		
		for(int i = 0; i < N; i++)
			operand[i] = Integer.parseInt(br.readLine());
		int c = 0;
		
		for(int i = 0; i < str.length(); i++) {
			char next = str.charAt(i);
			if(next == '*') {
				double number2 = st.pop();
				double number1 = st.pop();
				st.push(number1 * number2);
			}
			else if(next == '/') {
				double number2 = st.pop();
				double number1 = st.pop();
				st.push(number1 / number2);
			}
			else if(next == '+') {
				double number2 = st.pop();
				double number1 = st.pop();
				st.push(number1 + number2);
			}
			else if(next == '-') {
				double number2 = st.pop();
				double number1 = st.pop();
				st.push(number1 - number2);
			}
			else {
				st.push(operand[c++]);
			}
		}
		double num = st.pop();
		System.out.printf("%.2f",num);
			
	}
}
