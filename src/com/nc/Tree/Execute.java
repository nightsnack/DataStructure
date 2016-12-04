package com.nc.Tree;

public class Execute {
	public static void main (String[] args) {
		BinaryTree btree = new LinkBinaryTree();
		boolean yy = btree.CreateBTree("a(b(c),d(e(f,g),h,(,i)))");
		if (!yy) {
			System.out.println("建树错误");
			System.exit(1);
		}
		System.out.println("输出二叉树广义表：");
		btree.printBTree();
		System.out.println("前序：");
		btree.traverseBTree("preOrder");
		System.out.println("中序：");
		btree.traverseBTree("inOrder");
		System.out.println("后序：");
		btree.traverseBTree("postOrder");
		System.out.println("非递归层次：");
		btree.traverseBTree("levelOrder");
		System.out.println("递归层次：");
		btree.traverseBTree("levelOrder1");
		System.out.println("深度："+btree.depthBTree());
		System.out.println("节点数："+btree.countBtree());
		System.out.println("查找节点："+btree.findBTree('g')+" "+btree.findBTree('G'));
		
		BinaryTree newbtree = btree.copyTreeDrive();
		System.out.println("拷贝后二叉树广义表：");
		newbtree.printBTree();
		newbtree.exchange();
		System.out.println("交换后二叉树广义表：");
		newbtree.printBTree();
		btree.clearBTree();
		newbtree.clearBTree();
	}

}
