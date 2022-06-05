package org.suai.lab10;

import java.util.ArrayDeque;

public class WritersReadersFast extends WritersReaders{

    public WritersReadersFast(ArrayDeque<Threads> queue) {
        super(queue);
    }

    public void goReadWrite() throws InterruptedException{
        ArrayDeque<Threads> startedThreads = new ArrayDeque<>();

        while (!queue.isEmpty()) {
            var curThread = queue.poll();

            startedThreads.add(curThread);

            curThread.start();
        }

        for (var node : startedThreads)
            node.join();
    }
}