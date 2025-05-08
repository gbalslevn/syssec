package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class CodedInputStreamReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;
    private static final int NEXT_TAG_UNSET = 0;
    private int endGroupTag;
    private final CodedInputStream input;
    private int nextTag = 0;
    private int tag;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.datastore.preferences.protobuf.CodedInputStreamReader$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private CodedInputStreamReader(CodedInputStream codedInputStream) {
        CodedInputStream codedInputStream2 = (CodedInputStream) Internal.checkNotNull(codedInputStream, "input");
        this.input = codedInputStream2;
        codedInputStream2.wrapper = this;
    }

    public static CodedInputStreamReader forCodedInput(CodedInputStream codedInputStream) {
        CodedInputStreamReader codedInputStreamReader = codedInputStream.wrapper;
        return codedInputStreamReader != null ? codedInputStreamReader : new CodedInputStreamReader(codedInputStream);
    }

    private <T> void mergeGroupFieldInternal(T t5, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
        int i5 = this.endGroupTag;
        this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
        try {
            schema.mergeFrom(t5, this, extensionRegistryLite);
            if (this.tag == this.endGroupTag) {
            } else {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } finally {
            this.endGroupTag = i5;
        }
    }

    private <T> void mergeMessageFieldInternal(T t5, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
        int readUInt32 = this.input.readUInt32();
        CodedInputStream codedInputStream = this.input;
        if (codedInputStream.recursionDepth >= codedInputStream.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int pushLimit = codedInputStream.pushLimit(readUInt32);
        this.input.recursionDepth++;
        schema.mergeFrom(t5, this, extensionRegistryLite);
        this.input.checkLastTagWas(0);
        r5.recursionDepth--;
        this.input.popLimit(pushLimit);
    }

    private Object readField(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                return Boolean.valueOf(readBool());
            case 2:
                return readBytes();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(readEnum());
            case 5:
                return Integer.valueOf(readFixed32());
            case 6:
                return Long.valueOf(readFixed64());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(readInt32());
            case 9:
                return Long.valueOf(readInt64());
            case 10:
                return readMessage(cls, extensionRegistryLite);
            case 11:
                return Integer.valueOf(readSFixed32());
            case 12:
                return Long.valueOf(readSFixed64());
            case 13:
                return Integer.valueOf(readSInt32());
            case 14:
                return Long.valueOf(readSInt64());
            case 15:
                return readStringRequireUtf8();
            case 16:
                return Integer.valueOf(readUInt32());
            case 17:
                return Long.valueOf(readUInt64());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private <T> T readGroup(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
        T newInstance = schema.newInstance();
        mergeGroupFieldInternal(newInstance, schema, extensionRegistryLite);
        schema.makeImmutable(newInstance);
        return newInstance;
    }

    private void requirePosition(int i5) {
        if (this.input.getTotalBytesRead() != i5) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void requireWireType(int i5) {
        if (WireFormat.getTagWireType(this.tag) != i5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    private void verifyPackedFixed32Length(int i5) {
        if ((i5 & 3) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    private void verifyPackedFixed64Length(int i5) {
        if ((i5 & 7) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public int getFieldNumber() {
        int i5 = this.nextTag;
        if (i5 != 0) {
            this.tag = i5;
            this.nextTag = 0;
        } else {
            this.tag = this.input.readTag();
        }
        int i6 = this.tag;
        if (i6 == 0 || i6 == this.endGroupTag) {
            return Integer.MAX_VALUE;
        }
        return WireFormat.getTagFieldNumber(i6);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public int getTag() {
        return this.tag;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public <T> void mergeGroupField(T t5, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
        requireWireType(3);
        mergeGroupFieldInternal(t5, schema, extensionRegistryLite);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public <T> void mergeMessageField(T t5, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
        requireWireType(2);
        mergeMessageFieldInternal(t5, schema, extensionRegistryLite);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public boolean readBool() {
        requireWireType(0);
        return this.input.readBool();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void readBoolList(List<Boolean> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof BooleanArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 0) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    list.add(Boolean.valueOf(this.input.readBool()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
                return;
            }
            do {
                list.add(Boolean.valueOf(this.input.readBool()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 0) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead2 = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                booleanArrayList.addBoolean(this.input.readBool());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            requirePosition(totalBytesRead2);
            return;
        }
        do {
            booleanArrayList.addBoolean(this.input.readBool());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public ByteString readBytes() {
        requireWireType(2);
        return this.input.readBytes();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void readBytesList(List<ByteString> list) {
        int readTag;
        if (WireFormat.getTagWireType(this.tag) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(readBytes());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag = this.input.readTag();
            }
        } while (readTag == this.tag);
        this.nextTag = readTag;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public double readDouble() {
        requireWireType(1);
        return this.input.readDouble();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void readDoubleList(List<Double> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof DoubleArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 1) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readUInt32 = this.input.readUInt32();
                verifyPackedFixed64Length(readUInt32);
                int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
                do {
                    list.add(Double.valueOf(this.input.readDouble()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            do {
                list.add(Double.valueOf(this.input.readDouble()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 1) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readUInt322 = this.input.readUInt32();
            verifyPackedFixed64Length(readUInt322);
            int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
            do {
                doubleArrayList.addDouble(this.input.readDouble());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        do {
            doubleArrayList.addDouble(this.input.readDouble());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public int readEnum() {
        requireWireType(0);
        return this.input.readEnum();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void readEnumList(List<Integer> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof IntArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 0) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    list.add(Integer.valueOf(this.input.readEnum()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
                return;
            }
            do {
                list.add(Integer.valueOf(this.input.readEnum()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 0) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead2 = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                intArrayList.addInt(this.input.readEnum());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            requirePosition(totalBytesRead2);
            return;
        }
        do {
            intArrayList.addInt(this.input.readEnum());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public int readFixed32() {
        requireWireType(5);
        return this.input.readFixed32();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void readFixed32List(List<Integer> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof IntArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 2) {
                int readUInt32 = this.input.readUInt32();
                verifyPackedFixed32Length(readUInt32);
                int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
                do {
                    list.add(Integer.valueOf(this.input.readFixed32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(this.input.readFixed32()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 == 2) {
            int readUInt322 = this.input.readUInt32();
            verifyPackedFixed32Length(readUInt322);
            int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
            do {
                intArrayList.addInt(this.input.readFixed32());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (tagWireType2 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            intArrayList.addInt(this.input.readFixed32());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public long readFixed64() {
        requireWireType(1);
        return this.input.readFixed64();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void readFixed64List(List<Long> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof LongArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 1) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readUInt32 = this.input.readUInt32();
                verifyPackedFixed64Length(readUInt32);
                int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
                do {
                    list.add(Long.valueOf(this.input.readFixed64()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            do {
                list.add(Long.valueOf(this.input.readFixed64()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 1) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readUInt322 = this.input.readUInt32();
            verifyPackedFixed64Length(readUInt322);
            int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
            do {
                longArrayList.addLong(this.input.readFixed64());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        do {
            longArrayList.addLong(this.input.readFixed64());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public float readFloat() {
        requireWireType(5);
        return this.input.readFloat();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void readFloatList(List<Float> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof FloatArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 2) {
                int readUInt32 = this.input.readUInt32();
                verifyPackedFixed32Length(readUInt32);
                int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
                do {
                    list.add(Float.valueOf(this.input.readFloat()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Float.valueOf(this.input.readFloat()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        FloatArrayList floatArrayList = (FloatArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 == 2) {
            int readUInt322 = this.input.readUInt32();
            verifyPackedFixed32Length(readUInt322);
            int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
            do {
                floatArrayList.addFloat(this.input.readFloat());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (tagWireType2 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            floatArrayList.addFloat(this.input.readFloat());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.Reader
    @Deprecated
    public <T> void readGroupList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
        int readTag;
        if (WireFormat.getTagWireType(this.tag) != 3) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int i5 = this.tag;
        do {
            list.add(readGroup(schema, extensionRegistryLite));
            if (this.input.isAtEnd() || this.nextTag != 0) {
                return;
            } else {
                readTag = this.input.readTag();
            }
        } while (readTag == i5);
        this.nextTag = readTag;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public int readInt32() {
        requireWireType(0);
        return this.input.readInt32();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void readInt32List(List<Integer> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof IntArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 0) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    list.add(Integer.valueOf(this.input.readInt32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
                return;
            }
            do {
                list.add(Integer.valueOf(this.input.readInt32()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 0) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead2 = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                intArrayList.addInt(this.input.readInt32());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            requirePosition(totalBytesRead2);
            return;
        }
        do {
            intArrayList.addInt(this.input.readInt32());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public long readInt64() {
        requireWireType(0);
        return this.input.readInt64();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void readInt64List(List<Long> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof LongArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 0) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    list.add(Long.valueOf(this.input.readInt64()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
                return;
            }
            do {
                list.add(Long.valueOf(this.input.readInt64()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 0) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead2 = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                longArrayList.addLong(this.input.readInt64());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            requirePosition(totalBytesRead2);
            return;
        }
        do {
            longArrayList.addLong(this.input.readInt64());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0061, code lost:
    
        r7.input.popLimit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0066, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <K, V> void readMap(Map<K, V> map, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) {
        requireWireType(2);
        int pushLimit = this.input.pushLimit(this.input.readUInt32());
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (true) {
            try {
                int fieldNumber = getFieldNumber();
                if (fieldNumber == Integer.MAX_VALUE || this.input.isAtEnd()) {
                    break;
                }
                if (fieldNumber == 1) {
                    obj = readField(metadata.keyType, null, null);
                } else if (fieldNumber != 2) {
                    try {
                        if (!skipField()) {
                            throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            break;
                        }
                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                        if (!skipField()) {
                            throw new InvalidProtocolBufferException("Unable to parse map entry.");
                        }
                    }
                } else {
                    obj2 = readField(metadata.valueType, metadata.defaultValue.getClass(), extensionRegistryLite);
                }
            } catch (Throwable th) {
                this.input.popLimit(pushLimit);
                throw th;
            }
        }
    }

    public <T> T readMessage(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) {
        requireWireType(2);
        return (T) readMessage(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.Reader
    public <T> void readMessageList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
        int readTag;
        if (WireFormat.getTagWireType(this.tag) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int i5 = this.tag;
        do {
            list.add(readMessage(schema, extensionRegistryLite));
            if (this.input.isAtEnd() || this.nextTag != 0) {
                return;
            } else {
                readTag = this.input.readTag();
            }
        } while (readTag == i5);
        this.nextTag = readTag;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public int readSFixed32() {
        requireWireType(5);
        return this.input.readSFixed32();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void readSFixed32List(List<Integer> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof IntArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType == 2) {
                int readUInt32 = this.input.readUInt32();
                verifyPackedFixed32Length(readUInt32);
                int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
                do {
                    list.add(Integer.valueOf(this.input.readSFixed32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(this.input.readSFixed32()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 == 2) {
            int readUInt322 = this.input.readUInt32();
            verifyPackedFixed32Length(readUInt322);
            int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
            do {
                intArrayList.addInt(this.input.readSFixed32());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (tagWireType2 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            intArrayList.addInt(this.input.readSFixed32());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public long readSFixed64() {
        requireWireType(1);
        return this.input.readSFixed64();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void readSFixed64List(List<Long> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof LongArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 1) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int readUInt32 = this.input.readUInt32();
                verifyPackedFixed64Length(readUInt32);
                int totalBytesRead = this.input.getTotalBytesRead() + readUInt32;
                do {
                    list.add(Long.valueOf(this.input.readSFixed64()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            do {
                list.add(Long.valueOf(this.input.readSFixed64()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 1) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int readUInt322 = this.input.readUInt32();
            verifyPackedFixed64Length(readUInt322);
            int totalBytesRead2 = this.input.getTotalBytesRead() + readUInt322;
            do {
                longArrayList.addLong(this.input.readSFixed64());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        do {
            longArrayList.addLong(this.input.readSFixed64());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public int readSInt32() {
        requireWireType(0);
        return this.input.readSInt32();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void readSInt32List(List<Integer> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof IntArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 0) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    list.add(Integer.valueOf(this.input.readSInt32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
                return;
            }
            do {
                list.add(Integer.valueOf(this.input.readSInt32()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 0) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead2 = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                intArrayList.addInt(this.input.readSInt32());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            requirePosition(totalBytesRead2);
            return;
        }
        do {
            intArrayList.addInt(this.input.readSInt32());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public long readSInt64() {
        requireWireType(0);
        return this.input.readSInt64();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void readSInt64List(List<Long> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof LongArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 0) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    list.add(Long.valueOf(this.input.readSInt64()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
                return;
            }
            do {
                list.add(Long.valueOf(this.input.readSInt64()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 0) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead2 = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                longArrayList.addLong(this.input.readSInt64());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            requirePosition(totalBytesRead2);
            return;
        }
        do {
            longArrayList.addLong(this.input.readSInt64());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public String readString() {
        requireWireType(2);
        return this.input.readString();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void readStringList(List<String> list) {
        readStringListInternal(list, false);
    }

    public void readStringListInternal(List<String> list, boolean z5) {
        int readTag;
        int readTag2;
        if (WireFormat.getTagWireType(this.tag) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        if (!(list instanceof LazyStringList) || z5) {
            do {
                list.add(z5 ? readStringRequireUtf8() : readString());
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        do {
            lazyStringList.add(readBytes());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void readStringListRequireUtf8(List<String> list) {
        readStringListInternal(list, true);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public String readStringRequireUtf8() {
        requireWireType(2);
        return this.input.readStringRequireUtf8();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public int readUInt32() {
        requireWireType(0);
        return this.input.readUInt32();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void readUInt32List(List<Integer> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof IntArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 0) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    list.add(Integer.valueOf(this.input.readUInt32()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
                return;
            }
            do {
                list.add(Integer.valueOf(this.input.readUInt32()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 0) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead2 = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                intArrayList.addInt(this.input.readUInt32());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            requirePosition(totalBytesRead2);
            return;
        }
        do {
            intArrayList.addInt(this.input.readUInt32());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public long readUInt64() {
        requireWireType(0);
        return this.input.readUInt64();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public void readUInt64List(List<Long> list) {
        int readTag;
        int readTag2;
        if (!(list instanceof LongArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.tag);
            if (tagWireType != 0) {
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int totalBytesRead = this.input.getTotalBytesRead() + this.input.readUInt32();
                do {
                    list.add(Long.valueOf(this.input.readUInt64()));
                } while (this.input.getTotalBytesRead() < totalBytesRead);
                requirePosition(totalBytesRead);
                return;
            }
            do {
                list.add(Long.valueOf(this.input.readUInt64()));
                if (this.input.isAtEnd()) {
                    return;
                } else {
                    readTag = this.input.readTag();
                }
            } while (readTag == this.tag);
            this.nextTag = readTag;
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.tag);
        if (tagWireType2 != 0) {
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead2 = this.input.getTotalBytesRead() + this.input.readUInt32();
            do {
                longArrayList.addLong(this.input.readUInt64());
            } while (this.input.getTotalBytesRead() < totalBytesRead2);
            requirePosition(totalBytesRead2);
            return;
        }
        do {
            longArrayList.addLong(this.input.readUInt64());
            if (this.input.isAtEnd()) {
                return;
            } else {
                readTag2 = this.input.readTag();
            }
        } while (readTag2 == this.tag);
        this.nextTag = readTag2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public boolean skipField() {
        int i5;
        if (this.input.isAtEnd() || (i5 = this.tag) == this.endGroupTag) {
            return false;
        }
        return this.input.skipField(i5);
    }

    private <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) {
        T newInstance = schema.newInstance();
        mergeMessageFieldInternal(newInstance, schema, extensionRegistryLite);
        schema.makeImmutable(newInstance);
        return newInstance;
    }
}
