package com.nc.SparseMatrix;

public class Tripple implements Comparable<Object> {
	int row;
	int col;
	double val;

	public Tripple(int row, int col, double val) {
		super();
		this.row = row;
		this.col = col;
		this.val = val;
	}
	
	public String toString() {
		return "("+row+","+col+","+val+")";
	}

	public boolean equals(Object obj) {
		Tripple t = (Tripple) obj;
		if (this.row==t.row&&this.col==t.col) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int compareTo(Object obj) {
		Tripple t = (Tripple) obj;
		if (this.row>t.row) return 1;
		else if(this.row<t.row) return -1;
		else{
			if (this.col>t.col) return 1;
			else if (this.col<t.col) return -1;
			else return 0;
		}
	}

}
