package com.google.zxing.datamatrix.encoder;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.zxing.Dimension;

/* loaded from: classes2.dex */
public class SymbolInfo {
    static final SymbolInfo[] PROD_SYMBOLS;
    private static SymbolInfo[] symbols;
    private final int dataCapacity;
    private final int dataRegions;
    private final int errorCodewords;
    public final int matrixHeight;
    public final int matrixWidth;
    private final boolean rectangular;
    private final int rsBlockData;
    private final int rsBlockError;

    static {
        SymbolInfo[] symbolInfoArr = {new SymbolInfo(false, 3, 5, 8, 8, 1), new SymbolInfo(false, 5, 7, 10, 10, 1), new SymbolInfo(true, 5, 7, 16, 6, 1), new SymbolInfo(false, 8, 10, 12, 12, 1), new SymbolInfo(true, 10, 11, 14, 6, 2), new SymbolInfo(false, 12, 12, 14, 14, 1), new SymbolInfo(true, 16, 14, 24, 10, 1), new SymbolInfo(false, 18, 14, 16, 16, 1), new SymbolInfo(false, 22, 18, 18, 18, 1), new SymbolInfo(true, 22, 18, 16, 10, 2), new SymbolInfo(false, 30, 20, 20, 20, 1), new SymbolInfo(true, 32, 24, 16, 14, 2), new SymbolInfo(false, 36, 24, 22, 22, 1), new SymbolInfo(false, 44, 28, 24, 24, 1), new SymbolInfo(true, 49, 28, 22, 14, 2), new SymbolInfo(false, 62, 36, 14, 14, 4), new SymbolInfo(false, 86, 42, 16, 16, 4), new SymbolInfo(false, 114, 48, 18, 18, 4), new SymbolInfo(false, 144, 56, 20, 20, 4), new SymbolInfo(false, 174, 68, 22, 22, 4), new SymbolInfo(false, 204, 84, 24, 24, 4, 102, 42), new SymbolInfo(false, 280, 112, 14, 14, 16, 140, 56), new SymbolInfo(false, 368, 144, 16, 16, 16, 92, 36), new SymbolInfo(false, 456, 192, 18, 18, 16, 114, 48), new SymbolInfo(false, 576, 224, 20, 20, 16, 144, 56), new SymbolInfo(false, 696, 272, 22, 22, 16, 174, 68), new SymbolInfo(false, 816, 336, 24, 24, 16, ModuleDescriptor.MODULE_VERSION, 56), new SymbolInfo(false, 1050, 408, 18, 18, 36, 175, 68), new SymbolInfo(false, 1304, 496, 20, 20, 36, 163, 62), new DataMatrixSymbolInfo144()};
        PROD_SYMBOLS = symbolInfoArr;
        symbols = symbolInfoArr;
    }

    public SymbolInfo(boolean z5, int i5, int i6, int i7, int i8, int i9) {
        this(z5, i5, i6, i7, i8, i9, i5, i6);
    }

    private int getHorizontalDataRegions() {
        int i5 = this.dataRegions;
        int i6 = 1;
        if (i5 != 1) {
            i6 = 2;
            if (i5 != 2 && i5 != 4) {
                if (i5 == 16) {
                    return 4;
                }
                if (i5 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i6;
    }

    private int getVerticalDataRegions() {
        int i5 = this.dataRegions;
        if (i5 == 1 || i5 == 2) {
            return 1;
        }
        if (i5 == 4) {
            return 2;
        }
        if (i5 == 16) {
            return 4;
        }
        if (i5 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public static SymbolInfo lookup(int i5, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2, boolean z5) {
        for (SymbolInfo symbolInfo : symbols) {
            if (!(symbolShapeHint == SymbolShapeHint.FORCE_SQUARE && symbolInfo.rectangular) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || symbolInfo.rectangular) && i5 <= symbolInfo.dataCapacity)) {
                return symbolInfo;
            }
        }
        if (z5) {
            throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i5)));
        }
        return null;
    }

    public final int getDataCapacity() {
        return this.dataCapacity;
    }

    public int getDataLengthForInterleavedBlock(int i5) {
        return this.rsBlockData;
    }

    public final int getErrorCodewords() {
        return this.errorCodewords;
    }

    public final int getErrorLengthForInterleavedBlock(int i5) {
        return this.rsBlockError;
    }

    public int getInterleavedBlockCount() {
        return this.dataCapacity / this.rsBlockData;
    }

    public final int getSymbolDataHeight() {
        return getVerticalDataRegions() * this.matrixHeight;
    }

    public final int getSymbolDataWidth() {
        return getHorizontalDataRegions() * this.matrixWidth;
    }

    public final int getSymbolHeight() {
        return getSymbolDataHeight() + (getVerticalDataRegions() << 1);
    }

    public final int getSymbolWidth() {
        return getSymbolDataWidth() + (getHorizontalDataRegions() << 1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.rectangular ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.matrixWidth);
        sb.append('x');
        sb.append(this.matrixHeight);
        sb.append(", symbol size ");
        sb.append(getSymbolWidth());
        sb.append('x');
        sb.append(getSymbolHeight());
        sb.append(", symbol data size ");
        sb.append(getSymbolDataWidth());
        sb.append('x');
        sb.append(getSymbolDataHeight());
        sb.append(", codewords ");
        sb.append(this.dataCapacity);
        sb.append('+');
        sb.append(this.errorCodewords);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SymbolInfo(boolean z5, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        this.rectangular = z5;
        this.dataCapacity = i5;
        this.errorCodewords = i6;
        this.matrixWidth = i7;
        this.matrixHeight = i8;
        this.dataRegions = i9;
        this.rsBlockData = i10;
        this.rsBlockError = i11;
    }
}
