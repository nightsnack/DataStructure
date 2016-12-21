package com.nc.Sort;

import java.util.Date;
import java.util.Random;

/**
 * @author chiyexiao
 *
 */
public class Sort {
	
	public static void insertSort(Object[] a,int n) {
		for(int i = 1; i<n; i++) {
			Object x = a[i];
			int j;
			for (j = i-1; j>=0; j--) {
				if (((Comparable)a[j]).compareTo(x)>0)
				{	
					a[j+1] = a[j];
				}
				else
					break;
			}
			a[j+1] = x;
		}
	}
	
	public static void selectSort( Object a[],int n) {
		for (int i = 1;i<n; i++) {
			int k = i-1;
			for (int j = i;j<n;j++) {
				if (((Comparable)a[j]).compareTo(a[k])<0) {
					k = j;
				}
			}
			if (k != i-1) {
				Object temp = a[i-1];
				a[i-1] = a[k];
				a[k] = temp;
			}
		}
	}
	
	public static void bubbleSort(Object a[],int n) {
		for(int i = 1;i<n-1;i++) {
			int k;
			boolean flag = false;
			for(k = n-1; k>=i; k--) {
				if (((Comparable)a[k]).compareTo(a[k-1])<0)
				{
					Object temp = a[k];
					a[k] = a[k-1];
					a[k-1] = temp;
					flag = true;
				}
			}
			if (flag == false)
				return;
		}
	}
	
	public static int partition( Object a[], int s, int t) {
		int i = s,j = t;
		Object x = a[i];
		i++;
		while (i<=j) {
			while (i<=j&& ((Comparable)a[i]).compareTo(x)<=0) i++;
			while (j>=i && ((Comparable)a[j]).compareTo(x)>=0) j--;
			if (i<j) {
				Object temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		a[s] = a[j];
		a[j] = x;
		return j;
	}
	
	public static void quickRecursion (Object a[],int s,int t) {
		int j = partition(a, s, t);
		if(s < j-1) quickRecursion(a, s, j-1);
		if(t > j+1) quickRecursion(a, j+1, t);
	}
	
	public static void quickSort (Object a[], int n) {
		quickRecursion(a, 0, n-1);
	}
	
	public static void twoMerge(Object []a,Object[] r,int s,int m,int t) {
		int i = s,j = m+1,k = s;
		while (i<=m && j<=t) {
			if (((Comparable)a[i]).compareTo(a[j])<0) {
				r[k] = a[i];
				i++;k++;
			}
			else {
				r[k] = a[j];
				k++;
				j++;
			}
		}
		while (i<=m) {
			r[k] = a[i];
			i++;k++;
		}
		while (j<=t) {
			r[k] = a[j];
			j++;
			k++;
		}
	}
	
	public static void mergePass(Object []a,Object []r,int n,int len) {
		int p = 0;
		while (p+2*len-1<=n-1) {
			twoMerge(a, r, p, p+len-1, p+2*len-1);
			p+=2*len;
		}
		if(p+len-1<n-1) {
			twoMerge(a, r, p, p+len-1, n-1);
		}
		else {
			for(int i = p; i<=n-1; i++)	r[i] = a[i];
		}
	}
	
	public static void mergeSort(Object []a,int n) {
		Object []r = new Object[n];
		int len = 1;
		while (len <n ){
			mergePass(a, r, n, len);
			len = 2*len;
			mergePass(r, a, n, len);
			len = 2*len;
		}
	}
	
	public static void main (String args[]) {
//		Integer[] a = {45,53,18,36,72,30,48,93,15,36};
		Integer[] a = new Integer[50000];
		Random rnd = new Random();
		for(int i = 0; i<50000; i++) {
			a[i] = rnd.nextInt(1000000000);
		}
//		output(a);
		System.out.println("插入\n排序前："+Long.toString(new Date().getTime()));
		long epoch = System.currentTimeMillis();
		insertSort(a, a.length);
		long epoch1 = System.currentTimeMillis();
		System.out.println("排序用时："+(epoch1-epoch));
		System.out.println("排序后："+Long.toString(new Date().getTime()));
//		output(a);
//		Integer[] b = {45,53,18,36,72,30,48,93,15,36};
		Integer[] b = new Integer[50000];
		rnd= new Random();
		for(int i = 0; i<50000; i++) {
			b[i] = rnd.nextInt(1000000000);
		}
		System.out.println("选择\n排序前："+Long.toString(new Date().getTime()));
		epoch = System.currentTimeMillis();
		selectSort(b, b.length);
		epoch1 = System.currentTimeMillis();
		System.out.println("排序用时："+(epoch1-epoch));
		System.out.println("排序后："+Long.toString(new Date().getTime()));
//		output(b);
		Integer[] c = new Integer[50000];
		rnd= new Random();
		for(int i = 0; i<50000; i++) {
			c[i] = rnd.nextInt(1000000000);
		}
		System.out.println("冒泡\n排序前："+Long.toString(new Date().getTime()));
		epoch = System.currentTimeMillis();
		bubbleSort(c, c.length);
		epoch1 = System.currentTimeMillis();
		System.out.println("排序用时："+(epoch1-epoch));
		System.out.println("排序后："+Long.toString(new Date().getTime()));
//		
//		Integer[] c = {45,53,18,36,72,30,48,93,15,36};
//		bubbleSort(c, c.length);
//		output(c);
		Integer[] d = new Integer[50000];
		rnd= new Random();
		for(int i = 0; i<50000; i++) {
			d[i] = rnd.nextInt(1000000000);
		}
		System.out.println("快排\n排序前："+Long.toString(new Date().getTime()));
		epoch = System.currentTimeMillis();
		quickSort(d, d.length);
		epoch1 = System.currentTimeMillis();
		System.out.println("排序用时："+(epoch1-epoch));
		System.out.println("排序后："+Long.toString(new Date().getTime()));
//		Integer[] d = {45,53,18,36,72,30,48,93,15,36};
//		quickSort(d, d.length);
//		output(d);
		Integer[] e = new Integer[50000];
		rnd= new Random();
		for(int i = 0; i<50000; i++) {
			e[i] = rnd.nextInt(1000000000);
		}
		System.out.println("两路合并\n排序前："+Long.toString(new Date().getTime()));
		epoch = System.currentTimeMillis();
		mergeSort(e, e.length);
		epoch1 = System.currentTimeMillis();
		System.out.println("排序用时："+(epoch1-epoch));
		System.out.println("排序后："+Long.toString(new Date().getTime()));
		
//		Integer[] e = {45,53,18,36,72,30,48,93,15,36};
//		mergeSort(e, e.length);
//		output(e);
	}
	
	public static void output(Integer[] b) {
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]+" ");
		}
		System.out.println();
	}

}
