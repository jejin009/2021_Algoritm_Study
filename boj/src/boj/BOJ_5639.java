package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_5639 {

//	static class node {
//		node left;
//		node right;
//		int value;
//
//		public node(int num) {
//			this.value = num;
//		}
//	}
//
//	static Queue<Integer> inputs = new LinkedList<Integer>();
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		node head = new node(sc.nextInt());
//		while (sc.hasNext()) {
//			node node = new node(sc.nextInt());
//			makeTree(head, node);
//		}
//
//		visitTree(head);
//	}
//
//	private static void makeTree(node mom, node node) {
//		
//		if (node.value < mom.value) {
//			node node = new node(inputs.poll());
//			mom.left = node;
//			makeTree(node, mom.value);
//		}
//
//		if(inputs.isEmpty()) return;
//		if (inputs.peek() > mom.value) {
//			node node = new node(inputs.poll());
//			mom.right = node;
//			makeTree(node, mom.value);
//		}
//		return;
//	}
//
//	private static void visitTree(node node) {
//		if (node.left != null)
//			visitTree(node.left);
//		if (node.right != null)
//			visitTree(node.right);
//		
//		System.out.println(node.value);
//	}
}
