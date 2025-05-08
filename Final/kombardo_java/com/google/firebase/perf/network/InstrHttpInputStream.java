package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class InstrHttpInputStream extends InputStream {
    private final InputStream inputStream;
    private final NetworkRequestMetricBuilder networkMetricBuilder;
    private long timeToResponseInitiated;
    private final Timer timer;
    private long bytesRead = -1;
    private long timeToResponseLastRead = -1;

    public InstrHttpInputStream(InputStream inputStream, NetworkRequestMetricBuilder networkRequestMetricBuilder, Timer timer) {
        this.timer = timer;
        this.inputStream = inputStream;
        this.networkMetricBuilder = networkRequestMetricBuilder;
        this.timeToResponseInitiated = networkRequestMetricBuilder.getTimeToResponseInitiatedMicros();
    }

    @Override // java.io.InputStream
    public int available() {
        try {
            return this.inputStream.available();
        } catch (IOException e5) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e5;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long durationMicros = this.timer.getDurationMicros();
        if (this.timeToResponseLastRead == -1) {
            this.timeToResponseLastRead = durationMicros;
        }
        try {
            this.inputStream.close();
            long j5 = this.bytesRead;
            if (j5 != -1) {
                this.networkMetricBuilder.setResponsePayloadBytes(j5);
            }
            long j6 = this.timeToResponseInitiated;
            if (j6 != -1) {
                this.networkMetricBuilder.setTimeToResponseInitiatedMicros(j6);
            }
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timeToResponseLastRead);
            this.networkMetricBuilder.build();
        } catch (IOException e5) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e5;
        }
    }

    @Override // java.io.InputStream
    public void mark(int i5) {
        this.inputStream.mark(i5);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.inputStream.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            int read = this.inputStream.read();
            long durationMicros = this.timer.getDurationMicros();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = durationMicros;
            }
            if (read == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = durationMicros;
                this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
                this.networkMetricBuilder.build();
            } else {
                long j5 = this.bytesRead + 1;
                this.bytesRead = j5;
                this.networkMetricBuilder.setResponsePayloadBytes(j5);
            }
            return read;
        } catch (IOException e5) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e5;
        }
    }

    @Override // java.io.InputStream
    public void reset() {
        try {
            this.inputStream.reset();
        } catch (IOException e5) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e5;
        }
    }

    @Override // java.io.InputStream
    public long skip(long j5) {
        try {
            long skip = this.inputStream.skip(j5);
            long durationMicros = this.timer.getDurationMicros();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = durationMicros;
            }
            if (skip == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = durationMicros;
                this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
            } else {
                long j6 = this.bytesRead + skip;
                this.bytesRead = j6;
                this.networkMetricBuilder.setResponsePayloadBytes(j6);
            }
            return skip;
        } catch (IOException e5) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e5;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) {
        try {
            int read = this.inputStream.read(bArr, i5, i6);
            long durationMicros = this.timer.getDurationMicros();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = durationMicros;
            }
            if (read == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = durationMicros;
                this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
                this.networkMetricBuilder.build();
            } else {
                long j5 = this.bytesRead + read;
                this.bytesRead = j5;
                this.networkMetricBuilder.setResponsePayloadBytes(j5);
            }
            return read;
        } catch (IOException e5) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e5;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            int read = this.inputStream.read(bArr);
            long durationMicros = this.timer.getDurationMicros();
            if (this.timeToResponseInitiated == -1) {
                this.timeToResponseInitiated = durationMicros;
            }
            if (read == -1 && this.timeToResponseLastRead == -1) {
                this.timeToResponseLastRead = durationMicros;
                this.networkMetricBuilder.setTimeToResponseCompletedMicros(durationMicros);
                this.networkMetricBuilder.build();
            } else {
                long j5 = this.bytesRead + read;
                this.bytesRead = j5;
                this.networkMetricBuilder.setResponsePayloadBytes(j5);
            }
            return read;
        } catch (IOException e5) {
            this.networkMetricBuilder.setTimeToResponseCompletedMicros(this.timer.getDurationMicros());
            NetworkRequestMetricBuilderUtil.logError(this.networkMetricBuilder);
            throw e5;
        }
    }
}
