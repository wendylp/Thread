package com.atguigu.thread;

public class ThreadTest {

	public static void main(String[] args) {

		Ticket t1 = new Ticket();
		t1.start();
		
		Ticket t2 = new Ticket();
		t2.start();
		
		Ticket t3 = new Ticket();
		t3.start();
	}

}
