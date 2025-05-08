package kotlin.reflect.jvm.internal.impl.metadata;

import com.adjust.sdk.Constants;
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
public final class ProtoBuf$TypeParameter extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$TypeParameter> implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$TypeParameter> PARSER = new AbstractParser<ProtoBuf$TypeParameter>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$TypeParameter parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$TypeParameter(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$TypeParameter defaultInstance;
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private int name_;
    private boolean reified_;
    private final ByteString unknownFields;
    private int upperBoundIdMemoizedSerializedSize;
    private List<Integer> upperBoundId_;
    private List<ProtoBuf$Type> upperBound_;
    private Variance variance_;

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$TypeParameter, Builder> implements MessageLiteOrBuilder {
        private int bitField0_;
        private int id_;
        private int name_;
        private boolean reified_;
        private Variance variance_ = Variance.INV;
        private List<ProtoBuf$Type> upperBound_ = Collections.emptyList();
        private List<Integer> upperBoundId_ = Collections.emptyList();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$7600() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureUpperBoundIdIsMutable() {
            if ((this.bitField0_ & 32) != 32) {
                this.upperBoundId_ = new ArrayList(this.upperBoundId_);
                this.bitField0_ |= 32;
            }
        }

        private void ensureUpperBoundIsMutable() {
            if ((this.bitField0_ & 16) != 16) {
                this.upperBound_ = new ArrayList(this.upperBound_);
                this.bitField0_ |= 16;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$TypeParameter buildPartial() {
            ProtoBuf$TypeParameter protoBuf$TypeParameter = new ProtoBuf$TypeParameter(this);
            int i5 = this.bitField0_;
            int i6 = (i5 & 1) != 1 ? 0 : 1;
            protoBuf$TypeParameter.id_ = this.id_;
            if ((i5 & 2) == 2) {
                i6 |= 2;
            }
            protoBuf$TypeParameter.name_ = this.name_;
            if ((i5 & 4) == 4) {
                i6 |= 4;
            }
            protoBuf$TypeParameter.reified_ = this.reified_;
            if ((i5 & 8) == 8) {
                i6 |= 8;
            }
            protoBuf$TypeParameter.variance_ = this.variance_;
            if ((this.bitField0_ & 16) == 16) {
                this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                this.bitField0_ &= -17;
            }
            protoBuf$TypeParameter.upperBound_ = this.upperBound_;
            if ((this.bitField0_ & 32) == 32) {
                this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                this.bitField0_ &= -33;
            }
            protoBuf$TypeParameter.upperBoundId_ = this.upperBoundId_;
            protoBuf$TypeParameter.bitField0_ = i6;
            return protoBuf$TypeParameter;
        }

        public Builder setId(int i5) {
            this.bitField0_ |= 1;
            this.id_ = i5;
            return this;
        }

        public Builder setName(int i5) {
            this.bitField0_ |= 2;
            this.name_ = i5;
            return this;
        }

        public Builder setReified(boolean z5) {
            this.bitField0_ |= 4;
            this.reified_ = z5;
            return this;
        }

        public Builder setVariance(Variance variance) {
            variance.getClass();
            this.bitField0_ |= 8;
            this.variance_ = variance;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$TypeParameter build() {
            ProtoBuf$TypeParameter buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$TypeParameter protoBuf$TypeParameter) {
            if (protoBuf$TypeParameter == ProtoBuf$TypeParameter.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$TypeParameter.hasId()) {
                setId(protoBuf$TypeParameter.getId());
            }
            if (protoBuf$TypeParameter.hasName()) {
                setName(protoBuf$TypeParameter.getName());
            }
            if (protoBuf$TypeParameter.hasReified()) {
                setReified(protoBuf$TypeParameter.getReified());
            }
            if (protoBuf$TypeParameter.hasVariance()) {
                setVariance(protoBuf$TypeParameter.getVariance());
            }
            if (!protoBuf$TypeParameter.upperBound_.isEmpty()) {
                if (this.upperBound_.isEmpty()) {
                    this.upperBound_ = protoBuf$TypeParameter.upperBound_;
                    this.bitField0_ &= -17;
                } else {
                    ensureUpperBoundIsMutable();
                    this.upperBound_.addAll(protoBuf$TypeParameter.upperBound_);
                }
            }
            if (!protoBuf$TypeParameter.upperBoundId_.isEmpty()) {
                if (this.upperBoundId_.isEmpty()) {
                    this.upperBoundId_ = protoBuf$TypeParameter.upperBoundId_;
                    this.bitField0_ &= -33;
                } else {
                    ensureUpperBoundIdIsMutable();
                    this.upperBoundId_.addAll(protoBuf$TypeParameter.upperBoundId_);
                }
            }
            mergeExtensionFields(protoBuf$TypeParameter);
            setUnknownFields(getUnknownFields().concat(protoBuf$TypeParameter.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$TypeParameter protoBuf$TypeParameter = null;
            try {
                try {
                    ProtoBuf$TypeParameter parsePartialFrom = ProtoBuf$TypeParameter.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$TypeParameter protoBuf$TypeParameter2 = (ProtoBuf$TypeParameter) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$TypeParameter = protoBuf$TypeParameter2;
                        if (protoBuf$TypeParameter != null) {
                            mergeFrom(protoBuf$TypeParameter);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$TypeParameter != null) {
                }
                throw th;
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum Variance implements Internal.EnumLite {
        IN(0, 0),
        OUT(1, 1),
        INV(2, 2);

        private static Internal.EnumLiteMap<Variance> internalValueMap = new Internal.EnumLiteMap<Variance>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
            public Variance findValueByNumber(int i5) {
                return Variance.valueOf(i5);
            }
        };
        private final int value;

        Variance(int i5, int i6) {
            this.value = i6;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Variance valueOf(int i5) {
            if (i5 == 0) {
                return IN;
            }
            if (i5 == 1) {
                return OUT;
            }
            if (i5 != 2) {
                return null;
            }
            return INV;
        }
    }

    static {
        ProtoBuf$TypeParameter protoBuf$TypeParameter = new ProtoBuf$TypeParameter(true);
        defaultInstance = protoBuf$TypeParameter;
        protoBuf$TypeParameter.initFields();
    }

    public static ProtoBuf$TypeParameter getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.id_ = 0;
        this.name_ = 0;
        this.reified_ = false;
        this.variance_ = Variance.INV;
        this.upperBound_ = Collections.emptyList();
        this.upperBoundId_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.access$7600();
    }

    public int getId() {
        return this.id_;
    }

    public int getName() {
        return this.name_;
    }

    public boolean getReified() {
        return this.reified_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.id_) : 0;
        if ((this.bitField0_ & 2) == 2) {
            computeInt32Size += CodedOutputStream.computeInt32Size(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            computeInt32Size += CodedOutputStream.computeBoolSize(3, this.reified_);
        }
        if ((this.bitField0_ & 8) == 8) {
            computeInt32Size += CodedOutputStream.computeEnumSize(4, this.variance_.getNumber());
        }
        for (int i6 = 0; i6 < this.upperBound_.size(); i6++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(5, this.upperBound_.get(i6));
        }
        int i7 = 0;
        for (int i8 = 0; i8 < this.upperBoundId_.size(); i8++) {
            i7 += CodedOutputStream.computeInt32SizeNoTag(this.upperBoundId_.get(i8).intValue());
        }
        int i9 = computeInt32Size + i7;
        if (!getUpperBoundIdList().isEmpty()) {
            i9 = i9 + 1 + CodedOutputStream.computeInt32SizeNoTag(i7);
        }
        this.upperBoundIdMemoizedSerializedSize = i7;
        int extensionsSerializedSize = i9 + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = extensionsSerializedSize;
        return extensionsSerializedSize;
    }

    public ProtoBuf$Type getUpperBound(int i5) {
        return this.upperBound_.get(i5);
    }

    public int getUpperBoundCount() {
        return this.upperBound_.size();
    }

    public List<Integer> getUpperBoundIdList() {
        return this.upperBoundId_;
    }

    public List<ProtoBuf$Type> getUpperBoundList() {
        return this.upperBound_;
    }

    public Variance getVariance() {
        return this.variance_;
    }

    public boolean hasId() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasName() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasReified() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasVariance() {
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
        if (!hasId()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (!hasName()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i5 = 0; i5 < getUpperBoundCount(); i5++) {
            if (!getUpperBound(i5).isInitialized()) {
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
            codedOutputStream.writeInt32(1, this.id_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.name_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeBool(3, this.reified_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeEnum(4, this.variance_.getNumber());
        }
        for (int i5 = 0; i5 < this.upperBound_.size(); i5++) {
            codedOutputStream.writeMessage(5, this.upperBound_.get(i5));
        }
        if (getUpperBoundIdList().size() > 0) {
            codedOutputStream.writeRawVarint32(50);
            codedOutputStream.writeRawVarint32(this.upperBoundIdMemoizedSerializedSize);
        }
        for (int i6 = 0; i6 < this.upperBoundId_.size(); i6++) {
            codedOutputStream.writeInt32NoTag(this.upperBoundId_.get(i6).intValue());
        }
        newExtensionWriter.writeUntil(Constants.ONE_SECOND, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$TypeParameter protoBuf$TypeParameter) {
        return newBuilder().mergeFrom(protoBuf$TypeParameter);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$TypeParameter getDefaultInstanceForType() {
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

    private ProtoBuf$TypeParameter(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$TypeParameter, ?> extendableBuilder) {
        super(extendableBuilder);
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$TypeParameter(boolean z5) {
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$TypeParameter(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        this.upperBoundIdMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        ByteString.Output newOutput = ByteString.newOutput();
        CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
        boolean z5 = false;
        int i5 = 0;
        while (!z5) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.id_ = codedInputStream.readInt32();
                        } else if (readTag == 16) {
                            this.bitField0_ |= 2;
                            this.name_ = codedInputStream.readInt32();
                        } else if (readTag == 24) {
                            this.bitField0_ |= 4;
                            this.reified_ = codedInputStream.readBool();
                        } else if (readTag == 32) {
                            int readEnum = codedInputStream.readEnum();
                            Variance valueOf = Variance.valueOf(readEnum);
                            if (valueOf == null) {
                                newInstance.writeRawVarint32(readTag);
                                newInstance.writeRawVarint32(readEnum);
                            } else {
                                this.bitField0_ |= 8;
                                this.variance_ = valueOf;
                            }
                        } else if (readTag == 42) {
                            if ((i5 & 16) != 16) {
                                this.upperBound_ = new ArrayList();
                                i5 |= 16;
                            }
                            this.upperBound_.add(codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite));
                        } else if (readTag == 48) {
                            if ((i5 & 32) != 32) {
                                this.upperBoundId_ = new ArrayList();
                                i5 |= 32;
                            }
                            this.upperBoundId_.add(Integer.valueOf(codedInputStream.readInt32()));
                        } else if (readTag != 50) {
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                            if ((i5 & 32) != 32 && codedInputStream.getBytesUntilLimit() > 0) {
                                this.upperBoundId_ = new ArrayList();
                                i5 |= 32;
                            }
                            while (codedInputStream.getBytesUntilLimit() > 0) {
                                this.upperBoundId_.add(Integer.valueOf(codedInputStream.readInt32()));
                            }
                            codedInputStream.popLimit(pushLimit);
                        }
                    }
                    z5 = true;
                } catch (InvalidProtocolBufferException e5) {
                    throw e5.setUnfinishedMessage(this);
                } catch (IOException e6) {
                    throw new InvalidProtocolBufferException(e6.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if ((i5 & 16) == 16) {
                    this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                }
                if ((i5 & 32) == 32) {
                    this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
        if ((i5 & 16) == 16) {
            this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
        }
        if ((i5 & 32) == 32) {
            this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
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
