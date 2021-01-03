package com.leetcode.concurrency;

/**
 * wait/notify 信号量实现
 */
public class PrintInOrder {
    boolean first = false;
    boolean second = false;

    Object firstObject = new Object();
    Object secondObject = new Object();


    public PrintInOrder() {
        first = false;
        second = false;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (firstObject) {
            printFirst.run();
            first = true;
            firstObject.notify();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (firstObject) {
            while (!first) {
                //  阻塞，等待1线程
                firstObject.wait();
            }
        }
        synchronized (secondObject) {
            printSecond.run();
            second = true;
            secondObject.notify();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (secondObject) {
            while (!second) {
                // 阻塞，等待2线程
                secondObject.wait();
            }
        }
        printThird.run();
    }
}
