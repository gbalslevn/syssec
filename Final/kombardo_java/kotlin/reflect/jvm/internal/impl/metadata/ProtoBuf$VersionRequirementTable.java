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
public final class ProtoBuf$VersionRequirementTable extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$VersionRequirementTable> PARSER = new AbstractParser<ProtoBuf$VersionRequirementTable>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$VersionRequirementTable parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$VersionRequirementTable(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$VersionRequirementTable defaultInstance;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<ProtoBuf$VersionRequirement> requirement_;
    private final ByteString unknownFields;

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$VersionRequirementTable, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private List<ProtoBuf$VersionRequirement> requirement_ = Collections.emptyList();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$22100() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureRequirementIsMutable() {
            if ((this.bitField0_ & 1) != 1) {
                this.requirement_ = new ArrayList(this.requirement_);
                this.bitField0_ |= 1;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$VersionRequirementTable buildPartial() {
            ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = new ProtoBuf$VersionRequirementTable(this);
            if ((this.bitField0_ & 1) == 1) {
                this.requirement_ = Collections.unmodifiableList(this.requirement_);
                this.bitField0_ &= -2;
            }
            protoBuf$VersionRequirementTable.requirement_ = this.requirement_;
            return protoBuf$VersionRequirementTable;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$VersionRequirementTable build() {
            ProtoBuf$VersionRequirementTable buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
            if (protoBuf$VersionRequirementTable == ProtoBuf$VersionRequirementTable.getDefaultInstance()) {
                return this;
            }
            if (!protoBuf$VersionRequirementTable.requirement_.isEmpty()) {
                if (this.requirement_.isEmpty()) {
                    this.requirement_ = protoBuf$VersionRequirementTable.requirement_;
                    this.bitField0_ &= -2;
                } else {
                    ensureRequirementIsMutable();
                    this.requirement_.addAll(protoBuf$VersionRequirementTable.requirement_);
                }
            }
            setUnknownFields(getUnknownFields().concat(protoBuf$VersionRequirementTable.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = null;
            try {
                try {
                    ProtoBuf$VersionRequirementTable parsePartialFrom = ProtoBuf$VersionRequirementTable.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable2 = (ProtoBuf$VersionRequirementTable) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$VersionRequirementTable = protoBuf$VersionRequirementTable2;
                        if (protoBuf$VersionRequirementTable != null) {
                            mergeFrom(protoBuf$VersionRequirementTable);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$VersionRequirementTable != null) {
                }
                throw th;
            }
        }
    }

    static {
        ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable = new ProtoBuf$VersionRequirementTable(true);
        defaultInstance = protoBuf$VersionRequirementTable;
        protoBuf$VersionRequirementTable.initFields();
    }

    public static ProtoBuf$VersionRequirementTable getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.requirement_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.access$22100();
    }

    public int getRequirementCount() {
        return this.requirement_.size();
    }

    public List<ProtoBuf$VersionRequirement> getRequirementList() {
        return this.requirement_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.requirement_.size(); i7++) {
            i6 += CodedOutputStream.computeMessageSize(1, this.requirement_.get(i7));
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
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) {
        getSerializedSize();
        for (int i5 = 0; i5 < this.requirement_.size(); i5++) {
            codedOutputStream.writeMessage(1, this.requirement_.get(i5));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
        return newBuilder().mergeFrom(protoBuf$VersionRequirementTable);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    private ProtoBuf$VersionRequirementTable(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.getUnknownFields();
    }

    private ProtoBuf$VersionRequirementTable(boolean z5) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$VersionRequirementTable(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                    this.requirement_ = new ArrayList();
                                    z6 = true;
                                }
                                this.requirement_.add(codedInputStream.readMessage(ProtoBuf$VersionRequirement.PARSER, extensionRegistryLite));
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
                    this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
            this.requirement_ = Collections.unmodifiableList(this.requirement_);
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
