package com.google.firebase.analytics.ktx;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/analytics/ktx/FirebaseAnalyticsLegacyRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "<init>", "()V", "getComponents", BuildConfig.FLAVOR, "Lcom/google/firebase/components/Component;", "java.com.google.android.libraries.firebase.firebase_analytics_ktx_granule"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FirebaseAnalyticsLegacyRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public final List<Component<?>> getComponents() {
        return CollectionsKt.listOf(LibraryVersionComponent.create("fire-analytics-ktx", "22.2.0"));
    }
}
