package com.nc.Stack;

public class SequenceStack implements Stack {

	final int minSize = 10;
	private Object[] stackArray;
	private int top;
	
	public SequenceStack()
	{
		top  = -1;
		stackArray = new Object[minSize];
	}
	
	public SequenceStack( int n)
	{
		if (n<minSize) n=minSize;
		
		top  = -1;
		stackArray = new Object[n];
	}
	
	@Override
	public void push(Object obj) {
		if (top==stackArray.length) {
			Object [] x = new Object [2*stackArray.length];
			for (int i = 0; i < stackArray.length; i++) {
				x[i] =	stackArray[i];
			}
			stackArray = x;
		}
		top++;
		stackArray[top] = obj;

	}

	@Override
	public Object pop() {
		if (top == -1)
			return null;
		top --;
		return stackArray[top+1];
	}

	@Override
	public Object peek() {
		if (top == -1) return null;
		
		return stackArray[top];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top == -1;
	}

	@Override
	public void clear() {
		top = -1;
	}

}
