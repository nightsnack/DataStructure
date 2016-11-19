package com.nc.LinearList;

public interface List {
	Object value(int pos);	//返回线性表中的第pos个元素的值	
	boolean	add(Object obj, int pos);	//向第pos位置插入一个元素obj
	Object remove(int pos);		//删除第pos个元素并返回，若不存在返回空
	int find(Object obj);		//从头查找等于obj值的第一个元素，返回序号
	boolean modify(Object obj,int pos);		//用obj修改线性表中的给定序号pos的元素值
	boolean isEmpty();		//判断线性表是否为空
	int size();		//返回线性表的长度
	void forward();		//正序遍历
	void backward();	//倒序遍历
	void clear();
	List sort();
}
