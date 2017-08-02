package concurrent;

public class Shop {
/**
 * 
 *���������� ������Thread-0
���������� ������Thread-1
Thread-0 � ���� ����
Thread-1 � ���� ����

main ����� � ���� ����
���������� �����!Thread-1
���������� �����!Thread-0
 */
	public static void main(String[] args) throws InterruptedException {
		Shop shop = new Shop();
		Person one = new Person(shop);
		Person two = new Person(shop);

		one.start();
		two.start();
		Thread.sleep(3000);
		synchronized (shop) {
			System.out.println(Thread.currentThread().getName()+" ����� � ���� ����");
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
		System.out.println("���������� ������" + Thread.currentThread().getName());
		synchronized (shop) {
			System.out.println(Thread.currentThread().getName() + " � ���� ����");
			try {
				shop.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("���������� �����!" + Thread.currentThread().getName());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
