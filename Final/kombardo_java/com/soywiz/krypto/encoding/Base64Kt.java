package com.soywiz.krypto.encoding;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0010\u0015\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {BuildConfig.FLAVOR, BuildConfig.FLAVOR, "toDecodeArray", "(Ljava/lang/String;)[I", "krypto_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class Base64Kt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int[] toDecodeArray(String str) {
        int[] iArr = new int[256];
        for (int i5 = 0; i5 < 256; i5++) {
            iArr[i5] = -1;
        }
        int length = str.length();
        for (int i6 = 0; i6 < length; i6++) {
            iArr[str.charAt(i6)] = i6;
        }
        return iArr;
    }
}
