package com.google.accompanist.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import com.google.accompanist.permissions.PermissionStatus;
import com.google.accompanist.permissions.PermissionsUtilKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a!\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\r\u001a\u00020\f*\u00020\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001b\u0010\u0012\u001a\u00020\u0011*\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001b\u0010\u0014\u001a\u00020\u0011*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0014\u0010\u0015\"\u001e\u0010\u0017\u001a\u00020\u0011*\u00020\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\"\u001e\u0010\u0014\u001a\u00020\u0011*\u00020\u00168FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001b\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/google/accompanist/permissions/MutablePermissionState;", "permissionState", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycleEvent", BuildConfig.FLAVOR, "PermissionLifecycleCheckerEffect", "(Lcom/google/accompanist/permissions/MutablePermissionState;Landroidx/lifecycle/Lifecycle$Event;Landroidx/compose/runtime/Composer;II)V", BuildConfig.FLAVOR, "permissions", "PermissionsLifecycleCheckerEffect", "(Ljava/util/List;Landroidx/lifecycle/Lifecycle$Event;Landroidx/compose/runtime/Composer;II)V", "Landroid/content/Context;", "Landroid/app/Activity;", "findActivity", "(Landroid/content/Context;)Landroid/app/Activity;", BuildConfig.FLAVOR, "permission", BuildConfig.FLAVOR, "checkPermission", "(Landroid/content/Context;Ljava/lang/String;)Z", "shouldShowRationale", "(Landroid/app/Activity;Ljava/lang/String;)Z", "Lcom/google/accompanist/permissions/PermissionStatus;", "isGranted", "(Lcom/google/accompanist/permissions/PermissionStatus;)Z", "isGranted$annotations", "(Lcom/google/accompanist/permissions/PermissionStatus;)V", "getShouldShowRationale", "getShouldShowRationale$annotations", "permissions_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PermissionsUtilKt {
    public static final void PermissionLifecycleCheckerEffect(final MutablePermissionState permissionState, final Lifecycle.Event event, Composer composer, final int i5, final int i6) {
        int i7;
        Intrinsics.checkNotNullParameter(permissionState, "permissionState");
        Composer startRestartGroup = composer.startRestartGroup(-1770945943);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 14) == 0) {
            i7 = (startRestartGroup.changed(permissionState) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i8 = i6 & 2;
        if (i8 != 0) {
            i7 |= 48;
        } else if ((i5 & 112) == 0) {
            i7 |= startRestartGroup.changed(event) ? 32 : 16;
        }
        if ((i7 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (i8 != 0) {
                event = Lifecycle.Event.ON_RESUME;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1770945943, i7, -1, "com.google.accompanist.permissions.PermissionLifecycleCheckerEffect (PermissionsUtil.kt:74)");
            }
            startRestartGroup.startReplaceableGroup(-899069829);
            boolean z5 = (i7 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new LifecycleEventObserver() { // from class: v0.b
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event2) {
                        PermissionsUtilKt.PermissionLifecycleCheckerEffect$lambda$1$lambda$0(Lifecycle.Event.this, permissionState, lifecycleOwner, event2);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final LifecycleEventObserver lifecycleEventObserver = (LifecycleEventObserver) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            final Lifecycle lifecycle = ((LifecycleOwner) startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner())).getLifecycle();
            EffectsKt.DisposableEffect(lifecycle, lifecycleEventObserver, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.google.accompanist.permissions.PermissionsUtilKt$PermissionLifecycleCheckerEffect$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    Lifecycle.this.addObserver(lifecycleEventObserver);
                    final Lifecycle lifecycle2 = Lifecycle.this;
                    final LifecycleEventObserver lifecycleEventObserver2 = lifecycleEventObserver;
                    return new DisposableEffectResult() { // from class: com.google.accompanist.permissions.PermissionsUtilKt$PermissionLifecycleCheckerEffect$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            Lifecycle.this.removeObserver(lifecycleEventObserver2);
                        }
                    };
                }
            }, startRestartGroup, 72);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.permissions.PermissionsUtilKt$PermissionLifecycleCheckerEffect$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    PermissionsUtilKt.PermissionLifecycleCheckerEffect(MutablePermissionState.this, event, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PermissionLifecycleCheckerEffect$lambda$1$lambda$0(Lifecycle.Event event, MutablePermissionState permissionState, LifecycleOwner lifecycleOwner, Lifecycle.Event event2) {
        Intrinsics.checkNotNullParameter(permissionState, "$permissionState");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event2, "event");
        if (event2 != event || Intrinsics.areEqual(permissionState.getStatus(), PermissionStatus.Granted.INSTANCE)) {
            return;
        }
        permissionState.refreshPermissionStatus$permissions_release();
    }

    public static final void PermissionsLifecycleCheckerEffect(final List<MutablePermissionState> permissions, final Lifecycle.Event event, Composer composer, final int i5, final int i6) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Composer startRestartGroup = composer.startRestartGroup(1533427666);
        if ((i6 & 2) != 0) {
            event = Lifecycle.Event.ON_RESUME;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1533427666, i5, -1, "com.google.accompanist.permissions.PermissionsLifecycleCheckerEffect (PermissionsUtil.kt:104)");
        }
        startRestartGroup.startReplaceableGroup(-1664752211);
        boolean changed = startRestartGroup.changed(permissions);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new LifecycleEventObserver() { // from class: v0.a
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event2) {
                    PermissionsUtilKt.PermissionsLifecycleCheckerEffect$lambda$3$lambda$2(Lifecycle.Event.this, permissions, lifecycleOwner, event2);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        final LifecycleEventObserver lifecycleEventObserver = (LifecycleEventObserver) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        final Lifecycle lifecycle = ((LifecycleOwner) startRestartGroup.consume(LocalLifecycleOwnerKt.getLocalLifecycleOwner())).getLifecycle();
        EffectsKt.DisposableEffect(lifecycle, lifecycleEventObserver, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: com.google.accompanist.permissions.PermissionsUtilKt$PermissionsLifecycleCheckerEffect$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                Lifecycle.this.addObserver(lifecycleEventObserver);
                final Lifecycle lifecycle2 = Lifecycle.this;
                final LifecycleEventObserver lifecycleEventObserver2 = lifecycleEventObserver;
                return new DisposableEffectResult() { // from class: com.google.accompanist.permissions.PermissionsUtilKt$PermissionsLifecycleCheckerEffect$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        Lifecycle.this.removeObserver(lifecycleEventObserver2);
                    }
                };
            }
        }, startRestartGroup, 72);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.permissions.PermissionsUtilKt$PermissionsLifecycleCheckerEffect$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    PermissionsUtilKt.PermissionsLifecycleCheckerEffect(permissions, event, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PermissionsLifecycleCheckerEffect$lambda$3$lambda$2(Lifecycle.Event event, List permissions, LifecycleOwner lifecycleOwner, Lifecycle.Event event2) {
        Intrinsics.checkNotNullParameter(permissions, "$permissions");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event2, "event");
        if (event2 == event) {
            Iterator it = permissions.iterator();
            while (it.hasNext()) {
                MutablePermissionState mutablePermissionState = (MutablePermissionState) it.next();
                if (!Intrinsics.areEqual(mutablePermissionState.getStatus(), PermissionStatus.Granted.INSTANCE)) {
                    mutablePermissionState.refreshPermissionStatus$permissions_release();
                }
            }
        }
    }

    public static final boolean checkPermission(Context context, String permission) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(permission, "permission");
        return ContextCompat.checkSelfPermission(context, permission) == 0;
    }

    public static final Activity findActivity(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(context, "getBaseContext(...)");
        }
        throw new IllegalStateException("Permissions should be called in the context of an Activity");
    }

    public static final boolean getShouldShowRationale(PermissionStatus permissionStatus) {
        Intrinsics.checkNotNullParameter(permissionStatus, "<this>");
        if (Intrinsics.areEqual(permissionStatus, PermissionStatus.Granted.INSTANCE)) {
            return false;
        }
        if (permissionStatus instanceof PermissionStatus.Denied) {
            return ((PermissionStatus.Denied) permissionStatus).getShouldShowRationale();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final boolean isGranted(PermissionStatus permissionStatus) {
        Intrinsics.checkNotNullParameter(permissionStatus, "<this>");
        return Intrinsics.areEqual(permissionStatus, PermissionStatus.Granted.INSTANCE);
    }

    public static final boolean shouldShowRationale(Activity activity, String permission) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(permission, "permission");
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, permission);
    }
}
