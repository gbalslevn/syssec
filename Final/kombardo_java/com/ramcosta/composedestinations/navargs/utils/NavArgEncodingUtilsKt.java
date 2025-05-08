package com.ramcosta.composedestinations.navargs.utils;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.util.Base64;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0001H\u0007\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0004H\u0007\"\u0010\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"encodeForRoute", BuildConfig.FLAVOR, "arg", "base64ToByteArray", BuildConfig.FLAVOR, "toBase64Str", "isRunningOnUnitTests", BuildConfig.FLAVOR, "shouldUseJavaUtil", "compose-destinations_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class NavArgEncodingUtilsKt {

    @SuppressLint({"ObsoleteSdkInt"})
    private static final boolean isRunningOnUnitTests = false;
    private static final boolean shouldUseJavaUtil = true;

    @SuppressLint({"NewApi"})
    public static final byte[] base64ToByteArray(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!shouldUseJavaUtil) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes = str.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] decode = Base64.decode(bytes, 10);
            Intrinsics.checkNotNull(decode);
            return decode;
        }
        Base64.Decoder urlDecoder = java.util.Base64.getUrlDecoder();
        Charset UTF_82 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
        byte[] bytes2 = str.getBytes(UTF_82);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        byte[] decode2 = urlDecoder.decode(bytes2);
        Intrinsics.checkNotNull(decode2);
        return decode2;
    }

    public static final String encodeForRoute(String arg) {
        Intrinsics.checkNotNullParameter(arg, "arg");
        if (isRunningOnUnitTests) {
            String encode = URLEncoder.encode(arg, StandardCharsets.UTF_8.toString());
            Intrinsics.checkNotNull(encode);
            return encode;
        }
        String encode2 = Uri.encode(arg);
        Intrinsics.checkNotNull(encode2);
        return encode2;
    }

    @SuppressLint({"NewApi"})
    public static final String toBase64Str(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (shouldUseJavaUtil) {
            String encodeToString = java.util.Base64.getUrlEncoder().encodeToString(bArr);
            Intrinsics.checkNotNull(encodeToString);
            return encodeToString;
        }
        String encodeToString2 = android.util.Base64.encodeToString(bArr, 10);
        Intrinsics.checkNotNull(encodeToString2);
        return encodeToString2;
    }
}
