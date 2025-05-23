package com.facebook.appevents;

import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/AppEventStore;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "kotlin.jvm.PlatformType", "persistEvents", BuildConfig.FLAVOR, "accessTokenAppIdPair", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "appEvents", "Lcom/facebook/appevents/SessionEventsState;", "eventsToPersist", "Lcom/facebook/appevents/AppEventCollection;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AppEventStore {
    public static final AppEventStore INSTANCE = new AppEventStore();
    private static final String TAG = AppEventStore.class.getName();

    private AppEventStore() {
    }

    public static final synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState appEvents) {
        synchronized (AppEventStore.class) {
            if (CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
                return;
            }
            try {
                Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "accessTokenAppIdPair");
                Intrinsics.checkNotNullParameter(appEvents, "appEvents");
                AppEventUtility.assertIsNotMainThread();
                PersistedEvents readAndClearStore = AppEventDiskStore.readAndClearStore();
                readAndClearStore.addEvents(accessTokenAppIdPair, appEvents.getEventsToPersist());
                AppEventDiskStore.saveEventsToDisk$facebook_core_release(readAndClearStore);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, AppEventStore.class);
            }
        }
    }

    public static final synchronized void persistEvents(AppEventCollection eventsToPersist) {
        synchronized (AppEventStore.class) {
            if (CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
                return;
            }
            try {
                Intrinsics.checkNotNullParameter(eventsToPersist, "eventsToPersist");
                AppEventUtility.assertIsNotMainThread();
                PersistedEvents readAndClearStore = AppEventDiskStore.readAndClearStore();
                for (AccessTokenAppIdPair accessTokenAppIdPair : eventsToPersist.keySet()) {
                    SessionEventsState sessionEventsState = eventsToPersist.get(accessTokenAppIdPair);
                    if (sessionEventsState != null) {
                        readAndClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
                    } else {
                        throw new IllegalStateException("Required value was null.");
                    }
                }
                AppEventDiskStore.saveEventsToDisk$facebook_core_release(readAndClearStore);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, AppEventStore.class);
            }
        }
    }
}
