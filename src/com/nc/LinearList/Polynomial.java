package com.nc.LinearList;

public class Polynomial {

	static double ployValue(List ploy, double x) {
		double sum = (Double)ploy.value(1);
		for (int i=1; i<ploy.size(); i++)
			sum = sum*x+(Double)ploy.value(i+1);
		return sum;
	}
	
	static double ployValue1(List ploy, double x) {
		double sum = (Double)ploy.value(ploy.size());
		double p = 1;
		for (int i=1; i<ploy.size(); i++) {
			p*=x;
			sum+=p*(Double)ploy.value(ploy.size()-i);
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List std = new SequenceList();
		double []a = {2,0,-6,3,0,5};
		for (int i=0;i<a.length;i++) 
			std.add(a[i], i+1);
		std.forward();
		System.out.println("线性表长度："+std.size());
		double y = ployValue(std, 2);
		System.out.println("x等于2的时候多项式的值："+y);
	}

}
