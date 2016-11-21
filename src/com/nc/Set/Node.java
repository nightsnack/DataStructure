package com.nc.Set;

public class Node {
	public Object element;
	public Node next;
	public Node(Node nt) {next = nt;}
	public Node(Object obj,Node nt) {
		element = obj;
		next = nt;
	}
}
