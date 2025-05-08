package com.sun.jna;

/* loaded from: classes2.dex */
public class CallbackThreadInitializer {
    private boolean daemon;
    private boolean detach;
    private ThreadGroup group;
    private String name;

    public CallbackThreadInitializer() {
        this(true);
    }

    public boolean detach(Callback callback) {
        return this.detach;
    }

    public String getName(Callback callback) {
        return this.name;
    }

    public ThreadGroup getThreadGroup(Callback callback) {
        return this.group;
    }

    public boolean isDaemon(Callback callback) {
        return this.daemon;
    }

    public CallbackThreadInitializer(boolean z5) {
        this(z5, false);
    }

    public CallbackThreadInitializer(boolean z5, boolean z6) {
        this(z5, z6, null);
    }

    public CallbackThreadInitializer(boolean z5, boolean z6, String str) {
        this(z5, z6, str, null);
    }

    public CallbackThreadInitializer(boolean z5, boolean z6, String str, ThreadGroup threadGroup) {
        this.daemon = z5;
        this.detach = z6;
        this.name = str;
        this.group = threadGroup;
    }
}
