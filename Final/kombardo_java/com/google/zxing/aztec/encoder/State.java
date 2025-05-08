package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class State {
    static final State INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
    private final int binaryShiftByteCount;
    private final int bitCount;
    private final int mode;
    private final Token token;

    private State(Token token, int i5, int i6, int i7) {
        this.token = token;
        this.mode = i5;
        this.binaryShiftByteCount = i6;
        this.bitCount = i7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State addBinaryShiftChar(int i5) {
        Token token = this.token;
        int i6 = this.mode;
        int i7 = this.bitCount;
        if (i6 == 4 || i6 == 2) {
            int i8 = HighLevelEncoder.LATCH_TABLE[i6][0];
            int i9 = 65535 & i8;
            int i10 = i8 >> 16;
            token = token.add(i9, i10);
            i7 += i10;
            i6 = 0;
        }
        int i11 = this.binaryShiftByteCount;
        State state = new State(token, i6, i11 + 1, i7 + ((i11 == 0 || i11 == 31) ? 18 : i11 == 62 ? 9 : 8));
        return state.binaryShiftByteCount == 2078 ? state.endBinaryShift(i5 + 1) : state;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State endBinaryShift(int i5) {
        int i6 = this.binaryShiftByteCount;
        return i6 == 0 ? this : new State(this.token.addBinaryShift(i5 - i6, i6), this.mode, 0, this.bitCount);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBinaryShiftByteCount() {
        return this.binaryShiftByteCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getBitCount() {
        return this.bitCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMode() {
        return this.mode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isBetterThanOrEqualTo(State state) {
        int i5;
        int i6 = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
        int i7 = state.binaryShiftByteCount;
        if (i7 > 0 && ((i5 = this.binaryShiftByteCount) == 0 || i5 > i7)) {
            i6 += 10;
        }
        return i6 <= state.bitCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State latchAndAppend(int i5, int i6) {
        int i7 = this.bitCount;
        Token token = this.token;
        int i8 = this.mode;
        if (i5 != i8) {
            int i9 = HighLevelEncoder.LATCH_TABLE[i8][i5];
            int i10 = 65535 & i9;
            int i11 = i9 >> 16;
            token = token.add(i10, i11);
            i7 += i11;
        }
        int i12 = i5 == 2 ? 4 : 5;
        return new State(token.add(i6, i12), i5, 0, i7 + i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public State shiftAndAppend(int i5, int i6) {
        Token token = this.token;
        int i7 = this.mode;
        int i8 = i7 == 2 ? 4 : 5;
        return new State(token.add(HighLevelEncoder.SHIFT_TABLE[i7][i5], i8).add(i6, 5), this.mode, 0, this.bitCount + i8 + 5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitArray toBitArray(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (Token token = endBinaryShift(bArr.length).token; token != null; token = token.getPrevious()) {
            linkedList.addFirst(token);
        }
        BitArray bitArray = new BitArray();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Token) it.next()).appendTo(bitArray, bArr);
        }
        return bitArray;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount));
    }
}
