package com.ramcosta.composedestinations.navargs.primitives;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavType;
import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0012J\u001f\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0015J'\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00182\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/ramcosta/composedestinations/navargs/primitives/DestinationsIntNavType;", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", BuildConfig.FLAVOR, "<init>", "()V", "put", BuildConfig.FLAVOR, "bundle", "Landroid/os/Bundle;", "key", BuildConfig.FLAVOR, "value", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Integer;)V", "get", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Integer;", "parseValue", "(Ljava/lang/String;)Ljava/lang/Integer;", "serializeValue", "(Ljava/lang/Integer;)Ljava/lang/String;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;)Ljava/lang/Integer;", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Ljava/lang/Integer;)V", "intToBundleValue", BuildConfig.FLAVOR, "(Ljava/lang/Integer;)Ljava/lang/Object;", "bundleValueToInt", "valueForKey", "(Ljava/lang/Object;)Ljava/lang/Integer;", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DestinationsIntNavType extends DestinationsNavType<Integer> {
    public static final DestinationsIntNavType INSTANCE = new DestinationsIntNavType();

    private DestinationsIntNavType() {
    }

    private final Integer bundleValueToInt(Object valueForKey) {
        if (valueForKey instanceof Integer) {
            return (Integer) valueForKey;
        }
        return null;
    }

    private final Object intToBundleValue(Integer value) {
        if (value == null) {
            return (byte) 0;
        }
        return value;
    }

    @Override // androidx.navigation.NavType
    public Integer parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, "\u0002null\u0003")) {
            return null;
        }
        return NavType.IntType.parseValue(value);
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public String serializeValue(Integer value) {
        String num;
        return (value == null || (num = value.toString()) == null) ? "%02null%03" : num;
    }

    @Override // androidx.navigation.NavType
    public Integer get(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        return bundleValueToInt(bundle.get(key));
    }

    @Override // androidx.navigation.NavType
    public void put(Bundle bundle, String key, Integer value) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Object intToBundleValue = intToBundleValue(value);
        if (intToBundleValue instanceof Byte) {
            bundle.putByte(key, ((Number) intToBundleValue).byteValue());
        } else {
            if (intToBundleValue instanceof Integer) {
                bundle.putInt(key, ((Number) intToBundleValue).intValue());
                return;
            }
            throw new IllegalStateException(("Unexpected type " + intToBundleValue.getClass()).toString());
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public Integer get(SavedStateHandle savedStateHandle, String key) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        return bundleValueToInt(savedStateHandle.get(key));
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public void put(SavedStateHandle savedStateHandle, String key, Integer value) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        savedStateHandle.set(key, intToBundleValue(value));
    }
}
