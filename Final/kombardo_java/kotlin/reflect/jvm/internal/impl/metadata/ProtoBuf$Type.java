package kotlin.reflect.jvm.internal.impl.metadata;

import androidx.appcompat.R$styleable;
import com.sun.jna.Function;
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
public final class ProtoBuf$Type extends GeneratedMessageLite.ExtendableMessage<ProtoBuf$Type> implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$Type> PARSER = new AbstractParser<ProtoBuf$Type>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$Type parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$Type(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$Type defaultInstance;
    private int abbreviatedTypeId_;
    private ProtoBuf$Type abbreviatedType_;
    private List<Argument> argument_;
    private int bitField0_;
    private int className_;
    private int flags_;
    private int flexibleTypeCapabilitiesId_;
    private int flexibleUpperBoundId_;
    private ProtoBuf$Type flexibleUpperBound_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private boolean nullable_;
    private int outerTypeId_;
    private ProtoBuf$Type outerType_;
    private int typeAliasName_;
    private int typeParameterName_;
    private int typeParameter_;
    private final ByteString unknownFields;

    /* loaded from: classes3.dex */
    public static final class Argument extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static Parser<Argument> PARSER = new AbstractParser<Argument>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Argument parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new Argument(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Argument defaultInstance;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Projection projection_;
        private int typeId_;
        private ProtoBuf$Type type_;
        private final ByteString unknownFields;

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements MessageLiteOrBuilder {
            private int bitField0_;
            private int typeId_;
            private Projection projection_ = Projection.INV;
            private ProtoBuf$Type type_ = ProtoBuf$Type.getDefaultInstance();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$5000() {
                return create();
            }

            private static Builder create() {
                return new Builder();
            }

            private void maybeForceBuilderInitialization() {
            }

            public Argument buildPartial() {
                Argument argument = new Argument(this);
                int i5 = this.bitField0_;
                int i6 = (i5 & 1) != 1 ? 0 : 1;
                argument.projection_ = this.projection_;
                if ((i5 & 2) == 2) {
                    i6 |= 2;
                }
                argument.type_ = this.type_;
                if ((i5 & 4) == 4) {
                    i6 |= 4;
                }
                argument.typeId_ = this.typeId_;
                argument.bitField0_ = i6;
                return argument;
            }

            public Builder mergeType(ProtoBuf$Type protoBuf$Type) {
                if ((this.bitField0_ & 2) != 2 || this.type_ == ProtoBuf$Type.getDefaultInstance()) {
                    this.type_ = protoBuf$Type;
                } else {
                    this.type_ = ProtoBuf$Type.newBuilder(this.type_).mergeFrom(protoBuf$Type).buildPartial();
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setProjection(Projection projection) {
                projection.getClass();
                this.bitField0_ |= 1;
                this.projection_ = projection;
                return this;
            }

            public Builder setTypeId(int i5) {
                this.bitField0_ |= 4;
                this.typeId_ = i5;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Argument build() {
                Argument buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
            }

            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public Builder mergeFrom(Argument argument) {
                if (argument == Argument.getDefaultInstance()) {
                    return this;
                }
                if (argument.hasProjection()) {
                    setProjection(argument.getProjection());
                }
                if (argument.hasType()) {
                    mergeType(argument.getType());
                }
                if (argument.hasTypeId()) {
                    setTypeId(argument.getTypeId());
                }
                setUnknownFields(getUnknownFields().concat(argument.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                Argument argument = null;
                try {
                    try {
                        Argument parsePartialFrom = Argument.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e5) {
                        Argument argument2 = (Argument) e5.getUnfinishedMessage();
                        try {
                            throw e5;
                        } catch (Throwable th) {
                            th = th;
                            argument = argument2;
                            if (argument != null) {
                                mergeFrom(argument);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (argument != null) {
                    }
                    throw th;
                }
            }
        }

        /* loaded from: classes3.dex */
        public enum Projection implements Internal.EnumLite {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2),
            STAR(3, 3);

            private static Internal.EnumLiteMap<Projection> internalValueMap = new Internal.EnumLiteMap<Projection>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
                public Projection findValueByNumber(int i5) {
                    return Projection.valueOf(i5);
                }
            };
            private final int value;

            Projection(int i5, int i6) {
                this.value = i6;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Projection valueOf(int i5) {
                if (i5 == 0) {
                    return IN;
                }
                if (i5 == 1) {
                    return OUT;
                }
                if (i5 == 2) {
                    return INV;
                }
                if (i5 != 3) {
                    return null;
                }
                return STAR;
            }
        }

        static {
            Argument argument = new Argument(true);
            defaultInstance = argument;
            argument.initFields();
        }

        public static Argument getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.projection_ = Projection.INV;
            this.type_ = ProtoBuf$Type.getDefaultInstance();
            this.typeId_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.access$5000();
        }

        public Projection getProjection() {
            return this.projection_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i5 = this.memoizedSerializedSize;
            if (i5 != -1) {
                return i5;
            }
            int computeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.projection_.getNumber()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeEnumSize += CodedOutputStream.computeMessageSize(2, this.type_);
            }
            if ((this.bitField0_ & 4) == 4) {
                computeEnumSize += CodedOutputStream.computeInt32Size(3, this.typeId_);
            }
            int size = computeEnumSize + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public ProtoBuf$Type getType() {
            return this.type_;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public boolean hasProjection() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasType() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasTypeId() {
            return (this.bitField0_ & 4) == 4;
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
            if (!hasType() || getType().isInitialized()) {
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
                codedOutputStream.writeEnum(1, this.projection_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.type_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeInt32(3, this.typeId_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static Builder newBuilder(Argument argument) {
            return newBuilder().mergeFrom(argument);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        private Argument(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = builder.getUnknownFields();
        }

        private Argument(boolean z5) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Argument(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                                    int readEnum = codedInputStream.readEnum();
                                    Projection valueOf = Projection.valueOf(readEnum);
                                    if (valueOf == null) {
                                        newInstance.writeRawVarint32(readTag);
                                        newInstance.writeRawVarint32(readEnum);
                                    } else {
                                        this.bitField0_ |= 1;
                                        this.projection_ = valueOf;
                                    }
                                } else if (readTag == 18) {
                                    Builder builder = (this.bitField0_ & 2) == 2 ? this.type_.toBuilder() : null;
                                    ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.readMessage(ProtoBuf$Type.PARSER, extensionRegistryLite);
                                    this.type_ = protoBuf$Type;
                                    if (builder != null) {
                                        builder.mergeFrom(protoBuf$Type);
                                        this.type_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (readTag != 24) {
                                    if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    }
                                } else {
                                    this.bitField0_ |= 4;
                                    this.typeId_ = codedInputStream.readInt32();
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

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Type, Builder> implements MessageLiteOrBuilder {
        private int abbreviatedTypeId_;
        private int bitField0_;
        private int className_;
        private int flags_;
        private int flexibleTypeCapabilitiesId_;
        private int flexibleUpperBoundId_;
        private boolean nullable_;
        private int outerTypeId_;
        private int typeAliasName_;
        private int typeParameterName_;
        private int typeParameter_;
        private List<Argument> argument_ = Collections.emptyList();
        private ProtoBuf$Type flexibleUpperBound_ = ProtoBuf$Type.getDefaultInstance();
        private ProtoBuf$Type outerType_ = ProtoBuf$Type.getDefaultInstance();
        private ProtoBuf$Type abbreviatedType_ = ProtoBuf$Type.getDefaultInstance();

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$5700() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureArgumentIsMutable() {
            if ((this.bitField0_ & 1) != 1) {
                this.argument_ = new ArrayList(this.argument_);
                this.bitField0_ |= 1;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Type buildPartial() {
            ProtoBuf$Type protoBuf$Type = new ProtoBuf$Type(this);
            int i5 = this.bitField0_;
            if ((i5 & 1) == 1) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
                this.bitField0_ &= -2;
            }
            protoBuf$Type.argument_ = this.argument_;
            int i6 = (i5 & 2) != 2 ? 0 : 1;
            protoBuf$Type.nullable_ = this.nullable_;
            if ((i5 & 4) == 4) {
                i6 |= 2;
            }
            protoBuf$Type.flexibleTypeCapabilitiesId_ = this.flexibleTypeCapabilitiesId_;
            if ((i5 & 8) == 8) {
                i6 |= 4;
            }
            protoBuf$Type.flexibleUpperBound_ = this.flexibleUpperBound_;
            if ((i5 & 16) == 16) {
                i6 |= 8;
            }
            protoBuf$Type.flexibleUpperBoundId_ = this.flexibleUpperBoundId_;
            if ((i5 & 32) == 32) {
                i6 |= 16;
            }
            protoBuf$Type.className_ = this.className_;
            if ((i5 & 64) == 64) {
                i6 |= 32;
            }
            protoBuf$Type.typeParameter_ = this.typeParameter_;
            if ((i5 & 128) == 128) {
                i6 |= 64;
            }
            protoBuf$Type.typeParameterName_ = this.typeParameterName_;
            if ((i5 & 256) == 256) {
                i6 |= 128;
            }
            protoBuf$Type.typeAliasName_ = this.typeAliasName_;
            if ((i5 & 512) == 512) {
                i6 |= 256;
            }
            protoBuf$Type.outerType_ = this.outerType_;
            if ((i5 & 1024) == 1024) {
                i6 |= 512;
            }
            protoBuf$Type.outerTypeId_ = this.outerTypeId_;
            if ((i5 & 2048) == 2048) {
                i6 |= 1024;
            }
            protoBuf$Type.abbreviatedType_ = this.abbreviatedType_;
            if ((i5 & 4096) == 4096) {
                i6 |= 2048;
            }
            protoBuf$Type.abbreviatedTypeId_ = this.abbreviatedTypeId_;
            if ((i5 & 8192) == 8192) {
                i6 |= 4096;
            }
            protoBuf$Type.flags_ = this.flags_;
            protoBuf$Type.bitField0_ = i6;
            return protoBuf$Type;
        }

        public Builder mergeAbbreviatedType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 2048) != 2048 || this.abbreviatedType_ == ProtoBuf$Type.getDefaultInstance()) {
                this.abbreviatedType_ = protoBuf$Type;
            } else {
                this.abbreviatedType_ = ProtoBuf$Type.newBuilder(this.abbreviatedType_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 2048;
            return this;
        }

        public Builder mergeFlexibleUpperBound(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 8) != 8 || this.flexibleUpperBound_ == ProtoBuf$Type.getDefaultInstance()) {
                this.flexibleUpperBound_ = protoBuf$Type;
            } else {
                this.flexibleUpperBound_ = ProtoBuf$Type.newBuilder(this.flexibleUpperBound_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 8;
            return this;
        }

        public Builder mergeOuterType(ProtoBuf$Type protoBuf$Type) {
            if ((this.bitField0_ & 512) != 512 || this.outerType_ == ProtoBuf$Type.getDefaultInstance()) {
                this.outerType_ = protoBuf$Type;
            } else {
                this.outerType_ = ProtoBuf$Type.newBuilder(this.outerType_).mergeFrom(protoBuf$Type).buildPartial();
            }
            this.bitField0_ |= 512;
            return this;
        }

        public Builder setAbbreviatedTypeId(int i5) {
            this.bitField0_ |= 4096;
            this.abbreviatedTypeId_ = i5;
            return this;
        }

        public Builder setClassName(int i5) {
            this.bitField0_ |= 32;
            this.className_ = i5;
            return this;
        }

        public Builder setFlags(int i5) {
            this.bitField0_ |= 8192;
            this.flags_ = i5;
            return this;
        }

        public Builder setFlexibleTypeCapabilitiesId(int i5) {
            this.bitField0_ |= 4;
            this.flexibleTypeCapabilitiesId_ = i5;
            return this;
        }

        public Builder setFlexibleUpperBoundId(int i5) {
            this.bitField0_ |= 16;
            this.flexibleUpperBoundId_ = i5;
            return this;
        }

        public Builder setNullable(boolean z5) {
            this.bitField0_ |= 2;
            this.nullable_ = z5;
            return this;
        }

        public Builder setOuterTypeId(int i5) {
            this.bitField0_ |= 1024;
            this.outerTypeId_ = i5;
            return this;
        }

        public Builder setTypeAliasName(int i5) {
            this.bitField0_ |= 256;
            this.typeAliasName_ = i5;
            return this;
        }

        public Builder setTypeParameter(int i5) {
            this.bitField0_ |= 64;
            this.typeParameter_ = i5;
            return this;
        }

        public Builder setTypeParameterName(int i5) {
            this.bitField0_ |= 128;
            this.typeParameterName_ = i5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Type build() {
            ProtoBuf$Type buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$Type protoBuf$Type) {
            if (protoBuf$Type == ProtoBuf$Type.getDefaultInstance()) {
                return this;
            }
            if (!protoBuf$Type.argument_.isEmpty()) {
                if (this.argument_.isEmpty()) {
                    this.argument_ = protoBuf$Type.argument_;
                    this.bitField0_ &= -2;
                } else {
                    ensureArgumentIsMutable();
                    this.argument_.addAll(protoBuf$Type.argument_);
                }
            }
            if (protoBuf$Type.hasNullable()) {
                setNullable(protoBuf$Type.getNullable());
            }
            if (protoBuf$Type.hasFlexibleTypeCapabilitiesId()) {
                setFlexibleTypeCapabilitiesId(protoBuf$Type.getFlexibleTypeCapabilitiesId());
            }
            if (protoBuf$Type.hasFlexibleUpperBound()) {
                mergeFlexibleUpperBound(protoBuf$Type.getFlexibleUpperBound());
            }
            if (protoBuf$Type.hasFlexibleUpperBoundId()) {
                setFlexibleUpperBoundId(protoBuf$Type.getFlexibleUpperBoundId());
            }
            if (protoBuf$Type.hasClassName()) {
                setClassName(protoBuf$Type.getClassName());
            }
            if (protoBuf$Type.hasTypeParameter()) {
                setTypeParameter(protoBuf$Type.getTypeParameter());
            }
            if (protoBuf$Type.hasTypeParameterName()) {
                setTypeParameterName(protoBuf$Type.getTypeParameterName());
            }
            if (protoBuf$Type.hasTypeAliasName()) {
                setTypeAliasName(protoBuf$Type.getTypeAliasName());
            }
            if (protoBuf$Type.hasOuterType()) {
                mergeOuterType(protoBuf$Type.getOuterType());
            }
            if (protoBuf$Type.hasOuterTypeId()) {
                setOuterTypeId(protoBuf$Type.getOuterTypeId());
            }
            if (protoBuf$Type.hasAbbreviatedType()) {
                mergeAbbreviatedType(protoBuf$Type.getAbbreviatedType());
            }
            if (protoBuf$Type.hasAbbreviatedTypeId()) {
                setAbbreviatedTypeId(protoBuf$Type.getAbbreviatedTypeId());
            }
            if (protoBuf$Type.hasFlags()) {
                setFlags(protoBuf$Type.getFlags());
            }
            mergeExtensionFields(protoBuf$Type);
            setUnknownFields(getUnknownFields().concat(protoBuf$Type.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$Type protoBuf$Type = null;
            try {
                try {
                    ProtoBuf$Type parsePartialFrom = ProtoBuf$Type.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$Type = protoBuf$Type2;
                        if (protoBuf$Type != null) {
                            mergeFrom(protoBuf$Type);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$Type != null) {
                }
                throw th;
            }
        }
    }

    static {
        ProtoBuf$Type protoBuf$Type = new ProtoBuf$Type(true);
        defaultInstance = protoBuf$Type;
        protoBuf$Type.initFields();
    }

    public static ProtoBuf$Type getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.argument_ = Collections.emptyList();
        this.nullable_ = false;
        this.flexibleTypeCapabilitiesId_ = 0;
        this.flexibleUpperBound_ = getDefaultInstance();
        this.flexibleUpperBoundId_ = 0;
        this.className_ = 0;
        this.typeParameter_ = 0;
        this.typeParameterName_ = 0;
        this.typeAliasName_ = 0;
        this.outerType_ = getDefaultInstance();
        this.outerTypeId_ = 0;
        this.abbreviatedType_ = getDefaultInstance();
        this.abbreviatedTypeId_ = 0;
        this.flags_ = 0;
    }

    public static Builder newBuilder() {
        return Builder.access$5700();
    }

    public ProtoBuf$Type getAbbreviatedType() {
        return this.abbreviatedType_;
    }

    public int getAbbreviatedTypeId() {
        return this.abbreviatedTypeId_;
    }

    public Argument getArgument(int i5) {
        return this.argument_.get(i5);
    }

    public int getArgumentCount() {
        return this.argument_.size();
    }

    public List<Argument> getArgumentList() {
        return this.argument_;
    }

    public int getClassName() {
        return this.className_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public int getFlexibleTypeCapabilitiesId() {
        return this.flexibleTypeCapabilitiesId_;
    }

    public ProtoBuf$Type getFlexibleUpperBound() {
        return this.flexibleUpperBound_;
    }

    public int getFlexibleUpperBoundId() {
        return this.flexibleUpperBoundId_;
    }

    public boolean getNullable() {
        return this.nullable_;
    }

    public ProtoBuf$Type getOuterType() {
        return this.outerType_;
    }

    public int getOuterTypeId() {
        return this.outerTypeId_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int computeInt32Size = (this.bitField0_ & 4096) == 4096 ? CodedOutputStream.computeInt32Size(1, this.flags_) : 0;
        for (int i6 = 0; i6 < this.argument_.size(); i6++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(2, this.argument_.get(i6));
        }
        if ((this.bitField0_ & 1) == 1) {
            computeInt32Size += CodedOutputStream.computeBoolSize(3, this.nullable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            computeInt32Size += CodedOutputStream.computeInt32Size(4, this.flexibleTypeCapabilitiesId_);
        }
        if ((this.bitField0_ & 4) == 4) {
            computeInt32Size += CodedOutputStream.computeMessageSize(5, this.flexibleUpperBound_);
        }
        if ((this.bitField0_ & 16) == 16) {
            computeInt32Size += CodedOutputStream.computeInt32Size(6, this.className_);
        }
        if ((this.bitField0_ & 32) == 32) {
            computeInt32Size += CodedOutputStream.computeInt32Size(7, this.typeParameter_);
        }
        if ((this.bitField0_ & 8) == 8) {
            computeInt32Size += CodedOutputStream.computeInt32Size(8, this.flexibleUpperBoundId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            computeInt32Size += CodedOutputStream.computeInt32Size(9, this.typeParameterName_);
        }
        if ((this.bitField0_ & 256) == 256) {
            computeInt32Size += CodedOutputStream.computeMessageSize(10, this.outerType_);
        }
        if ((this.bitField0_ & 512) == 512) {
            computeInt32Size += CodedOutputStream.computeInt32Size(11, this.outerTypeId_);
        }
        if ((this.bitField0_ & 128) == 128) {
            computeInt32Size += CodedOutputStream.computeInt32Size(12, this.typeAliasName_);
        }
        if ((this.bitField0_ & 1024) == 1024) {
            computeInt32Size += CodedOutputStream.computeMessageSize(13, this.abbreviatedType_);
        }
        if ((this.bitField0_ & 2048) == 2048) {
            computeInt32Size += CodedOutputStream.computeInt32Size(14, this.abbreviatedTypeId_);
        }
        int extensionsSerializedSize = computeInt32Size + extensionsSerializedSize() + this.unknownFields.size();
        this.memoizedSerializedSize = extensionsSerializedSize;
        return extensionsSerializedSize;
    }

    public int getTypeAliasName() {
        return this.typeAliasName_;
    }

    public int getTypeParameter() {
        return this.typeParameter_;
    }

    public int getTypeParameterName() {
        return this.typeParameterName_;
    }

    public boolean hasAbbreviatedType() {
        return (this.bitField0_ & 1024) == 1024;
    }

    public boolean hasAbbreviatedTypeId() {
        return (this.bitField0_ & 2048) == 2048;
    }

    public boolean hasClassName() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 4096) == 4096;
    }

    public boolean hasFlexibleTypeCapabilitiesId() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasFlexibleUpperBound() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasFlexibleUpperBoundId() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasNullable() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasOuterType() {
        return (this.bitField0_ & 256) == 256;
    }

    public boolean hasOuterTypeId() {
        return (this.bitField0_ & 512) == 512;
    }

    public boolean hasTypeAliasName() {
        return (this.bitField0_ & 128) == 128;
    }

    public boolean hasTypeParameter() {
        return (this.bitField0_ & 32) == 32;
    }

    public boolean hasTypeParameterName() {
        return (this.bitField0_ & 64) == 64;
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
        for (int i5 = 0; i5 < getArgumentCount(); i5++) {
            if (!getArgument(i5).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasOuterType() && !getOuterType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (hasAbbreviatedType() && !getAbbreviatedType().isInitialized()) {
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
        if ((this.bitField0_ & 4096) == 4096) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        for (int i5 = 0; i5 < this.argument_.size(); i5++) {
            codedOutputStream.writeMessage(2, this.argument_.get(i5));
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeBool(3, this.nullable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(4, this.flexibleTypeCapabilitiesId_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeMessage(5, this.flexibleUpperBound_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(6, this.className_);
        }
        if ((this.bitField0_ & 32) == 32) {
            codedOutputStream.writeInt32(7, this.typeParameter_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeInt32(8, this.flexibleUpperBoundId_);
        }
        if ((this.bitField0_ & 64) == 64) {
            codedOutputStream.writeInt32(9, this.typeParameterName_);
        }
        if ((this.bitField0_ & 256) == 256) {
            codedOutputStream.writeMessage(10, this.outerType_);
        }
        if ((this.bitField0_ & 512) == 512) {
            codedOutputStream.writeInt32(11, this.outerTypeId_);
        }
        if ((this.bitField0_ & 128) == 128) {
            codedOutputStream.writeInt32(12, this.typeAliasName_);
        }
        if ((this.bitField0_ & 1024) == 1024) {
            codedOutputStream.writeMessage(13, this.abbreviatedType_);
        }
        if ((this.bitField0_ & 2048) == 2048) {
            codedOutputStream.writeInt32(14, this.abbreviatedTypeId_);
        }
        newExtensionWriter.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Type protoBuf$Type) {
        return newBuilder().mergeFrom(protoBuf$Type);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
    public ProtoBuf$Type getDefaultInstanceForType() {
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

    private ProtoBuf$Type(GeneratedMessageLite.ExtendableBuilder<ProtoBuf$Type, ?> extendableBuilder) {
        super(extendableBuilder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = extendableBuilder.getUnknownFields();
    }

    private ProtoBuf$Type(boolean z5) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x001d. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$Type(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Builder builder;
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
                        switch (readTag) {
                            case 0:
                                z5 = true;
                            case 8:
                                this.bitField0_ |= 4096;
                                this.flags_ = codedInputStream.readInt32();
                            case 18:
                                if (!z6) {
                                    this.argument_ = new ArrayList();
                                    z6 = true;
                                }
                                this.argument_.add(codedInputStream.readMessage(Argument.PARSER, extensionRegistryLite));
                            case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                                this.bitField0_ |= 1;
                                this.nullable_ = codedInputStream.readBool();
                            case 32:
                                this.bitField0_ |= 2;
                                this.flexibleTypeCapabilitiesId_ = codedInputStream.readInt32();
                            case 42:
                                builder = (this.bitField0_ & 4) == 4 ? this.flexibleUpperBound_.toBuilder() : null;
                                ProtoBuf$Type protoBuf$Type = (ProtoBuf$Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                                this.flexibleUpperBound_ = protoBuf$Type;
                                if (builder != null) {
                                    builder.mergeFrom(protoBuf$Type);
                                    this.flexibleUpperBound_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            case 48:
                                this.bitField0_ |= 16;
                                this.className_ = codedInputStream.readInt32();
                            case 56:
                                this.bitField0_ |= 32;
                                this.typeParameter_ = codedInputStream.readInt32();
                            case Function.THROW_LAST_ERROR /* 64 */:
                                this.bitField0_ |= 8;
                                this.flexibleUpperBoundId_ = codedInputStream.readInt32();
                            case 72:
                                this.bitField0_ |= 64;
                                this.typeParameterName_ = codedInputStream.readInt32();
                            case 82:
                                builder = (this.bitField0_ & 256) == 256 ? this.outerType_.toBuilder() : null;
                                ProtoBuf$Type protoBuf$Type2 = (ProtoBuf$Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                                this.outerType_ = protoBuf$Type2;
                                if (builder != null) {
                                    builder.mergeFrom(protoBuf$Type2);
                                    this.outerType_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 256;
                            case 88:
                                this.bitField0_ |= 512;
                                this.outerTypeId_ = codedInputStream.readInt32();
                            case 96:
                                this.bitField0_ |= 128;
                                this.typeAliasName_ = codedInputStream.readInt32();
                            case 106:
                                builder = (this.bitField0_ & 1024) == 1024 ? this.abbreviatedType_.toBuilder() : null;
                                ProtoBuf$Type protoBuf$Type3 = (ProtoBuf$Type) codedInputStream.readMessage(PARSER, extensionRegistryLite);
                                this.abbreviatedType_ = protoBuf$Type3;
                                if (builder != null) {
                                    builder.mergeFrom(protoBuf$Type3);
                                    this.abbreviatedType_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1024;
                            case 112:
                                this.bitField0_ |= 2048;
                                this.abbreviatedTypeId_ = codedInputStream.readInt32();
                            default:
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                    z5 = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException e5) {
                        throw e5.setUnfinishedMessage(this);
                    }
                } catch (IOException e6) {
                    throw new InvalidProtocolBufferException(e6.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z6) {
                    this.argument_ = Collections.unmodifiableList(this.argument_);
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
            this.argument_ = Collections.unmodifiableList(this.argument_);
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
