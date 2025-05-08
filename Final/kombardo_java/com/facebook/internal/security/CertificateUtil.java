package com.facebook.internal.security;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/facebook/internal/security/CertificateUtil;", BuildConfig.FLAVOR, "<init>", "()V", "Landroid/content/Context;", "ctx", BuildConfig.FLAVOR, "getCertificateHash", "(Landroid/content/Context;)Ljava/lang/String;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class CertificateUtil {
    public static final CertificateUtil INSTANCE = new CertificateUtil();

    private CertificateUtil() {
    }

    public static final String getCertificateHash(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        try {
            Signature[] signatures = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), 64).signatures;
            StringBuilder sb = new StringBuilder();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            Intrinsics.checkNotNullExpressionValue(signatures, "signatures");
            int length = signatures.length;
            int i5 = 0;
            while (i5 < length) {
                Signature signature = signatures[i5];
                i5++;
                messageDigest.update(signature.toByteArray());
                sb.append(Base64.encodeToString(messageDigest.digest(), 0));
                sb.append(":");
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
            return sb2;
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            return BuildConfig.FLAVOR;
        }
    }
}
