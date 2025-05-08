package com.google.firebase.encoders.proto;

import java.io.OutputStream;

/* loaded from: classes2.dex */
final class LengthCountingOutputStream extends OutputStream {
    private long length = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public long getLength() {
        return this.length;
    }

    @Override // java.io.OutputStream
    public void write(int i5) {
        this.length++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.length += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) {
        int i7;
        if (i5 >= 0 && i5 <= bArr.length && i6 >= 0 && (i7 = i5 + i6) <= bArr.length && i7 >= 0) {
            this.length += i6;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
