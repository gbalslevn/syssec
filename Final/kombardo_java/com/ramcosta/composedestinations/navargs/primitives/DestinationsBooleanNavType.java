package com.ramcosta.composedestinations.navargs.primitives;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavType;
import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0012J\u001f\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0015J'\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00182\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/ramcosta/composedestinations/navargs/primitives/DestinationsBooleanNavType;", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", BuildConfig.FLAVOR, "<init>", "()V", "put", BuildConfig.FLAVOR, "bundle", "Landroid/os/Bundle;", "key", BuildConfig.FLAVOR, "value", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Boolean;)V", "get", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Boolean;", "parseValue", "(Ljava/lang/String;)Ljava/lang/Boolean;", "serializeValue", "(Ljava/lang/Boolean;)Ljava/lang/String;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;)Ljava/lang/Boolean;", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Ljava/lang/Boolean;)V", "booleanToBundleValue", BuildConfig.FLAVOR, "(Ljava/lang/Boolean;)Ljava/lang/Object;", "bundleValueToBoolean", "valueForKey", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DestinationsBooleanNavType extends DestinationsNavType<Boolean> {
    public static final DestinationsBooleanNavType INSTANCE = new DestinationsBooleanNavType();

    private DestinationsBooleanNavType() {
    }

    private final Object booleanToBundleValue(Boolean value) {
        if (value == null) {
            return (byte) 0;
        }
        return value;
    }

    private final Boolean bundleValueToBoolean(Object valueForKey) {
        if (valueForKey instanceof Boolean) {
            return (Boolean) valueForKey;
        }
        return null;
    }

    @Override // androidx.navigation.NavType
    public Boolean parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, "\u0002null\u0003")) {
            return null;
        }
        return NavType.BoolType.parseValue(value);
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public String serializeValue(Boolean value) {
        String bool;
        return (value == null || (bool = value.toString()) == null) ? "%02null%03" : bool;
    }

    @Override // androidx.navigation.NavType
    public Boolean get(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        return bundleValueToBoolean(bundle.get(key));
    }

    @Override // androidx.navigation.NavType
    public void put(Bundle bundle, String key, Boolean value) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Object booleanToBundleValue = booleanToBundleValue(value);
        if (booleanToBundleValue instanceof Byte) {
            bundle.putByte(key, ((Number) booleanToBundleValue).byteValue());
        } else {
            if (booleanToBundleValue instanceof Boolean) {
                bundle.putBoolean(key, ((Boolean) booleanToBundleValue).booleanValue());
                return;
            }
            throw new IllegalStateException(("Unexpected type " + booleanToBundleValue.getClass()).toString());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public Boolean get(SavedStateHandle savedStateHandle, String key) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        return bundleValueToBoolean(savedStateHandle.get(key));
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public void put(SavedStateHandle savedStateHandle, String key, Boolean value) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        savedStateHandle.set(key, booleanToBundleValue(value));
    }
}
