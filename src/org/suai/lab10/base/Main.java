package org.suai.lab10;

import java.util.ArrayDeque;

public class Main {
    public static void test1() {
        ArrayDeque<Threads> queue = new ArrayDeque<>();
        SynchroStack stack = new SynchroStack();

        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(8);
        stack.push(9);
        stack.push(10);

        queue.add(new StackReader(stack));
        queue.add(new StackWriter(stack, 11));
        queue.add(new StackWriter(stack, 4));
        queue.add(new StackReader(stack));
        queue.add(new StackPoper(stack));
        queue.add(new StackReader(stack));

        for (int i = 0; i < 120; i++)
            queue.add(new StackReader(stack));

        WritersReaders wr = new WritersReaders(queue);

        try {
            wr.goReadWrite();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void test2() {
        ArrayDeque<Threads> queue = new ArrayDeque<>();
        SynchroStackFast stack = new SynchroStackFast();

        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(8);
        stack.push(9);
        stack.push(10);

        queue.add(new StackReader(stack));
        queue.add(new StackWriter(stack, 11));
        queue.add(new StackWriter(stack, 4));
        queue.add(new StackReader(stack));
        queue.add(new StackPoper(stack));
        queue.add(new StackReader(stack));

        for (int i = 0; i < 120; i++)
            queue.add(new StackReader(stack));

        WritersReadersFast wr = new WritersReadersFast(queue);

        try {
            wr.goReadWrite();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.println("test1: ");

        long start = System.currentTimeMillis();

        test1();

        long finish = System.currentTimeMillis();
        System.out.println(finish - start + "ms");



        System.out.println("test2: ");

        start = System.currentTimeMillis();

        test2();

        finish = System.currentTimeMillis();
        System.out.println(finish - start + "ms");
    }
}
