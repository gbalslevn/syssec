package com.ramcosta.composedestinations.generated.navtype;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import com.ramcosta.composedestinations.navargs.DestinationsNavTypeSerializer;
import com.ramcosta.composedestinations.navargs.utils.NavArgEncodingUtilsKt;
import java.io.Serializable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0002J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ramcosta/composedestinations/generated/navtype/UUIDNavType;", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", "Ljava/util/UUID;", "stringSerializer", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavTypeSerializer;", "Ljava/io/Serializable;", "<init>", "(Lcom/ramcosta/composedestinations/navargs/DestinationsNavTypeSerializer;)V", "get", "bundle", "Landroid/os/Bundle;", "key", BuildConfig.FLAVOR, "put", BuildConfig.FLAVOR, "value", "parseValue", "serializeValue", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UUIDNavType extends DestinationsNavType<UUID> {
    private final DestinationsNavTypeSerializer<Serializable> stringSerializer;

    public UUIDNavType(DestinationsNavTypeSerializer<Serializable> stringSerializer) {
        Intrinsics.checkNotNullParameter(stringSerializer, "stringSerializer");
        this.stringSerializer = stringSerializer;
    }

    @Override // androidx.navigation.NavType
    public UUID parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, "\u0002null\u0003")) {
            return null;
        }
        Serializable fromRouteString = this.stringSerializer.fromRouteString(value);
        Intrinsics.checkNotNull(fromRouteString, "null cannot be cast to non-null type java.util.UUID");
        return (UUID) fromRouteString;
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public String serializeValue(UUID value) {
        if (value == null) {
            return "%02null%03";
        }
        return NavArgEncodingUtilsKt.encodeForRoute(this.stringSerializer.toRouteString(value));
    }

    @Override // androidx.navigation.NavType
    public UUID get(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        return (UUID) bundle.getSerializable(key);
    }

    @Override // androidx.navigation.NavType
    public void put(Bundle bundle, String key, UUID value) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putSerializable(key, value);
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public UUID get(SavedStateHandle savedStateHandle, String key) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        return (UUID) savedStateHandle.get(key);
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public void put(SavedStateHandle savedStateHandle, String key, UUID value) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        savedStateHandle.set(key, value);
    }
}
