package concurrent;

//if  monitor this - thread run concurrently
//if monitor Monitor.class - one by one 
//if synchronized method is static  - one by one 
//if synchronized method - thread run concurrently
public class Monitor {
	

//	public static synchronized void staff() throws InterruptedException {
//		
//					for(int i =0;i<5;i++) {
//						Thread.sleep(1000);
//						System.out.println(Thread.currentThread().getName());
//					}
//			}
	public void staff() throws InterruptedException {

		synchronized (this) {
			for(int i =0;i<5;i++) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName());
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

	
		MyThread4 t1 = new MyThread4();
		MyThread4 t2 = new MyThread4();
		System.err.println(t1.getName());
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		Thread.sleep(10000);
		System.out.println("End main");
	}
}

class MyThread4 extends Thread {
	private Monitor monitor = new Monitor();
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		try {
			monitor.staff();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}