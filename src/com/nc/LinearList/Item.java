package com.nc.LinearList;


public class Item implements Comparable<Object> {
	double coef;	//系数
	int exp;		//指数
	
	public Item(double coef, int exp) {
		super();
		this.coef = coef;
		this.exp = exp;
	}
	
	/**
	 * 返回对象的字符串表示形式
	 * @return
	 */
	public String toString () {
		return String.valueOf(coef)+"x^"+exp;
	}

	@Override
	public int compareTo(Object o) {
		Item s = (Item) o;
		return exp-s.exp;
	}
	
}
