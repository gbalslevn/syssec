package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0003J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/facebook/appevents/internal/AppEventUtility;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "assertIsNotMainThread", "assertIsMainThread", BuildConfig.FLAVOR, "value", BuildConfig.FLAVOR, "normalizePrice", "(Ljava/lang/String;)D", BuildConfig.FLAVOR, "bytes", "bytesToHex", "([B)Ljava/lang/String;", BuildConfig.FLAVOR, "isEmulator", "()Z", "getAppVersion", "()Ljava/lang/String;", "Landroid/app/Activity;", "activity", "Landroid/view/View;", "getRootView", "(Landroid/app/Activity;)Landroid/view/View;", "PRICE_REGEX", "Ljava/lang/String;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AppEventUtility {
    public static final AppEventUtility INSTANCE = new AppEventUtility();
    private static final String PRICE_REGEX = "[-+]*\\d+([.,]\\d+)*([.,]\\d+)?";

    private AppEventUtility() {
    }

    public static final void assertIsMainThread() {
    }

    public static final void assertIsNotMainThread() {
    }

    public static final String bytesToHex(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        StringBuffer stringBuffer = new StringBuffer();
        int length = bytes.length;
        int i5 = 0;
        while (i5 < length) {
            byte b5 = bytes[i5];
            i5++;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b5)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            stringBuffer.append(format);
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "sb.toString()");
        return stringBuffer2;
    }

    public static final String getAppVersion() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        try {
            String str = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
            Intrinsics.checkNotNullExpressionValue(str, "{\n      val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)\n      packageInfo.versionName\n    }");
            return str;
        } catch (PackageManager.NameNotFoundException unused) {
            return BuildConfig.FLAVOR;
        }
    }

    public static final View getRootView(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(AppEventUtility.class) || activity == null) {
            return null;
        }
        try {
            Window window = activity.getWindow();
            if (window == null) {
                return null;
            }
            return window.getDecorView().getRootView();
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, AppEventUtility.class);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        if (kotlin.text.StringsKt.startsWith$default(r0, "generic", false, 2, (java.lang.Object) null) == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isEmulator() {
        String FINGERPRINT = Build.FINGERPRINT;
        Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
        if (!StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
            Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
            if (!StringsKt.startsWith$default(FINGERPRINT, "unknown", false, 2, (Object) null)) {
                String MODEL = Build.MODEL;
                Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
                    Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                    if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "Emulator", false, 2, (Object) null)) {
                        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
                        if (!StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
                            String MANUFACTURER = Build.MANUFACTURER;
                            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                            if (!StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
                                String BRAND = Build.BRAND;
                                Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
                                if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
                                    String DEVICE = Build.DEVICE;
                                    Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
                                }
                                if (!Intrinsics.areEqual("google_sdk", Build.PRODUCT)) {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static final double normalizePrice(String value) {
        try {
            Matcher matcher = Pattern.compile(PRICE_REGEX, 8).matcher(value);
            if (!matcher.find()) {
                return 0.0d;
            }
            return NumberFormat.getNumberInstance(Utility.getCurrentLocale()).parse(matcher.group(0)).doubleValue();
        } catch (ParseException unused) {
            return 0.0d;
        }
    }
}
