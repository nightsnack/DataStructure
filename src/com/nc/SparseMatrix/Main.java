package com.nc.SparseMatrix;

import com.nc.LinearList.LinkList;
import com.nc.LinearList.List;
import com.nc.LinearList.SequenceList;

public class Main {

	public static void main(String[] args) {
		List list  = new SequenceList();
		List std = new LinkList();
		Tripple [] trip = { new Tripple(1, 1, 3),new Tripple(1, 4, 5),
				new Tripple(2, 3, -2),new Tripple(3, 1, 1),
				new Tripple(3, 3, 4),new Tripple(3, 5, 6),
				new Tripple(4, 6, 8),new Tripple(5, 3, -1)
		};
		Tripple [] rest = { new Tripple(1, 1, 2),new Tripple(1, 2, 1),
				new Tripple(1, 6, -3),new Tripple(2, 3, 1),
				new Tripple(2, 4, 3),new Tripple(3, 1, -1),
				new Tripple(3, 4, 4),new Tripple(4, 6, 7),
				new Tripple(5, 2, 5),new Tripple(5, 5, 6)
		};
		
		for (int i=0; i<trip.length; i++)
			list.add(trip[i], list.size()+1);
		for (int i=0; i<rest.length; i++)
			std.add(rest[i], std.size()+1);
		
		SparseMatrix sm = new SparseMatrix(5, 6, list);
		SparseMatrix sp = new SparseMatrix(5, 6, std);
		System.out.println("Output sparse matrix sm:");
		sm.outputMatrix();
		System.out.println("Output sparse matrix sp:");
		sp.outputMatrix();
		SparseMatrix sr = sm.tranpose1();
//		SparseMatrix sr = sm.tranpose();
		System.out.println("Output transposed sparse matrix sr:");
		sr.outputMatrix();
		
		SparseMatrix st = sm.sparseAdd(sp);
		System.out.println("Output transposed sparse st, sum of sparse matrix sm and sp:");
		st.outputMatrix();

	}

}
