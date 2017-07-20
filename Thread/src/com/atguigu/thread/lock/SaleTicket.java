package com.atguigu.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket{
	
	private int count = 40;
	
	/*@Override
	public synchronized void run() {
		while(true){
			
			if(count > 0){
				
				System.out.println("������" + (count--) + "�ţ���ʣ" + count + "��");
				
			}
			
		}
		
	}*/
	
	
	private Lock lock = new ReentrantLock();
	
	public void saleTicket(){
		
		lock.lock(); //try�����
		
		try {
			
			if(count > 0){
				
				System.out.println(Thread.currentThread().getName() + "������" + (41 - count--) + "�ţ���ʣ" + count + "��");
			}
			
		} catch (Exception e) {
			
		}finally {
			
			lock.unlock();  //finally�н���
		}
	}

}
