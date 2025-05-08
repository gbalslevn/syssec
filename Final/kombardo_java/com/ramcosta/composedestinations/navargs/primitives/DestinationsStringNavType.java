package com.ramcosta.composedestinations.navargs.primitives;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavType;
import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import com.ramcosta.composedestinations.navargs.utils.NavArgEncodingUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\"\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0012J!\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0015J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/ramcosta/composedestinations/navargs/primitives/DestinationsStringNavType;", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", BuildConfig.FLAVOR, "<init>", "()V", "Landroid/os/Bundle;", "bundle", "key", "value", BuildConfig.FLAVOR, "put", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V", "get", "(Landroid/os/Bundle;Ljava/lang/String;)Ljava/lang/String;", "parseValue", "(Ljava/lang/String;)Ljava/lang/String;", "serializeValue", "argName", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Landroidx/lifecycle/SavedStateHandle;", "savedStateHandle", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;)Ljava/lang/String;", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Ljava/lang/String;)V", "ENCODED_DEFAULT_VALUE_STRING_PREFIX", "Ljava/lang/String;", "DECODED_DEFAULT_VALUE_STRING_PREFIX", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DestinationsStringNavType extends DestinationsNavType<String> {
    public static final int $stable = 0;
    private static final String DECODED_DEFAULT_VALUE_STRING_PREFIX = "\u0002def\u0003";
    private static final String ENCODED_DEFAULT_VALUE_STRING_PREFIX = "%02def%03";
    public static final DestinationsStringNavType INSTANCE = new DestinationsStringNavType();

    private DestinationsStringNavType() {
    }

    @Override // androidx.navigation.NavType
    public String parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (StringsKt.startsWith$default(value, DECODED_DEFAULT_VALUE_STRING_PREFIX, false, 2, (Object) null)) {
            return StringsKt.removePrefix(value, DECODED_DEFAULT_VALUE_STRING_PREFIX);
        }
        if (Intrinsics.areEqual(value, "\u0002null\u0003")) {
            return null;
        }
        return Intrinsics.areEqual(value, "\u0002\u0003") ? BuildConfig.FLAVOR : value;
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public String serializeValue(String value) {
        if (value == null) {
            return "%02null%03";
        }
        return value.length() == 0 ? "%02%03" : NavArgEncodingUtilsKt.encodeForRoute(value);
    }

    @Override // androidx.navigation.NavType
    public String get(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        return NavType.StringType.get(bundle, key);
    }

    @Override // androidx.navigation.NavType
    public void put(Bundle bundle, String key, String value) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        NavType.StringType.put(bundle, key, value);
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public String get(SavedStateHandle savedStateHandle, String key) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        return (String) savedStateHandle.get(key);
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public void put(SavedStateHandle savedStateHandle, String key, String value) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        savedStateHandle.set(key, value);
    }

    public final String serializeValue(String argName, String value) {
        Intrinsics.checkNotNullParameter(argName, "argName");
        if (Intrinsics.areEqual('{' + argName + '}', value)) {
            return ENCODED_DEFAULT_VALUE_STRING_PREFIX + NavArgEncodingUtilsKt.encodeForRoute(value);
        }
        return serializeValue(value);
    }
}
