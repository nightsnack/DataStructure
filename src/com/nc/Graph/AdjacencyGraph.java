package com.nc.Graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
//邻接矩阵
public class AdjacencyGraph implements Graph {
	final static int Maxvalue = 1000;
	private int n;  //顶点数
	private int e; //边数
	private int type;  //类型0123
	private int[][] a; //邻接矩阵
	
	public int[][] getA() {
		return a;
	}
	
	/**
	 * 构造函数
	 * @param n 邻接矩阵的维度
	 * @param type 图的类型 0123表示无向无权/无有/有无/有有
	 */

	public AdjacencyGraph(int n, int type) {
		super();
		if (n<1 || type<0 || type>3) {
			System.out.println("输入参数有误");
			System.exit(1);
		}
		this.n = n;
		this.e = 0;
		this.type = type;
		this.a = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i==j) {
					a[i][j] = 0;
				}
				else if (type == 0||type == 2) {
					a[i][j] = 0;
				} else {
					a[i][j] = AdjacencyGraph.Maxvalue;
				}
			}
		}
	}

	@Override
	public boolean createGraph(EdgeElement[] d) {
		for (int i = 0; i < d.length; i++) {
			if (d[i]==null) {
				System.out.println("边集中元素为空");
				return false;
			}
			int v1 = d[i].fromvex;
			int v2 = d[i].endvex;
			if (v1<0||v1>n-1||v2<0||v2>n-1||v1==v2) {
				System.out.println("wrong input");
				return false;
			}
			if (a[v1][v2]!=0&&a[v1][v2]!=Maxvalue) {
				System.out.println("Duplicate");
				return false;
			}
			switch (type) {
			case 0:
				a[v1][v2] = a[v2][v1] = 1;
				break;
			case 1:
				a[v1][v2] = a[v2][v1] = d[i].weight;
				break;
			case 2:
				a[v1][v2] = 1;
				break;
			case 3:
				a[v1][v2] = d[i].weight;
				break;
			}
		}
		e = d.length;
		return true;
	}
	
	public void verify(int i,int j) {
		if(i<0||i>n-1||j<0||j>n-1||i==j) {
			System.out.println("编号无效，退出");
			System.exit(0);
		}
		
	}
	
	/**
	 * 查找从i节点到j节点的边是否存在
	 * @param i
	 * @param j
	 * @return
	 */
	@Override
	public boolean find(int i,int j) {
		this.verify(i,j);
		if (a[i][j]!=0&&a[i][j]!=AdjacencyGraph.Maxvalue) {
			return true;
		}
		return false;
	}

	/**
	 * 删除边
	 * @param i
	 * @param j
	 * @return
	 */
	@Override
	public boolean removeEdge(int i,int j) {
		this.verify(i, j);
		if (a[i][j]==0||a[i][j]==AdjacencyGraph.Maxvalue) {
			System.out.println("不存在此边");
			System.exit(0);
		}
		switch (type) {
		case 0:
			a[i][j] = a[j][i] = 0;
			break;
		case 1:
			a[i][j] = a[j][i] = Maxvalue;
			break;
		case 2:
			a[i][j] = 0;
			break;
		case 3:
			a[i][j] = Maxvalue;
			break;
		}
		e--;
		return true;
	}

	@Override
	public int degree(int i) {
		if (i<0 ||i> n-1) {
			System.out.println("编号无效，退出");
			System.exit(0);
		}
		int k = 0;
		if (type == 0 || type == 1) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] != 0 && a[i][j] != Maxvalue) {
					k++;
				}
			}
			return k;
		}
		else {
			return inDegree(i)+outDegree(i);
		}
	}
	
	//求顶点入度
	@Override
	public int inDegree(int i) {
		if (i<0 ||i> n-1) {
			System.out.println("编号无效，退出");
			System.exit(0);
		}
		if (type == 0 || type == 1) {
			return degree(i);
		}
		int k = 0;
		for (int j = 0; j < n; j++) {
			if (a[j][i]!=0&&a[j][i]!=Maxvalue) {
				k++;
			}
		}
		return k;
	}
	
	//出度
	@Override
	public int outDegree(int i) {
		if (i<0 ||i> n-1) {
			System.out.println("编号无效，退出");
			System.exit(0);
		}
		if (type == 0 || type == 1) {
			return degree(i);
		}
		int k = 0;
		for (int j = 0; j < n; j++) {
			if (a[i][j]!=0&&a[i][j]!=Maxvalue) {
				k++;
			}
		}
		return k;
	}
	

	public void output1() {
		List<Integer> point = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			point.add(i);
		}
		for (int i = a.length-1; i >= 0; i--) {         //防止有顶点不联通的
			int flag = 0;
			for (int j = 0; j < i; j++) {
				if (i!=j&&a[i][j] != 0&&a[i][j] != Maxvalue) 
					flag++;
			}
			if (flag == 0) {
				point.remove(i);
			}
		}
		System.out.print("V={");
		Iterator<Integer> ir = point.iterator();
		while (ir.hasNext()) {
			System.out.print(ir.next()+" ");
		}
		System.out.println("}");
	}
	

	@Override
	public void output() {
		int i,j;
		System.out.print("V={");
		for (i = 0; i < n-1; i++) {
			System.out.print(i+",");
		}
		System.out.println(n-1+"}");
		System.out.print("E={");
		if (type==0||type==2) {
			for (i = 0; i < n; i++) 
				for (j = 0; j<n; j++) 
					if (a[i][j]!=0&&a[i][j]!=Maxvalue)
						if (type == 0) {
							if (i<j) System.out.print("("+i+","+j+"),");
						} else 
							System.out.print("<"+i+","+j+">,");
		} 
		else {
			for(i=0; i<n; i++)	
				for (j=0; j<n; j++)
					if (a[i][j]!=0&&a[i][j]!=Maxvalue)
						if(type==1) {
							if (i<j) System.out.print("("+i+","+j+")"+a[i][j]+",");
						}
						else
							System.out.print("<"+i+","+j+">"+a[i][j]+",");
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
		for(int j = 0; j<n; j++) {
			if(a[i][j]!=0&&a[i][j]!=Maxvalue&&visited[j]==false) {
				dfs(j,visited);
			}
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
			for (int j = 0; j<n; j++) {
				if(a[k][j]!=0&&a[k][j]!=Maxvalue&&!visited[j]) {
					System.out.print(j+" ");
					visited[j]=true;
					arrayList.add(j);
				}
			}
				
		}
	}

	@Override
	public int graphType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public int vertices() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public int edges() {
		// TODO Auto-generated method stub
		return e;
	}

	/**
	 * 向图插入一条边
	 */
	@Override
	public boolean putEdge(EdgeElement theEdge) {
		int v1,v2;
		v1 = theEdge.fromvex;v2 = theEdge.endvex;
		if(v1<0|| v1>n-1 || v2<0 || v2>n-1 || v1==v2) {
			System.out.println("边的顶点号无效，退出运行！");
			System.exit(1);
		}
		if (a[v1][v2]==0 || a[v1][v2]==Maxvalue)
			e++;
		else {
			System.out.println("Edge has already Exist");
			return false;
		}
		if (type == 0 || type == 1) {
			if (type==0)
				a[v1][v2] = a[v2][v1] = 1;
			else
				a[v1][v2] = a[v2][v1] = theEdge.weight;
		}
		else {
			if (type == 2)
				a[v1][v2] = 1;
			else
				a[v1][v2] = theEdge.weight;
		}
		return true;
	}

	@Override
	public void clearGraph() {
		// TODO Auto-generated method stub
		n=e=type=0; a=null; 
	}
	
}
