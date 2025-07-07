package com.lpu.threads;

class Printer
{
	public void print(String msg) {
		System.out.print("[");
		System.out.print(msg);
		System.out.print("]");	
	}
}

class PrinterThread extends Thread
{
	Printer p;
	String msg;
	
	public PrinterThread(Printer p, String msg) {
		super();
		this.p = p;
		this.msg = msg;
	}
	
	public void run()
	{
		synchronized(p)
		{
			p.print(msg);
		}
	}
	
}
public class SynchDemo {
	public static void main(String [] args) {
		Printer p = new Printer();
		PrinterThread t1 = new PrinterThread(p,"Java");
		PrinterThread t2 = new PrinterThread(p,"DBMS");
		t1.start();
		t2.start();
		
	}
}
