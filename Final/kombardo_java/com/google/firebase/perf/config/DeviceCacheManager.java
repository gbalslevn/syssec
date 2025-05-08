package com.google.firebase.perf.config;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.FirebaseApp;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class DeviceCacheManager {
    private static final String PREFS_NAME = "FirebasePerfSharedPrefs";
    private static DeviceCacheManager instance;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final ExecutorService serialExecutor;
    private volatile SharedPreferences sharedPref;

    public DeviceCacheManager(ExecutorService executorService) {
        this.serialExecutor = executorService;
    }

    private Context getFirebaseApplicationContext() {
        try {
            FirebaseApp.getInstance();
            return FirebaseApp.getInstance().getApplicationContext();
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    public static synchronized DeviceCacheManager getInstance() {
        DeviceCacheManager deviceCacheManager;
        synchronized (DeviceCacheManager.class) {
            try {
                if (instance == null) {
                    instance = new DeviceCacheManager(Executors.newSingleThreadExecutor());
                }
                deviceCacheManager = instance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return deviceCacheManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setContext$0(Context context) {
        if (this.sharedPref != null || context == null) {
            return;
        }
        this.sharedPref = context.getSharedPreferences(PREFS_NAME, 0);
    }

    public Optional<Boolean> getBoolean(String str) {
        if (str == null) {
            logger.debug("Key is null when getting boolean value on device cache.");
            return Optional.absent();
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.absent();
            }
        }
        if (!this.sharedPref.contains(str)) {
            return Optional.absent();
        }
        try {
            return Optional.of(Boolean.valueOf(this.sharedPref.getBoolean(str, false)));
        } catch (ClassCastException e5) {
            logger.debug("Key %s from sharedPreferences has type other than long: %s", str, e5.getMessage());
            return Optional.absent();
        }
    }

    public Optional<Double> getDouble(String str) {
        if (str == null) {
            logger.debug("Key is null when getting double value on device cache.");
            return Optional.absent();
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.absent();
            }
        }
        if (!this.sharedPref.contains(str)) {
            return Optional.absent();
        }
        try {
            try {
                return Optional.of(Double.valueOf(Double.longBitsToDouble(this.sharedPref.getLong(str, 0L))));
            } catch (ClassCastException unused) {
                return Optional.of(Double.valueOf(Float.valueOf(this.sharedPref.getFloat(str, 0.0f)).doubleValue()));
            }
        } catch (ClassCastException e5) {
            logger.debug("Key %s from sharedPreferences has type other than double: %s", str, e5.getMessage());
            return Optional.absent();
        }
    }

    public Optional<Long> getLong(String str) {
        if (str == null) {
            logger.debug("Key is null when getting long value on device cache.");
            return Optional.absent();
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.absent();
            }
        }
        if (!this.sharedPref.contains(str)) {
            return Optional.absent();
        }
        try {
            return Optional.of(Long.valueOf(this.sharedPref.getLong(str, 0L)));
        } catch (ClassCastException e5) {
            logger.debug("Key %s from sharedPreferences has type other than long: %s", str, e5.getMessage());
            return Optional.absent();
        }
    }

    public Optional<String> getString(String str) {
        if (str == null) {
            logger.debug("Key is null when getting String value on device cache.");
            return Optional.absent();
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.absent();
            }
        }
        if (!this.sharedPref.contains(str)) {
            return Optional.absent();
        }
        try {
            return Optional.of(this.sharedPref.getString(str, BuildConfig.FLAVOR));
        } catch (ClassCastException e5) {
            logger.debug("Key %s from sharedPreferences has type other than String: %s", str, e5.getMessage());
            return Optional.absent();
        }
    }

    public synchronized void setContext(final Context context) {
        if (this.sharedPref == null && context != null) {
            this.serialExecutor.execute(new Runnable() { // from class: com.google.firebase.perf.config.a
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceCacheManager.this.lambda$setContext$0(context);
                }
            });
        }
    }

    public boolean setValue(String str, boolean z5) {
        if (str == null) {
            logger.debug("Key is null when setting boolean value on device cache.");
            return false;
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        this.sharedPref.edit().putBoolean(str, z5).apply();
        return true;
    }

    public boolean setValue(String str, String str2) {
        if (str == null) {
            logger.debug("Key is null when setting String value on device cache.");
            return false;
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        if (str2 == null) {
            this.sharedPref.edit().remove(str).apply();
            return true;
        }
        this.sharedPref.edit().putString(str, str2).apply();
        return true;
    }

    public boolean setValue(String str, double d5) {
        if (str == null) {
            logger.debug("Key is null when setting double value on device cache.");
            return false;
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        this.sharedPref.edit().putLong(str, Double.doubleToRawLongBits(d5)).apply();
        return true;
    }

    public boolean setValue(String str, long j5) {
        if (str == null) {
            logger.debug("Key is null when setting long value on device cache.");
            return false;
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        this.sharedPref.edit().putLong(str, j5).apply();
        return true;
    }
}
