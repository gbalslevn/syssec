package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitMatrix;

/* loaded from: classes2.dex */
public final class AztecCode {
    private int codeWords;
    private boolean compact;
    private int layers;
    private BitMatrix matrix;
    private int size;

    public BitMatrix getMatrix() {
        return this.matrix;
    }

    public void setCodeWords(int i5) {
        this.codeWords = i5;
    }

    public void setCompact(boolean z5) {
        this.compact = z5;
    }

    public void setLayers(int i5) {
        this.layers = i5;
    }

    public void setMatrix(BitMatrix bitMatrix) {
        this.matrix = bitMatrix;
    }

    public void setSize(int i5) {
        this.size = i5;
    }
}
