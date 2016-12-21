package com.nc.Tree;

public interface BinaryTree {
	/**
	 * 根据广义表建立二叉树
	 * @param st
	 * @return
	 */
	boolean CreateBTree(String st);
	
	/**
	 * 判空
	 * @return
	 */
	boolean isEmpty();
	
	/**
	 * 按照所给的字符串顺序遍历二叉树,包含层次遍历（递归非递归）先序、中序、后续遍历
	 * @param s
	 */
	void traverseBTree(String s);
	
	/**
	 * 从二叉树查找值为0bj的节点，存在则返回值否则返回空
	 * @param obj
	 * @return
	 */
	Object findBTree(Object obj);
	
	/**
	 * 返回深度
	 * @return
	 */
	int depthBTree();
	
	/**
	 * 节点数
	 * @return
	 */
	int countBtree();
	
	/**
	 * 按照广义表的方式打印二叉树
	 */
	void printBTree();
	
	/**
	 * 清除二叉树
	 */
	void clearBTree();

	/**
	 * 递归复制
	 * @return 返回复制后的新树
	 */
	BinaryTree copyTreeDrive();

	/**
	 * 交换左右子树
	 */
	void exchange();
	
}
