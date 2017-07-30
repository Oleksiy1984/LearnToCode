package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
///////////////////////
/**
class Q implements Runnable{
	int i = 0;
		public int run(){// The return type is incompatible with Runnable.run()
		 System.out.println("i = "+ ++i);
		 return i;
	 }}
class Quest1 {
	public static void main(String[] args) {
		Q ob = new Q();
		ob.run();
}
	}
	*/
/**
��� ������� ���������� � ������� ����� ��������: 
	i = 0;
	i = 1;
	������ ����������: ������� ������ ������ ����� ������ � ������� ������������� ������� ������ Thread ��� ��� �����������; 
4)	������ ����������: ����������� ���������� ����� run();
	������ ������� ����������: ����� ������ ����������� ������� start().
*/

////////////////////////////////////////////

class T22 {
	public static void main(String[] args) {
		Thread t1 = new Thread();
		t1.setPriority(7);
		ThreadGroup tg = new ThreadGroup("TG");
		tg.setMaxPriority(8);
		Thread t2 = new Thread(tg, "t2");
		System.out.print("��������� t1=" + t1.getPriority());//7
		System.out.print(", ��������� t2=" + t2.getPriority());//5
	}
}

/**
� ���������� ���������� � ���������� ����� ��������: 
1)	��������� t1 = 7, ��������� t2 = 5;
	��������� t1 = 7, ��������� t2 = 8;
	��������� t1 = 10, ��������� t2 = 8;
	��� �����������.
	����� t1 �� ������ �� � ���� ������, 
	������� ��� ��������� ��������� ����������,
	 �.�. 7. ����� ������ setMaxPriority()
	  ��� ������ ������� � ���������� 8 �������, ��� 5, �������� � ����,
	   ��� ��������� ������ �������, � �������������,
	    � ������ t2 ����� ���������� ��� NORMAL_PRIORITY. 
�����: 1.

*/
//////////////////////////
class T1 implements Runnable {
	public void run() {
		System.out.print("t1 ");
	}
}

class T2 extends Thread {
	public void run() {
		System.out.print("t2 ");
	}
}

class Quest3 {
	public static void main(String[] args) {
		T1 t1 = new T1();
		//t1.start(); The method start() is undefined for the type T1
		
		//T2 t2 = new T2(t1); The constructor T2(T1) is undefined
		//t2.start();
		
		//should be
		T1 runnable = new T1();
		new Thread(runnable).start();//t1
		
		T2 thread = new T2();
		thread.start();//t2
		
		
	}
}
/*
� ���������� ���������� � ������� ����� ��������: 
	t1 t2;
	t2 t1;
3)	������ ����������: ����� start() �� ��������� � ������ T1;
4)	������ ����������: � ������ T2 �� ��������� �����������, �����-������ � �������� ��������� ������ Thread;
	������ �� ��������������.
	
	����� t1 �� ����� ���� ������, �.�. ����� T1 �� ����� ������ start(),
	 �� ������� ��� �����, ��������, �������� 
Thread t1 = new Thread(new T1());
������ t2 �� ����� ���� ������, 
�.�. � ������ T2 ��� ������������, ���������� ��������� ���������. 
�����: 3, 4.

*/
////////////////////////////
/*
 * ����� �� ��������� �������� �������� � ����, 
 * ��� ����� ��������� � ��������� ����������? (�������� ���)
	����� ������ sleep() ��� ���������;
2)	����� ������ stop();
3)	��������� ���������� ������ run();
	����� ������ notifyAll();
	����� ������ wait() � ���������� null.


������ sleep(), wait() �������� � ��������� ��������� � ��������
 � ��������� ������������������. ������ notify() � notifyAll()
  �� ����� ��������� � ��������� ��������� �������, 
  ��� ���� ���������� ������ ������ � ������ ��������
   � ������������������ ��������. ����� stop() 
   � ���������� ���������� ������ run() �������� ����� �
    ��������� ����������, �� �������� ������ ������
     � ��� �� ������ �������� ������ ����� ������������� ������. 
�����: 2, 3.

 */
///////////////////////////////////

class Quest5 extends Thread {
	Quest5() {
	}

	Quest5(Runnable r) {
		super(r);
	}

	public void run() {
		System.out.print("thread ");
	}

	public static void main(String[] args) {
		Runnable r = new Quest5(); // 1
		Quest5 t = new Quest5(r); // 2
		t.start();//thread 
	}
}

