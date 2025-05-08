package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public abstract class ListenerHolders {
    public static <L> ListenerHolder<L> createListenerHolder(L l5, Looper looper, String str) {
        Preconditions.checkNotNull(l5, "Listener must not be null");
        Preconditions.checkNotNull(looper, "Looper must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        return new ListenerHolder<>(looper, l5, str);
    }

    public static <L> ListenerHolder.ListenerKey<L> createListenerKey(L l5, String str) {
        Preconditions.checkNotNull(l5, "Listener must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        Preconditions.checkNotEmpty(str, "Listener type must not be empty");
        return new ListenerHolder.ListenerKey<>(l5, str);
    }
}
