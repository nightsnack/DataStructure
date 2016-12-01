package com.nc.Graph;

import java.util.ArrayList;

public class LinkedGraph implements Graph {

	private int n; //vertex
	private int e; //Edge
	private int type; 
	private EdgeNode []a;
	public EdgeNode[] getArray() {return a;}
	
	public LinkedGraph (int n, int t)
	{
		if (n<1 || t<0 || t>3) {
			System.out.println("Initialize error,wrong varibles");
			System.exit(1);
		}
		this.n = n;
		this.e = 0;
		this.type = t;
		a = new EdgeNode[n];
		for (int i = 0; i < n; i++) {
			a[i] = null;
		}
	}
	
	@Override
	public boolean createGraph(EdgeElement[] d) {
		// TODO Auto-generated method stub
		for (int i = 0; i < d.length; i++) {
			if (d[i]==null) {
				System.out.println("Edge set is empty");
				System.exit(1);
			}
			int v1,v2;
			v1 = d[i].fromvex;
			v2 = d[i].endvex;
			if (v1<0 ||v1>n-1 || v2<0 ||v2>n-1 || v1==v2) {
				System.out.println("vertex is invalid");
				return false;
			}
			EdgeNode p = a[v1];
			while (p!=null) {
				if(p.adjvex!=v2)
					p = p.next;
				else {
					System.out.println("Edge has already existed!");
					return false;
				}
			}
			if (type == 0) {
				a[v1] = new EdgeNode(v2, a[v1]);
				a[v2] = new EdgeNode(v1, a[v2]);
			}
			else if (type == 1) {
				a[v1] = new EdgeNode(v2, d[i].weight, a[v1]);
				a[v2] = new EdgeNode(v1, d[i].weight, a[v2]);
			}
			else if (type == 2) {
				a[v1] = new EdgeNode(v2, a[v1]);
			}
			else
				a[v1] = new EdgeNode(v2, d[i].weight, a[v1]);
		}
		e = d.length;
		return true;
	}

	@Override
	public int graphType() {
		// 类型
		return type;
	}

	@Override
	public int vertices() {
		// 顶点数
		return n;
	}

	@Override
	public int edges() {
		// 边数
		return e;
	}

	
	@Override
	public boolean find(int i, int j) {
		if(i<0||i>n-1||j<0||j>n-1||i==j) {
			System.out.println("编号无效，退出");
			System.exit(0);
		}
		EdgeNode p = a[i];
		while (p!=null) {
			if(p.adjvex == j) return true;
			p = p.next;
		}
		return false;
	}

	@Override
	public boolean putEdge(EdgeElement theEdge) {
		int v1,v2;
		v1 = theEdge.fromvex;v2 = theEdge.endvex;
		if(v1<0||v1>n-1||v2<0||v2>n-1||v1==v2) {
			System.out.println("边顶点序号无效，退出");
			System.exit(1);
		}
		EdgeNode p = a[v1];
		while (p!=null) {
			if (p.adjvex == v2)
				break;
			p = p.next;
		}
		if (p == null)
			e++;
		else {
			System.out.println("alerady Exist");
		}
		if(type == 0) {
			a[v1] = new EdgeNode(v2, a[v1]);
			a[v2] = new EdgeNode(v1, a[v2]);
		}else if (type == 1) {
			a[v1] = new EdgeNode(v2, theEdge.weight, a[v1]);
			a[v2] = new EdgeNode(v1, theEdge.weight, a[v2]);
		}
		else if (type == 2) {
			a[v1] = new EdgeNode(v2, a[v1]);
		}
		else
			a[v1] = new EdgeNode(v2, theEdge.weight, a[v1]);
		
		return true;
	}

