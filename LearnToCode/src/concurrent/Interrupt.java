package concurrent;

public class Interrupt {
	public static void main(String[] args) {
		MyThreadd t = new MyThreadd();
		//t.interrupt();
		try {
			Thread.sleep(1000);
			synchronized (t) {
				t.notify();
			}
			
		} catch (Exception e) {
			System.out.println("In catch");
		}
		System.out.println(t.isInterrupted());

	}

}

class MyThreadd extends Thread {
	MyThreadd() {
		this.start();
	}

	public void run() {
		System.out.println(Thread.currentThread().getName());
		synchronized (this) {
			{
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}