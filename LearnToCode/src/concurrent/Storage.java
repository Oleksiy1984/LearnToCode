package concurrent;

public class Storage {

	public Storage(Item item) {
		super();
		this.item = item;
	}

	private Item item;

	public synchronized void put() throws InterruptedException {
		while (item.getQuantity() >= 3) {
			wait();
		}
		Thread.sleep(1000);
		item.setQuantity(item.getQuantity() + 1);
		System.out.println("PUT. All guds " + item.getQuantity());
		notify();

	}

	public synchronized void get() throws InterruptedException {
		while (item.getQuantity() < 1) {
			wait();
		}
		Thread.sleep(1000);
		item.setQuantity(item.getQuantity() - 1);
		System.out.println("GET. All guds " + item.getQuantity());
		notify();
	}

	public static void main(String[] args) {
		Item item = new Item();
		Storage storage = new Storage(item);
		Producer producer = new Producer(storage);
		Consumer consumer = new Consumer(storage);
		producer.start();
		consumer.start();

	}

}

class Producer extends Thread {
	private Storage storage;

	public Producer(Storage storage) {
		super();
		this.storage = storage;
	}

	public void run() {
		synchronized (storage) {
			while (true) {
				try {
					storage.put();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}

class Consumer extends Thread {
	private Storage storage;

	public Consumer(Storage storage) {
		super();
		this.storage = storage;
	}

	public void run() {
		while (true) {
			try {
				storage.get();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

class Item {
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}