package com.nc.Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HuffmanTree extends LinkBinaryTree {
	
	private Map<Integer, Character> wcmap ;
	
	public HuffmanTree() {
		super();
	}
	
	public HuffmanTree(BTreeNode rt) {
		this.root = rt;
	}
	
	public void createHuffmanTree(char[] c, Integer[] a) {
		wcmap = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			wcmap.put(a[i], c[i]);
		}
		
		int n = a.length;
		BTreeNode[] b = new BTreeNode[n];
		for (int i = 0; i<n; i++)
			b[i] = new BTreeNode(a[i]);
		int k1 = 0, k2 = 0;
		for (int i = 1; i < n; i++) {
			int k = 0;
			while (b[k] == null) {
				k++;
			}
			k1 = k;
//			if(k < n)
			k++;
			while (b[k] == null){ k++;}
			k2 = k;
			for (int j = k2; j<n; j++) {
				if (b[j] != null) {
					Integer x = (Integer) b[j].element;
					if (x.compareTo((Integer)b[k1].element)<0) {
						k2 = k1;
						k1 = j;
					}else if(x.compareTo((Integer)b[k2].element)<0)
						k2 = j;
				}
			}
			Integer x = (Integer) b[k1].element + (Integer) b[k2].element;
			b[k1] = new BTreeNode(x,b[k1],b[k2]);
			b[k2] = null;
		}
		root = b[k1];
	}
	
	public int weightPathLength(int len)
	{
		return weightPathLength(root, len);
	}
	
	private int weightPathLength(BTreeNode ft, int len)
	{
		if (ft == null) return 0;
		if (ft.left == null && ft.right == null) {
			return (int)ft.element *len;
		} else {
			return weightPathLength(ft.left, len+1)+weightPathLength(ft.right, len+1);
		}
	}
	
	public void outputHuffmanCoding() {
		int[] a = new int[10];
		File textfile = new File("textfile.txt");
		File codefile = new File("codefile.txt");

		 FileWriter fileWritter1 = null,fileWritter2 = null;
		try {
			if (!textfile.exists())
				textfile.createNewFile();
			if (!codefile.exists())
				codefile.createNewFile();
			fileWritter1 = new FileWriter(textfile.getName(),true);
			BufferedWriter bufferWritter1 = new BufferedWriter(fileWritter1);
			fileWritter2 = new FileWriter(codefile.getName(),true);
			BufferedWriter bufferWritter2 = new BufferedWriter(fileWritter2);
			outputHuffmanCoding(this.root, 0, a,textfile,codefile,bufferWritter1,bufferWritter2);
			bufferWritter1.close();
			bufferWritter2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void outputHuffmanCoding(BTreeNode ft, int len,int[] a,File textfile, File codefile,BufferedWriter bufferWritter1,BufferedWriter bufferWritter2) {
		if (ft != null) {
			if(ft.left == null && ft.right == null) {
				System.out.print("节点 "+wcmap.get((Integer)ft.element)+" 权值为 "+(Integer)ft.element+" 编码为：");
				try {
					bufferWritter1.write(wcmap.get((Integer)ft.element)+"\r\n");
					for(int i = 0; i<len; i++) {
						System.out.print(a[i]+" ");
						bufferWritter2.write(a[i]+"");
					}
					bufferWritter2.write("\r\n");
					System.out.println();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				a[len] = 0;
				outputHuffmanCoding(ft.left, len+1, a,textfile,codefile,bufferWritter1,bufferWritter2);
				a[len] = 1;
				outputHuffmanCoding(ft.right, len+1, a,textfile,codefile,bufferWritter1,bufferWritter2);
			}
		}
	}
	
	public void decode() {
		File file = new File("codefile.txt");
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                char[] code = tempString.toCharArray();
                int weight = decode(code);
                System.out.println("节点 "+wcmap.get(weight)+" 权值 "+weight+" 编码 "+tempString);
                
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	 
	private int decode(char[] code) {
		BTreeNode bt = root;
		for (int i = 0; i < code.length; i++) {
			int temp = Integer.parseInt(code[i]+"");
			if (temp == 0)
				bt = bt.left;
			else
				bt = bt.right;
		}
		return (int)bt.element;
	}
	
	

}
