package com.nc.HuffmanTree;

import com.nc.Tree.BTreeNode;

public class HuffmanTreeNode extends BTreeNode{
	Object element;
	Object weight;
	BTreeNode left,right;
	
	public HuffmanTreeNode(Object element,Object weight) {
		super(element);
//		this.element = element;
		this.weight = weight;
		left = right = null;
	}
	
	public HuffmanTreeNode(Object element,Object weight,BTreeNode left, BTreeNode right) {
		super(element);
//		this.element = element;
		this.weight = weight;
		left = right = null;
	}
}
