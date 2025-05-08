package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* loaded from: classes3.dex */
public final class ProtoBuf$Contract extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$Contract> PARSER = new AbstractParser<ProtoBuf$Contract>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$Contract parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$Contract(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$Contract defaultInstance;
    private List<ProtoBuf$Effect> effect_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final ByteString unknownFields;

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$Contract, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private List<ProtoBuf$Effect> effect_ = Collections.emptyList();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$23500() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureEffectIsMutable() {
            if ((this.bitField0_ & 1) != 1) {
                this.effect_ = new ArrayList(this.effect_);
                this.bitField0_ |= 1;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Contract buildPartial() {
            ProtoBuf$Contract protoBuf$Contract = new ProtoBuf$Contract(this);
            if ((this.bitField0_ & 1) == 1) {
                this.effect_ = Collections.unmodifiableList(this.effect_);
                this.bitField0_ &= -2;
            }
            protoBuf$Contract.effect_ = this.effect_;
            return protoBuf$Contract;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Contract build() {
            ProtoBuf$Contract buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$Contract protoBuf$Contract) {
            if (protoBuf$Contract == ProtoBuf$Contract.getDefaultInstance()) {
                return this;
            }
            if (!protoBuf$Contract.effect_.isEmpty()) {
                if (this.effect_.isEmpty()) {
                    this.effect_ = protoBuf$Contract.effect_;
                    this.bitField0_ &= -2;
                } else {
                    ensureEffectIsMutable();
                    this.effect_.addAll(protoBuf$Contract.effect_);
                }
            }
            setUnknownFields(getUnknownFields().concat(protoBuf$Contract.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$Contract protoBuf$Contract = null;
            try {
                try {
                    ProtoBuf$Contract parsePartialFrom = ProtoBuf$Contract.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$Contract protoBuf$Contract2 = (ProtoBuf$Contract) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$Contract = protoBuf$Contract2;
                        if (protoBuf$Contract != null) {
                            mergeFrom(protoBuf$Contract);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$Contract != null) {
                }
                throw th;
            }
        }
    }

    static {
        ProtoBuf$Contract protoBuf$Contract = new ProtoBuf$Contract(true);
        defaultInstance = protoBuf$Contract;
        protoBuf$Contract.initFields();
    }

    public static ProtoBuf$Contract getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.effect_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.access$23500();
    }

    public ProtoBuf$Effect getEffect(int i5) {
        return this.effect_.get(i5);
    }

    public int getEffectCount() {
        return this.effect_.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.effect_.size(); i7++) {
            i6 += CodedOutputStream.computeMessageSize(1, this.effect_.get(i7));
        }
        int size = i6 + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b5 = this.memoizedIsInitialized;
        if (b5 == 1) {
            return true;
        }
        if (b5 == 0) {
            return false;
        }
        for (int i5 = 0; i5 < getEffectCount(); i5++) {
            if (!getEffect(i5).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        getSerializedSize();
        for (int i5 = 0; i5 < this.effect_.size(); i5++) {
            codedOutputStream.writeMessage(1, this.effect_.get(i5));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Contract protoBuf$Contract) {
        return newBuilder().mergeFrom(protoBuf$Contract);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    private ProtoBuf$Contract(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.getUnknownFields();
    }

    private ProtoBuf$Contract(boolean z5) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$Contract(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output newOutput = ByteString.newOutput();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
        boolean z5 = false;
        boolean z6 = false;
        while (!z5) {
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag != 10) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                if (!z6) {
                                    this.effect_ = new ArrayList();
                                    z6 = true;
                                }
                                this.effect_.add(codedInputStream.readMessage(ProtoBuf$Effect.PARSER, extensionRegistryLite));
                            }
                        }
                        z5 = true;
                    } catch (InvalidProtocolBufferException e5) {
                        throw e5.setUnfinishedMessage(this);
                    }
                } catch (IOException e6) {
                    throw new InvalidProtocolBufferException(e6.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z6) {
                    this.effect_ = Collections.unmodifiableList(this.effect_);
                }
                try {
                    newInstance.flush();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.unknownFields = newOutput.toByteString();
                    throw th2;
                }
                this.unknownFields = newOutput.toByteString();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z6) {
            this.effect_ = Collections.unmodifiableList(this.effect_);
        }
        try {
            newInstance.flush();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.unknownFields = newOutput.toByteString();
            throw th3;
        }
        this.unknownFields = newOutput.toByteString();
        makeExtensionsImmutable();
    }
}
