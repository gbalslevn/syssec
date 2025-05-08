package kotlin.reflect.jvm.internal.impl.metadata;

import androidx.appcompat.R$styleable;
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
public final class ProtoBuf$Annotation extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static Parser<ProtoBuf$Annotation> PARSER = new AbstractParser<ProtoBuf$Annotation>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation.1
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
        public ProtoBuf$Annotation parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return new ProtoBuf$Annotation(codedInputStream, extensionRegistryLite);
        }
    };
    private static final ProtoBuf$Annotation defaultInstance;
    private List<Argument> argument_;
    private int bitField0_;
    private int id_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final ByteString unknownFields;

    /* loaded from: classes3.dex */
    public static final class Argument extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static Parser<Argument> PARSER = new AbstractParser<Argument>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.1
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
            public Argument parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return new Argument(codedInputStream, extensionRegistryLite);
            }
        };
        private static final Argument defaultInstance;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int nameId_;
        private final ByteString unknownFields;
        private Value value_;

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements MessageLiteOrBuilder {
            private int bitField0_;
            private int nameId_;
            private Value value_ = Value.getDefaultInstance();

            private Builder() {
                maybeForceBuilderInitialization();
            }

            static /* synthetic */ Builder access$3600() {
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
                argument.nameId_ = this.nameId_;
                if ((i5 & 2) == 2) {
                    i6 |= 2;
                }
                argument.value_ = this.value_;
                argument.bitField0_ = i6;
                return argument;
            }

            public Builder mergeValue(Value value) {
                if ((this.bitField0_ & 2) != 2 || this.value_ == Value.getDefaultInstance()) {
                    this.value_ = value;
                } else {
                    this.value_ = Value.newBuilder(this.value_).mergeFrom(value).buildPartial();
                }
                this.bitField0_ |= 2;
                return this;
            }

            public Builder setNameId(int i5) {
                this.bitField0_ |= 1;
                this.nameId_ = i5;
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
                if (argument.hasNameId()) {
                    setNameId(argument.getNameId());
                }
                if (argument.hasValue()) {
                    mergeValue(argument.getValue());
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
        public static final class Value extends GeneratedMessageLite implements MessageLiteOrBuilder {
            public static Parser<Value> PARSER = new AbstractParser<Value>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.1
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Parser
                public Value parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    return new Value(codedInputStream, extensionRegistryLite);
                }
            };
            private static final Value defaultInstance;
            private ProtoBuf$Annotation annotation_;
            private int arrayDimensionCount_;
            private List<Value> arrayElement_;
            private int bitField0_;
            private int classId_;
            private double doubleValue_;
            private int enumValueId_;
            private int flags_;
            private float floatValue_;
            private long intValue_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int stringValue_;
            private Type type_;
            private final ByteString unknownFields;

            /* loaded from: classes3.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements MessageLiteOrBuilder {
                private int arrayDimensionCount_;
                private int bitField0_;
                private int classId_;
                private double doubleValue_;
                private int enumValueId_;
                private int flags_;
                private float floatValue_;
                private long intValue_;
                private int stringValue_;
                private Type type_ = Type.BYTE;
                private ProtoBuf$Annotation annotation_ = ProtoBuf$Annotation.getDefaultInstance();
                private List<Value> arrayElement_ = Collections.emptyList();

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                static /* synthetic */ Builder access$2100() {
                    return create();
                }

                private static Builder create() {
                    return new Builder();
                }

                private void ensureArrayElementIsMutable() {
                    if ((this.bitField0_ & 256) != 256) {
                        this.arrayElement_ = new ArrayList(this.arrayElement_);
                        this.bitField0_ |= 256;
                    }
                }

                private void maybeForceBuilderInitialization() {
                }

                public Value buildPartial() {
                    Value value = new Value(this);
                    int i5 = this.bitField0_;
                    int i6 = (i5 & 1) != 1 ? 0 : 1;
                    value.type_ = this.type_;
                    if ((i5 & 2) == 2) {
                        i6 |= 2;
                    }
                    value.intValue_ = this.intValue_;
                    if ((i5 & 4) == 4) {
                        i6 |= 4;
                    }
                    value.floatValue_ = this.floatValue_;
                    if ((i5 & 8) == 8) {
                        i6 |= 8;
                    }
                    value.doubleValue_ = this.doubleValue_;
                    if ((i5 & 16) == 16) {
                        i6 |= 16;
                    }
                    value.stringValue_ = this.stringValue_;
                    if ((i5 & 32) == 32) {
                        i6 |= 32;
                    }
                    value.classId_ = this.classId_;
                    if ((i5 & 64) == 64) {
                        i6 |= 64;
                    }
                    value.enumValueId_ = this.enumValueId_;
                    if ((i5 & 128) == 128) {
                        i6 |= 128;
                    }
                    value.annotation_ = this.annotation_;
                    if ((this.bitField0_ & 256) == 256) {
                        this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                        this.bitField0_ &= -257;
                    }
                    value.arrayElement_ = this.arrayElement_;
                    if ((i5 & 512) == 512) {
                        i6 |= 256;
                    }
                    value.arrayDimensionCount_ = this.arrayDimensionCount_;
                    if ((i5 & 1024) == 1024) {
                        i6 |= 512;
                    }
                    value.flags_ = this.flags_;
                    value.bitField0_ = i6;
                    return value;
                }

                public Builder mergeAnnotation(ProtoBuf$Annotation protoBuf$Annotation) {
                    if ((this.bitField0_ & 128) != 128 || this.annotation_ == ProtoBuf$Annotation.getDefaultInstance()) {
                        this.annotation_ = protoBuf$Annotation;
                    } else {
                        this.annotation_ = ProtoBuf$Annotation.newBuilder(this.annotation_).mergeFrom(protoBuf$Annotation).buildPartial();
                    }
                    this.bitField0_ |= 128;
                    return this;
                }

                public Builder setArrayDimensionCount(int i5) {
                    this.bitField0_ |= 512;
                    this.arrayDimensionCount_ = i5;
                    return this;
                }

                public Builder setClassId(int i5) {
                    this.bitField0_ |= 32;
                    this.classId_ = i5;
                    return this;
                }

                public Builder setDoubleValue(double d5) {
                    this.bitField0_ |= 8;
                    this.doubleValue_ = d5;
                    return this;
                }

                public Builder setEnumValueId(int i5) {
                    this.bitField0_ |= 64;
                    this.enumValueId_ = i5;
                    return this;
                }

                public Builder setFlags(int i5) {
                    this.bitField0_ |= 1024;
                    this.flags_ = i5;
                    return this;
                }

                public Builder setFloatValue(float f5) {
                    this.bitField0_ |= 4;
                    this.floatValue_ = f5;
                    return this;
                }

                public Builder setIntValue(long j5) {
                    this.bitField0_ |= 2;
                    this.intValue_ = j5;
                    return this;
                }

                public Builder setStringValue(int i5) {
                    this.bitField0_ |= 16;
                    this.stringValue_ = i5;
                    return this;
                }

                public Builder setType(Type type) {
                    type.getClass();
                    this.bitField0_ |= 1;
                    this.type_ = type;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Value build() {
                    Value buildPartial = buildPartial();
                    if (buildPartial.isInitialized()) {
                        return buildPartial;
                    }
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
                }

                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public Builder mergeFrom(Value value) {
                    if (value == Value.getDefaultInstance()) {
                        return this;
                    }
                    if (value.hasType()) {
                        setType(value.getType());
                    }
                    if (value.hasIntValue()) {
                        setIntValue(value.getIntValue());
                    }
                    if (value.hasFloatValue()) {
                        setFloatValue(value.getFloatValue());
                    }
                    if (value.hasDoubleValue()) {
                        setDoubleValue(value.getDoubleValue());
                    }
                    if (value.hasStringValue()) {
                        setStringValue(value.getStringValue());
                    }
                    if (value.hasClassId()) {
                        setClassId(value.getClassId());
                    }
                    if (value.hasEnumValueId()) {
                        setEnumValueId(value.getEnumValueId());
                    }
                    if (value.hasAnnotation()) {
                        mergeAnnotation(value.getAnnotation());
                    }
                    if (!value.arrayElement_.isEmpty()) {
                        if (this.arrayElement_.isEmpty()) {
                            this.arrayElement_ = value.arrayElement_;
                            this.bitField0_ &= -257;
                        } else {
                            ensureArrayElementIsMutable();
                            this.arrayElement_.addAll(value.arrayElement_);
                        }
                    }
                    if (value.hasArrayDimensionCount()) {
                        setArrayDimensionCount(value.getArrayDimensionCount());
                    }
                    if (value.hasFlags()) {
                        setFlags(value.getFlags());
                    }
                    setUnknownFields(getUnknownFields().concat(value.unknownFields));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                    Value value = null;
                    try {
                        try {
                            Value parsePartialFrom = Value.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e5) {
                            Value value2 = (Value) e5.getUnfinishedMessage();
                            try {
                                throw e5;
                            } catch (Throwable th) {
                                th = th;
                                value = value2;
                                if (value != null) {
                                    mergeFrom(value);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (value != null) {
                        }
                        throw th;
                    }
                }
            }

            /* loaded from: classes3.dex */
            public enum Type implements Internal.EnumLite {
                BYTE(0, 0),
                CHAR(1, 1),
                SHORT(2, 2),
                INT(3, 3),
                LONG(4, 4),
                FLOAT(5, 5),
                DOUBLE(6, 6),
                BOOLEAN(7, 7),
                STRING(8, 8),
                CLASS(9, 9),
                ENUM(10, 10),
                ANNOTATION(11, 11),
                ARRAY(12, 12);

                private static Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap<Type>() { // from class: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.Type.1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLiteMap
                    public Type findValueByNumber(int i5) {
                        return Type.valueOf(i5);
                    }
                };
                private final int value;

                Type(int i5, int i6) {
                    this.value = i6;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                public static Type valueOf(int i5) {
                    switch (i5) {
                        case 0:
                            return BYTE;
                        case 1:
                            return CHAR;
                        case 2:
                            return SHORT;
                        case 3:
                            return INT;
                        case 4:
                            return LONG;
                        case 5:
                            return FLOAT;
                        case 6:
                            return DOUBLE;
                        case 7:
                            return BOOLEAN;
                        case 8:
                            return STRING;
                        case 9:
                            return CLASS;
                        case 10:
                            return ENUM;
                        case 11:
                            return ANNOTATION;
                        case 12:
                            return ARRAY;
                        default:
                            return null;
                    }
                }
            }

            static {
                Value value = new Value(true);
                defaultInstance = value;
                value.initFields();
            }

            public static Value getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.type_ = Type.BYTE;
                this.intValue_ = 0L;
                this.floatValue_ = 0.0f;
                this.doubleValue_ = 0.0d;
                this.stringValue_ = 0;
                this.classId_ = 0;
                this.enumValueId_ = 0;
                this.annotation_ = ProtoBuf$Annotation.getDefaultInstance();
                this.arrayElement_ = Collections.emptyList();
                this.arrayDimensionCount_ = 0;
                this.flags_ = 0;
            }

            public static Builder newBuilder() {
                return Builder.access$2100();
            }

            public ProtoBuf$Annotation getAnnotation() {
                return this.annotation_;
            }

            public int getArrayDimensionCount() {
                return this.arrayDimensionCount_;
            }

            public Value getArrayElement(int i5) {
                return this.arrayElement_.get(i5);
            }

            public int getArrayElementCount() {
                return this.arrayElement_.size();
            }

            public List<Value> getArrayElementList() {
                return this.arrayElement_;
            }

            public int getClassId() {
                return this.classId_;
            }

            public double getDoubleValue() {
                return this.doubleValue_;
            }

            public int getEnumValueId() {
                return this.enumValueId_;
            }

            public int getFlags() {
                return this.flags_;
            }

            public float getFloatValue() {
                return this.floatValue_;
            }

            public long getIntValue() {
                return this.intValue_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int i5 = this.memoizedSerializedSize;
                if (i5 != -1) {
                    return i5;
                }
                int computeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.type_.getNumber()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    computeEnumSize += CodedOutputStream.computeSInt64Size(2, this.intValue_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    computeEnumSize += CodedOutputStream.computeFloatSize(3, this.floatValue_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    computeEnumSize += CodedOutputStream.computeDoubleSize(4, this.doubleValue_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(5, this.stringValue_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(6, this.classId_);
                }
                if ((this.bitField0_ & 64) == 64) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(7, this.enumValueId_);
                }
                if ((this.bitField0_ & 128) == 128) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(8, this.annotation_);
                }
                for (int i6 = 0; i6 < this.arrayElement_.size(); i6++) {
                    computeEnumSize += CodedOutputStream.computeMessageSize(9, this.arrayElement_.get(i6));
                }
                if ((this.bitField0_ & 512) == 512) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(10, this.flags_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    computeEnumSize += CodedOutputStream.computeInt32Size(11, this.arrayDimensionCount_);
                }
                int size = computeEnumSize + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public int getStringValue() {
                return this.stringValue_;
            }

            public Type getType() {
                return this.type_;
            }

            public boolean hasAnnotation() {
                return (this.bitField0_ & 128) == 128;
            }

            public boolean hasArrayDimensionCount() {
                return (this.bitField0_ & 256) == 256;
            }

            public boolean hasClassId() {
                return (this.bitField0_ & 32) == 32;
            }

            public boolean hasDoubleValue() {
                return (this.bitField0_ & 8) == 8;
            }

            public boolean hasEnumValueId() {
                return (this.bitField0_ & 64) == 64;
            }

            public boolean hasFlags() {
                return (this.bitField0_ & 512) == 512;
            }

            public boolean hasFloatValue() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean hasIntValue() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasStringValue() {
                return (this.bitField0_ & 16) == 16;
            }

            public boolean hasType() {
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
                if (hasAnnotation() && !getAnnotation().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                for (int i5 = 0; i5 < getArrayElementCount(); i5++) {
                    if (!getArrayElement(i5).isInitialized()) {
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
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.writeEnum(1, this.type_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.writeSInt64(2, this.intValue_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.writeFloat(3, this.floatValue_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    codedOutputStream.writeDouble(4, this.doubleValue_);
                }
                if ((this.bitField0_ & 16) == 16) {
                    codedOutputStream.writeInt32(5, this.stringValue_);
                }
                if ((this.bitField0_ & 32) == 32) {
                    codedOutputStream.writeInt32(6, this.classId_);
                }
                if ((this.bitField0_ & 64) == 64) {
                    codedOutputStream.writeInt32(7, this.enumValueId_);
                }
                if ((this.bitField0_ & 128) == 128) {
                    codedOutputStream.writeMessage(8, this.annotation_);
                }
                for (int i5 = 0; i5 < this.arrayElement_.size(); i5++) {
                    codedOutputStream.writeMessage(9, this.arrayElement_.get(i5));
                }
                if ((this.bitField0_ & 512) == 512) {
                    codedOutputStream.writeInt32(10, this.flags_);
                }
                if ((this.bitField0_ & 256) == 256) {
                    codedOutputStream.writeInt32(11, this.arrayDimensionCount_);
                }
                codedOutputStream.writeRawBytes(this.unknownFields);
            }

            public static Builder newBuilder(Value value) {
                return newBuilder().mergeFrom(value);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            private Value(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = builder.getUnknownFields();
            }

            private Value(boolean z5) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001e. Please report as an issue. */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v0 */
            /* JADX WARN: Type inference failed for: r5v1 */
            /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
            private Value(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output newOutput = ByteString.newOutput();
                CodedOutputStream newInstance = CodedOutputStream.newInstance(newOutput, 1);
                boolean z5 = false;
                char c5 = 0;
                while (true) {
                    ?? r5 = 256;
                    if (!z5) {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                switch (readTag) {
                                    case 0:
                                        z5 = true;
                                    case 8:
                                        int readEnum = codedInputStream.readEnum();
                                        Type valueOf = Type.valueOf(readEnum);
                                        if (valueOf == null) {
                                            newInstance.writeRawVarint32(readTag);
                                            newInstance.writeRawVarint32(readEnum);
                                        } else {
                                            this.bitField0_ |= 1;
                                            this.type_ = valueOf;
                                        }
                                    case 16:
                                        this.bitField0_ |= 2;
                                        this.intValue_ = codedInputStream.readSInt64();
                                    case R$styleable.Toolbar_titleTextColor /* 29 */:
                                        this.bitField0_ |= 4;
                                        this.floatValue_ = codedInputStream.readFloat();
                                    case 33:
                                        this.bitField0_ |= 8;
                                        this.doubleValue_ = codedInputStream.readDouble();
                                    case 40:
                                        this.bitField0_ |= 16;
                                        this.stringValue_ = codedInputStream.readInt32();
                                    case 48:
                                        this.bitField0_ |= 32;
                                        this.classId_ = codedInputStream.readInt32();
                                    case 56:
                                        this.bitField0_ |= 64;
                                        this.enumValueId_ = codedInputStream.readInt32();
                                    case 66:
                                        Builder builder = (this.bitField0_ & 128) == 128 ? this.annotation_.toBuilder() : null;
                                        ProtoBuf$Annotation protoBuf$Annotation = (ProtoBuf$Annotation) codedInputStream.readMessage(ProtoBuf$Annotation.PARSER, extensionRegistryLite);
                                        this.annotation_ = protoBuf$Annotation;
                                        if (builder != null) {
                                            builder.mergeFrom(protoBuf$Annotation);
                                            this.annotation_ = builder.buildPartial();
                                        }
                                        this.bitField0_ |= 128;
                                    case 74:
                                        if ((c5 & 256) != 256) {
                                            this.arrayElement_ = new ArrayList();
                                            c5 = 256;
                                        }
                                        this.arrayElement_.add(codedInputStream.readMessage(PARSER, extensionRegistryLite));
                                    case 80:
                                        this.bitField0_ |= 512;
                                        this.flags_ = codedInputStream.readInt32();
                                    case 88:
                                        this.bitField0_ |= 256;
                                        this.arrayDimensionCount_ = codedInputStream.readInt32();
                                    default:
                                        r5 = parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag);
                                        if (r5 == 0) {
                                            z5 = true;
                                        }
                                }
                            } catch (Throwable th) {
                                if ((c5 & 256) == r5) {
                                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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
                    } else {
                        if ((c5 & 256) == 256) {
                            this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
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

        static {
            Argument argument = new Argument(true);
            defaultInstance = argument;
            argument.initFields();
        }

        public static Argument getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.nameId_ = 0;
            this.value_ = Value.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.access$3600();
        }

        public int getNameId() {
            return this.nameId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int i5 = this.memoizedSerializedSize;
            if (i5 != -1) {
                return i5;
            }
            int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.nameId_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                computeInt32Size += CodedOutputStream.computeMessageSize(2, this.value_);
            }
            int size = computeInt32Size + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public Value getValue() {
            return this.value_;
        }

        public boolean hasNameId() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasValue() {
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
            if (!hasNameId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (!hasValue()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            if (getValue().isInitialized()) {
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
                codedOutputStream.writeInt32(1, this.nameId_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.value_);
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
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.bitField0_ |= 1;
                                this.nameId_ = codedInputStream.readInt32();
                            } else if (readTag != 18) {
                                if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                Value.Builder builder = (this.bitField0_ & 2) == 2 ? this.value_.toBuilder() : null;
                                Value value = (Value) codedInputStream.readMessage(Value.PARSER, extensionRegistryLite);
                                this.value_ = value;
                                if (builder != null) {
                                    builder.mergeFrom(value);
                                    this.value_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 2;
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

    /* loaded from: classes3.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ProtoBuf$Annotation, Builder> implements MessageLiteOrBuilder {
        private List<Argument> argument_ = Collections.emptyList();
        private int bitField0_;
        private int id_;

        private Builder() {
            maybeForceBuilderInitialization();
        }

        static /* synthetic */ Builder access$4200() {
            return create();
        }

        private static Builder create() {
            return new Builder();
        }

        private void ensureArgumentIsMutable() {
            if ((this.bitField0_ & 2) != 2) {
                this.argument_ = new ArrayList(this.argument_);
                this.bitField0_ |= 2;
            }
        }

        private void maybeForceBuilderInitialization() {
        }

        public ProtoBuf$Annotation buildPartial() {
            ProtoBuf$Annotation protoBuf$Annotation = new ProtoBuf$Annotation(this);
            int i5 = (this.bitField0_ & 1) != 1 ? 0 : 1;
            protoBuf$Annotation.id_ = this.id_;
            if ((this.bitField0_ & 2) == 2) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
                this.bitField0_ &= -3;
            }
            protoBuf$Annotation.argument_ = this.argument_;
            protoBuf$Annotation.bitField0_ = i5;
            return protoBuf$Annotation;
        }

        public Builder setId(int i5) {
            this.bitField0_ |= 1;
            this.id_ = i5;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        public ProtoBuf$Annotation build() {
            ProtoBuf$Annotation buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public Builder clone() {
            return create().mergeFrom(buildPartial());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
        public Builder mergeFrom(ProtoBuf$Annotation protoBuf$Annotation) {
            if (protoBuf$Annotation == ProtoBuf$Annotation.getDefaultInstance()) {
                return this;
            }
            if (protoBuf$Annotation.hasId()) {
                setId(protoBuf$Annotation.getId());
            }
            if (!protoBuf$Annotation.argument_.isEmpty()) {
                if (this.argument_.isEmpty()) {
                    this.argument_ = protoBuf$Annotation.argument_;
                    this.bitField0_ &= -3;
                } else {
                    ensureArgumentIsMutable();
                    this.argument_.addAll(protoBuf$Annotation.argument_);
                }
            }
            setUnknownFields(getUnknownFields().concat(protoBuf$Annotation.unknownFields));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            ProtoBuf$Annotation protoBuf$Annotation = null;
            try {
                try {
                    ProtoBuf$Annotation parsePartialFrom = ProtoBuf$Annotation.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        mergeFrom(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e5) {
                    ProtoBuf$Annotation protoBuf$Annotation2 = (ProtoBuf$Annotation) e5.getUnfinishedMessage();
                    try {
                        throw e5;
                    } catch (Throwable th) {
                        th = th;
                        protoBuf$Annotation = protoBuf$Annotation2;
                        if (protoBuf$Annotation != null) {
                            mergeFrom(protoBuf$Annotation);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (protoBuf$Annotation != null) {
                }
                throw th;
            }
        }
    }

    static {
        ProtoBuf$Annotation protoBuf$Annotation = new ProtoBuf$Annotation(true);
        defaultInstance = protoBuf$Annotation;
        protoBuf$Annotation.initFields();
    }

    public static ProtoBuf$Annotation getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.id_ = 0;
        this.argument_ = Collections.emptyList();
    }

    public static Builder newBuilder() {
        return Builder.access$4200();
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

    public int getId() {
        return this.id_;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public int getSerializedSize() {
        int i5 = this.memoizedSerializedSize;
        if (i5 != -1) {
            return i5;
        }
        int computeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.id_) : 0;
        for (int i6 = 0; i6 < this.argument_.size(); i6++) {
            computeInt32Size += CodedOutputStream.computeMessageSize(2, this.argument_.get(i6));
        }
        int size = computeInt32Size + this.unknownFields.size();
        this.memoizedSerializedSize = size;
        return size;
    }

    public boolean hasId() {
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
        if (!hasId()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i5 = 0; i5 < getArgumentCount(); i5++) {
            if (!getArgument(i5).isInitialized()) {
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
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.id_);
        }
        for (int i5 = 0; i5 < this.argument_.size(); i5++) {
            codedOutputStream.writeMessage(2, this.argument_.get(i5));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static Builder newBuilder(ProtoBuf$Annotation protoBuf$Annotation) {
        return newBuilder().mergeFrom(protoBuf$Annotation);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Builder toBuilder() {
        return newBuilder(this);
    }

    private ProtoBuf$Annotation(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = builder.getUnknownFields();
    }

    private ProtoBuf$Annotation(boolean z5) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString.EMPTY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ProtoBuf$Annotation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
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
                        if (readTag == 8) {
                            this.bitField0_ |= 1;
                            this.id_ = codedInputStream.readInt32();
                        } else if (readTag != 18) {
                            if (!parseUnknownField(codedInputStream, newInstance, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            if ((c5 & 2) != 2) {
                                this.argument_ = new ArrayList();
                                c5 = 2;
                            }
                            this.argument_.add(codedInputStream.readMessage(Argument.PARSER, extensionRegistryLite));
                        }
                    }
                    z5 = true;
                } catch (Throwable th) {
                    if ((c5 & 2) == 2) {
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
            } catch (InvalidProtocolBufferException e5) {
                throw e5.setUnfinishedMessage(this);
            } catch (IOException e6) {
                throw new InvalidProtocolBufferException(e6.getMessage()).setUnfinishedMessage(this);
            }
        }
        if ((c5 & 2) == 2) {
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
