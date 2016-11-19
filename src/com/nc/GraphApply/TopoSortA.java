package com.nc.GraphApply;

import com.nc.Graph.EdgeElement;
import com.nc.Graph.EdgeNode;
import com.nc.Graph.LinkedGraph;

public class TopoSortA {
	

	public static boolean TopoSort(LinkedGraph gr, int[] a) {
		int i,j,k,top,m = 0;
		int n = gr.vertices();
		EdgeNode p, b[] =gr.getArray();
		int[] d = new int [n];
		for(i = 0; i<n; i++) {
			d[i]=0;
		}
		for (i = 0; i<n; i++) {
			p = b[i];
			while (p!=null) {
				j = p.adjvex;
				d[j]++;
				p = p.next;
			}
		}
		
		top = -1;
		for(i = 0; i<n;	i++) {
			if(d[i]==0)
			{
				d[i] = top;
				top = i;
			}
		}
		
		while (top!=-1) {
			j = top;
			top = d[top];
			
			a[m] = j;
			m++;
			p = b[j];
			while (p!=null) {
				k = p.adjvex;
				d[k]--;
				if(d[k] == 0) {
					d[k] = top;
					top = k;
				}
				p = p.next;
			}
		}
		if (m<n) {
			System.out.println("有回路无拓扑序列");
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
