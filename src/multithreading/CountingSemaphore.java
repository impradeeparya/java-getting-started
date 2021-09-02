package multithreading;

/**
 * @author Pradeep Arya
 */
public class CountingSemaphore {

    private int count = 0;
    private int upperBound = 0;

    public CountingSemaphore(int upperBound) {
        this.upperBound = upperBound;
    }

    public synchronized void acquire() throws InterruptedException {

        while (this.count == this.upperBound) {
            wait();
        }

        this.count = this.count + 1;
    }

    public synchronized void release() {
        if (this.count > 0) {
            notifyAll();
            this.count = this.count - 1;
        }
    }

}
