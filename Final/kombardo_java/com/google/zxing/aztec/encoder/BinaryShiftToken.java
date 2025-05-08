package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

/* loaded from: classes2.dex */
final class BinaryShiftToken extends Token {
    private final short binaryShiftByteCount;
    private final short binaryShiftStart;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BinaryShiftToken(Token token, int i5, int i6) {
        super(token);
        this.binaryShiftStart = (short) i5;
        this.binaryShiftByteCount = (short) i6;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    public void appendTo(BitArray bitArray, byte[] bArr) {
        int i5 = 0;
        while (true) {
            short s5 = this.binaryShiftByteCount;
            if (i5 >= s5) {
                return;
            }
            if (i5 == 0 || (i5 == 31 && s5 <= 62)) {
                bitArray.appendBits(31, 5);
                short s6 = this.binaryShiftByteCount;
                if (s6 > 62) {
                    bitArray.appendBits(s6 - 31, 16);
                } else if (i5 == 0) {
                    bitArray.appendBits(Math.min((int) s6, 31), 5);
                } else {
                    bitArray.appendBits(s6 - 31, 5);
                }
            }
            bitArray.appendBits(bArr[this.binaryShiftStart + i5], 8);
            i5++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.binaryShiftStart);
        sb.append("::");
        sb.append((this.binaryShiftStart + this.binaryShiftByteCount) - 1);
        sb.append('>');
        return sb.toString();
    }
}