/*
��� ������� ���������� � ������� ����� ��������: 
	������ ���������� � ������ //1;
	������ ���������� � ������ //2;
3)	thread;
	thread thread; 
	��� ����� ��������������, �� ������ �������� �� �����.
*/

/*
 * ��� ������� ���������� ����� ������� ��� ������ r � t,
 *  �� �������� ������ ������. ����� t ���������������
 *   � �������������� ������ �� ������ �����.
 *    ��� �������������� � ������ ��������� �� ���������
 *     ������� �� ���������� ������� ������. 
 *     � ����� ����� run() ����� ������ ������ ���� ���. 
�����: 3.
*/
//////////////////////////////
class InThread implements Runnable {
	public void run() {
		System.out.println("running...");
	}
	public static void main(String[] args) {
		new Thread(new InThread()).start();
	}
}
/**
 * ������� ���������� �������� �������� ���������� ������� (1):
	new Thread().new InThread();
	new Runnable(new InThread());
	new Thread(Intread);
4)	new Thread(new InThread();
	new InThread().

��������� �������� �������� ������ ������ Thread.
 ����� ������� ��������� ������ � ������� �������,
  ����� �������� ��������� ��������� Runnable,
   ���������� ������� ����� ������� ���������������� ������ Thread
    � �������� ������ Runnable � ����������� ������ Thread
     �����: 4.
 */
/////////////////////////////

/**
 * ������� ������, ������������ � ������ java.lang.Thread (4):
1)	join()
2)	getPrioroty()
	wait()
	notifyAll()
5)	sleep()
6)	getName()

������ wait() � notifyAll() ���������� � ������ java.lang.Object. 
��������� ������ ���������� � ������ java.lang.Thread.
 �����: 1,2, 5, 6.
 */
//////////////////////////////////
/**
 * ������� ��������� ������, 
 * ��� ������ �� ������� ����� isAlive() 
 * ������ java.lang.Thread ������ �������� true (4):
	NEW
2)	RUNNABLE
3)	BLOCKED
4)	WAITING
5)	TIMED WAITING
	TERMINATED

����� isAlive() ���������� true,
 ����� ����� ��������� � ��������������� ���������
  ��� � ���������, �� �������� �� ����� ��������� � ���������������.
�����: 2, 3, 4, 5.
 */
class MiniTest extends Thread{
	public void run() {
		System.out.println("run...");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		MiniTest t = new MiniTest();
		System.out.println(t.getState());//NEW
		t.start();
		System.out.println(t.getState());//RUNNABLE
		Thread.sleep(1000);
		System.out.println(t.getState());//TIMED_WAITING
		Thread.sleep(3000);
		System.out.println(t.getState());//TERMINATED
		/**
		 * NEW 
		 * RUNNABLE 
		 * run... 
		 * TIMED_WAITING 
		 * TERMINATED
		 */
	}
}
////////////////////////////////
class InThread3 implements Runnable {
	public void run() {
		System.out.println("running...");
	}
}

class Quest4 {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(2);
		exec.execute(new InThread3());
		exec.execute(new InThread3());
		exec.execute(new InThread3());
		exec.execute(new InThread3());
		exec.execute(new InThread3());
		exec.execute(new InThread());
		exec.shutdown();
		while (!exec.isTerminated()) {
		}
	}
}


/**
 * ������� ������� �������� ������ ���� ��� ������� ����� ���� (1)?
    2
	4
	�
4)	6
	�������, ������� ������ �� ���������� ������ main()
	
 * � ������� �������, ��������������� ����� ��� �������
 *  �������������� �������, ����������� ��� ����� �����������
 *   �� ������ main() �������, �� ��� ������������.
 */
///////////////////////////////
/**
 * ��� ����� Lamp(��������).
 *  ���������� ��������� ���� ������ ���� ������
 *   turnOn ���, ����� �� ��������� �������� ��������� ��������,
 *    ����� ��� ��� �������� (���� lamp ����� �������� true, 
 *    ����� �������� ��������):
 *
 *
 */
class Lamp {
	private boolean lamp = false;

	public synchronized void turnOn() throws InterruptedException {
		
		while (lamp == true) {
			wait();
		}
		
		lamp =true;
		
		notify();
		
	}
}
/**
a)	lamp = true;
b)	notify();
c)	while (lamp == true) wait();
�������� ���� ������� (1):
	abc;
	bca;
	acb;
	cba;
5)	cab.
������������������ �������� ��� ������ turnOn() ���������: 
���� �������� ����� � ����, ���� �� �� ��������,
�������� ��������, ��������� ��������� ��������� ������.
�����: 5.
*/







