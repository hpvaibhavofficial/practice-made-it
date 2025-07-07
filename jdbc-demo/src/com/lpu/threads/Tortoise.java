package com.lpu.threads;

class TortoiseTh extends Thread{
	public void run() {
		int i = 1;
		while(i<=100) {
			System.out.println("Tortoise Running");
			i++;
		}
		System.out.println("Tortoise Reached!!!!!!!!!!!!!!!!");
	}
}
class HareTH extends Thread{
	public void run() {
		int i = 1;
		while(i<=90) {
			System.out.println("Hare Running");
			i++;
		}
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(i<=100) {
			System.out.println("Hare Running");
			i++;
		}
		System.out.println("Hare Reached!!!!!!!!!!!!!!!!!!");

		
		
	}
}
public class Tortoise {
	public static void main(String[] args) {
	TortoiseTh tt = new TortoiseTh();
	HareTH ht = new HareTH();
	tt.start();
	ht.start();
	}
}