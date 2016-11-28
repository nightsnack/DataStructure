package com.nc.Stack;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack sck = new SequenceStack();
//		Stack sck1 = new LinkStack();
		int[] a = {3,8,5,17,9,30,15,22};
		for(int i = 0; i<a.length; i++) sck.push(a[i]);
		System.out.println(sck.pop()+" " +sck.pop()+" "+sck.peek());
		sck.push(68);
		while (!sck.isEmpty()){ 
			System.out.println(sck.pop());
		}
		sck.clear();
	}
	
}
