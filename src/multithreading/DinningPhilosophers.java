package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Pradeep Arya
 */

class Fork {

}

class Philosopher implements Runnable {

    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(Fork leftFork, Fork rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }


    @Override
    public void run() {

        synchronized (leftFork) {
            synchronized (rightFork) {
                System.out.println("Philosopher " + Thread.currentThread().getName() + " eating");
            }
        }

    }
}

public class DinningPhilosophers {

    public static void main(String[] args) {

        int philosophersCount = 5;
        Philosopher[] philosophers = new Philosopher[philosophersCount];
        Fork[] forks = new Fork[philosophersCount];
        for (int index = 0; index < philosophersCount; index++) {
            forks[index] = new Fork();
        }

        for (int index = 0; index < philosophersCount; index++) {
            philosophers[index] = new Philosopher(forks[index], forks[(index + 1) % philosophersCount]);

        }

        ExecutorService executorService = Executors.newFixedThreadPool(philosophersCount);

        for (int index = 0; index < philosophersCount; index++) {
            executorService.submit(philosophers[index]);
        }

        executorService.shutdown();

    }
}
