package medium.designboundedblockingqueue;

class BoundedBlockingQueue {

    private final int[] queue;
    private int size = 0;
    private int head = 0;
    private int tail = 0;
    private final int capacity;

    public BoundedBlockingQueue(int capacity) {
        queue = new int[capacity];
        this.capacity = capacity;
    }

    synchronized public void enqueue(int element) {
        while (size == capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        size++;
        queue[head] = element;
        head = (head+1) % queue.length;
        notify();
    }

    synchronized public int dequeue() {
        while (size == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                // Will just loop and wait again if necessary
            }
        }
        size--;
        int retval = queue[tail];
        tail = (tail+1) % queue.length;
        notify();
        return retval;
    }

    public int size() {
        return size;
    }
}