package com.nc.Tree;

public class BTreeNode {
	Object element;
	
	BTreeNode left,right;
	
	public BTreeNode(Object element) {
		this.element = element;
		left = right = null;
	}
	
	public BTreeNode(Object element,BTreeNode left, BTreeNode right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}
}
