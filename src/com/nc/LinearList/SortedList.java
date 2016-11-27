/**
 * 
 */
package com.nc.LinearList;

/**
 * @author chiyexiao
 *
 */
public interface SortedList extends List {
	/**
	 * 向有序表中插入一个元素
	 * @param obj
	 */
	void insert(Object obj);
	/**
	 * 删除一个元素并返回，删除后仍为有序表
	 * @param obj
	 * @return already deleted object
	 */
	Object delete(Object obj);
	
	/**
	 * 按值查找元素，返回元素序号或-1
	 * @param obj
	 * @return 元素序号或-1
	 */
	int check(Object obj);

}
