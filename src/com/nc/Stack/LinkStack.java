package com.nc.Stack;

import com.nc.Set.Node;

public class LinkStack implements Stack {
	private Node top;
	
	public LinkStack() {
		top = null;
	}

	@Override
	public void push(Object obj) {
		top = new Node(obj, top);
	}

	@Override
	public Object pop() {
		if (top == null) return null;
		Object x = top.element;
		top = top.next;
		return x;
	}

	@Override
	public Object peek() {
		if (top == null) return null;
		Object x = top.element;
		return x;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top == null;
	}

	@Override
	public void clear() {
		top = null;
	}

}
