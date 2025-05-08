package com.google.android.datatransport.runtime;

import android.annotation.SuppressLint;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.runtime.logging.Logging;

/* loaded from: classes.dex */
public abstract class ForcedSender {
    private static final String LOG_TAG = "ForcedSender";

    @SuppressLint({"DiscouragedApi"})
    public static void sendBlocking(Transport<?> transport, Priority priority) {
        if (!(transport instanceof TransportImpl)) {
            Logging.w(LOG_TAG, "Expected instance of `TransportImpl`, got `%s`.", transport);
        } else {
            TransportRuntime.getInstance().getUploader().logAndUpdateState(((TransportImpl) transport).getTransportContext().withPriority(priority), 1);
        }
    }
}
