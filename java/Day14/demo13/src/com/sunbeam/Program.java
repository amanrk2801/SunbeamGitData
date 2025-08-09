package com.sunbeam;

/* 
public class Program {
	
	//race condition -- when deposit() and withdraw() methods are not declared synchronized
	public static void main(String[] args) {
		Account acc = new Account(1, "Savings", 10000.00); 
		
		class DepositThread extends Thread{
			@Override
			public void run() {
				for(int i = 1 ; i<=10000;i++) {
					acc.deposit(100);
					System.out.println("Balance after deposit : "+acc.getBalance());
				}
			}
		}
		DepositThread dt = new DepositThread(); 
		dt.start();
		
		class WithDrawThread extends Thread{
			@Override
			public void run() {
				for(int i = 1 ; i<=10000 ; i++) {
					acc.withdraw(100);
					System.out.println("Balance after withDraw : "+acc.getBalance());
				}
			}
		}
		WithDrawThread wt = new WithDrawThread();
		wt.start();
		
		try {
			dt.join();
			wt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Final balance : "+acc.getBalance());

	}

}*/
/* 
public class Program {
	
	// avoid race condition -- when deposit() and withdraw() methods are not declared synchronized
	// using "synchronized" block
	public static void main(String[] args) {
		Account acc = new Account(1, "Savings", 10000.00); 
		
		class DepositThread extends Thread{
			@Override
			public void run() {
				for(int i = 1 ; i<=10000;i++) 
				{
					try {
						synchronized (acc) 
						{ // LOCK 
							acc.deposit(100);
							System.out.println("Balance after deposit : " + acc.getBalance());
						} // UNLOCK 
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}
		DepositThread dt = new DepositThread(); 
		dt.start();
		
		class WithDrawThread extends Thread{
			@Override
			public void run() {
				for(int i = 1 ; i<=10000 ; i++) 
				{
					synchronized (acc) 
					{ // LOCK 
						acc.withdraw(100);
						System.out.println("Balance after withDraw : " + acc.getBalance());
					}// UNLOCK
				}
			}
		}
		WithDrawThread wt = new WithDrawThread();
		wt.start();
		
		try {
			dt.join();
			wt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Final balance : "+acc.getBalance());

	}

}*/ 
public class Program {
	
	//race condition -- when deposit() and withdraw() methods are not declared synchronized
	public static void main(String[] args) {
		Account acc = new Account(1, "Savings", 10000.00); 
		
		class DepositThread extends Thread{
			@Override
			public void run() {
				for(int i = 1 ; i<=10000;i++) {
					acc.deposit(100);
					System.out.println("Balance after deposit : "+acc.getBalance());
				}
			}
		}
		DepositThread dt = new DepositThread(); 
		dt.start();
		
		class WithDrawThread extends Thread{
			@Override
			public void run() {
				for(int i = 1 ; i<=10000 ; i++) {
					acc.withdraw(100);
					System.out.println("Balance after withDraw : "+acc.getBalance());
				}
			}
		}
		WithDrawThread wt = new WithDrawThread();
		wt.start();
		
		try {
			dt.join();
			wt.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Final balance : "+acc.getBalance());

	}

}
