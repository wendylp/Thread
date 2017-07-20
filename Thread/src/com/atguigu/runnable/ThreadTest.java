package com.atguigu.runnable;

public class ThreadTest {
	
	public static void main(String[] args) {
		
		Runnable r = new Ticket();
		
		new Thread(r).start();
		
		new Thread(r).start();
		
		new Thread(r).start();
		
	}

}
