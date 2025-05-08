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
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;

/* loaded from: classes3.dex */
public final class ProtoBuf$QualifiedNameTable extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$QualifiedNameTable> PARSER = new AbstractParser<ProtoBuf$QualifiedNameTable>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$QualifiedNameTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$QualifiedNameTable(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$QualifiedNameTable defaultInstance;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<QualifiedName> qualifiedName_;
    private final ByteString unknownFields;

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$QualifiedNameTable, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private List<QualifiedName> qualifiedName_ = Collections.emptyList();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$1400() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureQualifiedNameIsMutable() {
            if ((this.bitField0_ & 1) != 1) {
                this.qualifiedName_ = new ArrayList(this.qualifiedName_);
                this.bitField0_ |= 1;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$QualifiedNameTable buildPartial() {
            ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable = new ProtoBuf$QualifiedNameTable(this);
            if ((this.bitField0_ & 1) == 1) {
                this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
                this.bitField0_ &= -2;
            }
            protoBuf$QualifiedNameTable.qualifiedName_ = this.qualifiedName_;
            return protoBuf$QualifiedNameTable;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$QualifiedNameTable build() {
            ProtoBuf$QualifiedNameTable buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable) {
            if (protoBuf$QualifiedNameTable == ProtoBuf$QualifiedNameTable.getDefaultInstance()) {
                return this;
            }
            if (!protoBuf$QualifiedNameTable.qualifiedName_.isEmpty()) {
                if (this.qualifiedName_.isEmpty()) {
                    this.qualifiedName_ = protoBuf$QualifiedNameTable.qualifiedName_;
                    this.bitField0_ &= -2;
                } else {
                    ensureQualifiedNameIsMutable();
                    this.qualifiedName_.addAll(protoBuf$QualifiedNameTable.qualifiedName_);
                }
            }
            setUnknownFields(getUnknownFields().concat(protoBuf$QualifiedNameTable.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable = null;
            try {
                try {
                    ProtoBuf$QualifiedNameTable parsePartialFrom = ProtoBuf$QualifiedNameTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable2 = (ProtoBuf$QualifiedNameTable) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$QualifiedNameTable = protoBuf$QualifiedNameTable2;
                        if (protoBuf$QualifiedNameTable != null) {
                            mergeFrom(protoBuf$QualifiedNameTable);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$QualifiedNameTable != null) {
                }
                throw th;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class QualifiedName extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static Parser<QualifiedName> PARSER = new AbstractParser<QualifiedName>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public QualifiedName parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new QualifiedName(codedInputStream, extensionRegistryLite);
            }
        };
        private static final QualifiedName defaultInstance;
        private int bitField0_;
        private Kind kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int parentQualifiedName_;
        private int shortName_;
        private final ByteString unknownFields;

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<QualifiedName, Builder> implements MessageLiteOrBuilder {
            private int bitField0_;
            private int shortName_;
            private int parentQualifiedName_ = -1;
            private Kind kind_ = Kind.PACKAGE;

            private Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$700() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public QualifiedName buildPartial() {
                QualifiedName qualifiedName = new QualifiedName(this);
                int i5 = this.bitField0_;
                int i6 = (i5 & 1) != 1 ? 0 : 1;
                qualifiedName.parentQualifiedName_ = this.parentQualifiedName_;
                if ((i5 & 2) == 2) {
                    i6 |= 2;
                }
                qualifiedName.shortName_ = this.shortName_;
                if ((i5 & 4) == 4) {
                    i6 |= 4;
                }
                qualifiedName.kind_ = this.kind_;
                qualifiedName.bitField0_ = i6;
                return qualifiedName;
            }

            public Builder setKind(Kind kind) {
                kind.getClass();
                this.bitField0_ |= 4;
                this.kind_ = kind;
                return this;
            }

            public Builder setParentQualifiedName(int i5) {
                this.bitField0_ |= 1;
                this.parentQualifiedName_ = i5;
                return this;
            }

            public Builder setShortName(int i5) {
                this.bitField0_ |= 2;
                this.shortName_ = i5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public QualifiedName build() {
                QualifiedName buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(QualifiedName qualifiedName) {
                if (qualifiedName == QualifiedName.getDefaultInstance()) {
                    return this;
                }
                if (qualifiedName.hasParentQualifiedName()) {
                    setParentQualifiedName(qualifiedName.getParentQualifiedName());
                }
                if (qualifiedName.hasShortName()) {
                    setShortName(qualifiedName.getShortName());
                }
                if (qualifiedName.hasKind()) {
                    setKind(qualifiedName.getKind());
                }
                setUnknownFields(getUnknownFields().concat(qualifiedName.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                QualifiedName qualifiedName = null;
                try {
                    try {
                        QualifiedName parsePartialFrom = QualifiedName.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e5) {
                        QualifiedName qualifiedName2 = (QualifiedName) e5.getUnfinishedMessage();
                        try {
                            throw e5;
                        } catch (Throwable th) {
                            th = th;
                            qualifiedName = qualifiedName2;
                            if (qualifiedName != null) {
                                mergeFrom(qualifiedName);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (qualifiedName != null) {
                    }
                    throw th;
                }
            }
        }

        /* loaded from: classes3.dex */
        public enum Kind implements Internal.EnumLite {
            CLASS(0, 0),
            PACKAGE(1, 1),
            LOCAL(2, 2);

            private static Internal.EnumLiteMap<Kind> internalValueMap = new Internal.EnumLiteMap<Kind>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.Kind.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
                public Kind findValueByNumber(int i5) {
                    return Kind.valueOf(i5);
                }
            };
            private final int value;

            Kind(int i5, int i6) {
                this.value = i6;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Kind valueOf(int i5) {
                if (i5 == 0) {
                    return CLASS;
                }
                if (i5 == 1) {
                    return PACKAGE;
                }
                if (i5 != 2) {
                    return null;
                }
                return LOCAL;
            }
        }

        static {
            QualifiedName qualifiedName = new QualifiedName(true);
            defaultInstance = qualifiedName;
            qualifiedName.initFields();
        }

        public static QualifiedName getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.parentQualifiedName_ = -1;
            this.shortName_ = 0;
            this.kind_ = Kind.PACKAGE;
        }

        public static Builder newBuilder() {
            return Builder.access$700();
        }

        public Kind getKind() {
            return this.kind_;
        }

        public int getParentQualifiedName() {
            return this.parentQualifiedName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i5 = this.memoizedSerializedSize;
            if (i5 != -1) {
                return i5;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.parentQualifiedName_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeInt32Size(2, this.shortName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeInt32Size += CodedOutputStream.computeEnumSize(3, this.kind_.getNumber());
            }
            int size = computeInt32Size + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getShortName() {
            return this.shortName_;
        }

        public boolean hasKind() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasParentQualifiedName() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasShortName() {
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
            if (hasShortName()) {
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
                codedOutputStream.writeInt32(1, this.parentQualifiedName_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.shortName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(3, this.kind_.getNumber());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(QualifiedName qualifiedName) {
            return newBuilder().mergeFrom(qualifiedName);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private QualifiedName(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private QualifiedName(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private QualifiedName(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output newOutput = ByteString.newOutput();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
            boolean z5 = false;
            while (!z5) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.bitField0_ |= 1;
                                    this.parentQualifiedName_ = codedInputStream.readInt32();
                                } else if (readTag == 16) {
                                    this.bitField0_ |= 2;
                                    this.shortName_ = codedInputStream.readInt32();
                                } else if (readTag != 24) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    int readEnum = codedInputStream.readEnum();
                                    Kind valueOf = Kind.valueOf(readEnum);
                                    if (valueOf == null) {
                                        newInstance.writeRawVarint32(readTag);
                                        newInstance.writeRawVarint32(readEnum);
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.kind_ = valueOf;
                                    }
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

    static {
        ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable = new ProtoBuf$QualifiedNameTable(true);
        defaultInstance = protoBuf$QualifiedNameTable;
        protoBuf$QualifiedNameTable.initFields();
    }

    public static ProtoBuf$QualifiedNameTable getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.qualifiedName_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.access$1400();
    }

    public QualifiedName getQualifiedName(int i5) {
        return this.qualifiedName_.get(i5);
    }

    public int getQualifiedNameCount() {
        return this.qualifiedName_.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.qualifiedName_.size(); i7++) {
            i6 += CodedOutputStream.computeMessageSize(1, this.qualifiedName_.get(i7));
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
        for (int i5 = 0; i5 < getQualifiedNameCount(); i5++) {
            if (!getQualifiedName(i5).isInitialized()) {
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
        for (int i5 = 0; i5 < this.qualifiedName_.size(); i5++) {
            codedOutputStream.writeMessage(1, this.qualifiedName_.get(i5));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$QualifiedNameTable protoBuf$QualifiedNameTable) {
        return newBuilder().mergeFrom(protoBuf$QualifiedNameTable);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    private ProtoBuf$QualifiedNameTable(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.getUnknownFields();
    }

    private ProtoBuf$QualifiedNameTable(boolean z5) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$QualifiedNameTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                    this.qualifiedName_ = new ArrayList();
                                    z6 = true;
                                }
                                this.qualifiedName_.add(codedInputStream.readMessage(QualifiedName.PARSER, extensionRegistryLite));
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
                    this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
            this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
