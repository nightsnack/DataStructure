package com.nc.Tree;

public class BTreeNode {
	public Object element;
	public BTreeNode left;
	public BTreeNode right;
	
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
