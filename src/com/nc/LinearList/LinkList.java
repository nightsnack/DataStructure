package com.nc.LinearList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import com.nc.Set.Node;

public class LinkList implements List {
	private Node head;
	private int len;
	
	public LinkList()
	{
		len = 0;
		head = new Node (null);
		head.next = head;
	}
	

	@Override
	public Object value(int pos) {
		Node p = head.next;
		for(int i = 1;i<pos;i++) {
			p = p.next;
		}
		
		return p.element;
	}

	@Override
	public boolean add(Object obj, int pos) {
		if (pos<1||pos>len+1) {
			System.out.println("Invalid input variables");
			return false;
		}
		Node p = head.next;
		Node q = head;
		for(int i = 1;i<pos;i++) {
			q = p;
			p = p.next;
		}
		Node r = new Node(obj,p);
		q.next = r;
		len++;
		return true;
	}

	@Override
	public Object remove(int pos) {
		if (pos<1 ||pos>len ) {
			System.out.println("invalid input!");
			return null;
		}
		Node p = head.next;
		Node q = head;
		for(int i = 1;i<pos;i++) {
			q = p;
			p = p.next;
		}
		q.next = p.next;
		len--;
		return p.element;
	}

	@Override
	public int find(Object obj) {
		int i;
		Node p = head.next;
		for (i = 1;i<=len;i++) {
			if(p.element.equals(obj))
				break;
			else
				p = p.next;
		}
		if (p==head) return -1;
		else return i;
	}

	@Override
	public boolean modify(Object obj, int pos) {
		if (pos<1||pos>len) {
			System.out.println("Invalid input variables");
			return false;
		}
		Node p = head.next;
		for(int i = 1;i<pos;i++) {
			p = p.next;
		}
		p.element = obj;
		return true;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return len == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return len;
	}

	@Override
	public void forward() {
		Node p = head.next;
		while (p!=head) {
			System.out.println(p.element.toString());
			p = p.next;
		}
	}

	@Override
	public void backward() {
		java.util.List<Object> julist = new ArrayList<>();
		
		Node p = head.next;
		while (p!=head) {
			System.out.println(p.element.toString());
			julist.add(p.element);
			p = p.next;
		}
		Collections.reverse(julist);
		Iterator<Object> itr = julist.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	@Override
	public void clear() {
		len = 0;
		head.next = head;
	}

	@Override
	public List sort() {
		// TODO Auto-generated method stub
		LinkList list = new LinkList();
		Node r = head.next;
		while (r != head) {
			Object x = r.element;
			Node p = list.head.next;
			Node q = list.head;
			while (p != list.head) {
				Object y = p.element;
				if (Integer.valueOf(x.toString())< Integer.valueOf(y.toString())) {
					break;
				}
				q = p;
				p = p.next;
				
			}
			q.next = new Node (x,p);
			list.len++;
			r= r.next;
		}
		return list;
	}
	
	public static void main (String [] args) {
		List list = new LinkList();
		int[] a = {20,16,38,42,29};
		for(int i = 0; i<a.length; i++) {
			list.add(a[i], i+1);
		}
		int n1 = (Integer)list.remove(2);
		list.add(80, 3);
//		list.add(80, 20);
		int n2 = (Integer)list.value(4);
		list.modify(33, 4);
		System.out.println("n1="+n1+" n2="+n2);
		System.out.println("list length:"+list.size());
		list.forward();
		
		List list1 = list.sort();
		System.out.println("list1 length:"+list1.size());
		list1.forward();
		System.out.println();
		list1.backward();
		System.out.println("list1 length:"+list1.size());
	}

}
