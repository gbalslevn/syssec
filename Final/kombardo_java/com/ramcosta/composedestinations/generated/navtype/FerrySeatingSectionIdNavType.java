package com.ramcosta.composedestinations.generated.navtype;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import com.ramcosta.composedestinations.navargs.DestinationsNavTypeSerializer;
import com.ramcosta.composedestinations.navargs.utils.NavArgEncodingUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeatingSectionId;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002J\"\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ramcosta/composedestinations/generated/navtype/FerrySeatingSectionIdNavType;", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", "Luniffi/molslinjen_shared/FerrySeatingSectionId;", "customSerializer", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavTypeSerializer;", "<init>", "(Lcom/ramcosta/composedestinations/navargs/DestinationsNavTypeSerializer;)V", "get", "bundle", "Landroid/os/Bundle;", "key", BuildConfig.FLAVOR, "put", BuildConfig.FLAVOR, "value", "parseValue", "serializeValue", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FerrySeatingSectionIdNavType extends DestinationsNavType<FerrySeatingSectionId> {
    private final DestinationsNavTypeSerializer<FerrySeatingSectionId> customSerializer;

    public FerrySeatingSectionIdNavType(DestinationsNavTypeSerializer<FerrySeatingSectionId> customSerializer) {
        Intrinsics.checkNotNullParameter(customSerializer, "customSerializer");
        this.customSerializer = customSerializer;
    }

    @Override // androidx.navigation.NavType
    public FerrySeatingSectionId parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, "\u0002null\u0003")) {
            return null;
        }
        return this.customSerializer.fromRouteString(value);
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public String serializeValue(FerrySeatingSectionId value) {
        if (value == null) {
            return "%02null%03";
        }
        return NavArgEncodingUtilsKt.encodeForRoute(this.customSerializer.toRouteString(value));
    }

    @Override // androidx.navigation.NavType
    public FerrySeatingSectionId get(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        String string = bundle.getString(key);
        if (string != null) {
            return parseValue(string);
        }
        return null;
    }

    @Override // androidx.navigation.NavType
    public void put(Bundle bundle, String key, FerrySeatingSectionId value) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putString(key, value != null ? this.customSerializer.toRouteString(value) : null);
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public FerrySeatingSectionId get(SavedStateHandle savedStateHandle, String key) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        String str = (String) savedStateHandle.get(key);
        if (str != null) {
            return this.customSerializer.fromRouteString(str);
        }
        return null;
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public void put(SavedStateHandle savedStateHandle, String key, FerrySeatingSectionId value) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        savedStateHandle.set(key, value != null ? this.customSerializer.toRouteString(value) : null);
    }
}
