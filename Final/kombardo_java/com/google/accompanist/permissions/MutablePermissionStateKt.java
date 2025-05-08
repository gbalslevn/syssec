package com.google.accompanist.permissions;

import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.view.compose.ActivityResultRegistryKt;
import androidx.view.compose.ManagedActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$RequestPermission;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"rememberMutablePermissionState", "Lcom/google/accompanist/permissions/MutablePermissionState;", "permission", BuildConfig.FLAVOR, "onPermissionResult", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Lcom/google/accompanist/permissions/MutablePermissionState;", "permissions_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class MutablePermissionStateKt {
    public static final MutablePermissionState rememberMutablePermissionState(String permission, final Function1<? super Boolean, Unit> function1, Composer composer, int i5, int i6) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        composer.startReplaceableGroup(1424240517);
        if ((i6 & 2) != 0) {
            function1 = new Function1<Boolean, Unit>() { // from class: com.google.accompanist.permissions.MutablePermissionStateKt$rememberMutablePermissionState$1
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
            ComposerKt.traceEventStart(1424240517, i5, -1, "com.google.accompanist.permissions.rememberMutablePermissionState (MutablePermissionState.kt:47)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        composer.startReplaceableGroup(-1903070007);
        boolean z5 = true;
        boolean z6 = (((i5 & 14) ^ 6) > 4 && composer.changed(permission)) || (i5 & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new MutablePermissionState(permission, context, PermissionsUtilKt.findActivity(context));
            composer.updateRememberedValue(rememberedValue);
        }
        final MutablePermissionState mutablePermissionState = (MutablePermissionState) rememberedValue;
        composer.endReplaceableGroup();
        PermissionsUtilKt.PermissionLifecycleCheckerEffect(mutablePermissionState, null, composer, 0, 2);
        ActivityResultContracts$RequestPermission activityResultContracts$RequestPermission = new ActivityResultContracts$RequestPermission();
        composer.startReplaceableGroup(-1903069605);
        boolean changed = composer.changed(mutablePermissionState);
        if ((((i5 & 112) ^ 48) <= 32 || !composer.changedInstance(function1)) && (i5 & 48) != 32) {
            z5 = false;
        }
        boolean z7 = changed | z5;
        Object rememberedValue2 = composer.rememberedValue();
        if (z7 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function1<Boolean, Unit>() { // from class: com.google.accompanist.permissions.MutablePermissionStateKt$rememberMutablePermissionState$launcher$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z8) {
                    MutablePermissionState.this.refreshPermissionStatus$permissions_release();
                    function1.invoke(Boolean.valueOf(z8));
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        final ManagedActivityResultLauncher rememberLauncherForActivityResult = ActivityResultRegistryKt.rememberLauncherForActivityResult(activityResultContracts$RequestPermission, (Function1) rememberedValue2, composer, 8);
        EffectsKt.DisposableEffect(mutablePermissionState, rememberLauncherForActivityResult, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.google.accompanist.permissions.MutablePermissionStateKt$rememberMutablePermissionState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                MutablePermissionState.this.setLauncher$permissions_release(rememberLauncherForActivityResult);
                final MutablePermissionState mutablePermissionState2 = MutablePermissionState.this;
                return new DisposableEffectResult() { // from class: com.google.accompanist.permissions.MutablePermissionStateKt$rememberMutablePermissionState$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        MutablePermissionState.this.setLauncher$permissions_release(null);
                    }
                };
            }
        }, composer, ManagedActivityResultLauncher.$stable << 3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return mutablePermissionState;
    }
}
