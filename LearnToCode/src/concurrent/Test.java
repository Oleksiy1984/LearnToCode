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
При попытке компиляции и запуска будет выведено: 
	i = 0;
	i = 1;
	ошибка компиляции: создать объект потока можно только с помощью инициализации объекта класса Thread или его наследников; 
4)	ошибка компиляции: неправильно реализован метод run();
	ошибка времени выполнения: поток должен запускаться методом start().
*/

////////////////////////////////////////////

class T22 {
	public static void main(String[] args) {
		Thread t1 = new Thread();
		t1.setPriority(7);
		ThreadGroup tg = new ThreadGroup("TG");
		tg.setMaxPriority(8);
		Thread t2 = new Thread(tg, "t2");
		System.out.print("приоритет t1=" + t1.getPriority());//7
		System.out.print(", приоритет t2=" + t2.getPriority());//5
	}
}

/**
В результате компиляции и выполнения будет выведено: 
1)	приоритет t1 = 7, приоритет t2 = 5;
	приоритет t1 = 7, приоритет t2 = 8;
	приоритет t1 = 10, приоритет t2 = 8;
	нет правильного.
	Поток t1 не входит ни в одну группу, 
	поэтому его приоритет останется неизменным,
	 т.е. 7. Вызов метода setMaxPriority()
	  для группы потоков с параметром 8 большим, чем 5, приведет к тому,
	   что приоритет группы потоков, а следовательно,
	    и потока t2 будет установлен как NORMAL_PRIORITY. 
Ответ: 1.

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
В результате компиляции и запуска будет выведено: 
	t1 t2;
	t2 t1;
3)	ошибка компиляции: метод start() не определен в классе T1;
4)	ошибка компиляции: в классе T2 не определен конструктор, прини-мающий в качестве параметра объект Thread;
	ничего из перечисленного.
	
	Поток t1 не может быть создан, т.к. класс T1 не имеет метода start(),
	 но создать его можно, например, командой 
Thread t1 = new Thread(new T1());
Объект t2 не может быть создан, 
т.к. у класса T2 нет конструктора, способного принимать параметры. 
Ответ: 3, 4.

*/
////////////////////////////
/*
 * Какое из указанных действий приведет к тому, 
 * что поток переходит в состояние “пассивный”? (выберите два)
	вызов метода sleep() без параметра;
2)	вызов метода stop();
3)	окончание выполнения метода run();
	вызов метода notifyAll();
	вызов метода wait() с параметром null.


Методы sleep(), wait() приводят к временной остановке и переходу
 в состояние “неработоспособный”. Методы notify() и notifyAll()
  не имеют отношения к изменению состояния потоков, 
  они лишь уведомляют другие потоки о снятии изоляции
   с синхронизированных ресурсов. Метод stop() 
   и завершение выполнения метода run() приводят поток в
    состояние “пассивный”, из которого запуск потока
     с тем же именем возможен только после инициализации ссылки. 
Ответ: 2, 3.

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
При попытке компиляции и запуска будет выведено: 
	ошибка компиляции в строке //1;
	ошибка компиляции в строке //2;
3)	thread;
	thread thread; 
	код будет откомпилирован, но ничего выведено не будет.
*/

/*
 * При запуске приложения будет создано два потока r и t,
 *  но стартует только второй. Поток t инициализирован
 *   с использованием ссылки на первый поток.
 *    Это обстоятельство в данном контексте не оказывает
 *     влияния на выполнение второго потока. 
 *     В итоге метод run() будет вызван только один раз. 
Ответ: 3.
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
 * Укажите правильные варианты создания потокового объекта (1):
	new Thread().new InThread();
	new Runnable(new InThread());
	new Thread(Intread);
4)	new Thread(new InThread();
	new InThread().

Потоковым объектом является объект класса Thread.
 Чтобы создать потоковый объект с помощью объекта,
  класс которого реализует интерфейс Runnable,
   необходимо придать этому объекту функциональность класса Thread
    — передать объект Runnable в конструктор класса Thread
     Ответ: 4.
 */
/////////////////////////////

/**
 * Укажите методы, определенные в классе java.lang.Thread (4):
1)	join()
2)	getPrioroty()
	wait()
	notifyAll()
5)	sleep()
6)	getName()

Методы wait() и notifyAll() определены в классе java.lang.Object. 
Остальные методы определены в классе java.lang.Thread.
 Ответ: 1,2, 5, 6.
 */
