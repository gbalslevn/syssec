package com.google.accompanist.permissions;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"rememberPermissionState", "Lcom/google/accompanist/permissions/PermissionState;", "permission", BuildConfig.FLAVOR, "onPermissionResult", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Lcom/google/accompanist/permissions/PermissionState;", "permissions_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PermissionStateKt {
    public static final PermissionState rememberPermissionState(String permission, Function1<? super Boolean, Unit> function1, Composer composer, int i5, int i6) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        composer.startReplaceableGroup(923020361);
        if ((i6 & 2) != 0) {
            function1 = new Function1<Boolean, Unit>() { // from class: com.google.accompanist.permissions.PermissionStateKt$rememberPermissionState$1
                public final void invoke(boolean z5) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(923020361, i5, -1, "com.google.accompanist.permissions.rememberPermissionState (PermissionState.kt:36)");
        }
        MutablePermissionState rememberMutablePermissionState = MutablePermissionStateKt.rememberMutablePermissionState(permission, function1, composer, i5 & 126, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberMutablePermissionState;
    }
}
