package medium.printfoobaralternately;

class FooBar {
    private final int n;
    private boolean fooNext = true;

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (!fooNext)
                wait();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            fooNext = false;
            notify();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if (fooNext)
                wait();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooNext = true;
            notify();
        }
    }
}
