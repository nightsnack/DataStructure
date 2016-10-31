package com.nc.Graph;

public class EdgeElement {
	int fromvex; //起点域
	int endvex; //终点域
	int weight; //权重
	
	public EdgeElement(int fromvex, int endvex) {
		super();
		this.fromvex = fromvex;
		this.endvex = endvex;
	}

	public EdgeElement(int fromvex, int endvex, int weight) {
		super();
		this.fromvex = fromvex;
		this.endvex = endvex;
		this.weight = weight;
	}
	
	

}
