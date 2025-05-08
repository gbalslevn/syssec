package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;
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
public final class ProtoBuf$Package extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Package> implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$Package> PARSER = new AbstractParser<ProtoBuf$Package>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$Package parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$Package(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$Package defaultInstance;
    private int bitField0_;
    private List<ProtoBuf$Function> function_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<ProtoBuf$Property> property_;
    private List<ProtoBuf$TypeAlias> typeAlias_;
    private ProtoBuf$TypeTable typeTable_;
    private final ByteString unknownFields;
    private ProtoBuf$VersionRequirementTable versionRequirementTable_;

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Package, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private List<ProtoBuf$Function> function_ = Collections.emptyList();
        private List<ProtoBuf$Property> property_ = Collections.emptyList();
        private List<ProtoBuf$TypeAlias> typeAlias_ = Collections.emptyList();
        private ProtoBuf$TypeTable typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        private ProtoBuf$VersionRequirementTable versionRequirementTable_ = ProtoBuf$VersionRequirementTable.getDefaultInstance();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$11600() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureFunctionIsMutable() {
            if ((this.bitField0_ & 1) != 1) {
                this.function_ = new ArrayList(this.function_);
                this.bitField0_ |= 1;
            }
        }

        private void ensurePropertyIsMutable() {
            if ((this.bitField0_ & 2) != 2) {
                this.property_ = new ArrayList(this.property_);
                this.bitField0_ |= 2;
            }
        }

        private void ensureTypeAliasIsMutable() {
            if ((this.bitField0_ & 4) != 4) {
                this.typeAlias_ = new ArrayList(this.typeAlias_);
                this.bitField0_ |= 4;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Package buildPartial() {
            ProtoBuf$Package protoBuf$Package = new ProtoBuf$Package(this);
            int i5 = this.bitField0_;
            if ((i5 & 1) == 1) {
                this.function_ = Collections.unmodifiableList(this.function_);
                this.bitField0_ &= -2;
            }
            protoBuf$Package.function_ = this.function_;
            if ((this.bitField0_ & 2) == 2) {
                this.property_ = Collections.unmodifiableList(this.property_);
                this.bitField0_ &= -3;
            }
            protoBuf$Package.property_ = this.property_;
            if ((this.bitField0_ & 4) == 4) {
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                this.bitField0_ &= -5;
            }
            protoBuf$Package.typeAlias_ = this.typeAlias_;
            int i6 = (i5 & 8) != 8 ? 0 : 1;
            protoBuf$Package.typeTable_ = this.typeTable_;
            if ((i5 & 16) == 16) {
                i6 |= 2;
            }
            protoBuf$Package.versionRequirementTable_ = this.versionRequirementTable_;
            protoBuf$Package.bitField0_ = i6;
            return protoBuf$Package;
        }

        public Builder mergeTypeTable(ProtoBuf$TypeTable protoBuf$TypeTable) {
            if ((this.bitField0_ & 8) != 8 || this.typeTable_ == ProtoBuf$TypeTable.getDefaultInstance()) {
                this.typeTable_ = protoBuf$TypeTable;
            } else {
                this.typeTable_ = ProtoBuf$TypeTable.newBuilder(this.typeTable_).mergeFrom(protoBuf$TypeTable).buildPartial();
            }
            this.bitField0_ |= 8;
            return this;
        }

        public Builder mergeVersionRequirementTable(ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
            if ((this.bitField0_ & 16) != 16 || this.versionRequirementTable_ == ProtoBuf$VersionRequirementTable.getDefaultInstance()) {
                this.versionRequirementTable_ = protoBuf$VersionRequirementTable;
            } else {
                this.versionRequirementTable_ = ProtoBuf$VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(protoBuf$VersionRequirementTable).buildPartial();
            }
            this.bitField0_ |= 16;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Package build() {
            ProtoBuf$Package buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$Package protoBuf$Package) {
            if (protoBuf$Package == ProtoBuf$Package.getDefaultInstance()) {
                return this;
            }
            if (!protoBuf$Package.function_.isEmpty()) {
                if (this.function_.isEmpty()) {
                    this.function_ = protoBuf$Package.function_;
                    this.bitField0_ &= -2;
                } else {
                    ensureFunctionIsMutable();
                    this.function_.addAll(protoBuf$Package.function_);
                }
            }
            if (!protoBuf$Package.property_.isEmpty()) {
                if (this.property_.isEmpty()) {
                    this.property_ = protoBuf$Package.property_;
                    this.bitField0_ &= -3;
                } else {
                    ensurePropertyIsMutable();
                    this.property_.addAll(protoBuf$Package.property_);
                }
            }
            if (!protoBuf$Package.typeAlias_.isEmpty()) {
                if (this.typeAlias_.isEmpty()) {
                    this.typeAlias_ = protoBuf$Package.typeAlias_;
                    this.bitField0_ &= -5;
                } else {
                    ensureTypeAliasIsMutable();
                    this.typeAlias_.addAll(protoBuf$Package.typeAlias_);
                }
            }
            if (protoBuf$Package.hasTypeTable()) {
                mergeTypeTable(protoBuf$Package.getTypeTable());
            }
            if (protoBuf$Package.hasVersionRequirementTable()) {
                mergeVersionRequirementTable(protoBuf$Package.getVersionRequirementTable());
            }
            mergeExtensionFields(protoBuf$Package);
            setUnknownFields(getUnknownFields().concat(protoBuf$Package.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$Package protoBuf$Package = null;
            try {
                try {
                    ProtoBuf$Package parsePartialFrom = ProtoBuf$Package.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$Package protoBuf$Package2 = (ProtoBuf$Package) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$Package = protoBuf$Package2;
                        if (protoBuf$Package != null) {
                            mergeFrom(protoBuf$Package);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$Package != null) {
                }
                throw th;
            }
        }
    }

    static {
        ProtoBuf$Package protoBuf$Package = new ProtoBuf$Package(true);
        defaultInstance = protoBuf$Package;
        protoBuf$Package.initFields();
    }

    public static ProtoBuf$Package getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.function_ = Collections.emptyList();
        this.property_ = Collections.emptyList();
        this.typeAlias_ = Collections.emptyList();
        this.typeTable_ = ProtoBuf$TypeTable.getDefaultInstance();
        this.versionRequirementTable_ = ProtoBuf$VersionRequirementTable.getDefaultInstance();
    }

    public static Builder newBuilder() {
        return Builder.access$11600();
    }

    public static ProtoBuf$Package parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public ProtoBuf$Function getFunction(int i5) {
        return this.function_.get(i5);
    }

    public int getFunctionCount() {
        return this.function_.size();
    }

    public List<ProtoBuf$Function> getFunctionList() {
        return this.function_;
    }

    public ProtoBuf$Property getProperty(int i5) {
        return this.property_.get(i5);
    }

    public int getPropertyCount() {
        return this.property_.size();
    }

    public List<ProtoBuf$Property> getPropertyList() {
        return this.property_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.function_.size(); i7++) {
            i6 += CodedOutputStream.computeMessageSize(3, this.function_.get(i7));
        }
        for (int i8 = 0; i8 < this.property_.size(); i8++) {
            i6 += CodedOutputStream.computeMessageSize(4, this.property_.get(i8));
        }
        for (int i9 = 0; i9 < this.typeAlias_.size(); i9++) {
            i6 += CodedOutputStream.computeMessageSize(5, this.typeAlias_.get(i9));
        }
        if ((this.bitField0_ & 1) == 1) {
            i6 += CodedOutputStream.computeMessageSize(30, this.typeTable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            i6 += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        }
        int extensionsSerializedSize = i6 + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = extensionsSerializedSize;
        return extensionsSerializedSize;
    }

    public ProtoBuf$TypeAlias getTypeAlias(int i5) {
        return this.typeAlias_.get(i5);
    }

    public int getTypeAliasCount() {
        return this.typeAlias_.size();
    }

    public List<ProtoBuf$TypeAlias> getTypeAliasList() {
        return this.typeAlias_;
    }

    public ProtoBuf$TypeTable getTypeTable() {
        return this.typeTable_;
    }

    public ProtoBuf$VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable_;
    }

    public boolean hasTypeTable() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasVersionRequirementTable() {
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
        for (int i5 = 0; i5 < getFunctionCount(); i5++) {
            if (!getFunction(i5).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i6 = 0; i6 < getPropertyCount(); i6++) {
            if (!getProperty(i6).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i7 = 0; i7 < getTypeAliasCount(); i7++) {
            if (!getTypeAlias(i7).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasTypeTable() && !getTypeTable().isInitialized()) {
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
        for (int i5 = 0; i5 < this.function_.size(); i5++) {
            codedOutputStream.writeMessage(3, this.function_.get(i5));
        }
        for (int i6 = 0; i6 < this.property_.size(); i6++) {
            codedOutputStream.writeMessage(4, this.property_.get(i6));
        }
        for (int i7 = 0; i7 < this.typeAlias_.size(); i7++) {
            codedOutputStream.writeMessage(5, this.typeAlias_.get(i7));
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeMessage(30, this.typeTable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(32, this.versionRequirementTable_);
        }
        newExtensionWriter.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Package protoBuf$Package) {
        return newBuilder().mergeFrom(protoBuf$Package);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Package getDefaultInstanceForType() {
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

    private ProtoBuf$Package(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Package, ?> extendableBuilder) {
        super(extendableBuilder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$Package(boolean z5) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    private ProtoBuf$Package(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                        if (readTag == 26) {
                            int i5 = (c5 == true ? 1 : 0) & 1;
                            c5 = c5;
                            if (i5 != 1) {
                                this.function_ = new ArrayList();
                                c5 = (c5 == true ? 1 : 0) | 1;
                            }
                            this.function_.add(codedInputStream.readMessage(ProtoBuf$Function.PARSER, extensionRegistryLite));
                        } else if (readTag == 34) {
                            int i6 = (c5 == true ? 1 : 0) & 2;
                            c5 = c5;
                            if (i6 != 2) {
                                this.property_ = new ArrayList();
                                c5 = (c5 == true ? 1 : 0) | 2;
                            }
                            this.property_.add(codedInputStream.readMessage(ProtoBuf$Property.PARSER, extensionRegistryLite));
                        } else if (readTag != 42) {
                            if (readTag == 242) {
                                ProtoBuf$TypeTable.Builder builder = (this.bitField0_ & 1) == 1 ? this.typeTable_.toBuilder() : null;
                                ProtoBuf$TypeTable protoBuf$TypeTable = (ProtoBuf$TypeTable) codedInputStream.readMessage(ProtoBuf$TypeTable.PARSER, extensionRegistryLite);
                                this.typeTable_ = protoBuf$TypeTable;
                                if (builder != null) {
                                    builder.mergeFrom(protoBuf$TypeTable);
                                    this.typeTable_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1;
                            } else if (readTag != 258) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                ProtoBuf$VersionRequirementTable.Builder builder2 = (this.bitField0_ & 2) == 2 ? this.versionRequirementTable_.toBuilder() : null;
                                ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = (ProtoBuf$VersionRequirementTable) codedInputStream.readMessage(ProtoBuf$VersionRequirementTable.PARSER, extensionRegistryLite);
                                this.versionRequirementTable_ = protoBuf$VersionRequirementTable;
                                if (builder2 != null) {
                                    builder2.mergeFrom(protoBuf$VersionRequirementTable);
                                    this.versionRequirementTable_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            }
                        } else {
                            int i7 = (c5 == true ? 1 : 0) & 4;
                            c5 = c5;
                            if (i7 != 4) {
                                this.typeAlias_ = new ArrayList();
                                c5 = (c5 == true ? 1 : 0) | 4;
                            }
                            this.typeAlias_.add(codedInputStream.readMessage(ProtoBuf$TypeAlias.PARSER, extensionRegistryLite));
                        }
                    }
                    z5 = true;
                } catch (Throwable th) {
                    if (((c5 == true ? 1 : 0) & 1) == 1) {
                        this.function_ = Collections.unmodifiableList(this.function_);
                    }
                    if (((c5 == true ? 1 : 0) & 2) == 2) {
                        this.property_ = Collections.unmodifiableList(this.property_);
                    }
                    if (((c5 == true ? 1 : 0) & 4) == 4) {
                        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
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
        if (((c5 == true ? 1 : 0) & 1) == 1) {
            this.function_ = Collections.unmodifiableList(this.function_);
        }
        if (((c5 == true ? 1 : 0) & 2) == 2) {
            this.property_ = Collections.unmodifiableList(this.property_);
        }
        if (((c5 == true ? 1 : 0) & 4) == 4) {
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
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
