package com.nc.Tree;

import com.nc.Queue.LinkQueue;
import com.nc.Queue.Queue;
import com.nc.Stack.SequenceStack;
import com.nc.Stack.Stack;

public class LinkBinaryTree implements BinaryTree {
	
	protected BTreeNode root;
	
	public LinkBinaryTree() {
		root = null;
	}
	
	public LinkBinaryTree (BTreeNode rt) {
		root = rt;
	}

	@Override
	public boolean CreateBTree(String st) {
		Stack sck = new SequenceStack();
		root  = null;
		BTreeNode p = null;
		int k = 1;
		char [] a = st.toCharArray();
		for (int i = 0; i < a.length; i++) {
			switch (a[i]) {
			case ' ':
				break;
			case '(':
				sck.push(p);
				k = 1;
				break;
			case ',':
				k = 2;
				break;
			case ')':
				if(sck.isEmpty()) {
					System.out.println("广义表字符有误，缺了前括号");
					return false;
				}
				sck.pop();
				break;
			default:
//				if (a[i]>='a'&&a[i]<='a' || a[i]>='A'&& a[i]<='Z') {
					p = new BTreeNode(a[i]);
					if (root == null) root = p;
					else {
						BTreeNode x = (BTreeNode) sck.peek();
						if(k == 1)
							x.left = p;
						else
							x.right = p;
					}
//				}
//				else {
//					System.out.println("输入字符错误");
//					return false;
//				}
				break;
			}
			
		}
		if (sck.isEmpty())
			return true;
		else
			return false;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public void traverseBTree(String s) {
		if(s.equals("preOrder")) preOrder(root);
		else if (s.equals("inOrder")) inOrder(root);
		else if (s.equals("postOrder")) postOrder(root);
		else if (s.equals("levelOrder")) levelOrder(root);
		else if (s.equals("levelOrder1")) levelOrder1(root);
		System.out.println();
	}
	
	private void preOrder(BTreeNode rt)
	{
		if(rt!=null)
		{
			System.out.print(rt.element + " ");
			preOrder(rt.left);
			preOrder(rt.right);
		}
	}
	
	private void inOrder(BTreeNode rt) {
		if(rt != null) {
			inOrder(rt.left);
			System.out.print(rt.element+" ");
			inOrder(rt.right);
		}
	}
	
	private void postOrder(BTreeNode rt) {
		if (rt != null) {
			inOrder(rt.left);
			inOrder(rt.right);
			System.out.print(rt.element+" ");
		}
	}
	
	private void levelOrder(BTreeNode rt) {
		Queue que = new LinkQueue();
		que.enter(rt);
		while (!que.isEmpty()) {
			BTreeNode btx = (BTreeNode) que.leave();
			System.out.print(btx.element);
			if (btx.left!=null) que.enter(btx.left);
			if (btx.right!=null) que.enter(btx.right);
		}
	}
	
	private void levelOrder1(BTreeNode rt) {
		int depth = this.depthBTree();
		for (int i = 0; i < depth; i++) {
			levelVisit(root,i);
		}
		System.out.println();
	}
	
	private void levelVisit(BTreeNode rt, int level) {
		if(rt == null || level < 0) return;
		if(level == 0) System.out.print(rt.element+ " ");
		levelVisit(rt.left, level-1);
		levelVisit(rt.right, level-1);
	}

	@Override
	public Object findBTree(Object obj) {
		return findBTreeNode(root, obj);
	}
	
	private Object findBTreeNode(BTreeNode rt, Object x) {
		if (rt == null) return null;
		else { 
			if(rt.element.equals(x))
				return rt.element;
			else {
				Object y;
				y = findBTreeNode(rt.left, x);
				if (y!= null) return y;
				y = findBTreeNode(rt.right, x);
				if (y!= null )	 return y;
				return null;
			}
		}
	}

	@Override
	public int depthBTree() {
		return depthBTree(root);
	}
	
	private int depthBTree( BTreeNode rt) {
		if (rt == null) {
			return 0;
		}
		else {
			int dep1 = depthBTree(rt.left);
			int dep2 = depthBTree(rt.right);
			if (dep1 > dep2) 
				return dep1+1;
			else 
				return dep2+1;
		}
	}

	@Override
	public int countBtree() {
		return countBTree(root);
	}
	
	private int countBTree(BTreeNode rt) {
		if(rt == null) return 0;
		else return countBTree(rt.left)+countBTree(rt.right)+1;
	}
	
	@Override
	public void printBTree() {
		printBTree(root);
		System.out.println();
	}

	public void printBTree(BTreeNode rt) {
		if (rt != null) {
			System.out.print(rt.element);
			if (rt.left != null || rt.right != null) {
				System.out.print("(");
				printBTree(rt.left);
				if (rt.right!= null)
					System.out.print(',');
				printBTree(rt.right);
				System.out.print(")");
			}
		}
	}

	@Override
	public void clearBTree() {
		root = null;
	}
	
	
//	@Override
//	public void freeBTree(BTreeNode rt) {
//		if (rt == null)
//			return;
//		if(rt.left!= null) {
//			freeBTree(rt.left);
//		}
//		if (rt.right != null) {
//			freeBTree(rt.right);
//		}
//		if (rt != null) {
//			rt = null;
//		}
//	}
	
	public LinkBinaryTree copyTreeDrive() {
		BTreeNode newroot = copyTree(root);
		LinkBinaryTree newTree = new LinkBinaryTree(newroot);
		return newTree;
	}
	
	public BTreeNode copyTree(BTreeNode rt) {
		
		BTreeNode nLtree = null;
		BTreeNode nRtree = null;
		if (rt == null)
			return null;
		if (rt.left != null) {
			nLtree = copyTree(rt.left);
		}
		else 
			nLtree = null;
		if (rt.right != null) {
			nRtree = copyTree(rt.right);
		}
		else 
			nRtree = null;
		BTreeNode nTree = new BTreeNode(rt.element, nLtree, nRtree);
		
		return nTree;
	}
	
	public void exchange () {
		exchange(root);
	}
	
	private void exchange (BTreeNode rt) {
		if(rt == null)
			return;
		else {
			exchange(rt.left);
			exchange(rt.right);
		}
		BTreeNode tempTree = rt.left;
		rt.left = rt.right;
		rt.right = tempTree;
	}

}
