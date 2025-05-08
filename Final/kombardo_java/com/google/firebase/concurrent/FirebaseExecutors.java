package com.google.firebase.concurrent;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class FirebaseExecutors {

    /* loaded from: classes2.dex */
    private enum DirectExecutor implements Executor {
        INSTANCE;

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor directExecutor() {
        return DirectExecutor.INSTANCE;
    }

    public static Executor newSequentialExecutor(Executor executor) {
        return new SequentialExecutor(executor);
    }
}
