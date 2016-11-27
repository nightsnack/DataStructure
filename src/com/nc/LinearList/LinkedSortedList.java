package com.nc.LinearList;

public class LinkedSortedList extends LinkList implements SortedList {

	public LinkedSortedList() {
		super();
	}
	
	public LinkedSortedList(List list) {
		super();
		for(int i=1; i<list.size(); i++)
			this.insert(list.value(i));
	}
	
	@Override
	public void insert(Object obj) {
		int i;
		for(i=1; i<=size(); i++) {
			if(((Comparable)obj).compareTo(value(i))<0)
				break;
		}
		add(obj, i);
	}

	@Override
	public Object delete(Object obj) {
		int i;
		for(i = 1; i<size(); i++) {
			if(((Comparable<Object>)obj).compareTo(value(i))<0) return null; 
			//从小到大的顺序，一开始obj一直比顺序表里的元素大，找到一个obj比人家小了，那后面的,obj都会比他们小，所以就找不到了，返回空
			if(((Comparable<Object>)obj).compareTo(value(i))==0) return remove(i);
		}
		return null; //如果找了一个循环都没找到那说明没有
	}

	@Override
	public int check(Object obj) {
		int i;
		for(i=0; i<size(); i++) {
			if (((Comparable<Object>)obj).compareTo(value(i))<0) return -1;
			if (((Comparable<Object>)obj).compareTo(value(i))==0) return i;
		}
		return -1;
	}

}
