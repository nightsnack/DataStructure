package com.nc.Graph;

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
		this.n = n;
		this.type = type;
		this.a = new int[n][n];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (i==j) {
					a[i][j] = 0;
				}
				else if (type == 0||type == 2) {
					a[i][j] = 0;
				} else {
					a[i][j] = this.Maxvalue;
				}
			}
		}
	}

	public boolean createGraph(EdgeElement[] d) {
		for (int i = 0; i < d.length; i++) {
			if (d[i]==null) {
				System.out.println("边集中元素为空");
				return false;
			}
		}
	}


	@Override
	public void output() {
		// TODO Auto-generated method stub
		

	}

}
