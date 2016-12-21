package com.nc.BinarySearchTree;

import com.nc.Tree.BTreeNode;
import com.nc.Tree.LinkBinaryTree;

public class LinkBinarySearchTree extends LinkBinaryTree implements BinarySearchTree {

	public LinkBinarySearchTree() {
		super();
	}
	
	public LinkBinarySearchTree(BTreeNode st) {
		super(st);
	}
	
	@Override
	public Object find(Object obj) {
		if(root == null) return null;
		BTreeNode st = root;
		while (st != null) {
			if (((Comparable)obj).compareTo(st.element) == 0)
				return st.element;
			else if(((Comparable)obj).compareTo(st.element)<0)
				st = st.left;
			else
				st = st.right;
		}
		return null;
	}

	@Override
	public Object update(Object obj) {
		if (root == null) return null;
		BTreeNode st = root;
		while (st != null) { 
			if (((Comparable)obj).compareTo(st.element) == 0) {
				Object x = st.element;
				st.element = obj;
				return x;
			}
			else if (((Comparable)obj).compareTo(st.element) < 0)
				st = st.left;
			else st = st.right;
		}
		return null;
	}

	@Override
	public boolean insert(Object obj) {
		BTreeNode st = root, pt = null;
		while (st!= null) {
			pt = st;
			if (((Comparable)obj).compareTo(st.element) == 0)
				return false;
			else if(((Comparable)obj).compareTo(st.element)<0)
				st = st.left;
			else
				st = st.right;
		}
		BTreeNode s = new BTreeNode(obj);
		if (pt == null) root = s;
		else if (((Comparable)obj).compareTo(st.element)<0)
			pt.left = s;
		else 
			pt.right = s;
		return true;
	}

	@Override
	public boolean delete(Object obj) {
		if (root == null) 
			return false;
		BTreeNode st = root, pt = null;
		while (st != null) {
			if (((Comparable)obj).compareTo(st.element) == 0)
				break;
			else if(((Comparable)obj).compareTo(st.element)<0) {
				pt = st;
				st = st.left;
			}
			else {
				pt = st;
				st = st.right;
			}
		}
		if(st == null) {	//没找到删除的节点
			return false;
		}
		if(st.left == null && st.right == null) {
			if(st == root) root = null;
			else if(pt.left == st) pt.left = null;
			else pt.right = null;
		}
		else if (st.left == null || st.right == null)
		{
			if(st == root) {
				if (st.left == null)
					root = st.right;
			}
			else
				root = st.left;
		}
			
		return false;
	}

	@Override
	public void ascend() {
		// TODO Auto-generated method stub

	}

}
