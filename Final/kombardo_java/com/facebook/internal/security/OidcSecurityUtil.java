package com.facebook.internal.security;

import android.util.Base64;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.facebook.FacebookSdk;
import com.facebook.internal.security.OidcSecurityUtil;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u00048\u0006X\u0086D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/facebook/internal/security/OidcSecurityUtil;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "kid", "getRawKeyFromEndPoint", "(Ljava/lang/String;)Ljava/lang/String;", "key", "Ljava/security/PublicKey;", "getPublicKeyFromString", "(Ljava/lang/String;)Ljava/security/PublicKey;", "publicKey", "data", "signature", BuildConfig.FLAVOR, "verify", "(Ljava/security/PublicKey;Ljava/lang/String;Ljava/lang/String;)Z", "OPENID_KEYS_PATH", "Ljava/lang/String;", "getOPENID_KEYS_PATH", "()Ljava/lang/String;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class OidcSecurityUtil {
    public static final OidcSecurityUtil INSTANCE = new OidcSecurityUtil();
    private static final String OPENID_KEYS_PATH = "/.well-known/oauth/openid/keys/";

    private OidcSecurityUtil() {
    }

    public static final PublicKey getPublicKeyFromString(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        byte[] decode = Base64.decode(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(key, "\n", BuildConfig.FLAVOR, false, 4, (Object) null), "-----BEGIN PUBLIC KEY-----", BuildConfig.FLAVOR, false, 4, (Object) null), "-----END PUBLIC KEY-----", BuildConfig.FLAVOR, false, 4, (Object) null), 0);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(pubKeyString, Base64.DEFAULT)");
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decode));
        Intrinsics.checkNotNullExpressionValue(generatePublic, "kf.generatePublic(x509publicKey)");
        return generatePublic;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final String getRawKeyFromEndPoint(final String kid) {
        Intrinsics.checkNotNullParameter(kid, "kid");
        final URL url = new URL(Constants.SCHEME, Intrinsics.stringPlus("www.", FacebookSdk.getFacebookDomain()), OPENID_KEYS_PATH);
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition newCondition = reentrantLock.newCondition();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        FacebookSdk.getExecutor().execute(new Runnable() { // from class: t0.a
            @Override // java.lang.Runnable
            public final void run() {
                OidcSecurityUtil.m2885getRawKeyFromEndPoint$lambda1(url, ref$ObjectRef, kid, reentrantLock, newCondition);
            }
        });
        reentrantLock.lock();
        try {
            newCondition.await(5000L, TimeUnit.MILLISECONDS);
            reentrantLock.unlock();
            return (String) ref$ObjectRef.element;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.String] */
    /* renamed from: getRawKeyFromEndPoint$lambda-1, reason: not valid java name */
    public static final void m2885getRawKeyFromEndPoint$lambda1(URL openIdKeyUrl, Ref$ObjectRef result, String kid, ReentrantLock lock, Condition condition) {
        Intrinsics.checkNotNullParameter(openIdKeyUrl, "$openIdKeyUrl");
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(kid, "$kid");
        Intrinsics.checkNotNullParameter(lock, "$lock");
        URLConnection openConnection = openIdKeyUrl.openConnection();
        if (openConnection == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        try {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream, "connection.inputStream");
                String readText = TextStreamsKt.readText(new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8), 8192));
                httpURLConnection.getInputStream().close();
                result.element = new JSONObject(readText).optString(kid);
                httpURLConnection.disconnect();
                lock.lock();
            } catch (Exception e5) {
                String name = INSTANCE.getClass().getName();
                String message = e5.getMessage();
                if (message == null) {
                    message = "Error getting public key";
                }
                Log.d(name, message);
                httpURLConnection.disconnect();
                lock.lock();
                try {
                    condition.signal();
                    Unit unit = Unit.INSTANCE;
                } finally {
                }
            }
            try {
                condition.signal();
                Unit unit2 = Unit.INSTANCE;
            } finally {
            }
        } catch (Throwable th) {
            httpURLConnection.disconnect();
            lock.lock();
            try {
                condition.signal();
                Unit unit3 = Unit.INSTANCE;
                throw th;
            } finally {
            }
        }
    }

    public static final boolean verify(PublicKey publicKey, String data, String signature) {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(signature, "signature");
        try {
            Signature signature2 = Signature.getInstance("SHA256withRSA");
            signature2.initVerify(publicKey);
            byte[] bytes = data.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            signature2.update(bytes);
            byte[] decode = Base64.decode(signature, 8);
            Intrinsics.checkNotNullExpressionValue(decode, "decode(signature, Base64.URL_SAFE)");
            return signature2.verify(decode);
        } catch (Exception unused) {
            return false;
        }
    }
}
