package medium.thediningphilosophers;

class DiningPhilosophers {

    private final int numPhilosophers = 5;
    private final Object[] forks = new Object[numPhilosophers];

    public DiningPhilosophers() {
        for (int i = 0; i < numPhilosophers; i++)
            forks[i] = new Object();
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) {
        int left = (philosopher + 1) % numPhilosophers;
        if (left < philosopher) {
            synchronized(forks[left]) {
                pickLeftFork.run();
                synchronized(forks[philosopher]) {
                    pickRightFork.run();
                    eat.run();
                    putRightFork.run();
                }
                putLeftFork.run();
            }
        } else {
            synchronized(forks[philosopher]) {
                pickRightFork.run();
                synchronized (forks[left]) {
                    pickLeftFork.run();
                    eat.run();
                    putLeftFork.run();
                }
                putRightFork.run();
            }
        }
    }
}
