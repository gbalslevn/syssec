package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* loaded from: classes3.dex */
public final class ProtoBuf$Expression extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$Expression> PARSER = new AbstractParser<ProtoBuf$Expression>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$Expression parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$Expression(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$Expression defaultInstance;
    private List<ProtoBuf$Expression> andArgument_;
    private int bitField0_;
    private ConstantValue constantValue_;
    private int flags_;
    private int isInstanceTypeId_;
    private ProtoBuf$Type isInstanceType_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<ProtoBuf$Expression> orArgument_;
    private final ByteString unknownFields;
    private int valueParameterReference_;

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$Expression, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private int flags_;
        private int isInstanceTypeId_;
        private int valueParameterReference_;
        private ConstantValue constantValue_ = ConstantValue.TRUE;
        private ProtoBuf$Type isInstanceType_ = ProtoBuf$Type.getDefaultInstance();
        private List<ProtoBuf$Expression> andArgument_ = Collections.emptyList();
        private List<ProtoBuf$Expression> orArgument_ = Collections.emptyList();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$24900() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureAndArgumentIsMutable() {
            if ((this.bitField0_ & 32) != 32) {
                this.andArgument_ = new ArrayList(this.andArgument_);
                this.bitField0_ |= 32;
            }
        }

        private void ensureOrArgumentIsMutable() {
            if ((this.bitField0_ & 64) != 64) {
                this.orArgument_ = new ArrayList(this.orArgument_);
                this.bitField0_ |= 64;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Expression buildPartial() {
            ProtoBuf$Expression protoBuf$Expression = new ProtoBuf$Expression(this);
            int i5 = this.bitField0_;
            int i6 = (i5 & 1) != 1 ? 0 : 1;
            protoBuf$Expression.flags_ = this.flags_;
            if ((i5 & 2) == 2) {
                i6 |= 2;
            }
            protoBuf$Expression.valueParameterReference_ = this.valueParameterReference_;
            if ((i5 & 4) == 4) {
                i6 |= 4;
            }
            protoBuf$Expression.constantValue_ = this.constantValue_;
            if ((i5 & 8) == 8) {
                i6 |= 8;
            }
            protoBuf$Expression.isInstanceType_ = this.isInstanceType_;
            if ((i5 & 16) == 16) {
                i6 |= 16;
            }
            protoBuf$Expression.isInstanceTypeId_ = this.isInstanceTypeId_;
            if ((this.bitField0_ & 32) == 32) {
                this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                this.bitField0_ &= -33;
            }
            protoBuf$Expression.andArgument_ = this.andArgument_;
            if ((this.bitField0_ & 64) == 64) {
                this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                this.bitField0_ &= -65;
            }
            protoBuf$Expression.orArgument_ = this.orArgument_;
            protoBuf$Expression.bitField0_ = i6;
            return protoBuf$Expression;
        }

        public Builder mergeIsInstanceType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 8) != 8 || this.isInstanceType_ == ProtoBuf$Type.getDefaultInstance()) {
                this.isInstanceType_ = protoBuf$Type;
            } else {
                this.isInstanceType_ = ProtoBuf$Type.newBuilder(this.isInstanceType_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 8;
            return this;
        }

        public Builder setConstantValue(ConstantValue constantValue) {
            constantValue.getClass();
            this.bitField0_ |= 4;
            this.constantValue_ = constantValue;
            return this;
        }

        public Builder setFlags(int i5) {
            this.bitField0_ |= 1;
            this.flags_ = i5;
            return this;
        }

        public Builder setIsInstanceTypeId(int i5) {
            this.bitField0_ |= 16;
            this.isInstanceTypeId_ = i5;
            return this;
        }

        public Builder setValueParameterReference(int i5) {
            this.bitField0_ |= 2;
            this.valueParameterReference_ = i5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Expression build() {
            ProtoBuf$Expression buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$Expression protoBuf$Expression) {
            if (protoBuf$Expression == ProtoBuf$Expression.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$Expression.hasFlags()) {
                setFlags(protoBuf$Expression.getFlags());
            }
            if (protoBuf$Expression.hasValueParameterReference()) {
                setValueParameterReference(protoBuf$Expression.getValueParameterReference());
            }
            if (protoBuf$Expression.hasConstantValue()) {
                setConstantValue(protoBuf$Expression.getConstantValue());
            }
            if (protoBuf$Expression.hasIsInstanceType()) {
                mergeIsInstanceType(protoBuf$Expression.getIsInstanceType());
            }
            if (protoBuf$Expression.hasIsInstanceTypeId()) {
                setIsInstanceTypeId(protoBuf$Expression.getIsInstanceTypeId());
            }
            if (!protoBuf$Expression.andArgument_.isEmpty()) {
                if (this.andArgument_.isEmpty()) {
                    this.andArgument_ = protoBuf$Expression.andArgument_;
                    this.bitField0_ &= -33;
                } else {
                    ensureAndArgumentIsMutable();
                    this.andArgument_.addAll(protoBuf$Expression.andArgument_);
                }
            }
            if (!protoBuf$Expression.orArgument_.isEmpty()) {
                if (this.orArgument_.isEmpty()) {
                    this.orArgument_ = protoBuf$Expression.orArgument_;
                    this.bitField0_ &= -65;
                } else {
                    ensureOrArgumentIsMutable();
                    this.orArgument_.addAll(protoBuf$Expression.orArgument_);
                }
            }
            setUnknownFields(getUnknownFields().concat(protoBuf$Expression.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$Expression protoBuf$Expression = null;
            try {
                try {
                    ProtoBuf$Expression parsePartialFrom = ProtoBuf$Expression.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$Expression protoBuf$Expression2 = (ProtoBuf$Expression) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$Expression = protoBuf$Expression2;
                        if (protoBuf$Expression != null) {
                            mergeFrom(protoBuf$Expression);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$Expression != null) {
                }
                throw th;
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum ConstantValue implements Internal.EnumLite {
        TRUE(0, 0),
        FALSE(1, 1),
        NULL(2, 2);

        private static Internal.EnumLiteMap<ConstantValue> internalValueMap = new Internal.EnumLiteMap<ConstantValue>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.ConstantValue.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
            public ConstantValue findValueByNumber(int i5) {
                return ConstantValue.valueOf(i5);
            }
        };
        private final int value;

        ConstantValue(int i5, int i6) {
            this.value = i6;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static ConstantValue valueOf(int i5) {
            if (i5 == 0) {
                return TRUE;
            }
            if (i5 == 1) {
                return FALSE;
            }
            if (i5 != 2) {
                return null;
            }
            return NULL;
        }
    }

    static {
        ProtoBuf$Expression protoBuf$Expression = new ProtoBuf$Expression(true);
        defaultInstance = protoBuf$Expression;
        protoBuf$Expression.initFields();
    }

    public static ProtoBuf$Expression getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.flags_ = 0;
        this.valueParameterReference_ = 0;
        this.constantValue_ = ConstantValue.TRUE;
        this.isInstanceType_ = ProtoBuf$Type.getDefaultInstance();
        this.isInstanceTypeId_ = 0;
        this.andArgument_ = Collections.emptyList();
        this.orArgument_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.access$24900();
    }

    public ProtoBuf$Expression getAndArgument(int i5) {
        return this.andArgument_.get(i5);
    }

    public int getAndArgumentCount() {
        return this.andArgument_.size();
    }

    public ConstantValue getConstantValue() {
        return this.constantValue_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public ProtoBuf$Type getIsInstanceType() {
        return this.isInstanceType_;
    }

    public int getIsInstanceTypeId() {
        return this.isInstanceTypeId_;
    }

    public ProtoBuf$Expression getOrArgument(int i5) {
        return this.orArgument_.get(i5);
    }

    public int getOrArgumentCount() {
        return this.orArgument_.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeInt32Size += CodedOutputStream.computeInt32Size(2, this.valueParameterReference_);
        }
        if ((this.bitField0_ & 4) == 4) {
            computeInt32Size += CodedOutputStream.computeEnumSize(3, this.constantValue_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            computeInt32Size += CodedOutputStream.computeMessageSize(4, this.isInstanceType_);
        }
        if ((this.bitField0_ & 16) == 16) {
            computeInt32Size += CodedOutputStream.computeInt32Size(5, this.isInstanceTypeId_);
        }
        for (int i6 = 0; i6 < this.andArgument_.size(); i6++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(6, this.andArgument_.get(i6));
        }
        for (int i7 = 0; i7 < this.orArgument_.size(); i7++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(7, this.orArgument_.get(i7));
        }
        int size = computeInt32Size + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public int getValueParameterReference() {
        return this.valueParameterReference_;
    }

    public boolean hasConstantValue() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasIsInstanceType() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasIsInstanceTypeId() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasValueParameterReference() {
        return (this.bitField0_ & 2) == 2;
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
        if (hasIsInstanceType() && !getIsInstanceType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i5 = 0; i5 < getAndArgumentCount(); i5++) {
            if (!getAndArgument(i5).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < getOrArgumentCount(); i6++) {
            if (!getOrArgument(i6).isInitialized()) {
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
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.valueParameterReference_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(3, this.constantValue_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(4, this.isInstanceType_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(5, this.isInstanceTypeId_);
        }
        for (int i5 = 0; i5 < this.andArgument_.size(); i5++) {
            codedOutputStream.writeMessage(6, this.andArgument_.get(i5));
        }
        for (int i6 = 0; i6 < this.orArgument_.size(); i6++) {
            codedOutputStream.writeMessage(7, this.orArgument_.get(i6));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Expression protoBuf$Expression) {
        return newBuilder().mergeFrom(protoBuf$Expression);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    private ProtoBuf$Expression(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.getUnknownFields();
    }

    private ProtoBuf$Expression(boolean z5) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$Expression(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output newOutput = ByteString.newOutput();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
        boolean z5 = false;
        int i5 = 0;
        while (!z5) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.flags_ = codedInputStream.readInt32();
                        } else if (readTag == 16) {
                            this.bitField0_ |= 2;
                            this.valueParameterReference_ = codedInputStream.readInt32();
                        } else if (readTag == 24) {
                            int readEnum = codedInputStream.readEnum();
                            ConstantValue valueOf = ConstantValue.valueOf(readEnum);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum);
                            } else {
                                this.bitField0_ |= 4;
                                this.constantValue_ = valueOf;
                            }
                        } else if (readTag == 34) {
                            ProtoBuf$Type.Builder builder = (this.bitField0_ & 8) == 8 ? this.isInstanceType_.toBuilder() : null;
                            ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                            this.isInstanceType_ = protoBuf$Type;
                            if (builder != null) {
                                builder.mergeFrom(protoBuf$Type);
                                this.isInstanceType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                        } else if (readTag == 40) {
                            this.bitField0_ |= 16;
                            this.isInstanceTypeId_ = codedInputStream.readInt32();
                        } else if (readTag == 50) {
                            if ((i5 & 32) != 32) {
                                this.andArgument_ = new ArrayList();
                                i5 |= 32;
                            }
                            this.andArgument_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                        } else if (readTag != 58) {
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            if ((i5 & 64) != 64) {
                                this.orArgument_ = new ArrayList();
                                i5 |= 64;
                            }
                            this.orArgument_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                        }
                    }
                    z5 = true;
                } catch (Throwable th) {
                    if ((i5 & 32) == 32) {
                        this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                    }
                    if ((i5 & 64) == 64) {
                        this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
            } catch (InvalidProtocolBufferException e5) {
                throw e5.setUnfinishedMessage(this);
            } catch (IOException e6) {
                throw new InvalidProtocolBufferException(e6.getMessage()).setUnfinishedMessage(this);
            }
        }
        if ((i5 & 32) == 32) {
            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
        }
        if ((i5 & 64) == 64) {
            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
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
