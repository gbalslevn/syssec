package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class ExecutionModule_ExecutorFactory implements Factory<Executor> {

    /* loaded from: classes.dex */
    private static final class InstanceHolder {
        private static final ExecutionModule_ExecutorFactory INSTANCE = new ExecutionModule_ExecutorFactory();
    }

    public static ExecutionModule_ExecutorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static Executor executor() {
        return (Executor) Preconditions.checkNotNullFromProvides(ExecutionModule.executor());
    }

    @Override // javax.inject.Provider
    public Executor get() {
        return executor();
    }
}
