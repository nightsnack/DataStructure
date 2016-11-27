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

}
