package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class InstrHttpOutputStream extends OutputStream {
    long bytesWritten = -1;
    NetworkRequestMetricBuilder networkMetricBuilder;
    private final OutputStream outputStream;
    private final Timer timer;

    public InstrHttpOutputStream(OutputStream outputStream, NetworkRequestMetricBuilder networkRequestMetricBuilder, Timer timer) {
        this.outputStream = outputStream;
        this.networkMetricBuilder = networkRequestMetricBuilder;
        this.timer = timer;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j5 = this.bytesWritten;
        if (j5 != -1) {
            this.networkMetricBuilder.setRequestPayloadBytes(j5);
        }
        this.networkMetricBuilder.setTimeToRequestCompletedMicros(this.timer.getDurationMicros());
        try {
            this.outputStream.close();
        } catch (IOException e5) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e5;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        try {
            this.outputStream.flush();
        } catch (IOException e5) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e5;
        }
    }

    @Override // java.io.OutputStream
    public void write(int i5) {
        try {
            this.outputStream.write(i5);
            long j5 = this.bytesWritten + 1;
            this.bytesWritten = j5;
            this.networkMetricBuilder.setRequestPayloadBytes(j5);
        } catch (IOException e5) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e5;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        try {
            this.outputStream.write(bArr);
            long length = this.bytesWritten + bArr.length;
            this.bytesWritten = length;
            this.networkMetricBuilder.setRequestPayloadBytes(length);
        } catch (IOException e5) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e5;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) {
        try {
            this.outputStream.write(bArr, i5, i6);
            long j5 = this.bytesWritten + i6;
            this.bytesWritten = j5;
            this.networkMetricBuilder.setRequestPayloadBytes(j5);
        } catch (IOException e5) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e5;
        }
    }
}
