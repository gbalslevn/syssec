package androidx.core.provider;

import android.os.Handler;
import android.os.Process;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
abstract class RequestExecutor {

    /* loaded from: classes.dex */
    private static class DefaultThreadFactory implements ThreadFactory {
        private int mPriority;
        private String mThreadName;

        /* loaded from: classes.dex */
        private static class ProcessPriorityThread extends Thread {
            private final int mPriority;

            ProcessPriorityThread(Runnable runnable, String str, int i5) {
                super(runnable, str);
                this.mPriority = i5;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.mPriority);
                super.run();
            }
        }

        DefaultThreadFactory(String str, int i5) {
            this.mThreadName = str;
            this.mPriority = i5;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new ProcessPriorityThread(runnable, this.mThreadName, this.mPriority);
        }
    }

    /* loaded from: classes.dex */
    private static class HandlerExecutor implements Executor {
        private final Handler mHandler;

        HandlerExecutor(Handler handler) {
            this.mHandler = (Handler) Preconditions.checkNotNull(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.mHandler.post((Runnable) Preconditions.checkNotNull(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.mHandler + " is shutting down");
        }
    }

    /* loaded from: classes.dex */
    private static class ReplyRunnable<T> implements Runnable {
        private Callable<T> mCallable;
        private Consumer<T> mConsumer;
        private Handler mHandler;

        ReplyRunnable(Handler handler, Callable<T> callable, Consumer<T> consumer) {
            this.mCallable = callable;
            this.mConsumer = consumer;
            this.mHandler = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            final T t5;
            try {
                t5 = this.mCallable.call();
            } catch (Exception unused) {
                t5 = null;
            }
            final Consumer<T> consumer = this.mConsumer;
            this.mHandler.post(new Runnable() { // from class: androidx.core.provider.RequestExecutor.ReplyRunnable.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    consumer.accept(t5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadPoolExecutor createDefaultExecutor(String str, int i5, int i6) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i6, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new DefaultThreadFactory(str, i5));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Executor createHandlerExecutor(Handler handler) {
        return new HandlerExecutor(handler);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void execute(Executor executor, Callable<T> callable, Consumer<T> consumer) {
        executor.execute(new ReplyRunnable(CalleeHandler.create(), callable, consumer));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T submit(ExecutorService executorService, Callable<T> callable, int i5) {
        try {
            return executorService.submit(callable).get(i5, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e5) {
            throw e5;
        } catch (ExecutionException e6) {
            throw new RuntimeException(e6);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
