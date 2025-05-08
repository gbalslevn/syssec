package com.google.firebase.messaging.threads;

import android.annotation.SuppressLint;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public abstract class PoolableExecutors {
    private static final ExecutorFactory DEFAULT_INSTANCE;
    private static volatile ExecutorFactory instance;

    /* loaded from: classes2.dex */
    private static class DefaultExecutorFactory implements ExecutorFactory {
        private static final long CORE_THREAD_TIMEOUT_SECS = 60;

        private DefaultExecutorFactory() {
        }

        @Override // com.google.firebase.messaging.threads.ExecutorFactory
        public ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory, ThreadPriority threadPriority) {
            return newThreadPool(1, threadFactory, threadPriority);
        }

        @SuppressLint({"ThreadPoolCreation"})
        public ExecutorService newThreadPool(int i5, ThreadFactory threadFactory, ThreadPriority threadPriority) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i5, i5, CORE_THREAD_TIMEOUT_SECS, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return Executors.unconfigurableExecutorService(threadPoolExecutor);
        }
    }

    static {
        DefaultExecutorFactory defaultExecutorFactory = new DefaultExecutorFactory();
        DEFAULT_INSTANCE = defaultExecutorFactory;
        instance = defaultExecutorFactory;
    }

    public static ExecutorFactory factory() {
        return instance;
    }
}
