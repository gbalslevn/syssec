package com.ramcosta.composedestinations.navargs;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H&¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u0004\u0018\u00018\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", "T", BuildConfig.FLAVOR, "Landroidx/navigation/NavType;", "<init>", "()V", "serializeValue", BuildConfig.FLAVOR, "value", "(Ljava/lang/Object;)Ljava/lang/String;", "get", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "key", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;)Ljava/lang/Object;", "put", BuildConfig.FLAVOR, "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Ljava/lang/Object;)V", "safeGet", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Object;", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DestinationsNavType<T> extends NavType<T> {
    public static final int $stable = 0;

    public DestinationsNavType() {
        super(true);
    }

    public abstract T get(SavedStateHandle savedStateHandle, String key);

    public abstract void put(SavedStateHandle savedStateHandle, String key, T value);

    public final T safeGet(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (bundle != null) {
            return get(bundle, key);
        }
        return null;
    }

    public abstract String serializeValue(T value);
}
