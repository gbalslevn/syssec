package com.facebook;

import com.facebook.GraphRequestBatch;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u00012\u00020\u0002B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001a\u0010\u001fJ\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001a\u0010!J\u000f\u0010\"\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\"\u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010#R \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010$R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010%R$\u0010*\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010'R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010%R\u0018\u0010-\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/facebook/ProgressOutputStream;", "Ljava/io/FilterOutputStream;", "Lcom/facebook/RequestOutputStream;", "Ljava/io/OutputStream;", "out", "Lcom/facebook/GraphRequestBatch;", "requests", BuildConfig.FLAVOR, "Lcom/facebook/GraphRequest;", "Lcom/facebook/RequestProgress;", "progressMap", BuildConfig.FLAVOR, "maxProgress", "<init>", "(Ljava/io/OutputStream;Lcom/facebook/GraphRequestBatch;Ljava/util/Map;J)V", "size", BuildConfig.FLAVOR, "addProgress", "(J)V", "reportBatchProgress", "()V", "request", "setCurrentRequest", "(Lcom/facebook/GraphRequest;)V", BuildConfig.FLAVOR, "buffer", "write", "([B)V", BuildConfig.FLAVOR, "offset", "length", "([BII)V", "oneByte", "(I)V", "close", "Lcom/facebook/GraphRequestBatch;", "Ljava/util/Map;", "J", "getMaxProgress", "()J", "threshold", "<set-?>", "batchProgress", "getBatchProgress", "lastReportedProgress", "currentRequestProgress", "Lcom/facebook/RequestProgress;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ProgressOutputStream extends FilterOutputStream implements RequestOutputStream {
    private long batchProgress;
    private RequestProgress currentRequestProgress;
    private long lastReportedProgress;
    private final long maxProgress;
    private final Map<GraphRequest, RequestProgress> progressMap;
    private final GraphRequestBatch requests;
    private final long threshold;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressOutputStream(OutputStream out, GraphRequestBatch requests, Map<GraphRequest, RequestProgress> progressMap, long j5) {
        super(out);
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(progressMap, "progressMap");
        this.requests = requests;
        this.progressMap = progressMap;
        this.maxProgress = j5;
        this.threshold = FacebookSdk.getOnProgressThreshold();
    }

    private final void addProgress(long size) {
        RequestProgress requestProgress = this.currentRequestProgress;
        if (requestProgress != null) {
            requestProgress.addProgress(size);
        }
        long j5 = this.batchProgress + size;
        this.batchProgress = j5;
        if (j5 >= this.lastReportedProgress + this.threshold || j5 >= this.maxProgress) {
            reportBatchProgress();
        }
    }

    private final void reportBatchProgress() {
        if (this.batchProgress > this.lastReportedProgress) {
            for (GraphRequestBatch.Callback callback : this.requests.getCallbacks()) {
            }
            this.lastReportedProgress = this.batchProgress;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        Iterator<RequestProgress> it = this.progressMap.values().iterator();
        while (it.hasNext()) {
            it.next().reportProgress();
        }
        reportBatchProgress();
    }

    @Override // com.facebook.RequestOutputStream
    public void setCurrentRequest(GraphRequest request) {
        this.currentRequestProgress = request != null ? this.progressMap.get(request) : null;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ((FilterOutputStream) this).out.write(buffer);
        addProgress(buffer.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] buffer, int offset, int length) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ((FilterOutputStream) this).out.write(buffer, offset, length);
        addProgress(length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int oneByte) {
        ((FilterOutputStream) this).out.write(oneByte);
        addProgress(1L);
    }
}
