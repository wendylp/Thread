package com.atguigu.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket{
	
	private int count = 40;
	
	/*@Override
	public synchronized void run() {
		while(true){
			
			if(count > 0){
				
				System.out.println("卖出第" + (count--) + "张，还剩" + count + "张");
				
			}
			
		}
		
	}*/
	
	
	private Lock lock = new ReentrantLock();
	
	public void saleTicket(){
		
		lock.lock(); //try外加锁
		
		try {
			
			if(count > 0){
				
				System.out.println(Thread.currentThread().getName() + "卖出第" + (41 - count--) + "张，还剩" + count + "张");
			}
			
		} catch (Exception e) {
			
		}finally {
			
			lock.unlock();  //finally中解锁
		}
	}

}
