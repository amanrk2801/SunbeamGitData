package com.sunbeam;

import java.util.Scanner;

public class Graph {
	private final int INF = 999;
	private int vertexCount, edgeCount;
	private int adjmat[][];
	
	public Graph(int vCount) {
		vertexCount = vCount;
		adjmat = new int[vertexCount][vertexCount];
		for(int u = 0 ; u < vertexCount ; u++)
			for(int v = 0 ; v < vertexCount ; v++)
				adjmat[u][v] = INF;
	}
	
	public void accept(Scanner sc) {
		System.out.print("Enter edge count : ");
		edgeCount = sc.nextInt();
		System.out.println("Enter edges : (src, dest, wt) : ");
		for(int i = 0 ; i < edgeCount ; i++) {
			int src = sc.nextInt();
			int dest = sc.nextInt();
			int wt = sc.nextInt();
			adjmat[src][dest] = wt;
			adjmat[dest][src] = wt;			// comment this line for directed graph
		}
	}
	
	public void print() {
		System.out.println("Graph : ");
		for(int u = 0 ; u < vertexCount ; u++) {
			for(int v = 0 ; v < vertexCount ; v++) {
				System.out.print(" " + adjmat[u][v]);
			}
			System.out.println("");
		}
	}
	
	public int findMinDistVertex(int dist[], boolean spt[]) {
		int minDist = INF, minDistVertex = -1;
		for(int i = 0 ; i < vertexCount ; i++) {
			if(!spt[i] && dist[i] < minDist) {
				minDist = dist[i];
				minDistVertex = i;
			}
		}
		return minDistVertex;
	}
	
	public void djkshtraSPT(int start) {
		//1. create arrays to maintain SPT and dist of every vertex
		boolean spt[] = new boolean[vertexCount];
		int dist[]	= new int[vertexCount];
		for(int i = 0 ; i < vertexCount ; i++) {
			spt[i] = false;
			dist[i] = INF;
		}
		//2. mark dist of start vertex equal to 0
		dist[start] = 0;
		//3. Repeat till all vertices are not added into SPT
		int count = 0;
		while(count < vertexCount) {
			//4. choose minimum dist vertex
			int u = findMinDistVertex(dist, spt);
			//5. add vertex into SPT
			spt[u] = true;
			//6. increment count
			count++;
			//7. update dist of all adjacent vertices
			for(int v = 0 ; v < vertexCount ; v++) {
				if(!spt[v] && adjmat[u][v] != INF && dist[u] + adjmat[u][v] < dist[v]) {
					dist[v] = dist[u] + adjmat[u][v];
				}
			}
		}	
		//8. print SPT and dist
		for(int i = 0 ; i < vertexCount ; i++) {
			System.out.println(start + "->" + i + "=" + dist[i]);
			
		}
			
	}
	
}
















