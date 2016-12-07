package com.nc.GraphApply;

import com.nc.Graph.AdjacencyGraph;
import com.nc.LinearList.List;
import com.nc.LinearList.SequenceList;

public class ShortestPath {
	public void Dijkstra(AdjacencyGraph gr, int i,int []dist, List [] path) {
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

}
