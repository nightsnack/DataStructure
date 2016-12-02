package com.nc.Queue;

import com.nc.Set.Node;

public class LinkQueue implements Queue {
	
	private Node front,rear;
	
	public LinkQueue() {
		front = rear = null;
	}

	@Override
	public void enter(Object obj) {
		if (rear == null)
			front = rear = new Node(obj,null);
		else 
			rear = rear.next = new Node(obj, null);

	}

	@Override
	public Object leave() {
		if (front == null) {
			return null;
		}
		Node x = front;
		front = front.next;
		if (front == null) rear = null;
		return x.element;
	} 

	@Override
	public Object peek() {
		if (front == null) {
			return null;
		}
		return front.element;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front == null;
	}

	@Override
	public void clear() {
		front = rear = null;
	}

}
