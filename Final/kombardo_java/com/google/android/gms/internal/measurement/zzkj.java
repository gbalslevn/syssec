package com.google.android.gms.internal.measurement;

import com.adjust.sdk.Constants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class zzkj {
    static final Charset zza;
    public static final byte[] zzb;

    static {
        Charset.forName("US-ASCII");
        zza = Charset.forName(Constants.ENCODING);
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
        zzjk.zza(bArr, 0, bArr.length, false);
    }

    public static int zza(long j5) {
        return (int) (j5 ^ (j5 >>> 32));
    }

    public static int zza(boolean z5) {
        return z5 ? 1231 : 1237;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(zzlm zzlmVar) {
        return false;
    }

    public static int zza(byte[] bArr) {
        int length = bArr.length;
        int zza2 = zza(length, bArr, 0, length);
        if (zza2 == 0) {
            return 1;
        }
        return zza2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, byte[] bArr, int i6, int i7) {
        for (int i8 = i6; i8 < i6 + i7; i8++) {
            i5 = (i5 * 31) + bArr[i8];
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zza(T t5) {
        t5.getClass();
        return t5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zza(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }
}
