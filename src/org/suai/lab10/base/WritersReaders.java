package org.suai.lab10;

import java.util.ArrayDeque;

public class WritersReaders {
    protected final ArrayDeque<Threads> queue;

    public WritersReaders(ArrayDeque<Threads> queue) {
        this.queue = queue;
    }

    public void goReadWrite() throws InterruptedException{
        while (!queue.isEmpty()) {
            var curThread = queue.poll();
            curThread.start();
            curThread.join();
        }
    }
}