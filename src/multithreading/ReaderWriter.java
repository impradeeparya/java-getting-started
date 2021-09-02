package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Pradeep Arya
 */


class Reader {

    private BinarySemaphore readerSemaphore;
    private BinarySemaphore writerSemaphore;
    private int readCount;

    public Reader(BinarySemaphore readerSemaphore, BinarySemaphore writerSemaphore, int readCount) {
        this.readCount = readCount;
        this.readerSemaphore = readerSemaphore;
        this.writerSemaphore = writerSemaphore;
    }

    public void read() throws InterruptedException {

        readerSemaphore.acquire();
        this.readCount++;

        if (this.readCount == 1) writerSemaphore.acquire();

        readerSemaphore.release();

        System.out.println("Reader " + Thread.currentThread().getName() + " reading");

        readerSemaphore.acquire();
        this.readCount--;
        if (this.readCount == 0) {
            System.out.println("Reader " + Thread.currentThread().getName() + " releasing writer");
            writerSemaphore.release();
        }

        readerSemaphore.release();


    }

}

class Writer {

    private BinarySemaphore writerSemaphore;

    public Writer(BinarySemaphore writerSemaphore) {
        this.writerSemaphore = writerSemaphore;
    }

    public void write() throws InterruptedException {
        writerSemaphore.acquire();
        System.out.println("Writer " + Thread.currentThread().getName() + " writing");
        writerSemaphore.release();

    }
}

public class ReaderWriter {

    public static void main(String[] args) {

        BinarySemaphore readerSemaphore = new BinarySemaphore();
        BinarySemaphore writerSemaphore = new BinarySemaphore();

        Writer writer = new Writer(writerSemaphore);
        Reader reader = new Reader(readerSemaphore, writerSemaphore, 0);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        int count = 10;
        while (count > 0) {

            executor.submit(() -> {
                try {
                    writer.write();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            executor.submit(() -> {
                try {
                    reader.read();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            count--;
        }

        executor.shutdown();


    }
}
