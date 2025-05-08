package com.google.common.util.concurrent;

import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public abstract class Uninterruptibles {
    public static <V> V getUninterruptibly(Future<V> future) {
        V v5;
        boolean z5 = false;
        while (true) {
            try {
                v5 = future.get();
                break;
            } catch (InterruptedException unused) {
                z5 = true;
            } catch (Throwable th) {
                if (z5) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z5) {
            Thread.currentThread().interrupt();
        }
        return v5;
    }
}
