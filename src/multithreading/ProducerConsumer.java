package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Pradeep Arya
 */

class Producer {

    private List<String> items;
    private int itemCount;
    private CountingSemaphore producerSemaphore;
    private CountingSemaphore consumerSemaphore;

    public Producer(List<String> items, int itemCount, CountingSemaphore producerSemaphore, CountingSemaphore consumerSemaphore) {
        this.items = items;
        this.itemCount = itemCount;
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    public void produce() throws InterruptedException {

        producerSemaphore.acquire();
        synchronized (this) {
            if (items.size() == itemCount) {
                System.out.println("Producer waiting " + items.size());
                wait();
            }
            String item = "product - " + Thread.currentThread().getName();
            System.out.println("Producing item " + Thread.currentThread().getName() + " - " + item);
            this.items.add(item);
            notify();
        }
        producerSemaphore.release();
    }

}

class Consumer {

    private List<String> items;
    private CountingSemaphore consumerSemaphore;

    public Consumer(List<String> items, CountingSemaphore consumerSemaphore) {
        this.items = items;
        this.consumerSemaphore = consumerSemaphore;
    }

    public void consume() throws InterruptedException {

        consumerSemaphore.acquire();
        synchronized (this) {
            if (items.isEmpty()) {
                System.out.println("Consumer waiting " + items.size());
                wait();
            }
            System.out.println("Consuming item " + Thread.currentThread().getName() + " - " + this.items.remove(this.items.size() - 1));
            notify();
        }
        consumerSemaphore.release();
    }
}

public class ProducerConsumer {

    public static void main(String[] args) {

        List<String> items = new ArrayList<>();
        int size = 3;
        CountingSemaphore producerSemaphore = new CountingSemaphore(3);
        CountingSemaphore consumerSemaphore = new CountingSemaphore(3);
        Producer producer = new Producer(items, size, producerSemaphore, consumerSemaphore);
        Consumer consumer = new Consumer(items, consumerSemaphore);
        int count = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        while (count > 0) {
            executorService.submit(() -> {
                try {
                    producer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            executorService.submit(() -> {
                try {
                    consumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            count--;
        }

        executorService.shutdown();

    }
}
