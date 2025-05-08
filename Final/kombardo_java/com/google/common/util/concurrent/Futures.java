package com.google.common.util.concurrent;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public abstract class Futures extends GwtFuturesCatchingSpecialization {

    /* loaded from: classes2.dex */
    private static final class CallbackListener<V> implements Runnable {
        final FutureCallback<? super V> callback;
        final Future<V> future;

        CallbackListener(Future<V> future, FutureCallback<? super V> futureCallback) {
            this.future = future;
            this.callback = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.callback.onSuccess(Futures.getDone(this.future));
            } catch (Error e5) {
                e = e5;
                this.callback.onFailure(e);
            } catch (RuntimeException e6) {
                e = e6;
                this.callback.onFailure(e);
            } catch (ExecutionException e7) {
                this.callback.onFailure(e7.getCause());
            }
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).addValue(this.callback).toString();
        }
    }

    public static <V> void addCallback(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        Preconditions.checkNotNull(futureCallback);
        listenableFuture.addListener(new CallbackListener(listenableFuture, futureCallback), executor);
    }

    public static <V> V getDone(Future<V> future) {
        Preconditions.checkState(future.isDone(), "Future was expected to be done: %s", future);
        return (V) Uninterruptibles.getUninterruptibly(future);
    }
}
