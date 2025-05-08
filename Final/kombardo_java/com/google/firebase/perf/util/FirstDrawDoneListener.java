package com.google.firebase.perf.util;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.firebase.perf.util.FirstDrawDoneListener;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class FirstDrawDoneListener implements ViewTreeObserver.OnDrawListener {
    private final Runnable callback;

    @SuppressLint({"ThreadPoolCreation"})
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private final AtomicReference<View> viewReference;

    private FirstDrawDoneListener(View view, Runnable runnable) {
        this.viewReference = new AtomicReference<>(view);
        this.callback = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onDraw$0(View view) {
        view.getViewTreeObserver().removeOnDrawListener(this);
    }

    public static void registerForNextDraw(View view, Runnable runnable) {
        view.getViewTreeObserver().addOnDrawListener(new FirstDrawDoneListener(view, runnable));
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public void onDraw() {
        final View andSet = this.viewReference.getAndSet(null);
        if (andSet == null) {
            return;
        }
        andSet.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: W0.a
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                FirstDrawDoneListener.this.lambda$onDraw$0(andSet);
            }
        });
        this.mainThreadHandler.postAtFrontOfQueue(this.callback);
    }
}
