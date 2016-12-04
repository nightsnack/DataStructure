package com.nc.LinearList;

public class Polynomial1 {
	static double polyValue(List ploy,double x) {
		double sum = 0;
		for (int i = 0; i<ploy.size(); i++) {
			Item y = (Item)ploy.value(i+1);
			sum+=y.coef*Math.pow(x, y.exp);
		}
		return sum;
	}
	
	static List polyAdd(List b1, List b2) {
		List b3 = new LinkList();
		int i1=1,i2=1;
		while (i1<=b1.size()&&i2<=b2.size()) {
			Item x = (Item)b1.value(i1);
			Item y = (Item)b2.value(i2);
			if(x.exp<y.exp) {
				b3.add(x, b3.size()+1);
				i1++;
			}
			else if(x.exp>y.exp) {
				b3.add(y, b3.size()+1);
				i2++;
			} else {
				if(Math.abs(x.coef+y.coef)>1.0E-6) {
					Item z = new Item(x.coef+y.coef, x.exp);
					b3.add(z, b3.size()+1);
				}
				i1++;i2++;
			}
		}
		if(i1<b1.size())  {
			for (;i1<=b1.size();i1++)
				b3.add((Item)b1.value(i1), b3.size()+1);
		} else if(i2<=b2.size())  {
			for (;i2<=b2.size();i2++)
				b3.add((Item)b2.value(i2), b3.size()+1);
		}
		return b3;
	}
	
	static List polyMul(List b1, List b2) {
		List sub = new SequenceList();
		for (int i = 0; i < b1.size(); i++) {
			Item x = (Item)b1.value(i+1);
			Item z;
			List std = new SequenceList();
			
			for (int j = 0; j < b2.size(); j++) {
				Item y = (Item)b2.value(j+1);
				double tem_coef = x.coef*y.coef;
				int tem_exp = x.exp+y.exp;
				z = new Item(tem_coef, tem_exp);
				std.add(z, std.size()+1);
			}
			sub = polyAdd(sub, std);
		}
		return sub;
	}
	
	
	public static void main(String[] args) {
		List std1 = new SequenceList();
		List std2 = new LinkList();
		int [][]r1 = {{5,0},{3,2},{-6,3},{2,5}};
		int [][]r2 = {{3,0},{4,1},{-2,2},{3,3},{-2,5},{9,6}};
		for (int i=0; i<r1.length; i++) 
			std1.add(new Item(r1[i][0],r1[i][1]),i+1);
		for (int i=0; i<r2.length; i++) 
			std2.add(new Item(r2[i][0],r2[i][1]),i+1);
		double y1 = polyValue(std1, 2);
		double y2 = polyValue(std2, 2);
		System.out.println("x值为2的时候两个多项式的值为"+y1+", "+y2);
		List std3,std4;
		System.out.println("输出加法和:");
		std3 = polyAdd(std1,std2);
		std3.forward();
		System.out.println("输出乘法和:");
		std4 = polyMul(std1, std2);
		std4.forward();
	}
	
	

}
