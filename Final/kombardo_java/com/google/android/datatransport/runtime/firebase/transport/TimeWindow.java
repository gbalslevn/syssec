package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: classes.dex */
public final class TimeWindow {
    private static final TimeWindow DEFAULT_INSTANCE = new Builder().build();
    private final long end_ms_;
    private final long start_ms_;

    /* loaded from: classes.dex */
    public static final class Builder {
        private long start_ms_ = 0;
        private long end_ms_ = 0;

        Builder() {
        }

        public TimeWindow build() {
            return new TimeWindow(this.start_ms_, this.end_ms_);
        }

        public Builder setEndMs(long j5) {
            this.end_ms_ = j5;
            return this;
        }

        public Builder setStartMs(long j5) {
            this.start_ms_ = j5;
            return this;
        }
    }

    TimeWindow(long j5, long j6) {
        this.start_ms_ = j5;
        this.end_ms_ = j6;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Protobuf(tag = 2)
    public long getEndMs() {
        return this.end_ms_;
    }

    @Protobuf(tag = 1)
    public long getStartMs() {
        return this.start_ms_;
    }
}
