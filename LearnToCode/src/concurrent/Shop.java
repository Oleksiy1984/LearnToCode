package concurrent;

public class Shop {
/**
 * 
 *Посетитель пришелThread-0
Посетитель пришелThread-1
Thread-0 в синх блок
Thread-1 в синх блок

main зашел в синх блок
Посетитель зашел!Thread-1
Посетитель зашел!Thread-0
 */
	public static void main(String[] args) throws InterruptedException {
		Shop shop = new Shop();
		Person one = new Person(shop);
		Person two = new Person(shop);

		one.start();
		two.start();
		Thread.sleep(3000);
		synchronized (shop) {
			System.out.println(Thread.currentThread().getName()+" зашел в синх блок");
			shop.notifyAll();
			Thread.sleep(5000);
			System.out.println("main losed monitor");
		}

	}

}

class Person extends Thread {

	private Shop shop;

	public Person(Shop shop) {
		this.shop = shop;
	}

	public void run() {
		System.out.println("Посетитель пришел" + Thread.currentThread().getName());
		synchronized (shop) {
			System.out.println(Thread.currentThread().getName() + " в синх блок");
			try {
				shop.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Посетитель вышел!" + Thread.currentThread().getName());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
