package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
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
public final class ProtoBuf$ValueParameter extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$ValueParameter> implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$ValueParameter> PARSER = new AbstractParser<ProtoBuf$ValueParameter>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$ValueParameter parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$ValueParameter(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$ValueParameter defaultInstance;
    private int bitField0_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int typeId_;
    private ProtoBuf$Type type_;
    private final ByteString unknownFields;
    private int varargElementTypeId_;
    private ProtoBuf$Type varargElementType_;

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$ValueParameter, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private int flags_;
        private int name_;
        private int typeId_;
        private int varargElementTypeId_;
        private ProtoBuf$Type type_ = ProtoBuf$Type.getDefaultInstance();
        private ProtoBuf$Type varargElementType_ = ProtoBuf$Type.getDefaultInstance();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$17900() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$ValueParameter buildPartial() {
            ProtoBuf$ValueParameter protoBuf$ValueParameter = new ProtoBuf$ValueParameter(this);
            int i5 = this.bitField0_;
            int i6 = (i5 & 1) != 1 ? 0 : 1;
            protoBuf$ValueParameter.flags_ = this.flags_;
            if ((i5 & 2) == 2) {
                i6 |= 2;
            }
            protoBuf$ValueParameter.name_ = this.name_;
            if ((i5 & 4) == 4) {
                i6 |= 4;
            }
            protoBuf$ValueParameter.type_ = this.type_;
            if ((i5 & 8) == 8) {
                i6 |= 8;
            }
            protoBuf$ValueParameter.typeId_ = this.typeId_;
            if ((i5 & 16) == 16) {
                i6 |= 16;
            }
            protoBuf$ValueParameter.varargElementType_ = this.varargElementType_;
            if ((i5 & 32) == 32) {
                i6 |= 32;
            }
            protoBuf$ValueParameter.varargElementTypeId_ = this.varargElementTypeId_;
            protoBuf$ValueParameter.bitField0_ = i6;
            return protoBuf$ValueParameter;
        }

        public Builder mergeType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 4) != 4 || this.type_ == ProtoBuf$Type.getDefaultInstance()) {
                this.type_ = protoBuf$Type;
            } else {
                this.type_ = ProtoBuf$Type.newBuilder(this.type_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 4;
            return this;
        }

        public Builder mergeVarargElementType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 16) != 16 || this.varargElementType_ == ProtoBuf$Type.getDefaultInstance()) {
                this.varargElementType_ = protoBuf$Type;
            } else {
                this.varargElementType_ = ProtoBuf$Type.newBuilder(this.varargElementType_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 16;
            return this;
        }

        public Builder setFlags(int i5) {
            this.bitField0_ |= 1;
            this.flags_ = i5;
            return this;
        }

        public Builder setName(int i5) {
            this.bitField0_ |= 2;
            this.name_ = i5;
            return this;
        }

        public Builder setTypeId(int i5) {
            this.bitField0_ |= 8;
            this.typeId_ = i5;
            return this;
        }

        public Builder setVarargElementTypeId(int i5) {
            this.bitField0_ |= 32;
            this.varargElementTypeId_ = i5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$ValueParameter build() {
            ProtoBuf$ValueParameter buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$ValueParameter protoBuf$ValueParameter) {
            if (protoBuf$ValueParameter == ProtoBuf$ValueParameter.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$ValueParameter.hasFlags()) {
                setFlags(protoBuf$ValueParameter.getFlags());
            }
            if (protoBuf$ValueParameter.hasName()) {
                setName(protoBuf$ValueParameter.getName());
            }
            if (protoBuf$ValueParameter.hasType()) {
                mergeType(protoBuf$ValueParameter.getType());
            }
            if (protoBuf$ValueParameter.hasTypeId()) {
                setTypeId(protoBuf$ValueParameter.getTypeId());
            }
            if (protoBuf$ValueParameter.hasVarargElementType()) {
                mergeVarargElementType(protoBuf$ValueParameter.getVarargElementType());
            }
            if (protoBuf$ValueParameter.hasVarargElementTypeId()) {
                setVarargElementTypeId(protoBuf$ValueParameter.getVarargElementTypeId());
            }
            mergeExtensionFields(protoBuf$ValueParameter);
            setUnknownFields(getUnknownFields().concat(protoBuf$ValueParameter.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$ValueParameter protoBuf$ValueParameter = null;
            try {
                try {
                    ProtoBuf$ValueParameter parsePartialFrom = ProtoBuf$ValueParameter.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$ValueParameter protoBuf$ValueParameter2 = (ProtoBuf$ValueParameter) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$ValueParameter = protoBuf$ValueParameter2;
                        if (protoBuf$ValueParameter != null) {
                            mergeFrom(protoBuf$ValueParameter);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$ValueParameter != null) {
                }
                throw th;
            }
        }
    }

    static {
        ProtoBuf$ValueParameter protoBuf$ValueParameter = new ProtoBuf$ValueParameter(true);
        defaultInstance = protoBuf$ValueParameter;
        protoBuf$ValueParameter.initFields();
    }

    public static ProtoBuf$ValueParameter getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.flags_ = 0;
        this.name_ = 0;
        this.type_ = ProtoBuf$Type.getDefaultInstance();
        this.typeId_ = 0;
        this.varargElementType_ = ProtoBuf$Type.getDefaultInstance();
        this.varargElementTypeId_ = 0;
    }

    public static Builder newBuilder() {
        return Builder.access$17900();
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getName() {
        return this.name_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            computeInt32Size += CodedOutputStream.computeMessageSize(3, this.type_);
        }
        if ((this.bitField0_ & 16) == 16) {
            computeInt32Size += CodedOutputStream.computeMessageSize(4, this.varargElementType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            computeInt32Size += CodedOutputStream.computeInt32Size(5, this.typeId_);
        }
        if ((this.bitField0_ & 32) == 32) {
            computeInt32Size += CodedOutputStream.computeInt32Size(6, this.varargElementTypeId_);
        }
        int extensionsSerializedSize = computeInt32Size + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = extensionsSerializedSize;
        return extensionsSerializedSize;
    }

    public ProtoBuf$Type getType() {
        return this.type_;
    }

    public int getTypeId() {
        return this.typeId_;
    }

    public ProtoBuf$Type getVarargElementType() {
        return this.varargElementType_;
    }

    public int getVarargElementTypeId() {
        return this.varargElementTypeId_;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasType() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasTypeId() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasVarargElementType() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasVarargElementTypeId() {
        return (this.bitField0_ & 32) == 32;
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
        if (!hasName()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasType() && !getType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasVarargElementType() && !getVarargElementType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (extensionsAreInitialized()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        getSerializedSize();
        GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter = newExtensionWriter();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(3, this.type_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeMessage(4, this.varargElementType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(5, this.typeId_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(6, this.varargElementTypeId_);
        }
        newExtensionWriter.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        return newBuilder().mergeFrom(protoBuf$ValueParameter);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$ValueParameter getDefaultInstanceForType() {
        return defaultInstance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    private ProtoBuf$ValueParameter(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$ValueParameter, ?> extendableBuilder) {
        super(extendableBuilder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$ValueParameter(boolean z5) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$ValueParameter(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ProtoBuf$Type.Builder builder;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output newOutput = ByteString.newOutput();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
        boolean z5 = false;
        while (!z5) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.flags_ = codedInputStream.readInt32();
                        } else if (readTag != 16) {
                            if (readTag == 26) {
                                builder = (this.bitField0_ & 4) == 4 ? this.type_.toBuilder() : null;
                                ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                                this.type_ = protoBuf$Type;
                                if (builder != null) {
                                    builder.mergeFrom(protoBuf$Type);
                                    this.type_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            } else if (readTag == 34) {
                                builder = (this.bitField0_ & 16) == 16 ? this.varargElementType_.toBuilder() : null;
                                ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                                this.varargElementType_ = protoBuf$Type2;
                                if (builder != null) {
                                    builder.mergeFrom(protoBuf$Type2);
                                    this.varargElementType_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 16;
                            } else if (readTag == 40) {
                                this.bitField0_ |= 8;
                                this.typeId_ = codedInputStream.readInt32();
                            } else if (readTag != 48) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0_ |= 32;
                                this.varargElementTypeId_ = codedInputStream.readInt32();
                            }
                        } else {
                            this.bitField0_ |= 2;
                            this.name_ = codedInputStream.readInt32();
                        }
                    }
                    z5 = true;
                } catch (Throwable th) {
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
