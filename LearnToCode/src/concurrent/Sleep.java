package concurrent;

public class Sleep {

	// 1 Dont stop thread:
	// Begin Thread-0
	// In catch
	// End runThread-0

	// 2 in catch block return;
	// Begin Thread-0
	// In catch

	public static void main(String[] args) throws InterruptedException {
		Thread10 t = new Thread10();
		t.start();
		Thread.sleep(1000);
		t.interrupt();

	}

}

class Thread10 extends Thread {
	public void run() {
		System.out.println("Begin " + Thread.currentThread().getName());
		while (!Thread.currentThread().isInterrupted()) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("In catch");
				Thread.currentThread().interrupt();
				System.err.println(Thread.currentThread().isInterrupted());// false
				// return;
				// break; break cannot be used outside of a loop or a switch
			}
			System.out.println("End run" + Thread.currentThread().getName());
		}
	}
}