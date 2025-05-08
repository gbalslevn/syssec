package com.ramcosta.composedestinations.spec;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0001H\u0007*\u0012\u0010\u0000\"\u0006\u0012\u0002\b\u00030\u00012\u0006\u0012\u0002\b\u00030\u0001¨\u0006\u0005"}, d2 = {"NavHostGraphSpec", "Lcom/ramcosta/composedestinations/spec/TypedNavHostGraphSpec;", "defaultStartDirection", "Lcom/ramcosta/composedestinations/spec/Direction;", "T", "compose-destinations_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class NavHostGraphSpecKt {
    public static final <T> Direction defaultStartDirection(TypedNavHostGraphSpec<T> typedNavHostGraphSpec) {
        Intrinsics.checkNotNullParameter(typedNavHostGraphSpec, "<this>");
        T defaultStartArgs = typedNavHostGraphSpec.getDefaultStartArgs();
        return defaultStartArgs != null ? typedNavHostGraphSpec.getStartRoute().invoke(defaultStartArgs) : DirectionKt.Direction(typedNavHostGraphSpec.getStartRoute().getBaseRoute());
    }
}
