package com.google.protobuf;

import com.google.protobuf.WireFormat;

/* loaded from: classes2.dex */
public class MapEntryLite<K, V> {
    private static final int KEY_FIELD_NUMBER = 1;
    private static final int VALUE_FIELD_NUMBER = 2;
    private final K key;
    private final Metadata<K, V> metadata;
    private final V value;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Metadata<K, V> {
        public final K defaultKey;
        public final V defaultValue;
        public final WireFormat.FieldType keyType;
        public final WireFormat.FieldType valueType;

        public Metadata(WireFormat.FieldType fieldType, K k5, WireFormat.FieldType fieldType2, V v5) {
            this.keyType = fieldType;
            this.defaultKey = k5;
            this.valueType = fieldType2;
            this.defaultValue = v5;
        }
    }

    private MapEntryLite(WireFormat.FieldType fieldType, K k5, WireFormat.FieldType fieldType2, V v5) {
        this.metadata = new Metadata<>(fieldType, k5, fieldType2, v5);
        this.key = k5;
        this.value = v5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int computeSerializedSize(Metadata<K, V> metadata, K k5, V v5) {
        return FieldSet.computeElementSize(metadata.keyType, 1, k5) + FieldSet.computeElementSize(metadata.valueType, 2, v5);
    }

    public static <K, V> MapEntryLite<K, V> newDefaultInstance(WireFormat.FieldType fieldType, K k5, WireFormat.FieldType fieldType2, V v5) {
        return new MapEntryLite<>(fieldType, k5, fieldType2, v5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void writeTo(CodedOutputStream codedOutputStream, Metadata<K, V> metadata, K k5, V v5) {
        FieldSet.writeElement(codedOutputStream, metadata.keyType, 1, k5);
        FieldSet.writeElement(codedOutputStream, metadata.valueType, 2, v5);
    }

    public int computeMessageSize(int i5, K k5, V v5) {
        return CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSerializedSize(this.metadata, k5, v5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Metadata<K, V> getMetadata() {
        return this.metadata;
    }
}