//////////////////////////////////
/**
 * Укажите состояния потока, 
 * при вызове на которых метод isAlive() 
 * класса java.lang.Thread вернет значение true (4):
	NEW
2)	RUNNABLE
3)	BLOCKED
4)	WAITING
5)	TIMED WAITING
	TERMINATED

Метод isAlive() возвращает true,
 когда поток находится в работоспособном состоянии
  или в состоянии, из которого он может вернуться в работоспособное.
Ответ: 2, 3, 4, 5.
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
 * Сколько потоков выполнит объект ехес при запуске этого кода (1)?
    2
	4
	О
4)	6
	столько, сколько успеет до завершения метода main()
	
 * С помощью объекта, представляющего собой пул потоков
 *  фиксированного размера, выполняются все шесть запускаемых
 *   из метода main() потоков, по два одновременно.
 */
///////////////////////////////
/**
 * Дан класс Lamp(лампочка).
 *  Расставьте указанные ниже строки кода метода
 *   turnOn так, чтобы не допустить ситуации включения лампочки,
 *    когда она уже включена (поле lamp имеет значение true, 
 *    когда лампочка включена):
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
Выберите один вариант (1):
	abc;
	bca;
	acb;
	cba;
5)	cab.
Последовательность действий для метода turnOn() следующая: 
если лампочка горит — ждем, пока ее не выключат,
включаем лампочку, оповещаем возможных остальных ждущих.
Ответ: 5.
*/
/**
 * Выполнение какого из указанных действий приведет к тому,
 *  что поток переходит в состояние «пассивный»? (выберите 2) 
   вызов метода wait() с параметром null  
   вызов метода sleep() без параметра  
 3.  вызов метода stop()  
 4.  окончание выполнения метода run()  
   вызов метода notufyAll()  

 */
////////////////////////
// 3 methods to start thread
//in thread constructor (pass T extends Thread, pass T implem Runnable
class Test10 {
	public static void main(String[] argv) {
		//1
		Thread t = new Thread(
			new MyThread());
		t.start();//123
		//2
		Thread t2 = new Thread(
				new MyThread2());
			t2.start();//runnable
			//3
			MyThread thread = new MyThread();
			thread.start();//123
					
			MyThread2 runn = new MyThread2();
					//runn.start();Can't start runnable
			
			
	}
}

class MyThread extends Thread {
	@Override
	public void run() {System.out.println(123);}
} 
class MyThread2 implements Runnable {
	@Override
	public void run() {System.out.println("runnable");}
}
/////////////////////////////////////
class Test12 extends Thread {
	public void run() {
		for (int j = 0; j < 10; j++) {
			System.out.println(j);
			try {Thread.sleep(200);}
			catch (Exception e) {e.printStackTrace();}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		Test12 t = new Test12(); t.start();
		Thread.sleep(1000);
		t.interrupt(); // через секунду будет выброс 
	 	// исключения методом sleep если он
	}	// выполняется в данный момент
}
///////////////////////////////////////
class MyThread3 implements Runnable{
	public void run () {
		for (int i = 0; i<1000;i++)
		System.out.println("Heelo");
	}
}
class Runn{
	public static void main(String[] args) throws InterruptedException {
		MyThread3 t =new MyThread3();
		Thread th = new Thread(t);
		th.start();
		//th.interrupt();
		th.start();//java.lang.IllegalThreadStateException
	}
}
////////////////////////////////////
/**
 * Which of the following statements about the Callable call()
 *  and Runnable run()
methods are correct? (Choose all that apply.)
A. Both can throw unchecked exceptions.
B. Callable takes a generic method argument.
C. Callable can throw a checked exception.
D. Both can be implemented with lambda expressions.
E. Runnable returns a generic type.
F. Callable returns a generic type.
G. Both methods return void.

A, C, D, F. Runnable and Callable statements 
both take no method arguments as input,
so B is incorrect. Runnable returns void and Callable
 returns a generic type, so F is correct, 
 and E and G are incorrect. All methods are capable
  of throwing unchecked exceptions,
so A is correct. Only Callable is capable of throwing
 checked exceptions, so C is correct.
Both Runnable and Callable can be implemented 
with lambda expressions, so D is correct.
 */
/////////////////////////////////
/**
 * Fill in the blanks:__ occur(s) when two or more threads
 *  are blocked forever but
both appear active. 
____occur(s) when two or more threads try to complete a related
task at the same time.
A. Livelock, Deadlock
B. Deadlock, Starvation
C. Race conditions, Deadlock
D. Livelock, Race conditions
E. Starvation, Race conditions
F. Deadlock, Livelock

D. Livelock occurs when two or more threads are conceptually
 blocked forever, although
they are each still active and trying to complete their task.
 A race condition is an undesirable
result that occurs when two tasks are completed at the same time, 
which should have
been completed sequentially. For these reasons, D is the only 
correct answer.
 */


