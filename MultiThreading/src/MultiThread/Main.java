package MultiThread;

public class Main {
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		Thread myThread = new Thread() {
			@Override
			public void run() {
				System.out.println("Custom Thread 1 st command");
				System.out.println(Thread.currentThread().getName());
			}
			
		};
		
		System.out.println("Before Thread start");
		myThread.start();
		System.out.println("After Thread start");
		
		try {
			System.out.println("Asking main thread to wait for custom thread to finish");
			myThread.join();
			Thread.currentThread().sleep(4000);
			System.out.println("Main thread stopped waiting");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main thread last command");
		
	}

}
