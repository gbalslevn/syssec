package com.ramcosta.composedestinations.navargs.primitives;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import java.lang.Enum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0003B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u000fJ \u0010\u0010\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096\u0002¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0015J\u001f\u0010\u0010\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u0018J'\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ramcosta/composedestinations/navargs/primitives/DestinationsEnumNavType;", "E", BuildConfig.FLAVOR, "Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", "enumType", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "put", BuildConfig.FLAVOR, "bundle", "Landroid/os/Bundle;", "key", BuildConfig.FLAVOR, "value", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/Enum;)V", "get", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/Enum;", "parseValue", "(Ljava/lang/String;)Ljava/lang/Enum;", "serializeValue", "(Ljava/lang/Enum;)Ljava/lang/String;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;)Ljava/lang/Enum;", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Ljava/lang/Enum;)V", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DestinationsEnumNavType<E extends Enum<?>> extends DestinationsNavType<E> {
    private final Class<E> enumType;

    public DestinationsEnumNavType(Class<E> enumType) {
        Intrinsics.checkNotNullParameter(enumType, "enumType");
        this.enumType = enumType;
    }

    @Override // androidx.navigation.NavType
    public E parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, "\u0002null\u0003")) {
            return null;
        }
        return (E) CommonConstantsKt.valueOfIgnoreCase(this.enumType, value);
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public String serializeValue(E value) {
        String name;
        return (value == null || (name = value.name()) == null) ? "%02null%03" : name;
    }

    @Override // androidx.navigation.NavType
    public E get(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        return (E) bundle.getSerializable(key);
    }

    @Override // androidx.navigation.NavType
    public void put(Bundle bundle, String key, E value) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putSerializable(key, value);
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public E get(SavedStateHandle savedStateHandle, String key) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        return (E) savedStateHandle.get(key);
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public void put(SavedStateHandle savedStateHandle, String key, E value) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        savedStateHandle.set(key, value);
    }
}
