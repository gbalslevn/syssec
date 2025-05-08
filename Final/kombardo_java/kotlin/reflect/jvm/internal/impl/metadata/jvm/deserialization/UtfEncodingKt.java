package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class UtfEncodingKt {
    public static final byte[] stringsToBytes(String[] strings) {
        Intrinsics.checkNotNullParameter(strings, "strings");
        int i5 = 0;
        for (String str : strings) {
            i5 += str.length();
        }
        byte[] bArr = new byte[i5];
        int i6 = 0;
        for (String str2 : strings) {
            int length = str2.length();
            int i7 = 0;
            while (i7 < length) {
                bArr[i6] = (byte) str2.charAt(i7);
                i7++;
                i6++;
            }
        }
        return bArr;
    }
}
