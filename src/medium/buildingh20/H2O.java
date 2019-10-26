package medium.buildingh20;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Semaphore;

class H2O {
    private final Semaphore hcount = new Semaphore(2);
    private final Semaphore h2count = new Semaphore(0);
    private final Semaphore ocount = new Semaphore(0);
    private final CyclicBarrier complete = new CyclicBarrier(3);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hcount.acquire();
        h2count.release();
        ocount.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        try {
            complete.await();
        }
        catch (BrokenBarrierException bbe) {
            throw new InterruptedException();
        }
        hcount.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        h2count.acquire(2);
        ocount.release(2);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        try {
            complete.await();
        }
        catch (BrokenBarrierException bbe) {
            throw new InterruptedException();
        }
    }
}