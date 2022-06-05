package org.suai.lab10;

public class StackPoper extends Threads{

    public StackPoper(SynchroStack s) {
        super(s);
    }

    @Override
    public void run() {
        stack.pop();
    }
}
