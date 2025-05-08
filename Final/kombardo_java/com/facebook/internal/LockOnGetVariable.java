package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.internal.LockOnGetVariable;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/facebook/internal/LockOnGetVariable;", "T", BuildConfig.FLAVOR, "Ljava/util/concurrent/Callable;", "callable", "<init>", "(Ljava/util/concurrent/Callable;)V", "storedValue", "Ljava/lang/Object;", "Ljava/util/concurrent/CountDownLatch;", "initLatch", "Ljava/util/concurrent/CountDownLatch;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class LockOnGetVariable<T> {
    private CountDownLatch initLatch;
    private T storedValue;

    public LockOnGetVariable(final Callable<T> callable) {
        Intrinsics.checkNotNullParameter(callable, "callable");
        this.initLatch = new CountDownLatch(1);
        FacebookSdk.getExecutor().execute(new FutureTask(new Callable() { // from class: o0.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void m2860_init_$lambda0;
                m2860_init_$lambda0 = LockOnGetVariable.m2860_init_$lambda0(LockOnGetVariable.this, callable);
                return m2860_init_$lambda0;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-0, reason: not valid java name */
    public static final Void m2860_init_$lambda0(LockOnGetVariable this$0, Callable callable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callable, "$callable");
        try {
            this$0.storedValue = (T) callable.call();
        } finally {
            CountDownLatch countDownLatch = this$0.initLatch;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}
