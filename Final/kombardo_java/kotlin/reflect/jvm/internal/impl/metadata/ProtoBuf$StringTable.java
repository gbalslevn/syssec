package kotlin.reflect.jvm.internal.impl.metadata;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractParser;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.ProtocolStringList;

/* loaded from: classes3.dex */
public final class ProtoBuf$StringTable extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$StringTable> PARSER = new AbstractParser<ProtoBuf$StringTable>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$StringTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$StringTable(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$StringTable defaultInstance;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private LazyStringList string_;
    private final ByteString unknownFields;

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$StringTable, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private LazyStringList string_ = LazyStringArrayList.EMPTY;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$100() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureStringIsMutable() {
            if ((this.bitField0_ & 1) != 1) {
                this.string_ = new LazyStringArrayList(this.string_);
                this.bitField0_ |= 1;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$StringTable buildPartial() {
            ProtoBuf$StringTable protoBuf$StringTable = new ProtoBuf$StringTable(this);
            if ((this.bitField0_ & 1) == 1) {
                this.string_ = this.string_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            protoBuf$StringTable.string_ = this.string_;
            return protoBuf$StringTable;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$StringTable build() {
            ProtoBuf$StringTable buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$StringTable protoBuf$StringTable) {
            if (protoBuf$StringTable == ProtoBuf$StringTable.getDefaultInstance()) {
                return this;
            }
            if (!protoBuf$StringTable.string_.isEmpty()) {
                if (this.string_.isEmpty()) {
                    this.string_ = protoBuf$StringTable.string_;
                    this.bitField0_ &= -2;
                } else {
                    ensureStringIsMutable();
                    this.string_.addAll(protoBuf$StringTable.string_);
                }
            }
            setUnknownFields(getUnknownFields().concat(protoBuf$StringTable.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$StringTable protoBuf$StringTable = null;
            try {
                try {
                    ProtoBuf$StringTable parsePartialFrom = ProtoBuf$StringTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$StringTable protoBuf$StringTable2 = (ProtoBuf$StringTable) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$StringTable = protoBuf$StringTable2;
                        if (protoBuf$StringTable != null) {
                            mergeFrom(protoBuf$StringTable);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$StringTable != null) {
                }
                throw th;
            }
        }
    }

    static {
        ProtoBuf$StringTable protoBuf$StringTable = new ProtoBuf$StringTable(true);
        defaultInstance = protoBuf$StringTable;
        protoBuf$StringTable.initFields();
    }

    public static ProtoBuf$StringTable getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.string_ = LazyStringArrayList.EMPTY;
    }

    public static Builder newBuilder() {
        return Builder.access$100();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.string_.size(); i7++) {
            i6 += CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(i7));
        }
        int size = i6 + getStringList().size() + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public String getString(int i5) {
        return this.string_.get(i5);
    }

    public ProtocolStringList getStringList() {
        return this.string_;
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
        for (int i5 = 0; i5 < this.string_.size(); i5++) {
            codedOutputStream.writeBytes(1, this.string_.getByteString(i5));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$StringTable protoBuf$StringTable) {
        return newBuilder().mergeFrom(protoBuf$StringTable);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    private ProtoBuf$StringTable(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.getUnknownFields();
    }

    private ProtoBuf$StringTable(boolean z5) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    private ProtoBuf$StringTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                ByteString readBytes = codedInputStream.readBytes();
                                if (!z6) {
                                    this.string_ = new LazyStringArrayList();
                                    z6 = true;
                                }
                                this.string_.add(readBytes);
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
                    this.string_ = this.string_.getUnmodifiableView();
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
            this.string_ = this.string_.getUnmodifiableView();
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
