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
public final class ProtoBuf$Constructor extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Constructor> implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$Constructor> PARSER = new AbstractParser<ProtoBuf$Constructor>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$Constructor parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$Constructor(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$Constructor defaultInstance;
    private int bitField0_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final ByteString unknownFields;
    private List<ProtoBuf$ValueParameter> valueParameter_;
    private List<Integer> versionRequirement_;

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Constructor, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private int flags_ = 6;
        private List<ProtoBuf$ValueParameter> valueParameter_ = Collections.emptyList();
        private List<Integer> versionRequirement_ = Collections.emptyList();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$13300() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureValueParameterIsMutable() {
            if ((this.bitField0_ & 2) != 2) {
                this.valueParameter_ = new ArrayList(this.valueParameter_);
                this.bitField0_ |= 2;
            }
        }

        private void ensureVersionRequirementIsMutable() {
            if ((this.bitField0_ & 4) != 4) {
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 4;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Constructor buildPartial() {
            ProtoBuf$Constructor protoBuf$Constructor = new ProtoBuf$Constructor(this);
            int i5 = (this.bitField0_ & 1) != 1 ? 0 : 1;
            protoBuf$Constructor.flags_ = this.flags_;
            if ((this.bitField0_ & 2) == 2) {
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                this.bitField0_ &= -3;
            }
            protoBuf$Constructor.valueParameter_ = this.valueParameter_;
            if ((this.bitField0_ & 4) == 4) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -5;
            }
            protoBuf$Constructor.versionRequirement_ = this.versionRequirement_;
            protoBuf$Constructor.bitField0_ = i5;
            return protoBuf$Constructor;
        }

        public Builder setFlags(int i5) {
            this.bitField0_ |= 1;
            this.flags_ = i5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Constructor build() {
            ProtoBuf$Constructor buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$Constructor protoBuf$Constructor) {
            if (protoBuf$Constructor == ProtoBuf$Constructor.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$Constructor.hasFlags()) {
                setFlags(protoBuf$Constructor.getFlags());
            }
            if (!protoBuf$Constructor.valueParameter_.isEmpty()) {
                if (this.valueParameter_.isEmpty()) {
                    this.valueParameter_ = protoBuf$Constructor.valueParameter_;
                    this.bitField0_ &= -3;
                } else {
                    ensureValueParameterIsMutable();
                    this.valueParameter_.addAll(protoBuf$Constructor.valueParameter_);
                }
            }
            if (!protoBuf$Constructor.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$Constructor.versionRequirement_;
                    this.bitField0_ &= -5;
                } else {
                    ensureVersionRequirementIsMutable();
                    this.versionRequirement_.addAll(protoBuf$Constructor.versionRequirement_);
                }
            }
            mergeExtensionFields(protoBuf$Constructor);
            setUnknownFields(getUnknownFields().concat(protoBuf$Constructor.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$Constructor protoBuf$Constructor = null;
            try {
                try {
                    ProtoBuf$Constructor parsePartialFrom = ProtoBuf$Constructor.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$Constructor protoBuf$Constructor2 = (ProtoBuf$Constructor) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$Constructor = protoBuf$Constructor2;
                        if (protoBuf$Constructor != null) {
                            mergeFrom(protoBuf$Constructor);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$Constructor != null) {
                }
                throw th;
            }
        }
    }

    static {
        ProtoBuf$Constructor protoBuf$Constructor = new ProtoBuf$Constructor(true);
        defaultInstance = protoBuf$Constructor;
        protoBuf$Constructor.initFields();
    }

    public static ProtoBuf$Constructor getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.flags_ = 6;
        this.valueParameter_ = Collections.emptyList();
        this.versionRequirement_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.access$13300();
    }

    public int getFlags() {
        return this.flags_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
        for (int i6 = 0; i6 < this.valueParameter_.size(); i6++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(2, this.valueParameter_.get(i6));
        }
        int i7 = 0;
        for (int i8 = 0; i8 < this.versionRequirement_.size(); i8++) {
            i7 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i8).intValue());
        }
        int size = computeInt32Size + i7 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public ProtoBuf$ValueParameter getValueParameter(int i5) {
        return this.valueParameter_.get(i5);
    }

    public int getValueParameterCount() {
        return this.valueParameter_.size();
    }

    public List<ProtoBuf$ValueParameter> getValueParameterList() {
        return this.valueParameter_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
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
        for (int i5 = 0; i5 < getValueParameterCount(); i5++) {
            if (!getValueParameter(i5).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
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
        for (int i5 = 0; i5 < this.valueParameter_.size(); i5++) {
            codedOutputStream.writeMessage(2, this.valueParameter_.get(i5));
        }
        for (int i6 = 0; i6 < this.versionRequirement_.size(); i6++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i6).intValue());
        }
        newExtensionWriter.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Constructor protoBuf$Constructor) {
        return newBuilder().mergeFrom(protoBuf$Constructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Constructor getDefaultInstanceForType() {
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

    private ProtoBuf$Constructor(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Constructor, ?> extendableBuilder) {
        super(extendableBuilder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$Constructor(boolean z5) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$Constructor(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.bitField0_ |= 1;
                                this.flags_ = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                if ((i5 & 2) != 2) {
                                    this.valueParameter_ = new ArrayList();
                                    i5 |= 2;
                                }
                                this.valueParameter_.add(codedInputStream.readMessage(ProtoBuf$ValueParameter.PARSER, extensionRegistryLite));
                            } else if (readTag == 248) {
                                if ((i5 & 4) != 4) {
                                    this.versionRequirement_ = new ArrayList();
                                    i5 |= 4;
                                }
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            } else if (readTag != 250) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if ((i5 & 4) != 4 && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.versionRequirement_ = new ArrayList();
                                    i5 |= 4;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                }
                                codedInputStream.popLimit(pushLimit);
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
                if ((i5 & 2) == 2) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                }
                if ((i5 & 4) == 4) {
                    this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
        if ((i5 & 2) == 2) {
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        }
        if ((i5 & 4) == 4) {
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
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
