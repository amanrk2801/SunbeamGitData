package com.sunbeam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Graph {
	private int vertexCount, edgeCount;
	private boolean adjMat[][];
	public Graph(int vCount) {
		vertexCount = vCount;
		adjMat = new boolean[vertexCount][vertexCount];
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter edge Count : ");
		edgeCount = sc.nextInt();
		System.out.println("Enter edges : (src, dest) : ");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			adjMat[src][dest] = true;
			adjMat[dest][src] = true;		// comment for directed graph
		}
	}
	
	public void print() {
		System.out.println("Gaph : ");
		for(int u = 0 ; u < vertexCount ; u++) {
			for(int v = 0 ; v < vertexCount ; v++) {
				System.out.print(adjMat[u][v] ? "1 " : "0 ");
			}
			System.out.println("");
		}
	}
	
	public void DFSTraversal(int start) {
		//0. create stack to push and array to mark vertices
		Stack<Integer> st = new Stack<Integer>();
		boolean marked[] = new boolean[vertexCount];
		//1. push and mark start vertex
		st.push(start);
		marked[start] = true;
		//2. repeat till stack is not empty
		System.out.print("DFS Trversal : ");
		while(!st.isEmpty()) {
			//3. pop vertex from stack
			int u = st.pop();
			//4. visit vertex
			System.out.print(" " + u);
			//5. push all non marked adjacents on stack and mark them
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMat[u][v]) {
					st.push(v);
					marked[v] = true;
				}
			}
		}
		System.out.println("");
	}
	
	public void BFSTraversal(int start) {
		//0. create queue to push and array to mark vertices
		Queue<Integer> q = new LinkedList<>();
		boolean marked[] = new boolean[vertexCount];
		//1. push and mark start vertex
		q.offer(start);
		marked[start] = true;
		//2. repeat till queue is not empty
		System.out.print("BFS Traversal :  ");
		while(!q.isEmpty()) {
			//3. pop vertex from stack
			int u = q.poll();
			//4. visit vertex
			System.out.print(" " + u);
			//5. push all non marked adjacents on queue and mark them
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!marked[v] && adjMat[u][v]) {
					q.offer(v);
					marked[v] = true;
				}
			}	
		}
		System.out.println("");
	}
	
}














