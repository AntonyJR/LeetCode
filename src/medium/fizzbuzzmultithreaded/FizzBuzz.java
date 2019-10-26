package medium.fizzbuzzmultithreaded;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;
    private int current = 0;
    private static final int FIZZ = 0;
    private static final int BUZZ = FIZZ+1;
    private static final int FIZZBUZZ = BUZZ+1;
    private static final int NUMBER = FIZZBUZZ+1;
    private static final int STATES = NUMBER+1;
    private Semaphore[] blocks = new Semaphore[STATES];

    public FizzBuzz(int n) {
        this.n = n;
        for (int i=0; i<STATES; i++) {
            blocks[i] = new Semaphore(1);
            blocks[i].acquireUninterruptibly();
        }
        processNext();
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        commonOut(printFizz, FIZZ);
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        commonOut(printBuzz, BUZZ);
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        commonOut(printFizzBuzz, FIZZBUZZ);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            blocks[NUMBER].acquire();
            if (current > n)
                break;
            printNumber.accept(current);
            processNext();
        }
    }

    private void commonOut(Runnable target, int semaphore) throws InterruptedException {
        while (true) {
            blocks[semaphore].acquire();
            if (current > n)
                break;
            target.run();
            processNext();
        }
    }

    private void processNext() {
        current++;
        if (current <= n) {
            boolean fizz = current % 3 == 0;
            boolean buzz = current % 5 == 0;
            if (fizz && buzz) blocks[FIZZBUZZ].release();
            else if (fizz) blocks[FIZZ].release();
            else if (buzz) blocks[BUZZ].release();
            else blocks[NUMBER].release();
        }
        else {
            for (Semaphore semaphore : blocks)
                semaphore.release();
        }
    }
}
