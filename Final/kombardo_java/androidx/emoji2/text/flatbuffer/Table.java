package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class Table {
    protected ByteBuffer bb;
    protected int bb_pos;
    Utf8 utf8 = Utf8.getDefault();
    private int vtable_size;
    private int vtable_start;

    /* JADX INFO: Access modifiers changed from: protected */
    public int __indirect(int i5) {
        return i5 + this.bb.getInt(i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int __offset(int i5) {
        if (i5 < this.vtable_size) {
            return this.bb.getShort(this.vtable_start + i5);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void __reset(int i5, ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        if (byteBuffer == null) {
            this.bb_pos = 0;
            this.vtable_start = 0;
            this.vtable_size = 0;
        } else {
            this.bb_pos = i5;
            int i6 = i5 - byteBuffer.getInt(i5);
            this.vtable_start = i6;
            this.vtable_size = this.bb.getShort(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int __vector(int i5) {
        int i6 = i5 + this.bb_pos;
        return i6 + this.bb.getInt(i6) + 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int __vector_len(int i5) {
        int i6 = i5 + this.bb_pos;
        return this.bb.getInt(i6 + this.bb.getInt(i6));
    }
}
