package com.google.protobuf;

import android.support.v4.media.session.a;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class MessageSetSchema<T> implements Schema<T> {
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;

    private MessageSetSchema(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite messageLite) {
        this.unknownFieldSchema = unknownFieldSchema;
        this.hasExtensions = extensionSchema.hasExtensions(messageLite);
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t5) {
        return unknownFieldSchema.getSerializedSizeAsMessageSet(unknownFieldSchema.getFromMessage(t5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> MessageSetSchema<T> newSchema(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite messageLite) {
        return new MessageSetSchema<>(unknownFieldSchema, extensionSchema, messageLite);
    }

    private <UT, UB> void writeUnknownFieldsHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t5, Writer writer) {
        unknownFieldSchema.writeAsMessageSetTo(unknownFieldSchema.getFromMessage(t5), writer);
    }

    @Override // com.google.protobuf.Schema
    public boolean equals(T t5, T t6) {
        if (!this.unknownFieldSchema.getFromMessage(t5).equals(this.unknownFieldSchema.getFromMessage(t6))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t5).equals(this.extensionSchema.getExtensions(t6));
        }
        return true;
    }

    @Override // com.google.protobuf.Schema
    public int getSerializedSize(T t5) {
        int unknownFieldsSerializedSize = getUnknownFieldsSerializedSize(this.unknownFieldSchema, t5);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t5).getMessageSetSerializedSize() : unknownFieldsSerializedSize;
    }

    @Override // com.google.protobuf.Schema
    public int hashCode(T t5) {
        int hashCode = this.unknownFieldSchema.getFromMessage(t5).hashCode();
        return this.hasExtensions ? (hashCode * 53) + this.extensionSchema.getExtensions(t5).hashCode() : hashCode;
    }

    @Override // com.google.protobuf.Schema
    public final boolean isInitialized(T t5) {
        return this.extensionSchema.getExtensions(t5).isInitialized();
    }

    @Override // com.google.protobuf.Schema
    public void makeImmutable(T t5) {
        this.unknownFieldSchema.makeImmutable(t5);
        this.extensionSchema.makeImmutable(t5);
    }

    @Override // com.google.protobuf.Schema
    public void mergeFrom(T t5, T t6) {
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t5, t6);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t5, t6);
        }
    }

    @Override // com.google.protobuf.Schema
    public T newInstance() {
        MessageLite messageLite = this.defaultInstance;
        return messageLite instanceof GeneratedMessageLite ? (T) ((GeneratedMessageLite) messageLite).newMutableInstance() : (T) messageLite.newBuilderForType().buildPartial();
    }

    @Override // com.google.protobuf.Schema
    public void writeTo(T t5, Writer writer) {
        Iterator<Map.Entry<?, Object>> it = this.extensionSchema.getExtensions(t5).iterator();
        if (it.hasNext()) {
            a.a(it.next().getKey());
            throw null;
        }
        writeUnknownFieldsHelper(this.unknownFieldSchema, t5, writer);
    }
}
