package com.nc.BinarySearchTree;

import com.nc.Tree.BinaryTree;

public interface BinarySearchTree extends BinaryTree {
	/**
	 * 从二叉搜索树中查找obj的节点
	 * @param obj
	 * @return 存在则返回
	 */
	Object find(Object obj);
	
	/**
	 * 从二叉搜索树更新值为obj的结点。
	 * @param obj
	 * @return 若更新成功则返回原值，否则返回空
	 */
	Object update(Object obj);
	
	/**
	 * 插入，插入后仍为一棵二叉树
	 * @param obj
	 * @return 成功返回真 若碰到相同节点假定不需要插入，认为是插入失败返回假
	 */
	boolean insert(Object obj);
	
	/**
	 * 从二叉树中删除值为obj的结点
	 * @param obj
	 * @return
	 */
	boolean delete(Object obj);
	
	/**
	 * 按照关键字大小次序遍历输出一棵二叉搜索树中所有结点的值
	 */
	void ascend();
	
}
