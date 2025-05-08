package androidx.emoji2.text;

import androidx.emoji2.text.flatbuffer.MetadataList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
abstract class MetadataListReader {
    private static final int EMJI_TAG = 1164798569;
    private static final int EMJI_TAG_DEPRECATED = 1701669481;
    private static final int META_TABLE_NAME = 1835365473;

    /* loaded from: classes.dex */
    private static class ByteBufferReader implements OpenTypeReader {
        private final ByteBuffer mByteBuffer;

        ByteBufferReader(ByteBuffer byteBuffer) {
            this.mByteBuffer = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long getPosition() {
            return this.mByteBuffer.position();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readTag() {
            return this.mByteBuffer.getInt();
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public long readUnsignedInt() {
            return MetadataListReader.toUnsignedInt(this.mByteBuffer.getInt());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public int readUnsignedShort() {
            return MetadataListReader.toUnsignedShort(this.mByteBuffer.getShort());
        }

        @Override // androidx.emoji2.text.MetadataListReader.OpenTypeReader
        public void skip(int i5) {
            ByteBuffer byteBuffer = this.mByteBuffer;
            byteBuffer.position(byteBuffer.position() + i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class OffsetInfo {
        private final long mLength;
        private final long mStartOffset;

        OffsetInfo(long j5, long j6) {
            this.mStartOffset = j5;
            this.mLength = j6;
        }

        long getStartOffset() {
            return this.mStartOffset;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface OpenTypeReader {
        long getPosition();

        int readTag();

        long readUnsignedInt();

        int readUnsignedShort();

        void skip(int i5);
    }

    private static OffsetInfo findOffsetInfo(OpenTypeReader openTypeReader) {
        long j5;
        openTypeReader.skip(4);
        int readUnsignedShort = openTypeReader.readUnsignedShort();
        if (readUnsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        openTypeReader.skip(6);
        int i5 = 0;
        while (true) {
            if (i5 >= readUnsignedShort) {
                j5 = -1;
                break;
            }
            int readTag = openTypeReader.readTag();
            openTypeReader.skip(4);
            j5 = openTypeReader.readUnsignedInt();
            openTypeReader.skip(4);
            if (META_TABLE_NAME == readTag) {
                break;
            }
            i5++;
        }
        if (j5 != -1) {
            openTypeReader.skip((int) (j5 - openTypeReader.getPosition()));
            openTypeReader.skip(12);
            long readUnsignedInt = openTypeReader.readUnsignedInt();
            for (int i6 = 0; i6 < readUnsignedInt; i6++) {
                int readTag2 = openTypeReader.readTag();
                long readUnsignedInt2 = openTypeReader.readUnsignedInt();
                long readUnsignedInt3 = openTypeReader.readUnsignedInt();
                if (EMJI_TAG == readTag2 || EMJI_TAG_DEPRECATED == readTag2) {
                    return new OffsetInfo(readUnsignedInt2 + j5, readUnsignedInt3);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MetadataList read(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position((int) findOffsetInfo(new ByteBufferReader(duplicate)).getStartOffset());
        return MetadataList.getRootAsMetadataList(duplicate);
    }

    static long toUnsignedInt(int i5) {
        return i5 & 4294967295L;
    }

    static int toUnsignedShort(short s5) {
        return s5 & 65535;
    }
}
