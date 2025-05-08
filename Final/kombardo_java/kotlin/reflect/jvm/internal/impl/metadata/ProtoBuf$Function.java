package kotlin.reflect.jvm.internal.impl.metadata;

import com.sun.jna.Function;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
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
public final class ProtoBuf$Function extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Function> implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$Function> PARSER = new AbstractParser<ProtoBuf$Function>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$Function parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$Function(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$Function defaultInstance;
    private int bitField0_;
    private int contextReceiverTypeIdMemoizedSerializedSize;
    private List<Integer> contextReceiverTypeId_;
    private List<ProtoBuf$Type> contextReceiverType_;
    private ProtoBuf$Contract contract_;
    private int flags_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private int oldFlags_;
    private int receiverTypeId_;
    private ProtoBuf$Type receiverType_;
    private int returnTypeId_;
    private ProtoBuf$Type returnType_;
    private List<ProtoBuf$TypeParameter> typeParameter_;
    private ProtoBuf$TypeTable typeTable_;
    private final ByteString unknownFields;
    private List<ProtoBuf$ValueParameter> valueParameter_;
    private List<Integer> versionRequirement_;

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Function, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private int name_;
        private int receiverTypeId_;
        private int returnTypeId_;
        private int flags_ = 6;
        private int oldFlags_ = 6;
        private ProtoBuf$Type returnType_ = ProtoBuf$Type.getDefaultInstance();
        private List<ProtoBuf$TypeParameter> typeParameter_ = Collections.emptyList();
        private ProtoBuf$Type receiverType_ = ProtoBuf$Type.getDefaultInstance();
        private List<ProtoBuf$Type> contextReceiverType_ = Collections.emptyList();
        private List<Integer> contextReceiverTypeId_ = Collections.emptyList();
        private List<ProtoBuf$ValueParameter> valueParameter_ = Collections.emptyList();
        private ProtoBuf$TypeTable typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        private List<Integer> versionRequirement_ = Collections.emptyList();
        private ProtoBuf$Contract contract_ = ProtoBuf$Contract.getDefaultInstance();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$14100() {
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

        private void ensureValueParameterIsMutable() {
            if ((this.bitField0_ & 1024) != 1024) {
                this.valueParameter_ = new ArrayList(this.valueParameter_);
                this.bitField0_ |= 1024;
            }
        }

        private void ensureVersionRequirementIsMutable() {
            if ((this.bitField0_ & 4096) != 4096) {
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 4096;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Function buildPartial() {
            ProtoBuf$Function protoBuf$Function = new ProtoBuf$Function(this);
            int i5 = this.bitField0_;
            int i6 = (i5 & 1) != 1 ? 0 : 1;
            protoBuf$Function.flags_ = this.flags_;
            if ((i5 & 2) == 2) {
                i6 |= 2;
            }
            protoBuf$Function.oldFlags_ = this.oldFlags_;
            if ((i5 & 4) == 4) {
                i6 |= 4;
            }
            protoBuf$Function.name_ = this.name_;
            if ((i5 & 8) == 8) {
                i6 |= 8;
            }
            protoBuf$Function.returnType_ = this.returnType_;
            if ((i5 & 16) == 16) {
                i6 |= 16;
            }
            protoBuf$Function.returnTypeId_ = this.returnTypeId_;
            if ((this.bitField0_ & 32) == 32) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -33;
            }
            protoBuf$Function.typeParameter_ = this.typeParameter_;
            if ((i5 & 64) == 64) {
                i6 |= 32;
            }
            protoBuf$Function.receiverType_ = this.receiverType_;
            if ((i5 & 128) == 128) {
                i6 |= 64;
            }
            protoBuf$Function.receiverTypeId_ = this.receiverTypeId_;
            if ((this.bitField0_ & 256) == 256) {
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -257;
            }
            protoBuf$Function.contextReceiverType_ = this.contextReceiverType_;
            if ((this.bitField0_ & 512) == 512) {
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= -513;
            }
            protoBuf$Function.contextReceiverTypeId_ = this.contextReceiverTypeId_;
            if ((this.bitField0_ & 1024) == 1024) {
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                this.bitField0_ &= -1025;
            }
            protoBuf$Function.valueParameter_ = this.valueParameter_;
            if ((i5 & 2048) == 2048) {
                i6 |= 128;
            }
            protoBuf$Function.typeTable_ = this.typeTable_;
            if ((this.bitField0_ & 4096) == 4096) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -4097;
            }
            protoBuf$Function.versionRequirement_ = this.versionRequirement_;
            if ((i5 & 8192) == 8192) {
                i6 |= 256;
            }
            protoBuf$Function.contract_ = this.contract_;
            protoBuf$Function.bitField0_ = i6;
            return protoBuf$Function;
        }

        public Builder mergeContract(ProtoBuf$Contract protoBuf$Contract) {
            if ((this.bitField0_ & 8192) != 8192 || this.contract_ == ProtoBuf$Contract.getDefaultInstance()) {
                this.contract_ = protoBuf$Contract;
            } else {
                this.contract_ = ProtoBuf$Contract.newBuilder(this.contract_).mergeFrom(protoBuf$Contract).buildPartial();
            }
            this.bitField0_ |= 8192;
            return this;
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

        public Builder mergeTypeTable(ProtoBuf$TypeTable protoBuf$TypeTable) {
            if ((this.bitField0_ & 2048) != 2048 || this.typeTable_ == ProtoBuf$TypeTable.getDefaultInstance()) {
                this.typeTable_ = protoBuf$TypeTable;
            } else {
                this.typeTable_ = ProtoBuf$TypeTable.newBuilder(this.typeTable_).mergeFrom(protoBuf$TypeTable).buildPartial();
            }
            this.bitField0_ |= 2048;
            return this;
        }

        public Builder setFlags(int i5) {
            this.bitField0_ |= 1;
            this.flags_ = i5;
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Function build() {
            ProtoBuf$Function buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$Function protoBuf$Function) {
            if (protoBuf$Function == ProtoBuf$Function.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$Function.hasFlags()) {
                setFlags(protoBuf$Function.getFlags());
            }
            if (protoBuf$Function.hasOldFlags()) {
                setOldFlags(protoBuf$Function.getOldFlags());
            }
            if (protoBuf$Function.hasName()) {
                setName(protoBuf$Function.getName());
            }
            if (protoBuf$Function.hasReturnType()) {
                mergeReturnType(protoBuf$Function.getReturnType());
            }
            if (protoBuf$Function.hasReturnTypeId()) {
                setReturnTypeId(protoBuf$Function.getReturnTypeId());
            }
            if (!protoBuf$Function.typeParameter_.isEmpty()) {
                if (this.typeParameter_.isEmpty()) {
                    this.typeParameter_ = protoBuf$Function.typeParameter_;
                    this.bitField0_ &= -33;
                } else {
                    ensureTypeParameterIsMutable();
                    this.typeParameter_.addAll(protoBuf$Function.typeParameter_);
                }
            }
            if (protoBuf$Function.hasReceiverType()) {
                mergeReceiverType(protoBuf$Function.getReceiverType());
            }
            if (protoBuf$Function.hasReceiverTypeId()) {
                setReceiverTypeId(protoBuf$Function.getReceiverTypeId());
            }
            if (!protoBuf$Function.contextReceiverType_.isEmpty()) {
                if (this.contextReceiverType_.isEmpty()) {
                    this.contextReceiverType_ = protoBuf$Function.contextReceiverType_;
                    this.bitField0_ &= -257;
                } else {
                    ensureContextReceiverTypeIsMutable();
                    this.contextReceiverType_.addAll(protoBuf$Function.contextReceiverType_);
                }
            }
            if (!protoBuf$Function.contextReceiverTypeId_.isEmpty()) {
                if (this.contextReceiverTypeId_.isEmpty()) {
                    this.contextReceiverTypeId_ = protoBuf$Function.contextReceiverTypeId_;
                    this.bitField0_ &= -513;
                } else {
                    ensureContextReceiverTypeIdIsMutable();
                    this.contextReceiverTypeId_.addAll(protoBuf$Function.contextReceiverTypeId_);
                }
            }
            if (!protoBuf$Function.valueParameter_.isEmpty()) {
                if (this.valueParameter_.isEmpty()) {
                    this.valueParameter_ = protoBuf$Function.valueParameter_;
                    this.bitField0_ &= -1025;
                } else {
                    ensureValueParameterIsMutable();
                    this.valueParameter_.addAll(protoBuf$Function.valueParameter_);
                }
            }
            if (protoBuf$Function.hasTypeTable()) {
                mergeTypeTable(protoBuf$Function.getTypeTable());
            }
            if (!protoBuf$Function.versionRequirement_.isEmpty()) {
                if (this.versionRequirement_.isEmpty()) {
                    this.versionRequirement_ = protoBuf$Function.versionRequirement_;
                    this.bitField0_ &= -4097;
                } else {
                    ensureVersionRequirementIsMutable();
                    this.versionRequirement_.addAll(protoBuf$Function.versionRequirement_);
                }
            }
            if (protoBuf$Function.hasContract()) {
                mergeContract(protoBuf$Function.getContract());
            }
            mergeExtensionFields(protoBuf$Function);
            setUnknownFields(getUnknownFields().concat(protoBuf$Function.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$Function protoBuf$Function = null;
            try {
                try {
                    ProtoBuf$Function parsePartialFrom = ProtoBuf$Function.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$Function protoBuf$Function2 = (ProtoBuf$Function) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$Function = protoBuf$Function2;
                        if (protoBuf$Function != null) {
                            mergeFrom(protoBuf$Function);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$Function != null) {
                }
                throw th;
            }
        }
    }

    static {
        ProtoBuf$Function protoBuf$Function = new ProtoBuf$Function(true);
        defaultInstance = protoBuf$Function;
        protoBuf$Function.initFields();
    }

    public static ProtoBuf$Function getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.flags_ = 6;
        this.oldFlags_ = 6;
        this.name_ = 0;
        this.returnType_ = ProtoBuf$Type.getDefaultInstance();
        this.returnTypeId_ = 0;
        this.typeParameter_ = Collections.emptyList();
        this.receiverType_ = ProtoBuf$Type.getDefaultInstance();
        this.receiverTypeId_ = 0;
        this.contextReceiverType_ = Collections.emptyList();
        this.contextReceiverTypeId_ = Collections.emptyList();
        this.valueParameter_ = Collections.emptyList();
        this.typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        this.versionRequirement_ = Collections.emptyList();
        this.contract_ = ProtoBuf$Contract.getDefaultInstance();
    }

    public static Builder newBuilder() {
        return Builder.access$14100();
    }

    public static ProtoBuf$Function parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
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

    public ProtoBuf$Contract getContract() {
        return this.contract_;
    }

    public int getFlags() {
        return this.flags_;
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
        for (int i7 = 0; i7 < this.valueParameter_.size(); i7++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(6, this.valueParameter_.get(i7));
        }
        if ((this.bitField0_ & 16) == 16) {
            computeInt32Size += CodedOutputStream.computeInt32Size(7, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            computeInt32Size += CodedOutputStream.computeInt32Size(8, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            computeInt32Size += CodedOutputStream.computeInt32Size(9, this.flags_);
        }
        for (int i8 = 0; i8 < this.contextReceiverType_.size(); i8++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(10, this.contextReceiverType_.get(i8));
        }
        int i9 = 0;
        for (int i10 = 0; i10 < this.contextReceiverTypeId_.size(); i10++) {
            i9 += CodedOutputStream.computeInt32SizeNoTag(this.contextReceiverTypeId_.get(i10).intValue());
        }
        int i11 = computeInt32Size + i9;
        if (!getContextReceiverTypeIdList().isEmpty()) {
            i11 = i11 + 1 + CodedOutputStream.computeInt32SizeNoTag(i9);
        }
        this.contextReceiverTypeIdMemoizedSerializedSize = i9;
        if ((this.bitField0_ & 128) == 128) {
            i11 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.versionRequirement_.size(); i13++) {
            i12 += CodedOutputStream.computeInt32SizeNoTag(this.versionRequirement_.get(i13).intValue());
        }
        int size = i11 + i12 + (getVersionRequirementList().size() * 2);
        if ((this.bitField0_ & 256) == 256) {
            size += CodedOutputStream.computeMessageSize(32, this.contract_);
        }
        int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = extensionsSerializedSize;
        return extensionsSerializedSize;
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

    public ProtoBuf$TypeTable getTypeTable() {
        return this.typeTable_;
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

    public boolean hasContract() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
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

    public boolean hasTypeTable() {
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
        for (int i7 = 0; i7 < getValueParameterCount(); i7++) {
            if (!getValueParameter(i7).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasTypeTable() && !getTypeTable().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasContract() && !getContract().isInitialized()) {
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
        for (int i6 = 0; i6 < this.valueParameter_.size(); i6++) {
            codedOutputStream.writeMessage(6, this.valueParameter_.get(i6));
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(7, this.returnTypeId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeInt32(8, this.receiverTypeId_);
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(9, this.flags_);
        }
        for (int i7 = 0; i7 < this.contextReceiverType_.size(); i7++) {
            codedOutputStream.writeMessage(10, this.contextReceiverType_.get(i7));
        }
        if (getContextReceiverTypeIdList().size() > 0) {
            codedOutputStream.writeRawVarint32(90);
            codedOutputStream.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        }
        for (int i8 = 0; i8 < this.contextReceiverTypeId_.size(); i8++) {
            codedOutputStream.writeInt32NoTag(this.contextReceiverTypeId_.get(i8).intValue());
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeMessage(30, this.typeTable_);
        }
        for (int i9 = 0; i9 < this.versionRequirement_.size(); i9++) {
            codedOutputStream.writeInt32(31, this.versionRequirement_.get(i9).intValue());
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeMessage(32, this.contract_);
        }
        newExtensionWriter.writeUntil(19000, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Function protoBuf$Function) {
        return newBuilder().mergeFrom(protoBuf$Function);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Function getDefaultInstanceForType() {
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

    private ProtoBuf$Function(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Function, ?> extendableBuilder) {
        super(extendableBuilder);
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$Function(boolean z5) {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0029. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    private ProtoBuf$Function(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this.contextReceiverTypeIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output newOutput = ByteString.newOutput();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
        boolean z5 = false;
        char c5 = 0;
        while (true) {
            ?? r5 = 1024;
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
                                int i6 = (c5 == true ? 1 : 0) & 1024;
                                c5 = c5;
                                if (i6 != 1024) {
                                    this.valueParameter_ = new ArrayList();
                                    c5 = (c5 == true ? 1 : 0) | 1024;
                                }
                                this.valueParameter_.add(codedInputStream.readMessage(ProtoBuf$ValueParameter.PARSER, extensionRegistryLite));
                            case 56:
                                this.bitField0_ |= 16;
                                this.returnTypeId_ = codedInputStream.readInt32();
                            case Function.THROW_LAST_ERROR /* 64 */:
                                this.bitField0_ |= 64;
                                this.receiverTypeId_ = codedInputStream.readInt32();
                            case 72:
                                this.bitField0_ |= 1;
                                this.flags_ = codedInputStream.readInt32();
                            case 82:
                                int i7 = (c5 == true ? 1 : 0) & 256;
                                c5 = c5;
                                if (i7 != 256) {
                                    this.contextReceiverType_ = new ArrayList();
                                    c5 = (c5 == true ? 1 : 0) | 256;
                                }
                                this.contextReceiverType_.add(codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite));
                            case 88:
                                int i8 = (c5 == true ? 1 : 0) & 512;
                                c5 = c5;
                                if (i8 != 512) {
                                    this.contextReceiverTypeId_ = new ArrayList();
                                    c5 = (c5 == true ? 1 : 0) | 512;
                                }
                                this.contextReceiverTypeId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            case 90:
                                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                int i9 = (c5 == true ? 1 : 0) & 512;
                                c5 = c5;
                                if (i9 != 512) {
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
                            case 242:
                                ProtoBuf$TypeTable.Builder builder3 = (this.bitField0_ & 128) == 128 ? this.typeTable_.toBuilder() : null;
                                ProtoBuf$TypeTable protoBuf$TypeTable = (ProtoBuf$TypeTable) codedInputStream.readMessage(ProtoBuf$TypeTable.PARSER, extensionRegistryLite);
                                this.typeTable_ = protoBuf$TypeTable;
                                if (builder3 != null) {
                                    builder3.mergeFrom(protoBuf$TypeTable);
                                    this.typeTable_ = builder3.buildPartial();
                                }
                                this.bitField0_ |= 128;
                            case 248:
                                int i10 = (c5 == true ? 1 : 0) & 4096;
                                c5 = c5;
                                if (i10 != 4096) {
                                    this.versionRequirement_ = new ArrayList();
                                    c5 = (c5 == true ? 1 : 0) | 4096;
                                }
                                this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                            case 250:
                                int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                int i11 = (c5 == true ? 1 : 0) & 4096;
                                c5 = c5;
                                if (i11 != 4096) {
                                    c5 = c5;
                                    if (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.versionRequirement_ = new ArrayList();
                                        c5 = (c5 == true ? 1 : 0) | 4096;
                                    }
                                }
                                while (codedInputStream.getBytesUntilLimit() > 0) {
                                    this.versionRequirement_.add(Integer.valueOf(codedInputStream.readInt32()));
                                }
                                codedInputStream.popLimit(pushLimit2);
                            case 258:
                                ProtoBuf$Contract.Builder builder4 = (this.bitField0_ & 256) == 256 ? this.contract_.toBuilder() : null;
                                ProtoBuf$Contract protoBuf$Contract = (ProtoBuf$Contract) codedInputStream.readMessage(ProtoBuf$Contract.PARSER, extensionRegistryLite);
                                this.contract_ = protoBuf$Contract;
                                if (builder4 != null) {
                                    builder4.mergeFrom(protoBuf$Contract);
                                    this.contract_ = builder4.buildPartial();
                                }
                                this.bitField0_ |= 256;
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
                    if (((c5 == true ? 1 : 0) & 1024) == r5) {
                        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    }
                    if (((c5 == true ? 1 : 0) & 256) == 256) {
                        this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                    }
                    if (((c5 == true ? 1 : 0) & 512) == 512) {
                        this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                    }
                    if (((c5 == true ? 1 : 0) & 4096) == 4096) {
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
                if (((c5 == true ? 1 : 0) & 1024) == 1024) {
                    this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                }
                if (((c5 == true ? 1 : 0) & 256) == 256) {
                    this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                }
                if (((c5 == true ? 1 : 0) & 512) == 512) {
                    this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                }
                if (((c5 == true ? 1 : 0) & 4096) == 4096) {
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
