package com.dunder.mifflin;

import java.util.Stack;

public class Scope {
    private Stack<Context> contextStack;

    public Scope() {
        this.contextStack = new Stack<>();
        this.contextStack.push(new Context());
    }

    public Context getContext() {
        return contextStack.peek();
    }
}
