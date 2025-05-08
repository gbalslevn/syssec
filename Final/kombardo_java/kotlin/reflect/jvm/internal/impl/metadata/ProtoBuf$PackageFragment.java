package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable;
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
public final class ProtoBuf$PackageFragment extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$PackageFragment> implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$PackageFragment> PARSER = new AbstractParser<ProtoBuf$PackageFragment>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$PackageFragment parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$PackageFragment(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$PackageFragment defaultInstance;
    private int bitField0_;
    private List<ProtoBuf$Class> class__;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private ProtoBuf$Package package_;
    private ProtoBuf$QualifiedNameTable qualifiedNames_;
    private ProtoBuf$StringTable strings_;
    private final ByteString unknownFields;

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$PackageFragment, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private ProtoBuf$StringTable strings_ = ProtoBuf$StringTable.getDefaultInstance();
        private ProtoBuf$QualifiedNameTable qualifiedNames_ = ProtoBuf$QualifiedNameTable.getDefaultInstance();
        private ProtoBuf$Package package_ = ProtoBuf$Package.getDefaultInstance();
        private List<ProtoBuf$Class> class__ = Collections.emptyList();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$22600() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureClass_IsMutable() {
            if ((this.bitField0_ & 8) != 8) {
                this.class__ = new ArrayList(this.class__);
                this.bitField0_ |= 8;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$PackageFragment buildPartial() {
            ProtoBuf$PackageFragment protoBuf$PackageFragment = new ProtoBuf$PackageFragment(this);
            int i5 = this.bitField0_;
            int i6 = (i5 & 1) != 1 ? 0 : 1;
            protoBuf$PackageFragment.strings_ = this.strings_;
            if ((i5 & 2) == 2) {
                i6 |= 2;
            }
            protoBuf$PackageFragment.qualifiedNames_ = this.qualifiedNames_;
            if ((i5 & 4) == 4) {
                i6 |= 4;
            }
            protoBuf$PackageFragment.package_ = this.package_;
            if ((this.bitField0_ & 8) == 8) {
                this.class__ = Collections.unmodifiableList(this.class__);
                this.bitField0_ &= -9;
            }
            protoBuf$PackageFragment.class__ = this.class__;
            protoBuf$PackageFragment.bitField0_ = i6;
            return protoBuf$PackageFragment;
        }

        public Builder mergePackage(ProtoBuf$Package protoBuf$Package) {
            if ((this.bitField0_ & 4) != 4 || this.package_ == ProtoBuf$Package.getDefaultInstance()) {
                this.package_ = protoBuf$Package;
            } else {
                this.package_ = ProtoBuf$Package.newBuilder(this.package_).mergeFrom(protoBuf$Package).buildPartial();
            }
            this.bitField0_ |= 4;
            return this;
        }

        public Builder mergeQualifiedNames(ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable) {
            if ((this.bitField0_ & 2) != 2 || this.qualifiedNames_ == ProtoBuf$QualifiedNameTable.getDefaultInstance()) {
                this.qualifiedNames_ = protoBuf$QualifiedNameTable;
            } else {
                this.qualifiedNames_ = ProtoBuf$QualifiedNameTable.newBuilder(this.qualifiedNames_).mergeFrom(protoBuf$QualifiedNameTable).buildPartial();
            }
            this.bitField0_ |= 2;
            return this;
        }

        public Builder mergeStrings(ProtoBuf$StringTable protoBuf$StringTable) {
            if ((this.bitField0_ & 1) != 1 || this.strings_ == ProtoBuf$StringTable.getDefaultInstance()) {
                this.strings_ = protoBuf$StringTable;
            } else {
                this.strings_ = ProtoBuf$StringTable.newBuilder(this.strings_).mergeFrom(protoBuf$StringTable).buildPartial();
            }
            this.bitField0_ |= 1;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$PackageFragment build() {
            ProtoBuf$PackageFragment buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$PackageFragment protoBuf$PackageFragment) {
            if (protoBuf$PackageFragment == ProtoBuf$PackageFragment.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$PackageFragment.hasStrings()) {
                mergeStrings(protoBuf$PackageFragment.getStrings());
            }
            if (protoBuf$PackageFragment.hasQualifiedNames()) {
                mergeQualifiedNames(protoBuf$PackageFragment.getQualifiedNames());
            }
            if (protoBuf$PackageFragment.hasPackage()) {
                mergePackage(protoBuf$PackageFragment.getPackage());
            }
            if (!protoBuf$PackageFragment.class__.isEmpty()) {
                if (this.class__.isEmpty()) {
                    this.class__ = protoBuf$PackageFragment.class__;
                    this.bitField0_ &= -9;
                } else {
                    ensureClass_IsMutable();
                    this.class__.addAll(protoBuf$PackageFragment.class__);
                }
            }
            mergeExtensionFields(protoBuf$PackageFragment);
            setUnknownFields(getUnknownFields().concat(protoBuf$PackageFragment.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$PackageFragment protoBuf$PackageFragment = null;
            try {
                try {
                    ProtoBuf$PackageFragment parsePartialFrom = ProtoBuf$PackageFragment.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$PackageFragment protoBuf$PackageFragment2 = (ProtoBuf$PackageFragment) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$PackageFragment = protoBuf$PackageFragment2;
                        if (protoBuf$PackageFragment != null) {
                            mergeFrom(protoBuf$PackageFragment);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$PackageFragment != null) {
                }
                throw th;
            }
        }
    }

    static {
        ProtoBuf$PackageFragment protoBuf$PackageFragment = new ProtoBuf$PackageFragment(true);
        defaultInstance = protoBuf$PackageFragment;
        protoBuf$PackageFragment.initFields();
    }

    public static ProtoBuf$PackageFragment getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.strings_ = ProtoBuf$StringTable.getDefaultInstance();
        this.qualifiedNames_ = ProtoBuf$QualifiedNameTable.getDefaultInstance();
        this.package_ = ProtoBuf$Package.getDefaultInstance();
        this.class__ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.access$22600();
    }

    public static ProtoBuf$PackageFragment parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public ProtoBuf$Class getClass_(int i5) {
        return this.class__.get(i5);
    }

    public int getClass_Count() {
        return this.class__.size();
    }

    public List<ProtoBuf$Class> getClass_List() {
        return this.class__;
    }

    public ProtoBuf$Package getPackage() {
        return this.package_;
    }

    public ProtoBuf$QualifiedNameTable getQualifiedNames() {
        return this.qualifiedNames_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int computeMessageSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeMessageSize(1, this.strings_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeMessageSize += CodedOutputStream.computeMessageSize(2, this.qualifiedNames_);
        }
        if ((this.bitField0_ & 4) == 4) {
            computeMessageSize += CodedOutputStream.computeMessageSize(3, this.package_);
        }
        for (int i6 = 0; i6 < this.class__.size(); i6++) {
            computeMessageSize += CodedOutputStream.computeMessageSize(4, this.class__.get(i6));
        }
        int extensionsSerializedSize = computeMessageSize + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = extensionsSerializedSize;
        return extensionsSerializedSize;
    }

    public ProtoBuf$StringTable getStrings() {
        return this.strings_;
    }

    public boolean hasPackage() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasQualifiedNames() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasStrings() {
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
        if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasPackage() && !getPackage().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i5 = 0; i5 < getClass_Count(); i5++) {
            if (!getClass_(i5).isInitialized()) {
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
            codedOutputStream.writeMessage(1, this.strings_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(2, this.qualifiedNames_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(3, this.package_);
        }
        for (int i5 = 0; i5 < this.class__.size(); i5++) {
            codedOutputStream.writeMessage(4, this.class__.get(i5));
        }
        newExtensionWriter.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$PackageFragment protoBuf$PackageFragment) {
        return newBuilder().mergeFrom(protoBuf$PackageFragment);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$PackageFragment getDefaultInstanceForType() {
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

    private ProtoBuf$PackageFragment(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$PackageFragment, ?> extendableBuilder) {
        super(extendableBuilder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$PackageFragment(boolean z5) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$PackageFragment(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                        if (readTag == 10) {
                            ProtoBuf$StringTable.Builder builder = (this.bitField0_ & 1) == 1 ? this.strings_.toBuilder() : null;
                            ProtoBuf$StringTable protoBuf$StringTable = (ProtoBuf$StringTable) codedInputStream.readMessage(ProtoBuf$StringTable.PARSER, extensionRegistryLite);
                            this.strings_ = protoBuf$StringTable;
                            if (builder != null) {
                                builder.mergeFrom(protoBuf$StringTable);
                                this.strings_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 1;
                        } else if (readTag == 18) {
                            ProtoBuf$QualifiedNameTable.Builder builder2 = (this.bitField0_ & 2) == 2 ? this.qualifiedNames_.toBuilder() : null;
                            ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable = (ProtoBuf$QualifiedNameTable) codedInputStream.readMessage(ProtoBuf$QualifiedNameTable.PARSER, extensionRegistryLite);
                            this.qualifiedNames_ = protoBuf$QualifiedNameTable;
                            if (builder2 != null) {
                                builder2.mergeFrom(protoBuf$QualifiedNameTable);
                                this.qualifiedNames_ = builder2.buildPartial();
                            }
                            this.bitField0_ |= 2;
                        } else if (readTag == 26) {
                            ProtoBuf$Package.Builder builder3 = (this.bitField0_ & 4) == 4 ? this.package_.toBuilder() : null;
                            ProtoBuf$Package protoBuf$Package = (ProtoBuf$Package) codedInputStream.readMessage(ProtoBuf$Package.PARSER, extensionRegistryLite);
                            this.package_ = protoBuf$Package;
                            if (builder3 != null) {
                                builder3.mergeFrom(protoBuf$Package);
                                this.package_ = builder3.buildPartial();
                            }
                            this.bitField0_ |= 4;
                        } else if (readTag != 34) {
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            int i5 = (c5 == true ? 1 : 0) & '\b';
                            c5 = c5;
                            if (i5 != 8) {
                                this.class__ = new ArrayList();
                                c5 = '\b';
                            }
                            this.class__.add(codedInputStream.readMessage(ProtoBuf$Class.PARSER, extensionRegistryLite));
                        }
                    }
                    z5 = true;
                } catch (Throwable th) {
                    if (((c5 == true ? 1 : 0) & '\b') == 8) {
                        this.class__ = Collections.unmodifiableList(this.class__);
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
        if (((c5 == true ? 1 : 0) & '\b') == 8) {
            this.class__ = Collections.unmodifiableList(this.class__);
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
