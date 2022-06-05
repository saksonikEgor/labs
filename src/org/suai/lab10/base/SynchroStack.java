package org.suai.lab10;

public class SynchroStack {
    protected int size;
    protected StackNode first;
    protected StackNode last;

    static class StackNode {
        private StackNode prev;
        private StackNode next;
        private int value;
        private int index = 0;

        public StackNode(int val, StackNode prev, StackNode next) {
            value = val;
            this.prev = prev;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public StackNode getPrev() {
            return prev;
        }

        public StackNode getNext() {
            return next;
        }

        public void setPrev(StackNode prev) {
            this.prev = prev;
        }

        public void setNext(StackNode next) {
            this.next = next;
        }

        public int getIndex() {
            return this.index;
        }

        public void setIndex(int id) {
            this.index = id;
        }
    }

    public void push(int value) {
        StackNode cur = new StackNode(value, last, null);

        if (size == 0)
            first = cur;
        else {
            StackNode node = cur.getPrev();
            node.setNext(cur);
        }

        cur.setIndex(size);
        size++;
        last = cur;
    }

    public int pop() {
        if (size == 0)
            throw new RuntimeException("вы пытаетесь удалить элемент из пустого стэка");

        StackNode cur = last;

        if (size > 1) {
            last = last.getPrev();
            last.setNext(null);
        } else
            last = null;

        size--;
        return cur.getValue();
    }
/*
    public int getElement(int id) {
        if (id >= size)
            throw new RuntimeException("вы пытаетесь получить элемент, с несуществующим ииндексом");

        var cur = first;

        while (cur.getIndex() != id) {
            cur = cur.getNext();
        }

        return cur.getValue();
    }

 */

    public String toString() {
        StringBuilder str = new StringBuilder();

        if (size != 0) {
            StackNode cur = first;

            while (cur != last) {
                str.append(cur.getValue()).append(" ");
                cur = cur.getNext();
            }

            str.append(last.getValue()).append(" ");
        }
        return str.toString();
    }
}