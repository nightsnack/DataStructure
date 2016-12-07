package com.nc.Graph;

public class Excute1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph ga = new LinkedGraph(5,3);
		int [][]a = {{0,1,2},{0,2,3},{0,3,8},{1,3,12},{2,0,6},{2,3,6},{2,4,1},{3,4,4}};//邻接矩阵输入
		EdgeElement []dd = new EdgeElement[a.length];
		for (int i = 0; i < a.length; i++) {
			dd[i] = new EdgeElement(a[i][0], a[i][1],a[i][2]);
		}
		if (ga.createGraph(dd)) {
			System.out.println("Create Successful!");
		} else {
			System.out.println("Create Failed!");
			System.exit(1);
		}
		System.out.println("Output the vertex set and edge set:");
		ga.output();
		System.out.println("DepthFirstSearch from start vertex 0: ");
		ga.depthFirstSearch(0);
		System.out.println("bredthFirstSearch from start vertex 0: ");
		ga.breadthFirstSearch(0);
		System.out.println("Degree  inDegree  outDegree of the Point 0");
		System.out.println(ga.degree(0)+" "+ga.inDegree(0)+" "+ga.outDegree(0));
		if (ga.putEdge(new EdgeElement(4, 1, 5)))
			System.out.println("Enter <4,1>5 successfully!");
		else 
			System.out.println("Enter failed!");
		if (ga.removeEdge(0, 2))
			System.out.println("Remove <0,2> successfully!");
		else 
			System.out.println("Remove failed!");
		if (ga.find(3, 4))
			System.out.println("Find successfully");
		else 
			System.out.println("Do not exist");
		System.out.println("Output the vertex set and edge set again:");
		ga.output();
		System.out.print("type,vertex num and edge num of Graph 'ga':");
		System.out.println(ga.graphType()+" "+ga.vertices()+" "+ga.edges());


	}

}
