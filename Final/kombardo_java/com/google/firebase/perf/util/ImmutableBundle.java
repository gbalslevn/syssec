package com.google.firebase.perf.util;

import android.os.Bundle;
import com.google.firebase.perf.logging.AndroidLogger;

/* loaded from: classes2.dex */
public final class ImmutableBundle {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final Bundle bundle;

    public ImmutableBundle() {
        this(new Bundle());
    }

    private Optional<Integer> getInt(String str) {
        if (!containsKey(str)) {
            return Optional.absent();
        }
        try {
            return Optional.fromNullable((Integer) this.bundle.get(str));
        } catch (ClassCastException e5) {
            logger.debug("Metadata key %s contains type other than int: %s", str, e5.getMessage());
            return Optional.absent();
        }
    }

    public boolean containsKey(String str) {
        return str != null && this.bundle.containsKey(str);
    }

    public Optional<Boolean> getBoolean(String str) {
        if (!containsKey(str)) {
            return Optional.absent();
        }
        try {
            return Optional.fromNullable((Boolean) this.bundle.get(str));
        } catch (ClassCastException e5) {
            logger.debug("Metadata key %s contains type other than boolean: %s", str, e5.getMessage());
            return Optional.absent();
        }
    }

    public Optional<Double> getDouble(String str) {
        Object obj;
        if (containsKey(str) && (obj = this.bundle.get(str)) != null) {
            if (obj instanceof Float) {
                return Optional.of(Double.valueOf(((Float) obj).doubleValue()));
            }
            if (obj instanceof Double) {
                return Optional.of((Double) obj);
            }
            logger.debug("Metadata key %s contains type other than double: %s", str);
            return Optional.absent();
        }
        return Optional.absent();
    }

    public Optional<Long> getLong(String str) {
        return getInt(str).isAvailable() ? Optional.of(Long.valueOf(r3.get().intValue())) : Optional.absent();
    }

    public ImmutableBundle(Bundle bundle) {
        this.bundle = (Bundle) bundle.clone();
    }
}
