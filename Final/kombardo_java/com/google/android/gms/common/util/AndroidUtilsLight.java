package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import com.google.android.gms.common.wrappers.Wrappers;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public abstract class AndroidUtilsLight {
    private static volatile int zza = -1;

    @Deprecated
    public static byte[] getPackageCertificateHashBytes(Context context, String str) {
        MessageDigest zza2;
        PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1 || (zza2 = zza("SHA1")) == null) {
            return null;
        }
        return zza2.digest(packageInfo.signatures[0].toByteArray());
    }

    public static MessageDigest zza(String str) {
        MessageDigest messageDigest;
        for (int i5 = 0; i5 < 2; i5++) {
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }
}
