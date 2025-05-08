package androidx.datastore.preferences.protobuf;

import android.support.v4.media.session.a;
import androidx.datastore.preferences.protobuf.FieldSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
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

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T t5, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        UB builderFromMessage = unknownFieldSchema.getBuilderFromMessage(t5);
        FieldSet<ET> mutableExtensions = extensionSchema.getMutableExtensions(t5);
        do {
            try {
                if (reader.getFieldNumber() == Integer.MAX_VALUE) {
                    return;
                }
            } finally {
                unknownFieldSchema.setBuilderToMessage(t5, builderFromMessage);
            }
        } while (parseMessageSetItemOrUnknownField(reader, extensionRegistryLite, extensionSchema, mutableExtensions, unknownFieldSchema, builderFromMessage));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> MessageSetSchema<T> newSchema(UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MessageLite messageLite) {
        return new MessageSetSchema<>(unknownFieldSchema, extensionSchema, messageLite);
    }

    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean parseMessageSetItemOrUnknownField(Reader reader, ExtensionRegistryLite extensionRegistryLite, ExtensionSchema<ET> extensionSchema, FieldSet<ET> fieldSet, UnknownFieldSchema<UT, UB> unknownFieldSchema, UB ub) {
        int tag = reader.getTag();
        int i5 = 0;
        if (tag != WireFormat.MESSAGE_SET_ITEM_TAG) {
            if (WireFormat.getTagWireType(tag) != 2) {
                return reader.skipField();
            }
            Object findExtensionByNumber = extensionSchema.findExtensionByNumber(extensionRegistryLite, this.defaultInstance, WireFormat.getTagFieldNumber(tag));
            if (findExtensionByNumber == null) {
                return unknownFieldSchema.mergeOneFieldFrom(ub, reader, 0);
            }
            extensionSchema.parseLengthPrefixedMessageSetItem(reader, findExtensionByNumber, extensionRegistryLite, fieldSet);
            return true;
        }
        Object obj = null;
        ByteString byteString = null;
        while (reader.getFieldNumber() != Integer.MAX_VALUE) {
            int tag2 = reader.getTag();
            if (tag2 == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
                i5 = reader.readUInt32();
                obj = extensionSchema.findExtensionByNumber(extensionRegistryLite, this.defaultInstance, i5);
            } else if (tag2 == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
                if (obj != null) {
                    extensionSchema.parseLengthPrefixedMessageSetItem(reader, obj, extensionRegistryLite, fieldSet);
                } else {
                    byteString = reader.readBytes();
                }
            } else if (!reader.skipField()) {
                break;
            }
        }
        if (reader.getTag() != WireFormat.MESSAGE_SET_ITEM_END_TAG) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        if (byteString != null) {
            if (obj != null) {
                extensionSchema.parseMessageSetItem(byteString, obj, extensionRegistryLite, fieldSet);
            } else {
                unknownFieldSchema.addLengthDelimited(ub, i5, byteString);
            }
        }
        return true;
    }

    private <UT, UB> void writeUnknownFieldsHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t5, Writer writer) {
        unknownFieldSchema.writeAsMessageSetTo(unknownFieldSchema.getFromMessage(t5), writer);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public boolean equals(T t5, T t6) {
        if (!this.unknownFieldSchema.getFromMessage(t5).equals(this.unknownFieldSchema.getFromMessage(t6))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t5).equals(this.extensionSchema.getExtensions(t6));
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public int getSerializedSize(T t5) {
        int unknownFieldsSerializedSize = getUnknownFieldsSerializedSize(this.unknownFieldSchema, t5);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t5).getMessageSetSerializedSize() : unknownFieldsSerializedSize;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public int hashCode(T t5) {
        int hashCode = this.unknownFieldSchema.getFromMessage(t5).hashCode();
        return this.hasExtensions ? (hashCode * 53) + this.extensionSchema.getExtensions(t5).hashCode() : hashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final boolean isInitialized(T t5) {
        return this.extensionSchema.getExtensions(t5).isInitialized();
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void makeImmutable(T t5) {
        this.unknownFieldSchema.makeImmutable(t5);
        this.extensionSchema.makeImmutable(t5);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T t5, T t6) {
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t5, t6);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t5, t6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public T newInstance() {
        MessageLite messageLite = this.defaultInstance;
        return messageLite instanceof GeneratedMessageLite ? (T) ((GeneratedMessageLite) messageLite).newMutableInstance() : (T) messageLite.newBuilderForType().buildPartial();
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void writeTo(T t5, Writer writer) {
        Iterator<Map.Entry<?, Object>> it = this.extensionSchema.getExtensions(t5).iterator();
        if (it.hasNext()) {
            a.a(it.next().getKey());
            throw null;
        }
        writeUnknownFieldsHelper(this.unknownFieldSchema, t5, writer);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T t5, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t5, reader, extensionRegistryLite);
    }
}
