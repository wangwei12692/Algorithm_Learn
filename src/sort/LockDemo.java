package sort;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PrintAB2{
    public static void main(String[] args) {
        PrintAB2 printAb = new PrintAB2();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    printAb.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    printAb.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    Lock lock = new ReentrantLock();
    Condition cond = lock.newCondition();

    boolean flag = true;

    void printA() throws InterruptedException {
        try {
            lock.lock();
            while (flag) {
                cond.await();
            }
            System.out.println("A");
            flag = true;
            cond.signal();
        }finally {
            lock.unlock();
        }
    }

    void printB() throws InterruptedException {
        try {
            lock.lock();
            while (!flag) {
                cond.await();
            }
            System.out.println("B");
            flag = false;
            cond.signal();
        }finally {
            lock.unlock();
        }
    }
}

class PrintAb{
    public static void main(String[] args) {
        PrintAb printAb = new PrintAb();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printAb.printA();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                printAb.printB();
            }
        }).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    boolean flag = true;


    synchronized void printA() {
        while (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("A");
        flag = false;
        notify();
    }

    synchronized void printB() {
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("B");
        flag = true;
        notify();
    }
}

public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        LockDemo lockDemo = new LockDemo();
        new Thread(() -> lockDemo.printChar(0,'A')).start();
        new Thread(() -> lockDemo.printChar(1,'B')).start();
        new Thread(() -> lockDemo.printChar(2,'C')).start();

        Thread.sleep(2000);
    }

    private final ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    private void printChar(int target, char c) {
        for (int i = 0; i < 10;) {
            try {
                lock.lock();
                if (count % 3 == target) {
                    System.out.println(c);
                    count++;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
