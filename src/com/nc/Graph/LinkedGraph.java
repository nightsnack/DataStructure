package com.nc.Graph;

public class LinkedGraph implements Graph {

	private int n; //vertex
	private int e; //Edge
	private int type; 
	private EdgeNode []a;
	public EdgeNode[] getArray() {return a;}
	
	public LinkedGraph (int n, int t)
	{
		if (n<1 || t>0 || t>3) {
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int vertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean find(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean putEdge(EdgeElement theEdge) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeEdge(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int degree(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inDegree(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int outDegree(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void output() {
		// TODO Auto-generated method stub

	}

	@Override
	public void depthFirstSearch(int v) {
		// TODO Auto-generated method stub

	}

	@Override
	public void breadthFirstSearch(int v) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearGraph() {
		// TODO Auto-generated method stub

	}

}
