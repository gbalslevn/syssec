package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
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
public final class ProtoBuf$VersionRequirement extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$VersionRequirement> PARSER = new AbstractParser<ProtoBuf$VersionRequirement>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$VersionRequirement parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$VersionRequirement(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$VersionRequirement defaultInstance;
    private int bitField0_;
    private int errorCode_;
    private Level level_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int message_;
    private final ByteString unknownFields;
    private int versionFull_;
    private VersionKind versionKind_;
    private int version_;

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$VersionRequirement, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private int errorCode_;
        private int message_;
        private int versionFull_;
        private int version_;
        private Level level_ = Level.ERROR;
        private VersionKind versionKind_ = VersionKind.LANGUAGE_VERSION;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$21000() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$VersionRequirement buildPartial() {
            ProtoBuf$VersionRequirement protoBuf$VersionRequirement = new ProtoBuf$VersionRequirement(this);
            int i5 = this.bitField0_;
            int i6 = (i5 & 1) != 1 ? 0 : 1;
            protoBuf$VersionRequirement.version_ = this.version_;
            if ((i5 & 2) == 2) {
                i6 |= 2;
            }
            protoBuf$VersionRequirement.versionFull_ = this.versionFull_;
            if ((i5 & 4) == 4) {
                i6 |= 4;
            }
            protoBuf$VersionRequirement.level_ = this.level_;
            if ((i5 & 8) == 8) {
                i6 |= 8;
            }
            protoBuf$VersionRequirement.errorCode_ = this.errorCode_;
            if ((i5 & 16) == 16) {
                i6 |= 16;
            }
            protoBuf$VersionRequirement.message_ = this.message_;
            if ((i5 & 32) == 32) {
                i6 |= 32;
            }
            protoBuf$VersionRequirement.versionKind_ = this.versionKind_;
            protoBuf$VersionRequirement.bitField0_ = i6;
            return protoBuf$VersionRequirement;
        }

        public Builder setErrorCode(int i5) {
            this.bitField0_ |= 8;
            this.errorCode_ = i5;
            return this;
        }

        public Builder setLevel(Level level) {
            level.getClass();
            this.bitField0_ |= 4;
            this.level_ = level;
            return this;
        }

        public Builder setMessage(int i5) {
            this.bitField0_ |= 16;
            this.message_ = i5;
            return this;
        }

        public Builder setVersion(int i5) {
            this.bitField0_ |= 1;
            this.version_ = i5;
            return this;
        }

        public Builder setVersionFull(int i5) {
            this.bitField0_ |= 2;
            this.versionFull_ = i5;
            return this;
        }

        public Builder setVersionKind(VersionKind versionKind) {
            versionKind.getClass();
            this.bitField0_ |= 32;
            this.versionKind_ = versionKind;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$VersionRequirement build() {
            ProtoBuf$VersionRequirement buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$VersionRequirement protoBuf$VersionRequirement) {
            if (protoBuf$VersionRequirement == ProtoBuf$VersionRequirement.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$VersionRequirement.hasVersion()) {
                setVersion(protoBuf$VersionRequirement.getVersion());
            }
            if (protoBuf$VersionRequirement.hasVersionFull()) {
                setVersionFull(protoBuf$VersionRequirement.getVersionFull());
            }
            if (protoBuf$VersionRequirement.hasLevel()) {
                setLevel(protoBuf$VersionRequirement.getLevel());
            }
            if (protoBuf$VersionRequirement.hasErrorCode()) {
                setErrorCode(protoBuf$VersionRequirement.getErrorCode());
            }
            if (protoBuf$VersionRequirement.hasMessage()) {
                setMessage(protoBuf$VersionRequirement.getMessage());
            }
            if (protoBuf$VersionRequirement.hasVersionKind()) {
                setVersionKind(protoBuf$VersionRequirement.getVersionKind());
            }
            setUnknownFields(getUnknownFields().concat(protoBuf$VersionRequirement.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$VersionRequirement protoBuf$VersionRequirement = null;
            try {
                try {
                    ProtoBuf$VersionRequirement parsePartialFrom = ProtoBuf$VersionRequirement.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$VersionRequirement protoBuf$VersionRequirement2 = (ProtoBuf$VersionRequirement) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$VersionRequirement = protoBuf$VersionRequirement2;
                        if (protoBuf$VersionRequirement != null) {
                            mergeFrom(protoBuf$VersionRequirement);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$VersionRequirement != null) {
                }
                throw th;
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum Level implements Internal.EnumLite {
        WARNING(0, 0),
        ERROR(1, 1),
        HIDDEN(2, 2);

        private static Internal.EnumLiteMap<Level> internalValueMap = new Internal.EnumLiteMap<Level>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.Level.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
            public Level findValueByNumber(int i5) {
                return Level.valueOf(i5);
            }
        };
        private final int value;

        Level(int i5, int i6) {
            this.value = i6;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Level valueOf(int i5) {
            if (i5 == 0) {
                return WARNING;
            }
            if (i5 == 1) {
                return ERROR;
            }
            if (i5 != 2) {
                return null;
            }
            return HIDDEN;
        }
    }

    /* loaded from: classes3.dex */
    public enum VersionKind implements Internal.EnumLite {
        LANGUAGE_VERSION(0, 0),
        COMPILER_VERSION(1, 1),
        API_VERSION(2, 2);

        private static Internal.EnumLiteMap<VersionKind> internalValueMap = new Internal.EnumLiteMap<VersionKind>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.VersionKind.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
            public VersionKind findValueByNumber(int i5) {
                return VersionKind.valueOf(i5);
            }
        };
        private final int value;

        VersionKind(int i5, int i6) {
            this.value = i6;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static VersionKind valueOf(int i5) {
            if (i5 == 0) {
                return LANGUAGE_VERSION;
            }
            if (i5 == 1) {
                return COMPILER_VERSION;
            }
            if (i5 != 2) {
                return null;
            }
            return API_VERSION;
        }
    }

    static {
        ProtoBuf$VersionRequirement protoBuf$VersionRequirement = new ProtoBuf$VersionRequirement(true);
        defaultInstance = protoBuf$VersionRequirement;
        protoBuf$VersionRequirement.initFields();
    }

    public static ProtoBuf$VersionRequirement getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.version_ = 0;
        this.versionFull_ = 0;
        this.level_ = Level.ERROR;
        this.errorCode_ = 0;
        this.message_ = 0;
        this.versionKind_ = VersionKind.LANGUAGE_VERSION;
    }

    public static Builder newBuilder() {
        return Builder.access$21000();
    }

    public int getErrorCode() {
        return this.errorCode_;
    }

    public Level getLevel() {
        return this.level_;
    }

    public int getMessage() {
        return this.message_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.version_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeInt32Size += CodedOutputStream.computeInt32Size(2, this.versionFull_);
        }
        if ((this.bitField0_ & 4) == 4) {
            computeInt32Size += CodedOutputStream.computeEnumSize(3, this.level_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            computeInt32Size += CodedOutputStream.computeInt32Size(4, this.errorCode_);
        }
        if ((this.bitField0_ & 16) == 16) {
            computeInt32Size += CodedOutputStream.computeInt32Size(5, this.message_);
        }
        if ((this.bitField0_ & 32) == 32) {
            computeInt32Size += CodedOutputStream.computeEnumSize(6, this.versionKind_.getNumber());
        }
        int size = computeInt32Size + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public int getVersion() {
        return this.version_;
    }

    public int getVersionFull() {
        return this.versionFull_;
    }

    public VersionKind getVersionKind() {
        return this.versionKind_;
    }

    public boolean hasErrorCode() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasLevel() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasMessage() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasVersion() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasVersionFull() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasVersionKind() {
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
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.version_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.versionFull_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(3, this.level_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(4, this.errorCode_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(5, this.message_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeEnum(6, this.versionKind_.getNumber());
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$VersionRequirement protoBuf$VersionRequirement) {
        return newBuilder().mergeFrom(protoBuf$VersionRequirement);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    private ProtoBuf$VersionRequirement(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.getUnknownFields();
    }

    private ProtoBuf$VersionRequirement(boolean z5) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$VersionRequirement(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                            this.version_ = codedInputStream.readInt32();
                        } else if (readTag == 16) {
                            this.bitField0_ |= 2;
                            this.versionFull_ = codedInputStream.readInt32();
                        } else if (readTag == 24) {
                            int readEnum = codedInputStream.readEnum();
                            Level valueOf = Level.valueOf(readEnum);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum);
                            } else {
                                this.bitField0_ |= 4;
                                this.level_ = valueOf;
                            }
                        } else if (readTag == 32) {
                            this.bitField0_ |= 8;
                            this.errorCode_ = codedInputStream.readInt32();
                        } else if (readTag == 40) {
                            this.bitField0_ |= 16;
                            this.message_ = codedInputStream.readInt32();
                        } else if (readTag != 48) {
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            int readEnum2 = codedInputStream.readEnum();
                            VersionKind valueOf2 = VersionKind.valueOf(readEnum2);
                            if (valueOf2 == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum2);
                            } else {
                                this.bitField0_ |= 32;
                                this.versionKind_ = valueOf2;
                            }
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
