package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.ProtoEnum;
import com.google.firebase.encoders.proto.Protobuf;

/* loaded from: classes.dex */
public final class LogEventDropped {
    private static final LogEventDropped DEFAULT_INSTANCE = new Builder().build();
    private final long events_dropped_count_;
    private final Reason reason_;

    /* loaded from: classes.dex */
    public static final class Builder {
        private long events_dropped_count_ = 0;
        private Reason reason_ = Reason.REASON_UNKNOWN;

        Builder() {
        }

        public LogEventDropped build() {
            return new LogEventDropped(this.events_dropped_count_, this.reason_);
        }

        public Builder setEventsDroppedCount(long j5) {
            this.events_dropped_count_ = j5;
            return this;
        }

        public Builder setReason(Reason reason) {
            this.reason_ = reason;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum Reason implements ProtoEnum {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);

        private final int number_;

        Reason(int i5) {
            this.number_ = i5;
        }

        @Override // com.google.firebase.encoders.proto.ProtoEnum
        public int getNumber() {
            return this.number_;
        }
    }

    LogEventDropped(long j5, Reason reason) {
        this.events_dropped_count_ = j5;
        this.reason_ = reason;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Protobuf(tag = 1)
    public long getEventsDroppedCount() {
        return this.events_dropped_count_;
    }

    @Protobuf(tag = 3)
    public Reason getReason() {
        return this.reason_;
    }
}
