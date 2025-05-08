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
public final class ProtoBuf$TypeTable extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$TypeTable> PARSER = new AbstractParser<ProtoBuf$TypeTable>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$TypeTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$TypeTable(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$TypeTable defaultInstance;
    private int bitField0_;
    private int firstNullable_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<ProtoBuf$Type> type_;
    private final ByteString unknownFields;

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$TypeTable, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private List<ProtoBuf$Type> type_ = Collections.emptyList();
        private int firstNullable_ = -1;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$12600() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureTypeIsMutable() {
            if ((this.bitField0_ & 1) != 1) {
                this.type_ = new ArrayList(this.type_);
                this.bitField0_ |= 1;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$TypeTable buildPartial() {
            ProtoBuf$TypeTable protoBuf$TypeTable = new ProtoBuf$TypeTable(this);
            int i5 = this.bitField0_;
            if ((i5 & 1) == 1) {
                this.type_ = Collections.unmodifiableList(this.type_);
                this.bitField0_ &= -2;
            }
            protoBuf$TypeTable.type_ = this.type_;
            int i6 = (i5 & 2) != 2 ? 0 : 1;
            protoBuf$TypeTable.firstNullable_ = this.firstNullable_;
            protoBuf$TypeTable.bitField0_ = i6;
            return protoBuf$TypeTable;
        }

        public Builder setFirstNullable(int i5) {
            this.bitField0_ |= 2;
            this.firstNullable_ = i5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$TypeTable build() {
            ProtoBuf$TypeTable buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$TypeTable protoBuf$TypeTable) {
            if (protoBuf$TypeTable == ProtoBuf$TypeTable.getDefaultInstance()) {
                return this;
            }
            if (!protoBuf$TypeTable.type_.isEmpty()) {
                if (this.type_.isEmpty()) {
                    this.type_ = protoBuf$TypeTable.type_;
                    this.bitField0_ &= -2;
                } else {
                    ensureTypeIsMutable();
                    this.type_.addAll(protoBuf$TypeTable.type_);
                }
            }
            if (protoBuf$TypeTable.hasFirstNullable()) {
                setFirstNullable(protoBuf$TypeTable.getFirstNullable());
            }
            setUnknownFields(getUnknownFields().concat(protoBuf$TypeTable.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$TypeTable protoBuf$TypeTable = null;
            try {
                try {
                    ProtoBuf$TypeTable parsePartialFrom = ProtoBuf$TypeTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$TypeTable protoBuf$TypeTable2 = (ProtoBuf$TypeTable) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$TypeTable = protoBuf$TypeTable2;
                        if (protoBuf$TypeTable != null) {
                            mergeFrom(protoBuf$TypeTable);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$TypeTable != null) {
                }
                throw th;
            }
        }
    }

    static {
        ProtoBuf$TypeTable protoBuf$TypeTable = new ProtoBuf$TypeTable(true);
        defaultInstance = protoBuf$TypeTable;
        protoBuf$TypeTable.initFields();
    }

    public static ProtoBuf$TypeTable getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.type_ = Collections.emptyList();
        this.firstNullable_ = -1;
    }

    public static Builder newBuilder() {
        return Builder.access$12600();
    }

    public int getFirstNullable() {
        return this.firstNullable_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.type_.size(); i7++) {
            i6 += CodedOutputStream.computeMessageSize(1, this.type_.get(i7));
        }
        if ((this.bitField0_ & 1) == 1) {
            i6 += CodedOutputStream.computeInt32Size(2, this.firstNullable_);
        }
        int size = i6 + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public ProtoBuf$Type getType(int i5) {
        return this.type_.get(i5);
    }

    public int getTypeCount() {
        return this.type_.size();
    }

    public List<ProtoBuf$Type> getTypeList() {
        return this.type_;
    }

    public boolean hasFirstNullable() {
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
        for (int i5 = 0; i5 < getTypeCount(); i5++) {
            if (!getType(i5).isInitialized()) {
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
        for (int i5 = 0; i5 < this.type_.size(); i5++) {
            codedOutputStream.writeMessage(1, this.type_.get(i5));
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(2, this.firstNullable_);
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$TypeTable protoBuf$TypeTable) {
        return newBuilder().mergeFrom(protoBuf$TypeTable);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    private ProtoBuf$TypeTable(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.getUnknownFields();
    }

    private ProtoBuf$TypeTable(boolean z5) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$TypeTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            if (!z6) {
                                this.type_ = new ArrayList();
                                z6 = true;
                            }
                            this.type_.add(codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite));
                        } else if (readTag != 16) {
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            this.bitField0_ |= 1;
                            this.firstNullable_ = codedInputStream.readInt32();
                        }
                    }
                    z5 = true;
                } catch (Throwable th) {
                    if (z6) {
                        this.type_ = Collections.unmodifiableList(this.type_);
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
        if (z6) {
            this.type_ = Collections.unmodifiableList(this.type_);
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
