package com.ramcosta.composedestinations.navargs.primitives.arraylist;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandle;
import com.ramcosta.composedestinations.navargs.DestinationsNavType;
import com.ramcosta.composedestinations.navargs.primitives.arraylist.DestinationsStringArrayListNavType;
import com.ramcosta.composedestinations.navargs.utils.NavArgEncodingUtilsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00040\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016J-\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0096\u0002J$\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u0006\u0010\f\u001a\u00020\u0003H\u0016J$\u0010\u000f\u001a\u00020\u00032\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016J,\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J4\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00032\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016¨\u0006\u0012"}, d2 = {"Lcom/ramcosta/composedestinations/navargs/primitives/arraylist/DestinationsStringArrayListNavType;", "Lcom/ramcosta/composedestinations/navargs/DestinationsNavType;", "Ljava/util/ArrayList;", BuildConfig.FLAVOR, "Lkotlin/collections/ArrayList;", "<init>", "()V", "put", BuildConfig.FLAVOR, "bundle", "Landroid/os/Bundle;", "key", "value", "get", "parseValue", "serializeValue", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "compose-destinations_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DestinationsStringArrayListNavType extends DestinationsNavType<ArrayList<String>> {
    public static final DestinationsStringArrayListNavType INSTANCE = new DestinationsStringArrayListNavType();

    private DestinationsStringArrayListNavType() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence serializeValue$lambda$2(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.length() == 0 ? "%02%03" : it;
    }

    @Override // androidx.navigation.NavType
    public ArrayList<String> parseValue(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, "\u0002null\u0003")) {
            return null;
        }
        if (Intrinsics.areEqual(value, "[]")) {
            return new ArrayList<>();
        }
        List<String> split$default = StringsKt.split$default(value.subSequence(1, value.length() - 1), new String[]{"%2C"}, false, 0, 6, (Object) null);
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : split$default) {
            if (Intrinsics.areEqual(str, "\u0002\u0003")) {
                str = BuildConfig.FLAVOR;
            }
            arrayList.add(str);
        }
        return arrayList;
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public String serializeValue(ArrayList<String> value) {
        if (value == null) {
            return "%02null%03";
        }
        return NavArgEncodingUtilsKt.encodeForRoute('[' + CollectionsKt.joinToString$default(value, "%2C", null, null, 0, null, new Function1() { // from class: g1.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CharSequence serializeValue$lambda$2;
                serializeValue$lambda$2 = DestinationsStringArrayListNavType.serializeValue$lambda$2((String) obj);
                return serializeValue$lambda$2;
            }
        }, 30, null) + ']');
    }

    @Override // androidx.navigation.NavType
    public ArrayList<String> get(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        return bundle.getStringArrayList(key);
    }

    @Override // androidx.navigation.NavType
    public void put(Bundle bundle, String key, ArrayList<String> value) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        bundle.putStringArrayList(key, value);
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public ArrayList<String> get(SavedStateHandle savedStateHandle, String key) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        return (ArrayList) savedStateHandle.get(key);
    }

    @Override // com.ramcosta.composedestinations.navargs.DestinationsNavType
    public void put(SavedStateHandle savedStateHandle, String key, ArrayList<String> value) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(key, "key");
        savedStateHandle.set(key, value);
    }
}
