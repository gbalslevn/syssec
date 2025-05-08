package com.ramcosta.composedestinations.manualcomposablecalls;

import androidx.navigation.NavDeepLink;
import com.ramcosta.composedestinations.spec.TypedRoute;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\n\u0012\u0002\b\u00030\u0003j\u0002`\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"allDeepLinks", BuildConfig.FLAVOR, "Landroidx/navigation/NavDeepLink;", "Lcom/ramcosta/composedestinations/spec/TypedRoute;", "Lcom/ramcosta/composedestinations/spec/Route;", "manualComposableCalls", "Lcom/ramcosta/composedestinations/manualcomposablecalls/ManualComposableCalls;", "compose-destinations_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ManualComposableCallsKt {
    public static final List<NavDeepLink> allDeepLinks(TypedRoute<?> typedRoute, ManualComposableCalls manualComposableCalls) {
        Intrinsics.checkNotNullParameter(typedRoute, "<this>");
        List<NavDeepLink> manualDeepLinks = manualComposableCalls != null ? manualComposableCalls.manualDeepLinks(typedRoute.getRoute()) : null;
        return manualDeepLinks != null ? CollectionsKt.plus((Collection) manualDeepLinks, (Iterable) typedRoute.getDeepLinks()) : typedRoute.getDeepLinks();
    }
}
