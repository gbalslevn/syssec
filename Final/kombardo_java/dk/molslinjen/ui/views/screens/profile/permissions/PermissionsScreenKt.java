package dk.molslinjen.ui.views.screens.profile.permissions;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult;
import androidx.lifecycle.compose.LifecycleResumePauseEffectScope;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.core.Environment;
import dk.molslinjen.extensions.PermissionExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.reusable.dialog.TextDialogKt;
import dk.molslinjen.ui.views.screens.profile.permissions.AppPermission;
import dk.molslinjen.ui.views.screens.profile.permissions.PermissionsScreenKt;
import dk.molslinjen.ui.views.screens.profile.permissions.PermissionsViewModel;
import dk.molslinjen.ui.views.screens.profile.permissions.rows.GenericPermissionRowKt;
import dk.molslinjen.ui.views.screens.profile.permissions.rows.MarketingPushNotificationsPermissionRowKt;
import dk.molslinjen.ui.views.screens.profile.permissions.rows.PushNotificationsPermissionRowKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001au\u0010\u0011\u001a\u00020\u00042\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\r2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\rH\u0003¢\u0006\u0004\b\u0011\u0010\u0012\u001aa\u0010\u0013\u001a\u00020\u00042\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0003¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/permissions/PermissionsViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", BuildConfig.FLAVOR, "PermissionsScreen", "(Ldk/molslinjen/ui/views/screens/profile/permissions/PermissionsViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "Lkotlin/Function2;", "Ldk/molslinjen/ui/views/screens/profile/permissions/AppPermission;", BuildConfig.FLAVOR, "showDialog", "isPushNotificationEnabled", "isMarketingPushNotificationEnabled", "Lkotlin/Function1;", "togglePushNotifications", "toggleMarketingPushNotifications", "onLocationPermissionToggled", "PermissionsContent", "(Lkotlin/jvm/functions/Function2;ZZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "MarketingPushPermissionRow", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PermissionsScreenKt {
    private static final void MarketingPushPermissionRow(final Function2<? super AppPermission, ? super Boolean, Unit> function2, final Function1<? super Boolean, Unit> function1, final Function1<? super Boolean, Unit> function12, final boolean z5, final boolean z6, Composer composer, final int i5) {
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(975381283);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(975381283, i6, -1, "dk.molslinjen.ui.views.screens.profile.permissions.MarketingPushPermissionRow (PermissionsScreen.kt:138)");
            }
            if (Build.VERSION.SDK_INT >= 33) {
                startRestartGroup.startReplaceGroup(-643806179);
                AppPermission appPermission = AppPermission.MarketingNotifications;
                startRestartGroup.startReplaceGroup(-1821880348);
                int i7 = i6 & 896;
                boolean z7 = ((i6 & 14) == 4) | (i7 == 256);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z7 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function2() { // from class: U3.e
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit MarketingPushPermissionRow$lambda$15$lambda$14;
                            MarketingPushPermissionRow$lambda$15$lambda$14 = PermissionsScreenKt.MarketingPushPermissionRow$lambda$15$lambda$14(Function1.this, function2, (AppPermission) obj, ((Boolean) obj2).booleanValue());
                            return MarketingPushPermissionRow$lambda$15$lambda$14;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                Function2 function22 = (Function2) rememberedValue;
                startRestartGroup.endReplaceGroup();
                startRestartGroup.startReplaceGroup(-1821875023);
                boolean z8 = (i7 == 256) | ((i6 & 112) == 32);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z8 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: U3.f
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit MarketingPushPermissionRow$lambda$17$lambda$16;
                            MarketingPushPermissionRow$lambda$17$lambda$16 = PermissionsScreenKt.MarketingPushPermissionRow$lambda$17$lambda$16(Function1.this, function1, ((Boolean) obj).booleanValue());
                            return MarketingPushPermissionRow$lambda$17$lambda$16;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                GenericPermissionRowKt.GenericPermissionRow(function22, appPermission, (Function1) rememberedValue2, ComposableLambdaKt.rememberComposableLambda(1904727395, true, new PermissionsScreenKt$MarketingPushPermissionRow$3(z5, z6, function12), startRestartGroup, 54), startRestartGroup, 3120, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-642762843);
                startRestartGroup.startReplaceGroup(-1821842645);
                boolean z9 = ((i6 & 7168) == 2048) | ((i6 & 896) == 256) | ((i6 & 14) == 4);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (z9 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: U3.g
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit MarketingPushPermissionRow$lambda$19$lambda$18;
                            MarketingPushPermissionRow$lambda$19$lambda$18 = PermissionsScreenKt.MarketingPushPermissionRow$lambda$19$lambda$18(z5, function12, function2, ((Boolean) obj).booleanValue());
                            return MarketingPushPermissionRow$lambda$19$lambda$18;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                MarketingPushNotificationsPermissionRowKt.MarketingPushNotificationPermissionRow(z5, z6, (Function1) rememberedValue3, startRestartGroup, (i6 >> 9) & 126);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: U3.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MarketingPushPermissionRow$lambda$20;
                    MarketingPushPermissionRow$lambda$20 = PermissionsScreenKt.MarketingPushPermissionRow$lambda$20(Function2.this, function1, function12, z5, z6, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MarketingPushPermissionRow$lambda$20;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MarketingPushPermissionRow$lambda$15$lambda$14(Function1 function1, Function2 function2, AppPermission type, boolean z5) {
        Intrinsics.checkNotNullParameter(type, "type");
        function1.invoke(Boolean.TRUE);
        function2.invoke(type, Boolean.valueOf(z5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MarketingPushPermissionRow$lambda$17$lambda$16(Function1 function1, Function1 function12, boolean z5) {
        function1.invoke(Boolean.TRUE);
        function12.invoke(Boolean.valueOf(z5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MarketingPushPermissionRow$lambda$19$lambda$18(boolean z5, Function1 function1, Function2 function2, boolean z6) {
        if (z5) {
            function1.invoke(Boolean.valueOf(z6));
        } else {
            function1.invoke(Boolean.TRUE);
            function2.invoke(AppPermission.MarketingNotifications, Boolean.FALSE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MarketingPushPermissionRow$lambda$20(Function2 function2, Function1 function1, Function1 function12, boolean z5, boolean z6, int i5, Composer composer, int i6) {
        MarketingPushPermissionRow(function2, function1, function12, z5, z6, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PermissionsContent(final Function2<? super AppPermission, ? super Boolean, Unit> function2, final boolean z5, final boolean z6, final Function1<? super Boolean, Unit> function1, final Function1<? super Boolean, Unit> function12, final Function1<? super Boolean, Unit> function13, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1319412614);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(function12) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i6 |= startRestartGroup.changedInstance(function13) ? 131072 : 65536;
        }
        if ((74899 & i6) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1319412614, i6, -1, "dk.molslinjen.ui.views.screens.profile.permissions.PermissionsContent (PermissionsScreen.kt:89)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, startRestartGroup, 0, 15);
            int i7 = i6 >> 6;
            int i8 = i7 & 112;
            int i9 = i6 << 6;
            PushNotificationsPermissionRowKt.PushNotificationPermissionRow(z5, function1, function2, startRestartGroup, ((i6 >> 3) & 14) | i8 | (i9 & 896));
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, startRestartGroup, 0, 15);
            int i10 = i6 & 14;
            MarketingPushPermissionRow(function2, function1, function12, z5, z6, startRestartGroup, i10 | i8 | (i7 & 896) | (i9 & 7168) | (i9 & 57344));
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, startRestartGroup, 0, 15);
            composer2 = startRestartGroup;
            GenericPermissionRowKt.GenericPermissionRow(function2, AppPermission.Location, null, ComposableLambdaKt.rememberComposableLambda(-419288193, true, new PermissionsScreenKt$PermissionsContent$1$1(Environment.INSTANCE.isKombardo() ? R.string.permission_location_description_KE : R.string.permission_location_description_ML, function13), startRestartGroup, 54), startRestartGroup, i10 | 3120, 4);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: U3.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PermissionsContent$lambda$13;
                    PermissionsContent$lambda$13 = PermissionsScreenKt.PermissionsContent$lambda$13(Function2.this, z5, z6, function1, function12, function13, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return PermissionsContent$lambda$13;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionsContent$lambda$13(Function2 function2, boolean z5, boolean z6, Function1 function1, Function1 function12, Function1 function13, int i5, Composer composer, int i6) {
        PermissionsContent(function2, z5, z6, function1, function12, function13, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r14v3 */
    public static final void PermissionsScreen(final PermissionsViewModel viewModel, final DestinationsNavigator navigator, Composer composer, final int i5) {
        int i6;
        ?? r14;
        boolean z5;
        Object obj;
        int i7;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Composer startRestartGroup = composer.startRestartGroup(1031570674);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        int i8 = i6;
        if ((i8 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1031570674, i8, -1, "dk.molslinjen.ui.views.screens.profile.permissions.PermissionsScreen (PermissionsScreen.kt:33)");
            }
            final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final PermissionsViewModel.ViewState viewState = (PermissionsViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            Unit unit = Unit.INSTANCE;
            startRestartGroup.startReplaceGroup(-1080605719);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: U3.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        LifecyclePauseOrDisposeEffectResult PermissionsScreen$lambda$2$lambda$1;
                        PermissionsScreen$lambda$2$lambda$1 = PermissionsScreenKt.PermissionsScreen$lambda$2$lambda$1(PermissionsViewModel.this, (LifecycleResumePauseEffectScope) obj2);
                        return PermissionsScreen$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            LifecycleEffectKt.LifecycleResumeEffect(unit, null, (Function1) rememberedValue, startRestartGroup, 6, 2);
            Pair<AppPermission, Boolean> settingsDialogAppPermission = viewState.getSettingsDialogAppPermission();
            startRestartGroup.startReplaceGroup(-1080601084);
            if (settingsDialogAppPermission == null) {
                r14 = 1;
                z5 = false;
                obj = null;
                i7 = i8;
            } else {
                AppPermission component1 = settingsDialogAppPermission.component1();
                boolean booleanValue = settingsDialogAppPermission.component2().booleanValue();
                String stringResource = StringResources_androidKt.stringResource(component1.titleRes(booleanValue), startRestartGroup, 0);
                String stringResource2 = StringResources_androidKt.stringResource(component1.descriptionRes(booleanValue), startRestartGroup, 0);
                String stringResource3 = StringResources_androidKt.stringResource(R.string.button_openSettings, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(1799117266);
                boolean changedInstance2 = startRestartGroup.changedInstance(context) | startRestartGroup.changedInstance(viewModel);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: U3.b
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit PermissionsScreen$lambda$7$lambda$4$lambda$3;
                            PermissionsScreen$lambda$7$lambda$4$lambda$3 = PermissionsScreenKt.PermissionsScreen$lambda$7$lambda$4$lambda$3(context, viewModel);
                            return PermissionsScreen$lambda$7$lambda$4$lambda$3;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                SimpleButtonData simpleButtonData = new SimpleButtonData(stringResource3, false, false, (Function0) rememberedValue2, 6, null);
                String stringResource4 = StringResources_androidKt.stringResource(R.string.button_cancel, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(1799126043);
                boolean changedInstance3 = startRestartGroup.changedInstance(viewModel);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new PermissionsScreenKt$PermissionsScreen$2$2$1(viewModel);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                SimpleButtonData simpleButtonData2 = new SimpleButtonData(stringResource4, false, false, (Function0) ((KFunction) rememberedValue3), 6, null);
                startRestartGroup.startReplaceGroup(1799129595);
                boolean changedInstance4 = startRestartGroup.changedInstance(viewModel);
                Object rememberedValue4 = startRestartGroup.rememberedValue();
                if (changedInstance4 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new PermissionsScreenKt$PermissionsScreen$2$3$1(viewModel);
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                startRestartGroup.endReplaceGroup();
                r14 = 1;
                z5 = false;
                obj = null;
                i7 = i8;
                TextDialogKt.TextDialog(stringResource, stringResource2, simpleButtonData, null, simpleButtonData2, true, (Function0) ((KFunction) rememberedValue4), startRestartGroup, 196608, 8);
            }
            startRestartGroup.endReplaceGroup();
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, r14, obj);
            String stringResource5 = StringResources_androidKt.stringResource(R.string.profile_appPermissionsTitle, startRestartGroup, 6);
            startRestartGroup.startReplaceGroup(-1080570605);
            int i9 = i7 & 112;
            boolean z6 = i9 == 32 ? r14 : z5;
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                rememberedValue5 = new PermissionsScreenKt$PermissionsScreen$3$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            Function0 function0 = (Function0) rememberedValue5;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-1080569037);
            boolean z7 = i9 == 32 ? r14 : z5;
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (z7 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                rememberedValue6 = new PermissionsScreenKt$PermissionsScreen$4$1(navigator);
                startRestartGroup.updateRememberedValue(rememberedValue6);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(fillMaxSize$default, 0.0f, stringResource5, null, 0L, function0, (Function0) rememberedValue6, null, null, ComposableLambdaKt.rememberComposableLambda(-1319535937, r14, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.permissions.PermissionsScreenKt$PermissionsScreen$5
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i10) {
                    Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                    if ((i10 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1319535937, i10, -1, "dk.molslinjen.ui.views.screens.profile.permissions.PermissionsScreen.<anonymous> (PermissionsScreen.kt:70)");
                    }
                    PermissionsViewModel permissionsViewModel = PermissionsViewModel.this;
                    composer3.startReplaceGroup(1799140856);
                    boolean changedInstance5 = composer3.changedInstance(permissionsViewModel);
                    Object rememberedValue7 = composer3.rememberedValue();
                    if (changedInstance5 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue7 = new PermissionsScreenKt$PermissionsScreen$5$1$1(permissionsViewModel);
                        composer3.updateRememberedValue(rememberedValue7);
                    }
                    composer3.endReplaceGroup();
                    Function2 function2 = (Function2) ((KFunction) rememberedValue7);
                    boolean isPushNotificationEnabled = viewState.getIsPushNotificationEnabled();
                    boolean isMarketingPushNotificationEnabled = viewState.getIsMarketingPushNotificationEnabled();
                    PermissionsViewModel permissionsViewModel2 = PermissionsViewModel.this;
                    composer3.startReplaceGroup(1799148582);
                    boolean changedInstance6 = composer3.changedInstance(permissionsViewModel2);
                    Object rememberedValue8 = composer3.rememberedValue();
                    if (changedInstance6 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue8 = new PermissionsScreenKt$PermissionsScreen$5$2$1(permissionsViewModel2);
                        composer3.updateRememberedValue(rememberedValue8);
                    }
                    composer3.endReplaceGroup();
                    Function1 function1 = (Function1) ((KFunction) rememberedValue8);
                    PermissionsViewModel permissionsViewModel3 = PermissionsViewModel.this;
                    composer3.startReplaceGroup(1799151535);
                    boolean changedInstance7 = composer3.changedInstance(permissionsViewModel3);
                    Object rememberedValue9 = composer3.rememberedValue();
                    if (changedInstance7 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue9 = new PermissionsScreenKt$PermissionsScreen$5$3$1(permissionsViewModel3);
                        composer3.updateRememberedValue(rememberedValue9);
                    }
                    composer3.endReplaceGroup();
                    Function1 function12 = (Function1) ((KFunction) rememberedValue9);
                    PermissionsViewModel permissionsViewModel4 = PermissionsViewModel.this;
                    composer3.startReplaceGroup(1799154593);
                    boolean changedInstance8 = composer3.changedInstance(permissionsViewModel4);
                    Object rememberedValue10 = composer3.rememberedValue();
                    if (changedInstance8 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue10 = new PermissionsScreenKt$PermissionsScreen$5$4$1(permissionsViewModel4);
                        composer3.updateRememberedValue(rememberedValue10);
                    }
                    composer3.endReplaceGroup();
                    PermissionsScreenKt.PermissionsContent(function2, isPushNotificationEnabled, isMarketingPushNotificationEnabled, function1, function12, (Function1) ((KFunction) rememberedValue10), composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, 805306374, 410);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: U3.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    Unit PermissionsScreen$lambda$11;
                    PermissionsScreen$lambda$11 = PermissionsScreenKt.PermissionsScreen$lambda$11(PermissionsViewModel.this, navigator, i5, (Composer) obj2, ((Integer) obj3).intValue());
                    return PermissionsScreen$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionsScreen$lambda$11(PermissionsViewModel permissionsViewModel, DestinationsNavigator destinationsNavigator, int i5, Composer composer, int i6) {
        PermissionsScreen(permissionsViewModel, destinationsNavigator, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LifecyclePauseOrDisposeEffectResult PermissionsScreen$lambda$2$lambda$1(PermissionsViewModel permissionsViewModel, final LifecycleResumePauseEffectScope LifecycleResumeEffect) {
        Intrinsics.checkNotNullParameter(LifecycleResumeEffect, "$this$LifecycleResumeEffect");
        permissionsViewModel.reloadPermissionState();
        return new LifecyclePauseOrDisposeEffectResult() { // from class: dk.molslinjen.ui.views.screens.profile.permissions.PermissionsScreenKt$PermissionsScreen$lambda$2$lambda$1$$inlined$onPauseOrDispose$1
            @Override // androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult
            public void runPauseOrOnDisposeEffect() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PermissionsScreen$lambda$7$lambda$4$lambda$3(Context context, PermissionsViewModel permissionsViewModel) {
        PermissionExtensionsKt.openAppSettings(context);
        permissionsViewModel.dismissSettingsDialog();
        return Unit.INSTANCE;
    }
}
