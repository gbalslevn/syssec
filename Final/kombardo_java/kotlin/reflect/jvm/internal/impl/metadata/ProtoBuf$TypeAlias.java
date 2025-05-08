package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.io.InputStream;
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
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* loaded from: classes3.dex */
public final class ProtoBuf$TypeAlias extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$TypeAlias> implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$TypeAlias> PARSER = new AbstractParser<ProtoBuf$TypeAlias>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$TypeAlias parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$TypeAlias(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$TypeAlias defaultInstance;
    private List<ProtoBuf$Annotation> annotation_;
    private int bitField0_;
    private int expandedTypeId_;
    private ProtoBuf$Type expandedType_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private List<ProtoBuf$TypeParameter> typeParameter_;
    private int underlyingTypeId_;
    private ProtoBuf$Type underlyingType_;
    private final ByteString unknownFields;
    private List<Integer> versionRequirement_;

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$TypeAlias, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private int expandedTypeId_;
        private int name_;
        private int underlyingTypeId_;
        private int flags_ = 6;
        private List<ProtoBuf$TypeParameter> typeParameter_ = Collections.emptyList();
        private ProtoBuf$Type underlyingType_ = ProtoBuf$Type.getDefaultInstance();
        private ProtoBuf$Type expandedType_ = ProtoBuf$Type.getDefaultInstance();
        private List<ProtoBuf$Annotation> annotation_ = Collections.emptyList();
        private List<Integer> versionRequirement_ = Collections.emptyList();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$19000() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureAnnotationIsMutable() {
            if ((this.bitField0_ & 128) != 128) {
                this.annotation_ = new ArrayList(this.annotation_);
                this.bitField0_ |= 128;
            }
        }

        private void ensureTypeParameterIsMutable() {
            if ((this.bitField0_ & 4) != 4) {
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 4;
            }
        }

        private void ensureVersionRequirementIsMutable() {
            if ((this.bitField0_ & 256) != 256) {
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 256;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$TypeAlias buildPartial() {
            ProtoBuf$TypeAlias protoBuf$TypeAlias = new ProtoBuf$TypeAlias(this);
            int i5 = this.bitField0_;
            int i6 = (i5 & 1) != 1 ? 0 : 1;
            protoBuf$TypeAlias.flags_ = this.flags_;
            if ((i5 & 2) == 2) {
                i6 |= 2;
            }
            protoBuf$TypeAlias.name_ = this.name_;
            if ((this.bitField0_ & 4) == 4) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -5;
            }
            protoBuf$TypeAlias.typeParameter_ = this.typeParameter_;
            if ((i5 & 8) == 8) {
                i6 |= 4;
            }
            protoBuf$TypeAlias.underlyingType_ = this.underlyingType_;
            if ((i5 & 16) == 16) {
                i6 |= 8;
            }
            protoBuf$TypeAlias.underlyingTypeId_ = this.underlyingTypeId_;
            if ((i5 & 32) == 32) {
                i6 |= 16;
            }
            protoBuf$TypeAlias.expandedType_ = this.expandedType_;
            if ((i5 & 64) == 64) {
                i6 |= 32;
            }
            protoBuf$TypeAlias.expandedTypeId_ = this.expandedTypeId_;
            if ((this.bitField0_ & 128) == 128) {
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
                this.bitField0_ &= -129;
            }
            protoBuf$TypeAlias.annotation_ = this.annotation_;
            if ((this.bitField0_ & 256) == 256) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -257;
            }
            protoBuf$TypeAlias.versionRequirement_ = this.versionRequirement_;
            protoBuf$TypeAlias.bitField0_ = i6;
            return protoBuf$TypeAlias;
        }

        public Builder mergeExpandedType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 32) != 32 || this.expandedType_ == ProtoBuf$Type.getDefaultInstance()) {
                this.expandedType_ = protoBuf$Type;
            } else {
                this.expandedType_ = ProtoBuf$Type.newBuilder(this.expandedType_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 32;
            return this;
        }

        public Builder mergeUnderlyingType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 8) != 8 || this.underlyingType_ == ProtoBuf$Type.getDefaultInstance()) {
                this.underlyingType_ = protoBuf$Type;
            } else {
                this.underlyingType_ = ProtoBuf$Type.newBuilder(this.underlyingType_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 8;
            return this;
        }

        public Builder setExpandedTypeId(int i5) {
            this.bitField0_ |= 64;
            this.expandedTypeId_ = i5;
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

        public Builder setUnderlyingTypeId(int i5) {
            this.bitField0_ |= 16;
            this.underlyingTypeId_ = i5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$TypeAlias build() {
            ProtoBuf$TypeAlias buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$TypeAlias protoBuf$TypeAlias) {
            if (protoBuf$TypeAlias == ProtoBuf$TypeAlias.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$TypeAlias.hasFlags()) {
                setFlags(protoBuf$TypeAlias.getFlags());
            }
            if (protoBuf$TypeAlias.hasName()) {
                setName(protoBuf$TypeAlias.getName());
            }
            if (!protoBuf$TypeAlias.typeParameter_.isEmpty()) {
                if (this.typeParameter_.isEmpty()) {
                    this.typeParameter_ = protoBuf$TypeAlias.typeParameter_;
                    this.bitField0_ &= -5;
                } else {
                    ensureTypeParameterIsMutable();
                    this.typeParameter_.addAll(protoBuf$TypeAlias.typeParameter_);
                }
            }
            if (protoBuf$TypeAlias.hasUnderlyingType()) {
                mergeUnderlyingType(protoBuf$TypeAlias.getUnderlyingType());
            }
            if (protoBuf$TypeAlias.hasUnderlyingTypeId()) {
                setUnderlyingTypeId(protoBuf$TypeAlias.getUnderlyingTypeId());
            }
            if (protoBuf$TypeAlias.hasExpandedType()) {
                mergeExpandedType(protoBuf$TypeAlias.getExpandedType());
            }
            if (protoBuf$TypeAlias.hasExpandedTypeId()) {
                setExpandedTypeId(protoBuf$TypeAlias.getExpandedTypeId());
            }
            if (!protoBuf$TypeAlias.annotation_.isEmpty()) {
                if (this.annotation_.isEmpty()) {
                    this.annotation_ = protoBuf$TypeAlias.annotation_;
                    this.bitField0_ &= -129;
                } else {
                    ensureAnnotationIsMutable();
                    this.annotation_.addAll(protoBuf$TypeAlias.annotation_);
                }
            }
            if (!protoBuf$TypeAlias.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$TypeAlias.versionRequirement_;
                    this.bitField0_ &= -257;
                } else {
                    ensureVersionRequirementIsMutable();
                    this.versionRequirement_.addAll(protoBuf$TypeAlias.versionRequirement_);
                }
            }
            mergeExtensionFields(protoBuf$TypeAlias);
            setUnknownFields(getUnknownFields().concat(protoBuf$TypeAlias.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$TypeAlias protoBuf$TypeAlias = null;
            try {
                try {
                    ProtoBuf$TypeAlias parsePartialFrom = ProtoBuf$TypeAlias.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$TypeAlias protoBuf$TypeAlias2 = (ProtoBuf$TypeAlias) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$TypeAlias = protoBuf$TypeAlias2;
                        if (protoBuf$TypeAlias != null) {
                            mergeFrom(protoBuf$TypeAlias);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$TypeAlias != null) {
                }
                throw th;
            }
        }
    }

    static {
        ProtoBuf$TypeAlias protoBuf$TypeAlias = new ProtoBuf$TypeAlias(true);
        defaultInstance = protoBuf$TypeAlias;
        protoBuf$TypeAlias.initFields();
    }

    public static ProtoBuf$TypeAlias getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.flags_ = 6;
        this.name_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.underlyingType_ = ProtoBuf$Type.getDefaultInstance();
        this.underlyingTypeId_ = 0;
        this.expandedType_ = ProtoBuf$Type.getDefaultInstance();
        this.expandedTypeId_ = 0;
        this.annotation_ = Collections.emptyList();
        this.versionRequirement_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.access$19000();
    }

    public static ProtoBuf$TypeAlias parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public ProtoBuf$Annotation getAnnotation(int i5) {
        return this.annotation_.get(i5);
    }

    public int getAnnotationCount() {
        return this.annotation_.size();
    }

    public List<ProtoBuf$Annotation> getAnnotationList() {
        return this.annotation_;
    }

    public ProtoBuf$Type getExpandedType() {
        return this.expandedType_;
    }

    public int getExpandedTypeId() {
        return this.expandedTypeId_;
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
        for (int i6 = 0; i6 < this.typeParameter_.size(); i6++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(3, this.typeParameter_.get(i6));
        }
        if ((this.bitField0_ & 4) == 4) {
            computeInt32Size += CodedOutputStream.computeMessageSize(4, this.underlyingType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            computeInt32Size += CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
        }
        if ((this.bitField0_ & 16) == 16) {
            computeInt32Size += CodedOutputStream.computeMessageSize(6, this.expandedType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            computeInt32Size += CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
        }
        for (int i7 = 0; i7 < this.annotation_.size(); i7++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(8, this.annotation_.get(i7));
        }
        int i8 = 0;
        for (int i9 = 0; i9 < this.versionRequirement_.size(); i9++) {
            i8 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i9).intValue());
        }
        int size = computeInt32Size + i8 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public ProtoBuf$TypeParameter getTypeParameter(int i5) {
        return this.typeParameter_.get(i5);
    }

    public int getTypeParameterCount() {
        return this.typeParameter_.size();
    }

    public List<ProtoBuf$TypeParameter> getTypeParameterList() {
        return this.typeParameter_;
    }

    public ProtoBuf$Type getUnderlyingType() {
        return this.underlyingType_;
    }

    public int getUnderlyingTypeId() {
        return this.underlyingTypeId_;
    }

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public boolean hasExpandedType() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasExpandedTypeId() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasUnderlyingType() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasUnderlyingTypeId() {
        return (this.bitField0_ & 8) == 8;
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
        for (int i5 = 0; i5 < getTypeParameterCount(); i5++) {
            if (!getTypeParameter(i5).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasExpandedType() && !getExpandedType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i6 = 0; i6 < getAnnotationCount(); i6++) {
            if (!getAnnotation(i6).isInitialized()) {
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
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        for (int i5 = 0; i5 < this.typeParameter_.size(); i5++) {
            codedOutputStream.writeMessage(3, this.typeParameter_.get(i5));
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(4, this.underlyingType_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(5, this.underlyingTypeId_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeMessage(6, this.expandedType_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(7, this.expandedTypeId_);
        }
        for (int i6 = 0; i6 < this.annotation_.size(); i6++) {
            codedOutputStream.writeMessage(8, this.annotation_.get(i6));
        }
        for (int i7 = 0; i7 < this.versionRequirement_.size(); i7++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i7).intValue());
        }
        newExtensionWriter.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$TypeAlias protoBuf$TypeAlias) {
        return newBuilder().mergeFrom(protoBuf$TypeAlias);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$TypeAlias getDefaultInstanceForType() {
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

    private ProtoBuf$TypeAlias(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$TypeAlias, ?> extendableBuilder) {
        super(extendableBuilder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$TypeAlias(boolean z5) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0022. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    private ProtoBuf$TypeAlias(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        ProtoBuf$Type.Builder builder;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output newOutput = ByteString.newOutput();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
        boolean z5 = false;
        int i5 = 0;
        while (true) {
            ?? r5 = 128;
            if (!z5) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z5 = true;
                            case 8:
                                this.bitField0_ |= 1;
                                this.flags_ = codedInputStream.readInt32();
                            case 16:
                                this.bitField0_ |= 2;
                                this.name_ = codedInputStream.readInt32();
                            case 26:
                                if ((i5 & 4) != 4) {
                                    this.typeParameter_ = new ArrayList();
                                    i5 |= 4;
                                }
                                this.typeParameter_.add(codedInputStream.readMessage(ProtoBuf$TypeParameter.PARSER, extensionRegistryLite));
                            case 34:
                                builder = (this.bitField0_ & 4) == 4 ? this.underlyingType_.toBuilder() : null;
                                ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                                this.underlyingType_ = protoBuf$Type;
                                if (builder != null) {
                                    builder.mergeFrom(protoBuf$Type);
                                    this.underlyingType_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            case 40:
                                this.bitField0_ |= 8;
                                this.underlyingTypeId_ = codedInputStream.readInt32();
                            case 50:
                                builder = (this.bitField0_ & 16) == 16 ? this.expandedType_.toBuilder() : null;
                                ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                                this.expandedType_ = protoBuf$Type2;
                                if (builder != null) {
                                    builder.mergeFrom(protoBuf$Type2);
                                    this.expandedType_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 16;
                            case 56:
                                this.bitField0_ |= 32;
                                this.expandedTypeId_ = codedInputStream.readInt32();
                            case 66:
                                if ((i5 & 128) != 128) {
                                    this.annotation_ = new ArrayList();
                                    i5 |= 128;
                                }
                                this.annotation_.add(codedInputStream.readMessage(ProtoBuf$Annotation.PARSER, extensionRegistryLite));
                            case 248:
                                if ((i5 & 256) != 256) {
                                    this.versionRequirement_ = new ArrayList();
                                    i5 |= 256;
                                }
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            case 250:
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                if ((i5 & 256) != 256 && codedInputStream.getBytesUntilLimit() > 0) {
                                    this.versionRequirement_ = new ArrayList();
                                    i5 |= 256;
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                }
                                codedInputStream.popLimit(pushLimit);
                                break;
                            default:
                                r5 = parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag);
                                if (r5 == 0) {
                                    z5 = true;
                                }
                        }
                    } catch (Throwable th) {
                        if ((i5 & 4) == 4) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if ((i5 & 128) == r5) {
                            this.annotation_ = Collections.unmodifiableList(this.annotation_);
                        }
                        if ((i5 & 256) == 256) {
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
                } catch (InvalidProtocolBufferException e5) {
                    throw e5.setUnfinishedMessage(this);
                } catch (IOException e6) {
                    throw new InvalidProtocolBufferException(e6.getMessage()).setUnfinishedMessage(this);
                }
            } else {
                if ((i5 & 4) == 4) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if ((i5 & 128) == 128) {
                    this.annotation_ = Collections.unmodifiableList(this.annotation_);
                }
                if ((i5 & 256) == 256) {
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
                return;
            }
        }
    }
}
