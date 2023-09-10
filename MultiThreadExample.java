package semIV;
import java.util.Random;

public class MultiThreadExample {
	static int a=10;
    public static void main(String[] args) {
        Random rand = new Random();
        
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (a>0) {
                	a--;
                    int number = rand.nextInt(100);
                    System.out.println("Generated number: " + number);
                    if (number % 2 == 0) {
                        synchronized (this) {
                            new Thread(new SquareThread(number)).start();
                        }
                    } else {
                        synchronized (this) {
                            new Thread(new CubeThread(number)).start();
                        }
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
    }

    static class SquareThread implements Runnable {
        private int number;

        public SquareThread(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            int square = number * number;
            System.out.println("Square of " + number + ": " + square);
        }
    }

    static class CubeThread implements Runnable {
        private int number;

        public CubeThread(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            int cube = number * number * number;
            System.out.println("Cube of " + number + ": " + cube);
        }
    }
}
