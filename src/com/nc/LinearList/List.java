package com.nc.LinearList;

public interface List {
	/**
	 * 返回线性表中的第pos个元素的值	return the value of position 'pos'
	 * @param pos
	 * @return
	 */
	Object value(int pos);	//返回线性表中的第pos个元素的值	
	
	/**
	 * 向第pos位置插入一个元素obj add the element 'obj' to the position 'pos'
	 * @param obj
	 * @param pos
	 * @return T/F
	 */
	boolean	add(Object obj, int pos);	//向第pos位置插入一个元素obj
	/**
	 * remove the element in the position pos
	 * @param pos
	 * @return the object deleted just now
	 */
	Object remove(int pos);		//删除第pos个元素并返回，若不存在返回空
	/**
	 * find the element which value equals to value 'obj' from the front, return the position
	 * @param obj
	 * @return position
	 */
	int find(Object obj);		//从头查找等于obj值的第一个元素，返回序号
	/**
	 * replace element pos with obj
	 * @param obj
	 * @param pos
	 * @return
	 */
	boolean modify(Object obj,int pos);		//用obj修改线性表中的给定序号pos的元素值
	boolean isEmpty();		//判断线性表是否为空
	int size();		//返回线性表的长度
	/**
	 * traverse in positive sequence
	 */
	void forward();		//正序遍历
	
	/**
	 * traverse in negative sequence
	 */
	void backward();	//倒序遍历
	void clear();
	List sort();
}
