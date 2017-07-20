package com.atguigu.thread.lock;

/**
 * 
 *线程		 操作		资源类
 *高聚合		低耦合 
 * 
 * @author lenovo
 *
 */
public class ThreadTest {
	
	public static void main(String[] args) {
		
		final SaleTicket st = new SaleTicket(); //资源类必须finally修饰
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				for (int i = 0; i < 50; i++) {
					
					st.saleTicket();
				}
			}
		}, "AA").start();
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				for (int i = 0; i < 50; i++) {
					
					st.saleTicket();
				}
			}
		}, "BB").start();
		
	
		
		new Thread(new Runnable() {
		
		@Override
		public void run() {
			
			for (int i = 0; i < 50; i++) {
				
				st.saleTicket();
			}
		}
	}, "CC").start();
	
		

	}
	

}
