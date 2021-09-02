package multithreading;

/**
 * @author Pradeep Arya
 */
public class BinarySemaphore {
    private boolean lock = false;

    public synchronized void acquire() throws InterruptedException {

        while (lock) {
            wait();
        }

        this.lock = true;
    }

    public synchronized void release() {
        if (lock) {
            this.notifyAll();
            this.lock = false;
        }
    }

}
