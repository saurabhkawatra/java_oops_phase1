import java.io.File;
import java.io.IOException;

public class ThreadProgram {
	
	static int raceLineFinish = 0;
	
	public static void main(String[] args) {
		
		System.out.println(System.getProperty("os.arch"));
		
		File file = new File("test.txt");
		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Thread threadA = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread A started");
				try {
					while(raceLineFinish < 100) {
						Thread.currentThread().sleep(5000);
						double randomNum = 0;
						while(randomNum == 0) {
							randomNum = Math.random()*10;
						}
						System.out.println("Random No generated from thread A - "+ randomNum);
						System.out.println("Thread A racelinefinish before increment - "+ raceLineFinish);
						raceLineFinish = raceLineFinish + (int) randomNum;
						System.out.println("Thread A racelinefinish after increment - "+ raceLineFinish);
					}
					System.out.println("Thread A Wins with raceLineFinish value to be "+ raceLineFinish);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		Thread threadB = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Thread B started");
				try {
					while(raceLineFinish < 100) {
						Thread.currentThread().sleep(5000);
						double randomNum = 0;
						while(randomNum == 0) {
							randomNum = Math.random()*10;
						}
						System.out.println("Random No generated from thread B - "+ randomNum);
						System.out.println("Thread B racelinefinish before increment - "+ raceLineFinish);
						raceLineFinish = raceLineFinish + (int) randomNum;
						System.out.println("Thread B racelinefinish after increment - "+ raceLineFinish);
					}
					System.out.println("Thread B Wins with raceLineFinish value to be "+ raceLineFinish);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread threadC = new Thread() {
			@Override
			public void run() {
				System.out.println("Run Method Override");
			}
		};
		
		threadA.start();
		threadB.start();
	}

}
