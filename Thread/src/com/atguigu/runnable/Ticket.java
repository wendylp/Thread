package com.atguigu.runnable;

public class Ticket implements Runnable{

	private int count = 40;
	
	@Override
	public synchronized void run() {
		while(true){
			
			if (count > 0) {
				
				System.out.println(Thread.currentThread().getName() 
						+ "������" + (41 - count--) + "Ʊ����ʣ" + count + "��Ʊ");
			}
		}
			
	}

}
