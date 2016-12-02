package com.nc.Queue;

public class MainQueue {
	public static void main (String[] args) {
		Queue que = new LinkQueue();
		int [] a = {67,3,4,5,777,6,6,6,7,7,3,4,7,8,6,6};
		for (int i = 0; i< a.length; i++) {
			que.enter(a[i]);
		}
		System.out.print(que.leave()+" ");
		System.out.print(que.leave()+" ");
		que.enter(68);
		System.out.print(que.peek()+" ");
		System.out.println(que.leave());
		while(!que.isEmpty())System.out.print(que.leave()+" ");
		System.out.println();
		que.clear();

	}
}
