package org.suai.lab10;

public class Threads extends Thread {
    protected final SynchroStack stack;

    public Threads(SynchroStack s) {
        this.stack = s;
    }
}
