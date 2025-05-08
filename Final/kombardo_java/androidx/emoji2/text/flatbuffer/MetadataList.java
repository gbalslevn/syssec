package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public final class MetadataList extends Table {
    public static MetadataList getRootAsMetadataList(ByteBuffer byteBuffer) {
        return getRootAsMetadataList(byteBuffer, new MetadataList());
    }

    public MetadataList __assign(int i5, ByteBuffer byteBuffer) {
        __init(i5, byteBuffer);
        return this;
    }

    public void __init(int i5, ByteBuffer byteBuffer) {
        __reset(i5, byteBuffer);
    }

    public MetadataItem list(MetadataItem metadataItem, int i5) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return metadataItem.__assign(__indirect(__vector(__offset) + (i5 * 4)), this.bb);
        }
        return null;
    }

    public int listLength() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public int version() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return this.bb.getInt(__offset + this.bb_pos);
        }
        return 0;
    }

    public static MetadataList getRootAsMetadataList(ByteBuffer byteBuffer, MetadataList metadataList) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return metadataList.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }
}
