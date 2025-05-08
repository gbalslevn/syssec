package com.facebook.appevents;

import android.content.Context;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.Utility;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0002\b\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/appevents/AppEventDiskStore;", BuildConfig.FLAVOR, "()V", "PERSISTED_EVENTS_FILENAME", BuildConfig.FLAVOR, "TAG", "kotlin.jvm.PlatformType", "readAndClearStore", "Lcom/facebook/appevents/PersistedEvents;", "saveEventsToDisk", BuildConfig.FLAVOR, "eventsToPersist", "saveEventsToDisk$facebook_core_release", "MovedClassObjectInputStream", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AppEventDiskStore {
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    public static final AppEventDiskStore INSTANCE = new AppEventDiskStore();
    private static final String TAG = AppEventDiskStore.class.getName();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/AppEventDiskStore$MovedClassObjectInputStream;", "Ljava/io/ObjectInputStream;", "inputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "readClassDescriptor", "Ljava/io/ObjectStreamClass;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes.dex */
    private static final class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2";

        public MovedClassObjectInputStream(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        protected ObjectStreamClass readClassDescriptor() {
            ObjectStreamClass resultClassDescriptor = super.readClassDescriptor();
            if (Intrinsics.areEqual(resultClassDescriptor.getName(), ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                resultClassDescriptor = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            } else if (Intrinsics.areEqual(resultClassDescriptor.getName(), APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                resultClassDescriptor = ObjectStreamClass.lookup(AppEvent.SerializationProxyV2.class);
            }
            Intrinsics.checkNotNullExpressionValue(resultClassDescriptor, "resultClassDescriptor");
            return resultClassDescriptor;
        }
    }

    private AppEventDiskStore() {
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x009f A[Catch: all -> 0x0035, TRY_LEAVE, TryCatch #3 {, blocks: (B:4:0x0003, B:12:0x0028, B:14:0x002b, B:17:0x009f, B:23:0x0039, B:44:0x0074, B:46:0x0077, B:47:0x0089, B:50:0x0082, B:36:0x005e, B:38:0x0061, B:41:0x006c, B:33:0x0070, B:27:0x008a, B:29:0x008d, B:32:0x0098), top: B:3:0x0003, inners: #1, #4, #5, #10 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final synchronized PersistedEvents readAndClearStore() {
        PersistedEvents persistedEvents;
        Throwable th;
        MovedClassObjectInputStream movedClassObjectInputStream;
        String str;
        String str2;
        Object readObject;
        synchronized (AppEventDiskStore.class) {
            AppEventUtility.assertIsNotMainThread();
            Context applicationContext = FacebookSdk.getApplicationContext();
            persistedEvents = null;
            try {
                try {
                    FileInputStream openFileInput = applicationContext.openFileInput(PERSISTED_EVENTS_FILENAME);
                    Intrinsics.checkNotNullExpressionValue(openFileInput, "context.openFileInput(PERSISTED_EVENTS_FILENAME)");
                    movedClassObjectInputStream = new MovedClassObjectInputStream(new BufferedInputStream(openFileInput));
                    try {
                        readObject = movedClassObjectInputStream.readObject();
                    } catch (FileNotFoundException unused) {
                        Utility.closeQuietly(movedClassObjectInputStream);
                        try {
                            applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                        } catch (Exception e5) {
                            e = e5;
                            str = TAG;
                            str2 = "Got unexpected exception when removing events file: ";
                            Log.w(str, str2, e);
                            if (persistedEvents == null) {
                            }
                            return persistedEvents;
                        }
                        if (persistedEvents == null) {
                        }
                        return persistedEvents;
                    } catch (Exception e6) {
                        e = e6;
                        Log.w(TAG, "Got unexpected exception while reading events: ", e);
                        Utility.closeQuietly(movedClassObjectInputStream);
                        try {
                            applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                        } catch (Exception e7) {
                            e = e7;
                            str = TAG;
                            str2 = "Got unexpected exception when removing events file: ";
                            Log.w(str, str2, e);
                            if (persistedEvents == null) {
                            }
                            return persistedEvents;
                        }
                        if (persistedEvents == null) {
                        }
                        return persistedEvents;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    Utility.closeQuietly(null);
                    try {
                        applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                    } catch (Exception e8) {
                        Log.w(TAG, "Got unexpected exception when removing events file: ", e8);
                    }
                    throw th;
                }
            } catch (FileNotFoundException unused2) {
                movedClassObjectInputStream = null;
            } catch (Exception e9) {
                e = e9;
                movedClassObjectInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                Utility.closeQuietly(null);
                applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                throw th;
            }
            if (readObject == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.PersistedEvents");
            }
            PersistedEvents persistedEvents2 = (PersistedEvents) readObject;
            Utility.closeQuietly(movedClassObjectInputStream);
            try {
                applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
            } catch (Exception e10) {
                Log.w(TAG, "Got unexpected exception when removing events file: ", e10);
            }
            persistedEvents = persistedEvents2;
            if (persistedEvents == null) {
                persistedEvents = new PersistedEvents();
            }
        }
        return persistedEvents;
    }

    public static final void saveEventsToDisk$facebook_core_release(PersistedEvents eventsToPersist) {
        ObjectOutputStream objectOutputStream;
        Context applicationContext = FacebookSdk.getApplicationContext();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(applicationContext.openFileOutput(PERSISTED_EVENTS_FILENAME, 0)));
        } catch (Throwable th) {
            th = th;
        }
        try {
            objectOutputStream.writeObject(eventsToPersist);
            Utility.closeQuietly(objectOutputStream);
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            try {
                Log.w(TAG, "Got unexpected exception while persisting events: ", th);
                try {
                    applicationContext.getFileStreamPath(PERSISTED_EVENTS_FILENAME).delete();
                } catch (Exception unused) {
                }
            } finally {
                Utility.closeQuietly(objectOutputStream2);
            }
        }
    }
}
