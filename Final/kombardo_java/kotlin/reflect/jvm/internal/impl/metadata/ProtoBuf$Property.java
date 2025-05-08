package kotlin.reflect.jvm.internal.impl.metadata;

import com.sun.jna.Function;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
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
public final class ProtoBuf$Property extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Property> implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$Property> PARSER = new AbstractParser<ProtoBuf$Property>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$Property parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$Property(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$Property defaultInstance;
    private int bitField0_;
    private int contextReceiverTypeIdMemoizedSerializedSize;
    private List<Integer> contextReceiverTypeId_;
    private List<ProtoBuf$Type> contextReceiverType_;
    private int flags_;
    private int getterFlags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int oldFlags_;
    private int receiverTypeId_;
    private ProtoBuf$Type receiverType_;
    private int returnTypeId_;
    private ProtoBuf$Type returnType_;
    private int setterFlags_;
    private ProtoBuf$ValueParameter setterValueParameter_;
    private List<ProtoBuf$TypeParameter> typeParameter_;
    private final ByteString unknownFields;
    private List<Integer> versionRequirement_;

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Property, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private int getterFlags_;
        private int name_;
        private int receiverTypeId_;
        private int returnTypeId_;
        private int setterFlags_;
        private int flags_ = 518;
        private int oldFlags_ = 2054;
        private ProtoBuf$Type returnType_ = ProtoBuf$Type.getDefaultInstance();
        private List<ProtoBuf$TypeParameter> typeParameter_ = Collections.emptyList();
        private ProtoBuf$Type receiverType_ = ProtoBuf$Type.getDefaultInstance();
        private List<ProtoBuf$Type> contextReceiverType_ = Collections.emptyList();
        private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
        private ProtoBuf$ValueParameter setterValueParameter_ = ProtoBuf$ValueParameter.getDefaultInstance();
        private List<Integer> versionRequirement_ = Collections.emptyList();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$16000() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureContextReceiverTypeIdIsMutable() {
            if ((this.bitField0_ & 512) != 512) {
                this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                this.bitField0_ |= 512;
            }
        }

        private void ensureContextReceiverTypeIsMutable() {
            if ((this.bitField0_ & 256) != 256) {
                this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                this.bitField0_ |= 256;
            }
        }

        private void ensureTypeParameterIsMutable() {
            if ((this.bitField0_ & 32) != 32) {
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 32;
            }
        }

        private void ensureVersionRequirementIsMutable() {
            if ((this.bitField0_ & 8192) != 8192) {
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 8192;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Property buildPartial() {
            ProtoBuf$Property protoBuf$Property = new ProtoBuf$Property(this);
            int i5 = this.bitField0_;
            int i6 = (i5 & 1) != 1 ? 0 : 1;
            protoBuf$Property.flags_ = this.flags_;
            if ((i5 & 2) == 2) {
                i6 |= 2;
            }
            protoBuf$Property.oldFlags_ = this.oldFlags_;
            if ((i5 & 4) == 4) {
                i6 |= 4;
            }
            protoBuf$Property.name_ = this.name_;
            if ((i5 & 8) == 8) {
                i6 |= 8;
            }
            protoBuf$Property.returnType_ = this.returnType_;
            if ((i5 & 16) == 16) {
                i6 |= 16;
            }
            protoBuf$Property.returnTypeId_ = this.returnTypeId_;
            if ((this.bitField0_ & 32) == 32) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -33;
            }
            protoBuf$Property.typeParameter_ = this.typeParameter_;
            if ((i5 & 64) == 64) {
                i6 |= 32;
            }
            protoBuf$Property.receiverType_ = this.receiverType_;
            if ((i5 & 128) == 128) {
                i6 |= 64;
            }
            protoBuf$Property.receiverTypeId_ = this.receiverTypeId_;
            if ((this.bitField0_ & 256) == 256) {
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -257;
            }
            protoBuf$Property.contextReceiverType_ = this.contextReceiverType_;
            if ((this.bitField0_ & 512) == 512) {
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= -513;
            }
            protoBuf$Property.contextReceiverTypeId_ = this.contextReceiverTypeId_;
            if ((i5 & 1024) == 1024) {
                i6 |= 128;
            }
            protoBuf$Property.setterValueParameter_ = this.setterValueParameter_;
            if ((i5 & 2048) == 2048) {
                i6 |= 256;
            }
            protoBuf$Property.getterFlags_ = this.getterFlags_;
            if ((i5 & 4096) == 4096) {
                i6 |= 512;
            }
            protoBuf$Property.setterFlags_ = this.setterFlags_;
            if ((this.bitField0_ & 8192) == 8192) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -8193;
            }
            protoBuf$Property.versionRequirement_ = this.versionRequirement_;
            protoBuf$Property.bitField0_ = i6;
            return protoBuf$Property;
        }

        public Builder mergeReceiverType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 64) != 64 || this.receiverType_ == ProtoBuf$Type.getDefaultInstance()) {
                this.receiverType_ = protoBuf$Type;
            } else {
                this.receiverType_ = ProtoBuf$Type.newBuilder(this.receiverType_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 64;
            return this;
        }

        public Builder mergeReturnType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 8) != 8 || this.returnType_ == ProtoBuf$Type.getDefaultInstance()) {
                this.returnType_ = protoBuf$Type;
            } else {
                this.returnType_ = ProtoBuf$Type.newBuilder(this.returnType_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 8;
            return this;
        }

        public Builder mergeSetterValueParameter(ProtoBuf$ValueParameter protoBuf$ValueParameter) {
            if ((this.bitField0_ & 1024) != 1024 || this.setterValueParameter_ == ProtoBuf$ValueParameter.getDefaultInstance()) {
                this.setterValueParameter_ = protoBuf$ValueParameter;
            } else {
                this.setterValueParameter_ = ProtoBuf$ValueParameter.newBuilder(this.setterValueParameter_).mergeFrom(protoBuf$ValueParameter).buildPartial();
            }
            this.bitField0_ |= 1024;
            return this;
        }

        public Builder setFlags(int i5) {
            this.bitField0_ |= 1;
            this.flags_ = i5;
            return this;
        }

        public Builder setGetterFlags(int i5) {
            this.bitField0_ |= 2048;
            this.getterFlags_ = i5;
            return this;
        }

        public Builder setName(int i5) {
            this.bitField0_ |= 4;
            this.name_ = i5;
            return this;
        }

        public Builder setOldFlags(int i5) {
            this.bitField0_ |= 2;
            this.oldFlags_ = i5;
            return this;
        }

        public Builder setReceiverTypeId(int i5) {
            this.bitField0_ |= 128;
            this.receiverTypeId_ = i5;
            return this;
        }

        public Builder setReturnTypeId(int i5) {
            this.bitField0_ |= 16;
            this.returnTypeId_ = i5;
            return this;
        }

        public Builder setSetterFlags(int i5) {
            this.bitField0_ |= 4096;
            this.setterFlags_ = i5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Property build() {
            ProtoBuf$Property buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$Property protoBuf$Property) {
            if (protoBuf$Property == ProtoBuf$Property.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$Property.hasFlags()) {
                setFlags(protoBuf$Property.getFlags());
            }
            if (protoBuf$Property.hasOldFlags()) {
                setOldFlags(protoBuf$Property.getOldFlags());
            }
            if (protoBuf$Property.hasName()) {
                setName(protoBuf$Property.getName());
            }
            if (protoBuf$Property.hasReturnType()) {
                mergeReturnType(protoBuf$Property.getReturnType());
            }
            if (protoBuf$Property.hasReturnTypeId()) {
                setReturnTypeId(protoBuf$Property.getReturnTypeId());
            }
            if (!protoBuf$Property.typeParameter_.isEmpty()) {
                if (this.typeParameter_.isEmpty()) {
                    this.typeParameter_ = protoBuf$Property.typeParameter_;
                    this.bitField0_ &= -33;
                } else {
                    ensureTypeParameterIsMutable();
                    this.typeParameter_.addAll(protoBuf$Property.typeParameter_);
                }
            }
            if (protoBuf$Property.hasReceiverType()) {
                mergeReceiverType(protoBuf$Property.getReceiverType());
            }
            if (protoBuf$Property.hasReceiverTypeId()) {
                setReceiverTypeId(protoBuf$Property.getReceiverTypeId());
            }
            if (!protoBuf$Property.contextReceiverType_.isEmpty()) {
                if (this.contextReceiverType_.isEmpty()) {
                    this.contextReceiverType_ = protoBuf$Property.contextReceiverType_;
                    this.bitField0_ &= -257;
                } else {
                    ensureContextReceiverTypeIsMutable();
                    this.contextReceiverType_.addAll(protoBuf$Property.contextReceiverType_);
                }
            }
            if (!protoBuf$Property.contextReceiverTypeId_.isEmpty()) {
                if (this.contextReceiverTypeId_.isEmpty()) {
                    this.contextReceiverTypeId_ = protoBuf$Property.contextReceiverTypeId_;
                    this.bitField0_ &= -513;
                } else {
                    ensureContextReceiverTypeIdIsMutable();
                    this.contextReceiverTypeId_.addAll(protoBuf$Property.contextReceiverTypeId_);
                }
            }
            if (protoBuf$Property.hasSetterValueParameter()) {
                mergeSetterValueParameter(protoBuf$Property.getSetterValueParameter());
            }
            if (protoBuf$Property.hasGetterFlags()) {
                setGetterFlags(protoBuf$Property.getGetterFlags());
            }
            if (protoBuf$Property.hasSetterFlags()) {
                setSetterFlags(protoBuf$Property.getSetterFlags());
            }
            if (!protoBuf$Property.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$Property.versionRequirement_;
                    this.bitField0_ &= -8193;
                } else {
                    ensureVersionRequirementIsMutable();
                    this.versionRequirement_.addAll(protoBuf$Property.versionRequirement_);
                }
            }
            mergeExtensionFields(protoBuf$Property);
            setUnknownFields(getUnknownFields().concat(protoBuf$Property.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$Property protoBuf$Property = null;
            try {
                try {
                    ProtoBuf$Property parsePartialFrom = ProtoBuf$Property.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$Property protoBuf$Property2 = (ProtoBuf$Property) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$Property = protoBuf$Property2;
                        if (protoBuf$Property != null) {
                            mergeFrom(protoBuf$Property);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$Property != null) {
                }
                throw th;
            }
        }
    }

    static {
        ProtoBuf$Property protoBuf$Property = new ProtoBuf$Property(true);
        defaultInstance = protoBuf$Property;
        protoBuf$Property.initFields();
    }

    public static ProtoBuf$Property getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.flags_ = 518;
        this.oldFlags_ = 2054;
        this.name_ = 0;
        this.returnType_ = ProtoBuf$Type.getDefaultInstance();
        this.returnTypeId_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.receiverType_ = ProtoBuf$Type.getDefaultInstance();
        this.receiverTypeId_ = 0;
        this.contextReceiverType_ = Collections.emptyList();
        this.contextReceiverTypeId_ = Collections.emptyList();
        this.setterValueParameter_ = ProtoBuf$ValueParameter.getDefaultInstance();
        this.getterFlags_ = 0;
        this.setterFlags_ = 0;
        this.versionRequirement_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.access$16000();
    }

    public ProtoBuf$Type getContextReceiverType(int i5) {
        return this.contextReceiverType_.get(i5);
    }

    public int getContextReceiverTypeCount() {
        return this.contextReceiverType_.size();
    }

    public List<Integer> getContextReceiverTypeIdList() {
        return this.contextReceiverTypeId_;
    }

    public List<ProtoBuf$Type> getContextReceiverTypeList() {
        return this.contextReceiverType_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getGetterFlags() {
        return this.getterFlags_;
    }

    public int getName() {
        return this.name_;
    }

    public int getOldFlags() {
        return this.oldFlags_;
    }

    public ProtoBuf$Type getReceiverType() {
        return this.receiverType_;
    }

    public int getReceiverTypeId() {
        return this.receiverTypeId_;
    }

    public ProtoBuf$Type getReturnType() {
        return this.returnType_;
    }

    public int getReturnTypeId() {
        return this.returnTypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int computeInt32Size = (this.bitField0_ & 2) == 2 ? CodedOutputStream.computeInt32Size(1, this.oldFlags_) : 0;
        if ((this.bitField0_ & 4) == 4) {
            computeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        if ((this.bitField0_ & 8) == 8) {
            computeInt32Size += CodedOutputStream.computeMessageSize(3, this.returnType_);
        }
        for (int i6 = 0; i6 < this.typeParameter_.size(); i6++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(4, this.typeParameter_.get(i6));
        }
        if ((this.bitField0_ & 32) == 32) {
            computeInt32Size += CodedOutputStream.computeMessageSize(5, this.receiverType_);
        }
        if ((this.bitField0_ & 128) == 128) {
            computeInt32Size += CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
        }
        if ((this.bitField0_ & 256) == 256) {
            computeInt32Size += CodedOutputStream.computeInt32Size(7, this.getterFlags_);
        }
        if ((this.bitField0_ & 512) == 512) {
            computeInt32Size += CodedOutputStream.computeInt32Size(8, this.setterFlags_);
        }
        if ((this.bitField0_ & 16) == 16) {
            computeInt32Size += CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            computeInt32Size += CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            computeInt32Size += CodedOutputStream.computeInt32Size(11, this.flags_);
        }
        for (int i7 = 0; i7 < this.contextReceiverType_.size(); i7++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(12, this.contextReceiverType_.get(i7));
        }
        int i8 = 0;
        for (int i9 = 0; i9 < this.contextReceiverTypeId_.size(); i9++) {
            i8 += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i9).intValue());
        }
        int i10 = computeInt32Size + i8;
        if (!getContextReceiverTypeIdList().isEmpty()) {
            i10 = i10 + 1 + CodedOutputStream.computeInt32SizeNoTag(i8);
        }
        this.contextReceiverTypeIdMemoizedSerializedSize = i8;
        int i11 = 0;
        for (int i12 = 0; i12 < this.versionRequirement_.size(); i12++) {
            i11 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i12).intValue());
        }
        int size = i10 + i11 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public int getSetterFlags() {
        return this.setterFlags_;
    }

    public ProtoBuf$ValueParameter getSetterValueParameter() {
        return this.setterValueParameter_;
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

    public List<Integer> getVersionRequirementList() {
        return this.versionRequirement_;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasGetterFlags() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean hasName() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasOldFlags() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasReceiverType() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasReceiverTypeId() {
        return (this.bitField0_ & 64) == 64;
    }

    public boolean hasReturnType() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasReturnTypeId() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasSetterFlags() {
        return (this.bitField0_ & 512) == 512;
    }

    public boolean hasSetterValueParameter() {
        return (this.bitField0_ & 128) == 128;
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
        if (hasReturnType() && !getReturnType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i5 = 0; i5 < getTypeParameterCount(); i5++) {
            if (!getTypeParameter(i5).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasReceiverType() && !getReceiverType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i6 = 0; i6 < getContextReceiverTypeCount(); i6++) {
            if (!getContextReceiverType(i6).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasSetterValueParameter() && !getSetterValueParameter().isInitialized()) {
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
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(1, this.oldFlags_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(3, this.returnType_);
        }
        for (int i5 = 0; i5 < this.typeParameter_.size(); i5++) {
            codedOutputStream.writeMessage(4, this.typeParameter_.get(i5));
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeMessage(5, this.receiverType_);
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeMessage(6, this.setterValueParameter_);
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeInt32(7, this.getterFlags_);
        }
        if ((this.bitField0_ & 512) == 512) {
            codedOutputStream.writeInt32(8, this.setterFlags_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(9, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeInt32(10, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(11, this.flags_);
        }
        for (int i6 = 0; i6 < this.contextReceiverType_.size(); i6++) {
            codedOutputStream.writeMessage(12, this.contextReceiverType_.get(i6));
        }
        if (getContextReceiverTypeIdList().size() > 0) {
            codedOutputStream.writeRawVarint32(106);
            codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        }
        for (int i7 = 0; i7 < this.contextReceiverTypeId_.size(); i7++) {
            codedOutputStream.writeInt32NoTag(this.contextReceiverTypeId_.get(i7).intValue());
        }
        for (int i8 = 0; i8 < this.versionRequirement_.size(); i8++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i8).intValue());
        }
        newExtensionWriter.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Property protoBuf$Property) {
        return newBuilder().mergeFrom(protoBuf$Property);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Property getDefaultInstanceForType() {
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

    private ProtoBuf$Property(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Property, ?> extendableBuilder) {
        super(extendableBuilder);
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$Property(boolean z5) {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0027. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    private ProtoBuf$Property(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output newOutput = ByteString.newOutput();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
        boolean z5 = false;
        char c5 = 0;
        while (true) {
            ?? r5 = 256;
            if (!z5) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z5 = true;
                            case 8:
                                this.bitField0_ |= 2;
                                this.oldFlags_ = codedInputStream.readInt32();
                            case 16:
                                this.bitField0_ |= 4;
                                this.name_ = codedInputStream.readInt32();
                            case 26:
                                ProtoBuf$Type.Builder builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
                                ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                                this.returnType_ = protoBuf$Type;
                                if (builder != null) {
                                    builder.mergeFrom(protoBuf$Type);
                                    this.returnType_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 8;
                            case 34:
                                int i5 = (c5 == true ? 1 : 0) & 32;
                                c5 = c5;
                                if (i5 != 32) {
                                    this.typeParameter_ = new ArrayList();
                                    c5 = (c5 == true ? 1 : 0) | ' ';
                                }
                                this.typeParameter_.add(codedInputStream.readMessage(ProtoBuf$TypeParameter.PARSER, extensionRegistryLite));
                            case 42:
                                ProtoBuf$Type.Builder builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
                                ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                                this.receiverType_ = protoBuf$Type2;
                                if (builder2 != null) {
                                    builder2.mergeFrom(protoBuf$Type2);
                                    this.receiverType_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 32;
                            case 50:
                                ProtoBuf$ValueParameter.Builder builder3 = (this.bitField0_ & 128) == 128 ? this.setterValueParameter_.toBuilder() : null;
                                ProtoBuf$ValueParameter protoBuf$ValueParameter = (ProtoBuf$ValueParameter) codedInputStream.readMessage(ProtoBuf$ValueParameter.PARSER, extensionRegistryLite);
                                this.setterValueParameter_ = protoBuf$ValueParameter;
                                if (builder3 != null) {
                                    builder3.mergeFrom(protoBuf$ValueParameter);
                                    this.setterValueParameter_ = builder3.buildPartial();
                                }
                                this.bitField0_ |= 128;
                            case 56:
                                this.bitField0_ |= 256;
                                this.getterFlags_ = codedInputStream.readInt32();
                            case Function.THROW_LAST_ERROR /* 64 */:
                                this.bitField0_ |= 512;
                                this.setterFlags_ = codedInputStream.readInt32();
                            case 72:
                                this.bitField0_ |= 16;
                                this.returnTypeId_ = codedInputStream.readInt32();
                            case 80:
                                this.bitField0_ |= 64;
                                this.receiverTypeId_ = codedInputStream.readInt32();
                            case 88:
                                this.bitField0_ |= 1;
                                this.flags_ = codedInputStream.readInt32();
                            case 98:
                                int i6 = (c5 == true ? 1 : 0) & 256;
                                c5 = c5;
                                if (i6 != 256) {
                                    this.contextReceiverType_ = new ArrayList();
                                    c5 = (c5 == true ? 1 : 0) | 256;
                                }
                                this.contextReceiverType_.add(codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite));
                            case 104:
                                int i7 = (c5 == true ? 1 : 0) & 512;
                                c5 = c5;
                                if (i7 != 512) {
                                    this.contextReceiverTypeId_ = new ArrayList();
                                    c5 = (c5 == true ? 1 : 0) | 512;
                                }
                                this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            case 106:
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                int i8 = (c5 == true ? 1 : 0) & 512;
                                c5 = c5;
                                if (i8 != 512) {
                                    c5 = c5;
                                    if (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.contextReceiverTypeId_ = new ArrayList();
                                        c5 = (c5 == true ? 1 : 0) | 512;
                                    }
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                                }
                                codedInputStream.popLimit(pushLimit);
                            case 248:
                                int i9 = (c5 == true ? 1 : 0) & 8192;
                                c5 = c5;
                                if (i9 != 8192) {
                                    this.versionRequirement_ = new ArrayList();
                                    c5 = (c5 == true ? 1 : 0) | 8192;
                                }
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            case 250:
                                int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                int i10 = (c5 == true ? 1 : 0) & 8192;
                                c5 = c5;
                                if (i10 != 8192) {
                                    c5 = c5;
                                    if (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.versionRequirement_ = new ArrayList();
                                        c5 = (c5 == true ? 1 : 0) | 8192;
                                    }
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                }
                                codedInputStream.popLimit(pushLimit2);
                            default:
                                r5 = parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag);
                                if (r5 == 0) {
                                    z5 = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException e5) {
                        throw e5.setUnfinishedMessage(this);
                    } catch (IOException e6) {
                        throw new InvalidProtocolBufferException(e6.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (((c5 == true ? 1 : 0) & 32) == 32) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if (((c5 == true ? 1 : 0) & 256) == r5) {
                        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    }
                    if (((c5 == true ? 1 : 0) & 512) == 512) {
                        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    }
                    if (((c5 == true ? 1 : 0) & 8192) == 8192) {
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
            } else {
                if (((c5 == true ? 1 : 0) & 32) == 32) {
                    this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                }
                if (((c5 == true ? 1 : 0) & 256) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                }
                if (((c5 == true ? 1 : 0) & 512) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                }
                if (((c5 == true ? 1 : 0) & 8192) == 8192) {
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
