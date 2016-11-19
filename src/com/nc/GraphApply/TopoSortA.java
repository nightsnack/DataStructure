package com.nc.GraphApply;

import com.nc.Graph.EdgeElement;
import com.nc.Graph.EdgeNode;
import com.nc.Graph.LinkedGraph;

public class TopoSortA {
	

	public static boolean TopoSort(LinkedGraph gr, int[] a) {
		int n = gr.vertices();
		int [] d = new int[n];
		EdgeNode p;
		EdgeNode [] b = gr.getArray();
		
		for (int i = 0; i < d.length; i++) {
			d[i] = 0;
		}
		
		for (int i = 0; i < b.length; i++) {
			p = b[i];
			while(p!=null) {
				int j = p.adjvex;
				d[j]++;
				p = p.next;
			}
		}
		int top = -1;
		for (int i = 0; i < d.length; i++) {
			if(d[i]==0) {
				d[i] = top;
				top = i;
			}
		}
		
		int m = 0;
		while(top!=-1) {
			int j = top;
			top = d[top];
			a[m] = j;
			m++;
			
			p = b[j];
			while(p!=null) {
				int k = p.adjvex;
				d[k]--;
				if(d[k]==0) {
					d[k] = top;
					top = k;
				}
				p = p.next;
			}
		}
		if(m<n) 
		{
			System.out.println("该图有毒");
			return false;
		} else
		    return true;
	}
	
	public static void main(String[] args) {
		LinkedGraph g = new LinkedGraph(6, 2);
		int [][]b = {{0,2},{1,2},{1,3},{1,4},{2,3},{2,5},{3,5},{4,5}};
		EdgeElement[] dd = new EdgeElement[b.length];
		for(int i = 0; i<b.length; i++) {
			dd[i] = new EdgeElement(b[i][0], b[i][1]);
		}
		g.createGraph(dd);
		g.output();
		int [] a = new int [g.vertices()];
		if (TopoSort(g, a)) {
			System.out.println("拓扑序列为：");
			for (int i = 0; i<g.vertices();i++)
				System.out.print(a[i]+" ");
			System.out.println();
		}else
			System.out.println("排序失败");
	}
	

}
