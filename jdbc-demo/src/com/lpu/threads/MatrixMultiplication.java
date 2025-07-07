package com.lpu.threads;


import java.util.ArrayList;
import java.util.List;

//chatCode()
//{
//	while(connection is there)
//	{
//		read a line from keyboad
//		send the line to network
//		read a line from network
//		write line on the screen
//	}
//}



class AdderThread extends Thread
{
	int[][] a, b, c;
	int row;
	public AdderThread(int[][] a, int[][] b, int[][] c, int row) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.row = row;
	}
	public void run()
	{
//		System.out.println("adding row number " + row);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i = 0 ;i<a[row].length; i++)
		{
			c[row][i] = a[row][i] + b[row][i];
		}
	}
	
}
public class MatrixMultiplication {
	public static void main(String[] args) throws InterruptedException {
		int[][] a = { {1,2,3,4,5},
				{1,2,3,4,5},
				{1,2,3,4,5},
				{1,2,3,4,5},
				{1,2,3,4,5}
		};
		int[][] b = { {1,2,3,4,5},
				{1,2,3,4,5},
				{1,2,3,4,5},
				{1,2,3,4,5},
				{1,2,3,4,5}
		};
		int[][] c =  new int[a.length][a.length];
		List<AdderThread> list =new ArrayList<>();
		
		for(int i= 0;i<a.length; i++)
		{
			AdderThread t = new AdderThread(a, b, c, i);
			list.add(t);
			t.start();
		}
		
		for(AdderThread t : list)
		{
			System.out.println("main thread waiting for all threads in the list to finish ");
			t.join();
		}
		
		for(int i = 0; i<c.length; i++)
		{
			for(int j = 0; j<c.length ; j++)
			{
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}

}