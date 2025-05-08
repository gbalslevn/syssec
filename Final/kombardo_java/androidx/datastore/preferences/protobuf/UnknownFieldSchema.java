package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class UnknownFieldSchema<T, B> {
    private static volatile int recursionLimit = 100;

    private final void mergeFrom(B b5, Reader reader, int i5) {
        while (reader.getFieldNumber() != Integer.MAX_VALUE && mergeOneFieldFrom(b5, reader, i5)) {
        }
    }

    abstract void addFixed32(B b5, int i5, int i6);

    abstract void addFixed64(B b5, int i5, long j5);

    abstract void addGroup(B b5, int i5, T t5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void addLengthDelimited(B b5, int i5, ByteString byteString);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void addVarint(B b5, int i5, long j5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B getBuilderFromMessage(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T getFromMessage(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getSerializedSize(T t5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getSerializedSizeAsMessageSet(T t5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void makeImmutable(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T merge(T t5, T t6);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean mergeOneFieldFrom(B b5, Reader reader, int i5) {
        int tag = reader.getTag();
        int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType == 0) {
            addVarint(b5, tagFieldNumber, reader.readInt64());
            return true;
        }
        if (tagWireType == 1) {
            addFixed64(b5, tagFieldNumber, reader.readFixed64());
            return true;
        }
        if (tagWireType == 2) {
            addLengthDelimited(b5, tagFieldNumber, reader.readBytes());
            return true;
        }
        if (tagWireType != 3) {
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            addFixed32(b5, tagFieldNumber, reader.readFixed32());
            return true;
        }
        B newBuilder = newBuilder();
        int makeTag = WireFormat.makeTag(tagFieldNumber, 4);
        int i6 = i5 + 1;
        if (i6 >= recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        mergeFrom(newBuilder, reader, i6);
        if (makeTag != reader.getTag()) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        addGroup(b5, tagFieldNumber, toImmutable(newBuilder));
        return true;
    }

    abstract B newBuilder();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setBuilderToMessage(Object obj, B b5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void setToMessage(Object obj, T t5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean shouldDiscardUnknownFields(Reader reader);

    abstract T toImmutable(B b5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeAsMessageSetTo(T t5, Writer writer);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeTo(T t5, Writer writer);
}
