package com.google.zxing;

import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* loaded from: classes2.dex */
public interface Writer {
    BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i5, int i6, Map<EncodeHintType, ?> map);
}
