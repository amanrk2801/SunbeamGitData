package com.sunbeam;

import java.util.Scanner;

public class Graph {
	private final int INF = 999;
	private int vertexCount, edgeCount;
	private int adjMat[][];
	public Graph(int vCount) {
		vertexCount = vCount;
		adjMat = new int[vertexCount][vertexCount];
		for(int u = 0 ; u < vertexCount ; u++)
			for(int v = 0 ; v < vertexCount ; v++)
				adjMat[u][v] = INF;
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter edge Count : ");
		edgeCount = sc.nextInt();
		System.out.println("Enter edges : (src, dest, wt) : ");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjMat[src][dest] = wt;
			adjMat[dest][src] = wt;		// comment for directed graph
		}
	}
	
	public void print() {
		System.out.println("Gaph : ");
		for(int u = 0 ; u < vertexCount ; u++) {
			for(int v = 0 ; v < vertexCount ; v++) {
				System.out.print(" " + adjMat[u][v]);
			}
			System.out.println("");
		}
	}
	
	public void primsMST(int start) {
		//0. MST, parent, key
		boolean mst[] = new boolean[vertexCount];
		int parent[] = new int[vertexCount];
		int key[] = new int[vertexCount];
		for(int i = 0 ; i < vertexCount ; i++) {
			parent[i] = -1;
			key[i] = INF;
			mst[i] = false;
		}
		//1. choose start vertex and mark its key = 0
		key[start] = 0;
		int count = 0;
		while(count < vertexCount) {
			//1. find min key vertex
			int minKey = INF, u = -1;
			for(int i = 0 ; i < vertexCount ; i++) {
				if(!mst[i] && key[i] < minKey) {
					minKey = key[i];
					u = i;
				}
			}
			//2. add min key vertex into MST
			mst[u] = true;
			//3. increment count
			count++;
			//4. update key and parent of adjacents
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!mst[v] && adjMat[u][v] != INF && adjMat[u][v] < key[v]) {
					key[v] = adjMat[u][v];
					parent[v] = u;
				}
			}
		}
		int wt = 0;
		for(int i = 0 ; i < vertexCount ; i++)
			wt += key[i];
		
		System.out.println("Minimum weight = " + wt);
	}
}





















