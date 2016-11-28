package com.nc.Stack;

public class arithmeticExpression {
	
	public static double compute(String str)
	{
		Stack sck = new SequenceStack();
		double x = 0.0,y;
		char[] a = str.toCharArray();
		int i = 0;
		while (i < a.length) {
			while (a[i] == ' ') i++;
			switch (a[i]) {
			case '+':
				x = (Double) sck.pop() + (Double)sck.pop();
				i++;break;
			case '-':
				x = (Double) sck.pop();
				x = (Double) sck.pop() - x;
				i++;break;
			case '*':
				x = (Double) sck.pop() * (Double)sck.pop();
				i++;break;
			case '/':
				x = (Double) sck.pop();
				if (Math.abs(x)>1e-6)
					x = (Double)sck.pop()/x;
				else {
					System.out.println("除数为0");
					System.exit(1);
				}
				i++;break;
			default:
					
				
			}
		}
		
		return x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
