package medium.printzeroevenodd;

import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private final int n;
    private static class ReadyStatus {
        volatile boolean ready;
        ReadyStatus(boolean initial) {
            ready = initial;
        }
        synchronized void acquire() throws InterruptedException {
            if (!ready) wait();
            ready = false;
        }
        synchronized void release() {
            ready = true;
            notify();
        }
    }
    private final ReadyStatus zero = new ReadyStatus(true);
    private final ReadyStatus odd = new ReadyStatus(false);
    private final ReadyStatus even = new ReadyStatus(false);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if (i % 2 == 0)
                even.release();
            else
                odd.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2; i<=n; i+=2) {
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i<=n; i+=2) {
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}
