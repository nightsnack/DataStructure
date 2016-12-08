package com.nc.GraphApply;

import java.util.Scanner;

import com.nc.Graph.AdjacencyGraph;
import com.nc.Graph.EdgeElement;
import com.nc.LinearList.List;
import com.nc.LinearList.SequenceList;

public class ShortestPath {
	public static void Dijkstra(AdjacencyGraph gr, int i,int []dist, List [] path) {
		int n = gr.vertices();
		if (i<0 || i> n-1) {
			System.out.println("Vertex nember is not in the graph");
			System.exit(1);
		}
		
		int [][] a = gr.getA();
		boolean []s = new boolean[n];
		for (int v = 0; v<n; v++) {
			if(v == i) 
				s[v] = true;
			else
				s[v] = false;
			dist[v] = a[i][v];
			path[v] = new SequenceList();
			if(a[i][v]!= AdjacencyGraph.getMaxvalue() && v != i) {
				path[v].add(i, 1);
				path[v].add(v, 2);
			}
		}
		
		for (int k = 1; k<= n-2; k++ ) {
			int w = AdjacencyGraph.getMaxvalue();
			int m = i;
			for (int j = 0; j<n; j++) {
				if (s[j] == false && dist[j]<w)
				{
					w = dist[j];
					m = j;
				}
			}
			if (m != i)
				s[m] = true;
			else 
				break;
			
			for (int j = 0; j < n; j++) {
				if (s[j] == false && dist[m]+a[m][j]< dist[j]) {
					dist[j] = dist[m] + a[m][j];
					path[j].clear();
					for(int pos = 1; pos <=path[m].size(); pos++ )
						path[j].add(path[m].value(pos), pos);
					path[j].add(j, path[j].size()+1);
				}
			}
		}
	}
	
	/**
	public static void main (String [] args) {
		AdjacencyGraph g = new AdjacencyGraph(5, 3);
		int [][]a = {{0,1,3},{0,4,30},{1,2,25},{1,3,8},{2,4,10},{3,0,20},{3,2,4},{3,4,12},{4,0,5}};
		
		EdgeElement []dd = new EdgeElement[a.length];
		for(int i = 0; i<a.length; i++) {
			dd[i] = new EdgeElement(a[i][0], a[i][1], a[i][2]);
		}
		g.createGraph(dd);
		int[] dist = new int[g.vertices()];
		List[] path = new SequenceList[g.vertices()];
		Dijkstra(g, 0, dist, path);
		System.out.println("从源点0到各顶点的最短距离：");
		for(int i = 0; i<dist.length; i++) {
			System.out.println("0-"+i+":"+dist[i]);
		}
		System.out.println();
		
		for(int i = 0;i<path.length; i++) {
			path[i].forward();
			System.out.println();
		}
	}
**/
	public static void main (String [] args) {
		Scanner sca = new Scanner(System.in);
		System.out.println("请输入城市个数:");
		int n = Integer.valueOf(sca.nextLine());
		System.out.println("请输入航线条数:");
		int m = Integer.valueOf(sca.nextLine());
		AdjacencyGraph g = new AdjacencyGraph(n, 1);
		for(int i = 0; i< m; i++) {
			System.out.println("请输入每条航线的起点和终点：");
			int p = sca.nextInt();
			int q = sca.nextInt();
			g.putEdge(new EdgeElement(p, q));
		}
//		int [][]a = {{0,1,3},{0,4,30},{1,2,25},{1,3,8},{2,4,10},{3,0,20},{3,2,4},{3,4,12},{4,0,5}};
//		
//		EdgeElement []dd = new EdgeElement[a.length];
//		for(int i = 0; i<a.length; i++) {
//			dd[i] = new EdgeElement(a[i][0], a[i][1], a[i][2]);
//		}
//		g.createGraph(dd);
		int v,w;
//		do {
			System.out.println("请输入起点和终点：");
			w = sca.nextInt();
			v = sca.nextInt();
		while (v<0||w<0||w>n-1||v>n-1)
		{
			System.out.println("输入有误重新输入");
			w = sca.nextInt();
			v = sca.nextInt();
		}
		int[] dist = new int[g.vertices()];
		List[] path = new SequenceList[g.vertices()];
		Dijkstra(g, w, dist, path);
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i] = -2;
		}
		if(w != v) {
			if(path[v].isEmpty()){
				System.out.println("从点"+w+"不能抵达到点"+v);
				System.exit(1);
			}
			System.out.println("从点"+w+"到点"+v+"的最短换乘方式为：");
			path[v].forward();
//			System.out.println("距离为：");
//			System.out.println(dist[v]);
		} else {
			System.out.println("从点"+w+"到点"+v+"无需乘飞机");
		}
		
	}
}
