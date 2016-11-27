package com.nc.SparseMatrix;

import com.nc.LinearList.LinkList;
import com.nc.LinearList.LinkedSortedList;
import com.nc.LinearList.List;
import com.nc.LinearList.SortedList;

public class SparseMatrix {
	private int rows;
	private int cols;
	private SortedList terms;
	
	public SparseMatrix(int rows, int cols, List list) {
		super();
		this.rows = rows;
		this.cols = cols;
		this.terms = new LinkedSortedList(list);
	}
	
	public void outputMatrix() {
		System.out.println("columes and rows of the sparsematrix"+this.cols+","+this.rows);
		terms.forward();
	}
	
	public SparseMatrix tranpose()
	{
		SparseMatrix sm = new SparseMatrix(this.cols, this.rows, new LinkList());
		if (terms.size()==0) return sm;
		for (int i=1;i<this.terms.size(); i++) {
			Tripple x = (Tripple)terms.value(i);
			sm.terms.insert(new Tripple(x.col, x.row, x.val));
		}
		return sm;
	}
	
	public SparseMatrix tranpose1()
	{
		SparseMatrix sm = new SparseMatrix(this.cols, this.rows, new LinkList());
		if (terms.size() == 0) return sm;
		for (int k = 1; k<=this.cols; k++) {
			for (int i = 1; i<=terms.size(); i++) {
				if (((Tripple)terms.value(i)).col == k)
					sm.terms.add(new Tripple(k, ((Tripple)terms.value(i)).row, ((Tripple)terms.value(i)).val), sm.terms.size()+1);
			}
		}
		return sm;
	}
	
	public SparseMatrix sparseAdd(SparseMatrix sm) { 
		if ((this.rows != sm.rows) || (this.cols != sm.cols )) {
			System.out.println("tow matrix measurenents are different!");
			System.exit(1);
		}
		
		SparseMatrix tm = new SparseMatrix(rows, cols, new LinkList());
		if ((this.terms.size()==0)&& (sm.terms.size()==0) ) return tm;
		int i1  = 1,i2 = 1;
		while (i1 <=this.terms.size() && i2<=sm.terms.size()) {
			Tripple x1 = (Tripple)this.terms.value(i1);
			Tripple x2 = (Tripple)sm.terms.value(i2);
			if (x1.compareTo(x2)<0) {
				tm.terms.add(x1, tm.terms.size()+1);
				i1++;
			}
			else if (x1.compareTo(x2)>0) {
				tm.terms.add(x2, tm.terms.size()+1);
				i2++;
			}
			else {
				double y = x1.val+x2.val;
				if(Math.abs(y)>1E-6) {
					Tripple x3 = new Tripple(x1.row, x1.col, y);
					tm.terms.add(x3, tm.terms.size()+1);
					
				}
				i1++;
				i2++;
			}
		}
		while (i1<=this.terms.size()) {
			tm.terms.add(this.terms.value(i1), tm.terms.size()+1);
			i1++;
		}
		while (i2<=sm.terms.size()) {
			tm.terms.add(sm.terms.value(i2), tm.terms.size()+1);
			i2++;
		}
		return tm;
	}

}
