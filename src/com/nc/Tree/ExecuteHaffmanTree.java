package com.nc.Tree;

public class ExecuteHaffmanTree {
	public static void main (String[] args) {
		char[] c ={'A','B','C','D','E','F'}; 
		Integer [] a= {4,2,6,8,3,1};
		HuffmanTree hfmt = new HuffmanTree();
		hfmt.createHuffmanTree(c ,a);
		System.out.println("输出二叉树广义表：");
		hfmt.printBTree();
		System.out.println("前序：");
		hfmt.traverseBTree("preOrder");
		System.out.println("中序：");
		hfmt.traverseBTree("inOrder");
		System.out.println("后序：");
		hfmt.traverseBTree("postOrder");
		int len = hfmt.weightPathLength(0);
		System.out.println("哈夫曼树带权路径长度："+len);
		hfmt.outputHuffmanCoding();
		System.out.println("译码");
		hfmt.decode();
	}
}
