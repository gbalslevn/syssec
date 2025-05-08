package com.ramcosta.composedestinations.generated.navtype;

import android.os.Bundle;
import androidx.compose.ui.geometry.Offset;
import androidx.lifecycle.SavedStateHandle;
import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import com.ramcosta.composedestinations.navargs.DestinationsNavTypeSerializer;
import com.ramcosta.composedestinations.navargs.utils.NavArgEncodingUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\b\fJ'\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\b\u0010J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0002\b\u0012J\u0017\u0010\u0013\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\b\u0014J\u001f\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\b\fJ'\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\b\u0010R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ramcosta/composedestinations/generated/navtype/OffsetNavType;", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", "Landroidx/compose/ui/geometry/Offset;", "customSerializer", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavTypeSerializer;", "<init>", "(Lcom/ramcosta/composedestinations/navargs/DestinationsNavTypeSerializer;)V", "get", "bundle", "Landroid/os/Bundle;", "key", BuildConfig.FLAVOR, "get-GcwITfU", "put", BuildConfig.FLAVOR, "value", "put-b0fnrdo", "parseValue", "parseValue-x-9fifI", "serializeValue", "serializeValue-_kEHs6E", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OffsetNavType extends DestinationsNavType<Offset> {
    private final DestinationsNavTypeSerializer<Offset> customSerializer;

    public OffsetNavType(DestinationsNavTypeSerializer<Offset> customSerializer) {
        Intrinsics.checkNotNullParameter(customSerializer, "customSerializer");
        this.customSerializer = customSerializer;
    }

    @Override // androidx.navigation.NavType
    /* renamed from: get-GcwITfU, reason: not valid java name and merged with bridge method [inline-methods] */
    public Offset get(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        String string = bundle.getString(key);
        if (string != null) {
            return parseValue(string);
        }
        return null;
    }

    @Override // androidx.navigation.NavType
    /* renamed from: parseValue-x-9fifI, reason: not valid java name and merged with bridge method [inline-methods] */
    public Offset parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, "\u0002null\u0003")) {
            return null;
        }
        return this.customSerializer.fromRouteString(value);
    }

    @Override // androidx.navigation.NavType
    /* renamed from: put-b0fnrdo, reason: not valid java name and merged with bridge method [inline-methods] */
    public void put(Bundle bundle, String key, Offset value) {
        String str;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        if (value != null) {
            str = this.customSerializer.toRouteString(Offset.m1328boximpl(value.getPackedValue()));
        } else {
            str = null;
        }
        bundle.putString(key, str);
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    /* renamed from: serializeValue-_kEHs6E, reason: not valid java name and merged with bridge method [inline-methods] */
    public String serializeValue(Offset value) {
        return value == null ? "%02null%03" : NavArgEncodingUtilsKt.encodeForRoute(this.customSerializer.toRouteString(value));
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    /* renamed from: get-GcwITfU, reason: not valid java name and merged with bridge method [inline-methods] */
    public Offset get(SavedStateHandle savedStateHandle, String key) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        String str = (String) savedStateHandle.get(key);
        if (str != null) {
            return Offset.m1328boximpl(this.customSerializer.fromRouteString(str).getPackedValue());
        }
        return null;
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    /* renamed from: put-b0fnrdo, reason: not valid java name and merged with bridge method [inline-methods] */
    public void put(SavedStateHandle savedStateHandle, String key, Offset value) {
        String str;
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        if (value != null) {
            str = this.customSerializer.toRouteString(Offset.m1328boximpl(value.getPackedValue()));
        } else {
            str = null;
        }
        savedStateHandle.set(key, str);
    }
}
