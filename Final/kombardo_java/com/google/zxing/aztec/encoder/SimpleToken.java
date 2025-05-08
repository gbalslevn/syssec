package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

/* loaded from: classes2.dex */
final class SimpleToken extends Token {
    private final short bitCount;
    private final short value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleToken(Token token, int i5, int i6) {
        super(token);
        this.value = (short) i5;
        this.bitCount = (short) i6;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    void appendTo(BitArray bitArray, byte[] bArr) {
        bitArray.appendBits(this.value, this.bitCount);
    }

    public String toString() {
        short s5 = this.value;
        short s6 = this.bitCount;
        return "<" + Integer.toBinaryString((s5 & ((1 << s6) - 1)) | (1 << s6) | (1 << this.bitCount)).substring(1) + '>';
    }
}
