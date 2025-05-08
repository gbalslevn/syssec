package com.soywiz.krypto.internal;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001a7\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {BuildConfig.FLAVOR, "src", BuildConfig.FLAVOR, "srcPos", "dst", "dstPos", "count", "arraycopy", "([BI[BII)[B", "krypto_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class KryptoToolsKt {
    public static final byte[] arraycopy(byte[] bArr, int i5, byte[] bArr2, int i6, int i7) {
        return ArraysKt.copyInto(bArr, bArr2, i6, i5, i7 + i5);
    }
}
