package com.facebook;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013R$\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/facebook/RequestProgress;", BuildConfig.FLAVOR, "Landroid/os/Handler;", "callbackHandler", "Lcom/facebook/GraphRequest;", "request", "<init>", "(Landroid/os/Handler;Lcom/facebook/GraphRequest;)V", BuildConfig.FLAVOR, "size", BuildConfig.FLAVOR, "addProgress", "(J)V", "addToMax", "reportProgress", "()V", "Landroid/os/Handler;", "Lcom/facebook/GraphRequest;", "threshold", "J", "<set-?>", "progress", "getProgress", "()J", "lastReportedProgress", "maxProgress", "getMaxProgress", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class RequestProgress {
    private final Handler callbackHandler;
    private long lastReportedProgress;
    private long maxProgress;
    private long progress;
    private final GraphRequest request;
    private final long threshold;

    public RequestProgress(Handler handler, GraphRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.callbackHandler = handler;
        this.request = request;
        this.threshold = FacebookSdk.getOnProgressThreshold();
    }

    public final void addProgress(long size) {
        long j5 = this.progress + size;
        this.progress = j5;
        if (j5 >= this.lastReportedProgress + this.threshold || j5 >= this.maxProgress) {
            reportProgress();
        }
    }

    public final void addToMax(long size) {
        this.maxProgress += size;
    }

    public final void reportProgress() {
        if (this.progress > this.lastReportedProgress) {
            this.request.getCallback();
        }
    }
}
