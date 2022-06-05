package org.suai.lab10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SynchroStackFast extends SynchroStack {

    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
    private final Lock writeLock = lock.writeLock();
    private final Lock readLock = lock.readLock();

    public void push(int value) {
        try {
            writeLock.lock();
            super.push(value);
        } finally {
            writeLock.unlock();
        }
    }

    public int pop() {
        int result;

        try {
            writeLock.lock();
            result = super.pop();
        }
        finally {
            writeLock.unlock();
        }

        return result;
    }

    public String toString() {
        String result;

        try {
            readLock.lock();
            result = super.toString();
        }
        finally {
            readLock.unlock();
        }

        return result;
    }
}
