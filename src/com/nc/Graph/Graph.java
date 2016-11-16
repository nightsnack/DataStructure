package com.nc.Graph;
//接口
public interface Graph {
	boolean createGraph(EdgeElement[]d);  //根据边集数组参数d建立一个图
    int graphType();                   //返回图的类型
    int vertices();                    //返回图中的顶点数
    int edges();                       //返回图中的边数
    boolean find(int i, int j);        //从图中查找一条边(i,j)是否存在
    boolean putEdge(EdgeElement theEdge); //向图中插入一条边theEdge
    boolean removeEdge(int i, int j);     //从图中删除一条边(i,j)
    int degree(int i);                 //返回顶点i的度
    int inDegree(int i);               //返回顶点i的入度
    int outDegree(int i);              //返回顶点i的出度
    void output();                     //以图的顶点集和边集的形式输出一个图
    void depthFirstSearch(int v);      //从顶点v开始深度优先搜索遍历图
    void breadthFirstSearch(int v);    //从顶点v开始广度优先搜索遍历图
    void clearGraph();                 //清除图中的所有内容
}
