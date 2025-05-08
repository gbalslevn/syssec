package com.google.firebase.perf.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public final class TraceMetric extends GeneratedMessageLite<TraceMetric, Builder> implements MessageLiteOrBuilder {
    public static final int CLIENT_START_TIME_US_FIELD_NUMBER = 4;
    public static final int COUNTERS_FIELD_NUMBER = 6;
    public static final int CUSTOM_ATTRIBUTES_FIELD_NUMBER = 8;
    private static final TraceMetric DEFAULT_INSTANCE;
    public static final int DURATION_US_FIELD_NUMBER = 5;
    public static final int IS_AUTO_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<TraceMetric> PARSER = null;
    public static final int PERF_SESSIONS_FIELD_NUMBER = 9;
    public static final int SUBTRACES_FIELD_NUMBER = 7;
    private int bitField0_;
    private long clientStartTimeUs_;
    private long durationUs_;
    private boolean isAuto_;
    private MapFieldLite<String, Long> counters_ = MapFieldLite.emptyMapField();
    private MapFieldLite<String, String> customAttributes_ = MapFieldLite.emptyMapField();
    private String name_ = BuildConfig.FLAVOR;
    private Internal.ProtobufList<TraceMetric> subtraces_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<PerfSession> perfSessions_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.google.firebase.perf.v1.TraceMetric$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<TraceMetric, Builder> implements MessageLiteOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllPerfSessions(Iterable<? extends PerfSession> iterable) {
            copyOnWrite();
            ((TraceMetric) this.instance).addAllPerfSessions(iterable);
            return this;
        }

        public Builder addAllSubtraces(Iterable<? extends TraceMetric> iterable) {
            copyOnWrite();
            ((TraceMetric) this.instance).addAllSubtraces(iterable);
            return this;
        }

        public Builder addPerfSessions(PerfSession perfSession) {
            copyOnWrite();
            ((TraceMetric) this.instance).addPerfSessions(perfSession);
            return this;
        }

        public Builder addSubtraces(TraceMetric traceMetric) {
            copyOnWrite();
            ((TraceMetric) this.instance).addSubtraces(traceMetric);
            return this;
        }

        public Builder putAllCounters(Map<String, Long> map) {
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCountersMap().putAll(map);
            return this;
        }

        public Builder putAllCustomAttributes(Map<String, String> map) {
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCustomAttributesMap().putAll(map);
            return this;
        }

        public Builder putCounters(String str, long j5) {
            str.getClass();
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCountersMap().put(str, Long.valueOf(j5));
            return this;
        }

        public Builder putCustomAttributes(String str, String str2) {
            str.getClass();
            str2.getClass();
            copyOnWrite();
            ((TraceMetric) this.instance).getMutableCustomAttributesMap().put(str, str2);
            return this;
        }

        public Builder setClientStartTimeUs(long j5) {
            copyOnWrite();
            ((TraceMetric) this.instance).setClientStartTimeUs(j5);
            return this;
        }

        public Builder setDurationUs(long j5) {
            copyOnWrite();
            ((TraceMetric) this.instance).setDurationUs(j5);
            return this;
        }

        public Builder setName(String str) {
            copyOnWrite();
            ((TraceMetric) this.instance).setName(str);
            return this;
        }

        private Builder() {
            super(TraceMetric.DEFAULT_INSTANCE);
        }
    }

    /* loaded from: classes2.dex */
    private static final class CountersDefaultEntryHolder {
        static final MapEntryLite<String, Long> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, BuildConfig.FLAVOR, WireFormat.FieldType.INT64, 0L);
    }

    /* loaded from: classes2.dex */
    private static final class CustomAttributesDefaultEntryHolder {
        static final MapEntryLite<String, String> defaultEntry;

        static {
            WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
            defaultEntry = MapEntryLite.newDefaultInstance(fieldType, BuildConfig.FLAVOR, fieldType, BuildConfig.FLAVOR);
        }
    }

    static {
        TraceMetric traceMetric = new TraceMetric();
        DEFAULT_INSTANCE = traceMetric;
        GeneratedMessageLite.registerDefaultInstance(TraceMetric.class, traceMetric);
    }

    private TraceMetric() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllPerfSessions(Iterable<? extends PerfSession> iterable) {
        ensurePerfSessionsIsMutable();
        AbstractMessageLite.addAll(iterable, this.perfSessions_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllSubtraces(Iterable<? extends TraceMetric> iterable) {
        ensureSubtracesIsMutable();
        AbstractMessageLite.addAll(iterable, this.subtraces_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPerfSessions(PerfSession perfSession) {
        perfSession.getClass();
        ensurePerfSessionsIsMutable();
        this.perfSessions_.add(perfSession);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addSubtraces(TraceMetric traceMetric) {
        traceMetric.getClass();
        ensureSubtracesIsMutable();
        this.subtraces_.add(traceMetric);
    }

    private void ensurePerfSessionsIsMutable() {
        Internal.ProtobufList<PerfSession> protobufList = this.perfSessions_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.perfSessions_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureSubtracesIsMutable() {
        Internal.ProtobufList<TraceMetric> protobufList = this.subtraces_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.subtraces_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static TraceMetric getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Long> getMutableCountersMap() {
        return internalGetMutableCounters();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> getMutableCustomAttributesMap() {
        return internalGetMutableCustomAttributes();
    }

    private MapFieldLite<String, Long> internalGetCounters() {
        return this.counters_;
    }

    private MapFieldLite<String, String> internalGetCustomAttributes() {
        return this.customAttributes_;
    }

    private MapFieldLite<String, Long> internalGetMutableCounters() {
        if (!this.counters_.isMutable()) {
            this.counters_ = this.counters_.mutableCopy();
        }
        return this.counters_;
    }

    private MapFieldLite<String, String> internalGetMutableCustomAttributes() {
        if (!this.customAttributes_.isMutable()) {
            this.customAttributes_ = this.customAttributes_.mutableCopy();
        }
        return this.customAttributes_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClientStartTimeUs(long j5) {
        this.bitField0_ |= 4;
        this.clientStartTimeUs_ = j5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDurationUs(long j5) {
        this.bitField0_ |= 8;
        this.durationUs_ = j5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setName(String str) {
        str.getClass();
        this.bitField0_ |= 1;
        this.name_ = str;
    }

    public boolean containsCustomAttributes(String str) {
        str.getClass();
        return internalGetCustomAttributes().containsKey(str);
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        AnonymousClass1 anonymousClass1 = null;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new TraceMetric();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\t\b\u0002\u0002\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0004ဂ\u0002\u0005ဂ\u0003\u00062\u0007\u001b\b2\t\u001b", new Object[]{"bitField0_", "name_", "isAuto_", "clientStartTimeUs_", "durationUs_", "counters_", CountersDefaultEntryHolder.defaultEntry, "subtraces_", TraceMetric.class, "customAttributes_", CustomAttributesDefaultEntryHolder.defaultEntry, "perfSessions_", PerfSession.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<TraceMetric> parser = PARSER;
                if (parser == null) {
                    synchronized (TraceMetric.class) {
                        try {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        } finally {
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public int getCountersCount() {
        return internalGetCounters().size();
    }

    public Map<String, Long> getCountersMap() {
        return Collections.unmodifiableMap(internalGetCounters());
    }

    public Map<String, String> getCustomAttributesMap() {
        return Collections.unmodifiableMap(internalGetCustomAttributes());
    }

    public long getDurationUs() {
        return this.durationUs_;
    }

    public String getName() {
        return this.name_;
    }

    public List<PerfSession> getPerfSessionsList() {
        return this.perfSessions_;
    }

    public List<TraceMetric> getSubtracesList() {
        return this.subtraces_;
    }

    public boolean hasClientStartTimeUs() {
        return (this.bitField0_ & 4) != 0;
    }
}
