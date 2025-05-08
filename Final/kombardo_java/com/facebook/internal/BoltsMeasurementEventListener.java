package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u001c\u0010\t\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/BoltsMeasurementEventListener;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "applicationContext", "close", BuildConfig.FLAVOR, "finalize", "onReceive", "intent", "Landroid/content/Intent;", "open", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class BoltsMeasurementEventListener extends BroadcastReceiver {
    private static final String BOLTS_MEASUREMENT_EVENT_PREFIX = "bf_";
    private static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
    private static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
    private static BoltsMeasurementEventListener singleton;
    private final Context applicationContext;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/facebook/internal/BoltsMeasurementEventListener$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/facebook/internal/BoltsMeasurementEventListener;", "getInstance", "(Landroid/content/Context;)Lcom/facebook/internal/BoltsMeasurementEventListener;", BuildConfig.FLAVOR, "BOLTS_MEASUREMENT_EVENT_PREFIX", "Ljava/lang/String;", "MEASUREMENT_EVENT_ARGS_KEY", "MEASUREMENT_EVENT_NAME_KEY", "singleton", "Lcom/facebook/internal/BoltsMeasurementEventListener;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BoltsMeasurementEventListener getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (BoltsMeasurementEventListener.access$getSingleton$cp() != null) {
                return BoltsMeasurementEventListener.access$getSingleton$cp();
            }
            BoltsMeasurementEventListener boltsMeasurementEventListener = new BoltsMeasurementEventListener(context, null);
            BoltsMeasurementEventListener.access$open(boltsMeasurementEventListener);
            BoltsMeasurementEventListener.access$setSingleton$cp(boltsMeasurementEventListener);
            return BoltsMeasurementEventListener.access$getSingleton$cp();
        }

        private Companion() {
        }
    }

    public /* synthetic */ BoltsMeasurementEventListener(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public static final /* synthetic */ BoltsMeasurementEventListener access$getSingleton$cp() {
        if (CrashShieldHandler.isObjectCrashing(BoltsMeasurementEventListener.class)) {
            return null;
        }
        try {
            return singleton;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, BoltsMeasurementEventListener.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$open(BoltsMeasurementEventListener boltsMeasurementEventListener) {
        if (CrashShieldHandler.isObjectCrashing(BoltsMeasurementEventListener.class)) {
            return;
        }
        try {
            boltsMeasurementEventListener.open();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, BoltsMeasurementEventListener.class);
        }
    }

    public static final /* synthetic */ void access$setSingleton$cp(BoltsMeasurementEventListener boltsMeasurementEventListener) {
        if (CrashShieldHandler.isObjectCrashing(BoltsMeasurementEventListener.class)) {
            return;
        }
        try {
            singleton = boltsMeasurementEventListener;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, BoltsMeasurementEventListener.class);
        }
    }

    private final void close() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this.applicationContext);
            Intrinsics.checkNotNullExpressionValue(localBroadcastManager, "getInstance(applicationContext)");
            localBroadcastManager.unregisterReceiver(this);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void open() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this.applicationContext);
            Intrinsics.checkNotNullExpressionValue(localBroadcastManager, "getInstance(applicationContext)");
            localBroadcastManager.registerReceiver(this, new IntentFilter(MEASUREMENT_EVENT_NOTIFICATION_NAME));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void finalize() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            close();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(context);
            Set<String> set = null;
            String stringPlus = Intrinsics.stringPlus(BOLTS_MEASUREMENT_EVENT_PREFIX, intent == null ? null : intent.getStringExtra(MEASUREMENT_EVENT_NAME_KEY));
            Bundle bundleExtra = intent == null ? null : intent.getBundleExtra(MEASUREMENT_EVENT_ARGS_KEY);
            Bundle bundle = new Bundle();
            if (bundleExtra != null) {
                set = bundleExtra.keySet();
            }
            if (set != null) {
                for (String key : set) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    bundle.putString(new Regex("[ -]*$").replace(new Regex("^[ -]*").replace(new Regex("[^0-9a-zA-Z _-]").replace(key, "-"), BuildConfig.FLAVOR), BuildConfig.FLAVOR), (String) bundleExtra.get(key));
                }
            }
            internalAppEventsLogger.logEvent(stringPlus, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private BoltsMeasurementEventListener(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.applicationContext = applicationContext;
    }
}
