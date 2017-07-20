package com.atguigu.runnable;

public class Ticket implements Runnable{

	private int count = 40;
	
	@Override
	public synchronized void run() {
		while(true){
			
			if (count > 0) {
				
				System.out.println(Thread.currentThread().getName() 
						+ "卖出第" + (41 - count--) + "票，还剩" + count + "张票");
			}
		}
			
	}

}
