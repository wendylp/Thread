package com.atguigu.thread.lock;

/**
 * 
 *�߳�		 ����		��Դ��
 *�߾ۺ�		����� 
 * 
 * @author lenovo
 *
 */
public class ThreadTest {
	
	public static void main(String[] args) {
		
		final SaleTicket st = new SaleTicket(); //��Դ�����finally����
		
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
