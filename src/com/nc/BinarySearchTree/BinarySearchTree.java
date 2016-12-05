package com.nc.BinarySearchTree;

import com.nc.Tree.BinaryTree;

public interface BinarySearchTree extends BinaryTree {
	/**
	 * 从二叉搜索树中查找obj的节点
	 * @param obj
	 * @return 存在则返回
	 */
	Object find(Object obj);
	Object update(Object obj);
	boolean insert(Object obj);
	boolean delete(Object obj);
	void ascend();
	
}
