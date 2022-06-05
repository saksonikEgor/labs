package org.suai.lab10;

public class StackReader extends Threads {

    public StackReader(SynchroStack s) {
        super(s);
    }

    @Override
    public void run() {
        stack.toString();
    }
}
