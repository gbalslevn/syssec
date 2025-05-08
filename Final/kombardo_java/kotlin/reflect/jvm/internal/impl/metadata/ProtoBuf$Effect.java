package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression;
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
public final class ProtoBuf$Effect extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$Effect> PARSER = new AbstractParser<ProtoBuf$Effect>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$Effect parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$Effect(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$Effect defaultInstance;
    private int bitField0_;
    private ProtoBuf$Expression conclusionOfConditionalEffect_;
    private List<ProtoBuf$Expression> effectConstructorArgument_;
    private EffectType effectType_;
    private InvocationKind kind_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final ByteString unknownFields;

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$Effect, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private EffectType effectType_ = EffectType.RETURNS_CONSTANT;
        private List<ProtoBuf$Expression> effectConstructorArgument_ = Collections.emptyList();
        private ProtoBuf$Expression conclusionOfConditionalEffect_ = ProtoBuf$Expression.getDefaultInstance();
        private InvocationKind kind_ = InvocationKind.AT_MOST_ONCE;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$24000() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureEffectConstructorArgumentIsMutable() {
            if ((this.bitField0_ & 2) != 2) {
                this.effectConstructorArgument_ = new ArrayList(this.effectConstructorArgument_);
                this.bitField0_ |= 2;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Effect buildPartial() {
            ProtoBuf$Effect protoBuf$Effect = new ProtoBuf$Effect(this);
            int i5 = this.bitField0_;
            int i6 = (i5 & 1) != 1 ? 0 : 1;
            protoBuf$Effect.effectType_ = this.effectType_;
            if ((this.bitField0_ & 2) == 2) {
                this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                this.bitField0_ &= -3;
            }
            protoBuf$Effect.effectConstructorArgument_ = this.effectConstructorArgument_;
            if ((i5 & 4) == 4) {
                i6 |= 2;
            }
            protoBuf$Effect.conclusionOfConditionalEffect_ = this.conclusionOfConditionalEffect_;
            if ((i5 & 8) == 8) {
                i6 |= 4;
            }
            protoBuf$Effect.kind_ = this.kind_;
            protoBuf$Effect.bitField0_ = i6;
            return protoBuf$Effect;
        }

        public Builder mergeConclusionOfConditionalEffect(ProtoBuf$Expression protoBuf$Expression) {
            if ((this.bitField0_ & 4) != 4 || this.conclusionOfConditionalEffect_ == ProtoBuf$Expression.getDefaultInstance()) {
                this.conclusionOfConditionalEffect_ = protoBuf$Expression;
            } else {
                this.conclusionOfConditionalEffect_ = ProtoBuf$Expression.newBuilder(this.conclusionOfConditionalEffect_).mergeFrom(protoBuf$Expression).buildPartial();
            }
            this.bitField0_ |= 4;
            return this;
        }

        public Builder setEffectType(EffectType effectType) {
            effectType.getClass();
            this.bitField0_ |= 1;
            this.effectType_ = effectType;
            return this;
        }

        public Builder setKind(InvocationKind invocationKind) {
            invocationKind.getClass();
            this.bitField0_ |= 8;
            this.kind_ = invocationKind;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Effect build() {
            ProtoBuf$Effect buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$Effect protoBuf$Effect) {
            if (protoBuf$Effect == ProtoBuf$Effect.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$Effect.hasEffectType()) {
                setEffectType(protoBuf$Effect.getEffectType());
            }
            if (!protoBuf$Effect.effectConstructorArgument_.isEmpty()) {
                if (this.effectConstructorArgument_.isEmpty()) {
                    this.effectConstructorArgument_ = protoBuf$Effect.effectConstructorArgument_;
                    this.bitField0_ &= -3;
                } else {
                    ensureEffectConstructorArgumentIsMutable();
                    this.effectConstructorArgument_.addAll(protoBuf$Effect.effectConstructorArgument_);
                }
            }
            if (protoBuf$Effect.hasConclusionOfConditionalEffect()) {
                mergeConclusionOfConditionalEffect(protoBuf$Effect.getConclusionOfConditionalEffect());
            }
            if (protoBuf$Effect.hasKind()) {
                setKind(protoBuf$Effect.getKind());
            }
            setUnknownFields(getUnknownFields().concat(protoBuf$Effect.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$Effect protoBuf$Effect = null;
            try {
                try {
                    ProtoBuf$Effect parsePartialFrom = ProtoBuf$Effect.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$Effect protoBuf$Effect2 = (ProtoBuf$Effect) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$Effect = protoBuf$Effect2;
                        if (protoBuf$Effect != null) {
                            mergeFrom(protoBuf$Effect);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$Effect != null) {
                }
                throw th;
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum EffectType implements Internal.EnumLite {
        RETURNS_CONSTANT(0, 0),
        CALLS(1, 1),
        RETURNS_NOT_NULL(2, 2);

        private static Internal.EnumLiteMap<EffectType> internalValueMap = new Internal.EnumLiteMap<EffectType>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.EffectType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
            public EffectType findValueByNumber(int i5) {
                return EffectType.valueOf(i5);
            }
        };
        private final int value;

        EffectType(int i5, int i6) {
            this.value = i6;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static EffectType valueOf(int i5) {
            if (i5 == 0) {
                return RETURNS_CONSTANT;
            }
            if (i5 == 1) {
                return CALLS;
            }
            if (i5 != 2) {
                return null;
            }
            return RETURNS_NOT_NULL;
        }
    }

    /* loaded from: classes3.dex */
    public enum InvocationKind implements Internal.EnumLite {
        AT_MOST_ONCE(0, 0),
        EXACTLY_ONCE(1, 1),
        AT_LEAST_ONCE(2, 2);

        private static Internal.EnumLiteMap<InvocationKind> internalValueMap = new Internal.EnumLiteMap<InvocationKind>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.InvocationKind.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
            public InvocationKind findValueByNumber(int i5) {
                return InvocationKind.valueOf(i5);
            }
        };
        private final int value;

        InvocationKind(int i5, int i6) {
            this.value = i6;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static InvocationKind valueOf(int i5) {
            if (i5 == 0) {
                return AT_MOST_ONCE;
            }
            if (i5 == 1) {
                return EXACTLY_ONCE;
            }
            if (i5 != 2) {
                return null;
            }
            return AT_LEAST_ONCE;
        }
    }

    static {
        ProtoBuf$Effect protoBuf$Effect = new ProtoBuf$Effect(true);
        defaultInstance = protoBuf$Effect;
        protoBuf$Effect.initFields();
    }

    public static ProtoBuf$Effect getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.effectType_ = EffectType.RETURNS_CONSTANT;
        this.effectConstructorArgument_ = Collections.emptyList();
        this.conclusionOfConditionalEffect_ = ProtoBuf$Expression.getDefaultInstance();
        this.kind_ = InvocationKind.AT_MOST_ONCE;
    }

    public static Builder newBuilder() {
        return Builder.access$24000();
    }

    public ProtoBuf$Expression getConclusionOfConditionalEffect() {
        return this.conclusionOfConditionalEffect_;
    }

    public ProtoBuf$Expression getEffectConstructorArgument(int i5) {
        return this.effectConstructorArgument_.get(i5);
    }

    public int getEffectConstructorArgumentCount() {
        return this.effectConstructorArgument_.size();
    }

    public EffectType getEffectType() {
        return this.effectType_;
    }

    public InvocationKind getKind() {
        return this.kind_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int computeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.effectType_.getNumber()) : 0;
        for (int i6 = 0; i6 < this.effectConstructorArgument_.size(); i6++) {
            computeEnumSize += CodedOutputStream.computeMessageSize(2, this.effectConstructorArgument_.get(i6));
        }
        if ((this.bitField0_ & 2) == 2) {
            computeEnumSize += CodedOutputStream.computeMessageSize(3, this.conclusionOfConditionalEffect_);
        }
        if ((this.bitField0_ & 4) == 4) {
            computeEnumSize += CodedOutputStream.computeEnumSize(4, this.kind_.getNumber());
        }
        int size = computeEnumSize + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public boolean hasConclusionOfConditionalEffect() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasEffectType() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasKind() {
        return (this.bitField0_ & 4) == 4;
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
        for (int i5 = 0; i5 < getEffectConstructorArgumentCount(); i5++) {
            if (!getEffectConstructorArgument(i5).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (!hasConclusionOfConditionalEffect() || getConclusionOfConditionalEffect().isInitialized()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeEnum(1, this.effectType_.getNumber());
        }
        for (int i5 = 0; i5 < this.effectConstructorArgument_.size(); i5++) {
            codedOutputStream.writeMessage(2, this.effectConstructorArgument_.get(i5));
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(3, this.conclusionOfConditionalEffect_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(4, this.kind_.getNumber());
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Effect protoBuf$Effect) {
        return newBuilder().mergeFrom(protoBuf$Effect);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    private ProtoBuf$Effect(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.getUnknownFields();
    }

    private ProtoBuf$Effect(boolean z5) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$Effect(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output newOutput = ByteString.newOutput();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
        boolean z5 = false;
        char c5 = 0;
        while (!z5) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            int readEnum = codedInputStream.readEnum();
                            EffectType valueOf = EffectType.valueOf(readEnum);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum);
                            } else {
                                this.bitField0_ |= 1;
                                this.effectType_ = valueOf;
                            }
                        } else if (readTag == 18) {
                            if ((c5 & 2) != 2) {
                                this.effectConstructorArgument_ = new ArrayList();
                                c5 = 2;
                            }
                            this.effectConstructorArgument_.add(codedInputStream.readMessage(ProtoBuf$Expression.PARSER, extensionRegistryLite));
                        } else if (readTag == 26) {
                            ProtoBuf$Expression.Builder builder = (this.bitField0_ & 2) == 2 ? this.conclusionOfConditionalEffect_.toBuilder() : null;
                            ProtoBuf$Expression protoBuf$Expression = (ProtoBuf$Expression) codedInputStream.readMessage(ProtoBuf$Expression.PARSER, extensionRegistryLite);
                            this.conclusionOfConditionalEffect_ = protoBuf$Expression;
                            if (builder != null) {
                                builder.mergeFrom(protoBuf$Expression);
                                this.conclusionOfConditionalEffect_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 2;
                        } else if (readTag != 32) {
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            int readEnum2 = codedInputStream.readEnum();
                            InvocationKind valueOf2 = InvocationKind.valueOf(readEnum2);
                            if (valueOf2 == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum2);
                            } else {
                                this.bitField0_ |= 4;
                                this.kind_ = valueOf2;
                            }
                        }
                    }
                    z5 = true;
                } catch (Throwable th) {
                    if ((c5 & 2) == 2) {
                        this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
        if ((c5 & 2) == 2) {
            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
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
