package org.suai.lab10;

public class StackWriter extends Threads {
    protected int value;

    public StackWriter(SynchroStack s, int val) {
        super(s);
        this.value = val;
    }

    @Override
    public void run() {
        stack.push(value);
    }
}
