package dk.molslinjen.ui.views.screens.profile.vehicles.register;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.account.LicensePlateValidation;
import dk.molslinjen.extensions.DoubleExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.dialog.CustomDialogKt;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.screens.profile.vehicles.register.ProfileVehicleValidationDialogKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a;\u0010\b\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0003¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;", "licensePlateValidation", BuildConfig.FLAVOR, "isLoading", "Lkotlin/Function0;", BuildConfig.FLAVOR, "registerCallback", "cancelRegister", "ProfileVehicleValidationDialog", "(Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DialogContent", "(Ldk/molslinjen/domain/model/account/LicensePlateValidation$Valid;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProfileVehicleValidationDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void DialogContent(final LicensePlateValidation.Valid valid, Composer composer, final int i5) {
        int i6;
        int i7;
        Composer composer2;
        Composer composer3;
        Composer startRestartGroup = composer.startRestartGroup(376730519);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(valid) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer3 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(376730519, i6, -1, "dk.molslinjen.ui.views.screens.profile.vehicles.register.DialogContent (ProfileVehicleValidationDialog.kt:71)");
            }
            Alignment.Companion companion = Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally = companion.getCenterHorizontally();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), centerHorizontally, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            AppColor appColor = AppColor.INSTANCE;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(companion2, appColor.m3267getGrey40d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.m2599constructorimpl(20));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_car, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion2, Dp.m2599constructorimpl(24)), appColor.m3281getWhite0d7_KjU(), startRestartGroup, 3456, 0);
            startRestartGroup.endNode();
            float f5 = 8;
            TextKt.m940Text4IGK_g(valid.getManufacturer() + " " + valid.getModel(), PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f5), 5, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), startRestartGroup, 48, 1572864, 65532);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl((float) 16)), companion.getTop(), startRestartGroup, 6);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Double heightInMeters = valid.getHeightInMeters();
            startRestartGroup.startReplaceGroup(732641538);
            if (heightInMeters == null) {
                composer2 = startRestartGroup;
                i7 = 2;
            } else {
                i7 = 2;
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_vehicle_registerDialog_vehicleHeight, new Object[]{DoubleExtensionsKt.format(heightInMeters.doubleValue(), 2)}, startRestartGroup, 6), null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer2, 384, 1572864, 65530);
                Unit unit = Unit.INSTANCE;
            }
            composer2.endReplaceGroup();
            Double lengthInMeters = valid.getLengthInMeters();
            Composer composer4 = composer2;
            composer4.startReplaceGroup(732651426);
            if (lengthInMeters == null) {
                composer3 = composer4;
            } else {
                composer3 = composer4;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_vehicle_registerDialog_vehicleLength, new Object[]{DoubleExtensionsKt.format(lengthInMeters.doubleValue(), i7)}, composer4, 6), null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer3, 384, 1572864, 65530);
                Unit unit2 = Unit.INSTANCE;
            }
            composer3.endReplaceGroup();
            composer3.endNode();
            composer3.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: b4.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DialogContent$lambda$8;
                    DialogContent$lambda$8 = ProfileVehicleValidationDialogKt.DialogContent$lambda$8(LicensePlateValidation.Valid.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DialogContent$lambda$8;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DialogContent$lambda$8(LicensePlateValidation.Valid valid, int i5, Composer composer, int i6) {
        DialogContent(valid, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void ProfileVehicleValidationDialog(final LicensePlateValidation.Valid licensePlateValidation, final boolean z5, final Function0<Unit> registerCallback, final Function0<Unit> cancelRegister, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(licensePlateValidation, "licensePlateValidation");
        Intrinsics.checkNotNullParameter(registerCallback, "registerCallback");
        Intrinsics.checkNotNullParameter(cancelRegister, "cancelRegister");
        Composer startRestartGroup = composer.startRestartGroup(-1837876684);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(licensePlateValidation) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(registerCallback) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(cancelRegister) ? 2048 : 1024;
        }
        int i7 = i6;
        if ((i7 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1837876684, i7, -1, "dk.molslinjen.ui.views.screens.profile.vehicles.register.ProfileVehicleValidationDialog (ProfileVehicleValidationDialog.kt:39)");
            }
            SimpleButtonData simpleButtonData = new SimpleButtonData(StringResources_androidKt.stringResource(R.string.profile_vehicle_registerDialog_cta, startRestartGroup, 6), z5, false, registerCallback, 4, null);
            SimpleButtonData simpleButtonData2 = new SimpleButtonData(StringResources_androidKt.stringResource(R.string.button_cancel, startRestartGroup, 6), false, !z5, cancelRegister, 2, null);
            startRestartGroup.startReplaceGroup(-1434293462);
            boolean z6 = ((i7 & 112) == 32) | ((i7 & 7168) == 2048);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: b4.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit ProfileVehicleValidationDialog$lambda$1$lambda$0;
                        ProfileVehicleValidationDialog$lambda$1$lambda$0 = ProfileVehicleValidationDialogKt.ProfileVehicleValidationDialog$lambda$1$lambda$0(z5, cancelRegister);
                        return ProfileVehicleValidationDialog$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            CustomDialogKt.CustomDialog(simpleButtonData, null, simpleButtonData2, (Function0) rememberedValue, false, ComposableLambdaKt.rememberComposableLambda(1095956719, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.vehicles.register.ProfileVehicleValidationDialogKt$ProfileVehicleValidationDialog$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope CustomDialog, Composer composer3, int i8) {
                    Intrinsics.checkNotNullParameter(CustomDialog, "$this$CustomDialog");
                    if ((i8 & 17) == 16 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1095956719, i8, -1, "dk.molslinjen.ui.views.screens.profile.vehicles.register.ProfileVehicleValidationDialog.<anonymous> (ProfileVehicleValidationDialog.kt:57)");
                    }
                    TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.profile_vehicle_registerDialog_title, new Object[]{LicensePlateValidation.Valid.this.getLicensePlate()}, composer3, 6), null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), composer3, 0, 1572864, 65022);
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), composer3, 6);
                    ProfileVehicleValidationDialogKt.DialogContent(LicensePlateValidation.Valid.this, composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), composer2, 196608, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: b4.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProfileVehicleValidationDialog$lambda$2;
                    ProfileVehicleValidationDialog$lambda$2 = ProfileVehicleValidationDialogKt.ProfileVehicleValidationDialog$lambda$2(LicensePlateValidation.Valid.this, z5, registerCallback, cancelRegister, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProfileVehicleValidationDialog$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleValidationDialog$lambda$1$lambda$0(boolean z5, Function0 function0) {
        if (!z5) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProfileVehicleValidationDialog$lambda$2(LicensePlateValidation.Valid valid, boolean z5, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        ProfileVehicleValidationDialog(valid, z5, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
