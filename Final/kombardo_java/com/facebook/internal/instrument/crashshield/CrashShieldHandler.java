package com.facebook.internal.instrument.crashshield;

import android.os.Handler;
import android.os.Looper;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J!\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u0010\u0010\u0011R8\u0010\u0015\u001a&\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00010\u0001 \u0013*\u0012\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00140\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/facebook/internal/instrument/crashshield/CrashShieldHandler;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "enable", BuildConfig.FLAVOR, "e", "o", "handleThrowable", "(Ljava/lang/Throwable;Ljava/lang/Object;)V", BuildConfig.FLAVOR, "isObjectCrashing", "(Ljava/lang/Object;)Z", "isDebug", "()Z", "scheduleCrashInDebug", "(Ljava/lang/Throwable;)V", BuildConfig.FLAVOR, "kotlin.jvm.PlatformType", BuildConfig.FLAVOR, "crashingObjects", "Ljava/util/Set;", "enabled", "Z", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class CrashShieldHandler {
    public static final CrashShieldHandler INSTANCE = new CrashShieldHandler();
    private static final Set<Object> crashingObjects = Collections.newSetFromMap(new WeakHashMap());
    private static boolean enabled;

    private CrashShieldHandler() {
    }

    public static final void enable() {
        enabled = true;
    }

    public static final void handleThrowable(Throwable e5, Object o5) {
        Intrinsics.checkNotNullParameter(o5, "o");
        if (enabled) {
            crashingObjects.add(o5);
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                ExceptionAnalyzer.execute(e5);
                InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                InstrumentData.Builder.build(e5, InstrumentData.Type.CrashShield).save();
            }
            scheduleCrashInDebug(e5);
        }
    }

    public static final boolean isDebug() {
        return false;
    }

    public static final boolean isObjectCrashing(Object o5) {
        Intrinsics.checkNotNullParameter(o5, "o");
        return crashingObjects.contains(o5);
    }

    public static final void scheduleCrashInDebug(final Throwable e5) {
        if (isDebug()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.internal.instrument.crashshield.CrashShieldHandler$scheduleCrashInDebug$1
                @Override // java.lang.Runnable
                public void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        throw new RuntimeException(e5);
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, this);
                    }
                }
            });
        }
    }
}
