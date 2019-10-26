package easy.printinorder;

class Foo {
    static class Hold {
        boolean completed = false;
    }
    private final Hold first = new Hold();
    private final Hold second = new Hold();

    public Foo() {
    }

    public void first(Runnable printFirst) {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        synchronized(first) {
            first.completed = true;
            first.notify();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(first) {
            while (!first.completed)
                first.wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        synchronized(second) {
            second.completed = true;
            second.notify();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized(second) {
            while (!second.completed)
                second.wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