	@Override
	public boolean removeEdge(int i, int j) {
		// TODO Auto-generated method stub
		if (i<0 || i>n-1 || j<0 || j>n-1 || i==j) {
			System.out.println("顶点序号无效");
			System.exit(1);
		}
		EdgeNode p = a[i], q = null;
		while (p != null) {
			if (p.adjvex == j) break;
			q = p;p = p.next;
		}
		
		if (p == null) {
			System.out.println("Edge prepared to delete do not exist!");
			return false;
		}
		
		if(q == null)
			a[i] = a[i].next;
		else 
			q.next = p.next;
		
		if (type==0 || type == 1) {
			EdgeNode p1 = a[j],q1 =null;
			while (p1!=null) {
				if (p1.adjvex == i)  break;
				q1 = p1;p1 = p1.next;
			}
			if (q1 == null)
				a[j] = a[j].next;
			else
				q1.next = p1.next;
		}
		e--;
		return true;
	}

	@Override
	public int degree(int i) {
		// TODO Auto-generated method stub
		if (i<0 || i>n-1) {
			System.out.println("vertex varible is invalid!");
			System.exit(1);
		}
		int k = 0;
		if (type == 0 ||type ==1 ) {
			EdgeNode p = a[i];
			while (p!= null) {
				p = p.next;
				k++;
			}
			return k;
		}
		else
			return inDegree(i)+outDegree(i);
	}

	@Override
	public int inDegree(int i) {
		if (i<0 || i>n-1) {
			System.out.println("vertex varible is invalid!");
			System.exit(1);
		}
		
		if (type == 0 ||type ==1 ) {
			return degree(i);
		}
		int k = 0;
		for (int j = 0; j < n; j++) {
			EdgeNode p = a[j];
			while (p!=null) {
				if(p.adjvex == i)
					k++;
				p = p.next;
			}
		}
		return k;
	}

	@Override
	public int outDegree(int i) {
		if (i<0 || i>n-1) {
			System.out.println("vertex varible is invalid!");
			System.exit(1);
		}
		int k=0;
		EdgeNode p = a[i];
		while (p != null) {
			k++;
			p = p.next;
		}
		return k;
	}

	@Override
	public void output() {
		// TODO Auto-generated method stub
		int i,j;
		System.out.print("V={");
		for (i = 0; i<n-1; i++ ) System.out.print(i+ ",");
		System.out.println(n-1+"}");
		System.out.print("E={");
		for (i=0; i<n; i++) {
			EdgeNode p = a[i];
			while (p!=null) {
				j = p.adjvex;
				switch (type) {
				case 0:
					if(i<j) System.out.print("("+i+","+j+"),");
					break;
				case 1:
					System.out.print("("+i+","+j+")"+p.weight+",");
					break;
				case 2:
					if (i<j) System.out.print("<"+i+","+j+">,");
					break;
				case 3:
					System.out.print("<"+i+","+j+">"+p.weight+",");
					break;
				}
				p = p.next;	
			}
		}
		System.out.println("}");
	}

	/**
	 * DRIVE
	 * @param v 开始节点号
	 */
	@Override
	public void depthFirstSearch(int v) {
		boolean[] visited = new boolean[n];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		dfs(v,visited);
		System.out.println();
		
	}
	
	/**
	 * WORK
	 * @param i	节点
	 * @param visited	标记数组
	 */
	private void dfs(int i,boolean[] visited) {
		System.out.print(i+" ");
		visited[i] = true;
		EdgeNode p = a[i];
		while(p!=null) {
			int j = p.adjvex;
			if (!visited[j])
				dfs(j, visited);
			p = p.next;
		}
	}
	
	/**
	 * DRIVE
	 * @param v 开始节点号
	 */
	@Override
	public void breadthFirstSearch(int v) {
		boolean[] visited = new boolean[n];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		bfs(v,visited);
		System.out.println();
		
	}
	
	/**
	 * WORK
	 * @param i	节点
	 * @param visited	标记数组
	 */
	private void bfs(int i,boolean[] visited) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		System.out.print(i+" ");
		visited[i] = true;
		arrayList.add(i);
		while(!arrayList.isEmpty()) {
			int k = arrayList.get(0);
			arrayList.remove(0);
			EdgeNode p = a[k];
			while (p!=null) {
				int j = p.adjvex;
				if (!visited[j]) {
					System.out.print(j+" ");
					visited[j]=true;
					arrayList.add(j);
				}
				p = p.next;
			}
				
		}
	}


	@Override
	public void clearGraph() {
		// TODO Auto-generated method stub
		n = e = type=0;a=null;

	}

}
