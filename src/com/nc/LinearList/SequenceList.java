package com.nc.LinearList;

import com.nc.Stack.SequenceStack;
import com.nc.Stack.Stack;

public class SequenceList implements List {
	final int minSize = 10;
	private Object[] listArray;
	private int len;
	public SequenceList() {
		len = 0;
		listArray = new Object[minSize];
	}
	
	public SequenceList(int n) {
		if (n<minSize) {
			n = minSize;
		}
		len = 0;
		listArray = new Object[n];
	}

	@Override
	public Object value(int pos) {
		if (pos<1 || pos>len) {
			System.out.println("pos is invalid");
			return false;
		}
		return listArray[pos-1];
	}

	@Override
	public boolean add(Object obj, int pos) {
		if (pos<1 || pos>len+1) {
			System.out.println("pos is invalid");
			return false;
		}
		if (len == listArray.length) {
			Object[] objArr = new Object[2*len];
			for(int i = 0; i<listArray.length; i++) {
				objArr[i] = listArray[i];
			}
			listArray = objArr;
		}
		for(int i = len-1; i>=pos-1; i--) {
			listArray[i+1] = listArray[i];
		}
		listArray[pos-1] = obj;
		len++;
		return true;
	}

	@Override
	public Object remove(int pos) {
		if (pos<1 || pos>len) {
			System.out.println("pos is invalid");
			return null;
		}
		Object x = listArray[pos-1];
		for (int i = pos-1; i<len-1; i++ ) {
			listArray[i] = listArray[i+1];
		}
		len --;
		return x;
	}

	@Override
	public int find(Object obj) {
		int i;
		for (i = 0; i < listArray.length; i++) {
			if(listArray[i].equals(obj))
				return ++i;
		}
		return -1;
	}

	@Override
	public boolean modify(Object obj, int pos) {
		if (pos<1 || pos>len) {
			System.out.println("pos is invalid");
			return false;
		}
		listArray[pos-1] = obj;
		return true;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return len==0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return len;
	}

	@Override
	public void forward() {
		// TODO Auto-generated method stub
		for (int i = 0; i < len; i++) {
			System.out.print(listArray[i].toString()+" ");
		}
		System.out.println();
	}

	@Override
	public void backward() {
		for (int i = len-1; i >= 0; i--) {
			System.out.print(listArray[i].toString()+" ");
		}
	}

	@Override
	public void clear() {
		len=0;
		
	}
	
	public void reverse() {
		Stack stack = new SequenceStack(len);
		for (int i = 0; i < len; i++) {
			stack.push(listArray[i]);
		}
		for (int i = 0; i < len; i++) {
			listArray[i] = stack.pop();
		}
	}
	
	@Override
	public boolean deleteSpecficObject(Object x) {
		int i;
		for (i = 0; i < len; i++) {
			if (listArray[i].equals(x)) {
				remove(i+1);
				break;
			}
		}
		if(i == len)
		{
			System.out.println("Not Exist!");
			return false;
		}
		else 
			return true;
	}

	@Override
	public List sort() {
		// TODO Auto-generated method stub
		SequenceList list = new SequenceList(len);
		list.len = len;
		for (int i = 0; i < len; i++) {
			list.listArray[i] = listArray[i];
		}
		for (int i = 0; i<list.len; i++) {
			Object x = list.listArray[i];
			int j;
			for (j = i-1; j>=0; j-- ) {
				Object y = list.listArray[j];
				if(Integer.valueOf(x.toString()) < Integer.valueOf(y.toString())) {
					list.listArray[j+1] = list.listArray[j];
				} else
				{
					break;
				}
			}
			list.listArray[j+1] = x;
		}
		return list;
	}
	
	public static void main (String [] args) {
		List list = new SequenceList(10);
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
		System.out.println("Delete Object 38");
		list.deleteSpecficObject(38);
		list.forward();
		System.out.println("Reverse list:");
		list.reverse();
		list.forward();
		
		List list1 = list.sort();
		System.out.println("list1 length:"+list1.size());
		list1.forward();
		System.out.println();
		list1.backward();
		System.out.println("list1 length:"+list1.size());
	}


}
