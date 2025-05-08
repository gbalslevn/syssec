package dk.molslinjen.ui.views.screens.booking.shared;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.dialog.SimpleButtonData;
import dk.molslinjen.ui.views.reusable.dialog.TextDialogKt;
import dk.molslinjen.ui.views.screens.booking.shared.CheckoutMultiRideFlowTopBarKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001d\u0010\u0003\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a+\u0010\b\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/Function0;", BuildConfig.FLAVOR, "abortMultiRideFlow", "CheckoutMultiRideFlowTopBar", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/MutableState;", BuildConfig.FLAVOR, "showDialog", "AbortMultiRideFlowDialog", "(Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CheckoutMultiRideFlowTopBarKt {
    public static final void AbortMultiRideFlowDialog(final MutableState<Boolean> showDialog, final Function0<Unit> abortMultiRideFlow, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(showDialog, "showDialog");
        Intrinsics.checkNotNullParameter(abortMultiRideFlow, "abortMultiRideFlow");
        Composer startRestartGroup = composer.startRestartGroup(-1623303580);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(showDialog) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(abortMultiRideFlow) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1623303580, i6, -1, "dk.molslinjen.ui.views.screens.booking.shared.AbortMultiRideFlowDialog (CheckoutMultiRideFlowTopBar.kt:53)");
            }
            if (showDialog.getValue().booleanValue()) {
                String stringResource = StringResources_androidKt.stringResource(R.string.multiRideFlow_abort_dialogDescription, startRestartGroup, 6);
                String stringResource2 = StringResources_androidKt.stringResource(R.string.multiRideFlow_abort_abortMultiRide, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(-856936625);
                int i7 = i6 & 14;
                boolean z5 = ((i6 & 112) == 32) | (i7 == 4);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = new Function0() { // from class: a3.x
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit AbortMultiRideFlowDialog$lambda$6$lambda$5;
                            AbortMultiRideFlowDialog$lambda$6$lambda$5 = CheckoutMultiRideFlowTopBarKt.AbortMultiRideFlowDialog$lambda$6$lambda$5(MutableState.this, abortMultiRideFlow);
                            return AbortMultiRideFlowDialog$lambda$6$lambda$5;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                SimpleButtonData simpleButtonData = new SimpleButtonData(stringResource2, false, false, (Function0) rememberedValue, 6, null);
                String stringResource3 = StringResources_androidKt.stringResource(R.string.button_cancel, startRestartGroup, 6);
                startRestartGroup.startReplaceGroup(-856928286);
                boolean z6 = i7 == 4;
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function0() { // from class: a3.y
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit AbortMultiRideFlowDialog$lambda$8$lambda$7;
                            AbortMultiRideFlowDialog$lambda$8$lambda$7 = CheckoutMultiRideFlowTopBarKt.AbortMultiRideFlowDialog$lambda$8$lambda$7(MutableState.this);
                            return AbortMultiRideFlowDialog$lambda$8$lambda$7;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                SimpleButtonData simpleButtonData2 = new SimpleButtonData(stringResource3, false, false, (Function0) rememberedValue2, 6, null);
                startRestartGroup.startReplaceGroup(-856942942);
                boolean z7 = i7 == 4;
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (z7 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function0() { // from class: a3.z
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit AbortMultiRideFlowDialog$lambda$10$lambda$9;
                            AbortMultiRideFlowDialog$lambda$10$lambda$9 = CheckoutMultiRideFlowTopBarKt.AbortMultiRideFlowDialog$lambda$10$lambda$9(MutableState.this);
                            return AbortMultiRideFlowDialog$lambda$10$lambda$9;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                TextDialogKt.TextDialog(stringResource, null, null, simpleButtonData, simpleButtonData2, false, (Function0) rememberedValue3, startRestartGroup, 0, 38);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: a3.A
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit AbortMultiRideFlowDialog$lambda$11;
                    AbortMultiRideFlowDialog$lambda$11 = CheckoutMultiRideFlowTopBarKt.AbortMultiRideFlowDialog$lambda$11(MutableState.this, abortMultiRideFlow, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return AbortMultiRideFlowDialog$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AbortMultiRideFlowDialog$lambda$10$lambda$9(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AbortMultiRideFlowDialog$lambda$11(MutableState mutableState, Function0 function0, int i5, Composer composer, int i6) {
        AbortMultiRideFlowDialog(mutableState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AbortMultiRideFlowDialog$lambda$6$lambda$5(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.FALSE);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AbortMultiRideFlowDialog$lambda$8$lambda$7(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.INSTANCE;
    }

    public static final void CheckoutMultiRideFlowTopBar(final Function0<Unit> abortMultiRideFlow, Composer composer, final int i5) {
        int i6;
        TextStyle m2295copyp1EtxEg;
        Composer composer2;
        Intrinsics.checkNotNullParameter(abortMultiRideFlow, "abortMultiRideFlow");
        Composer startRestartGroup = composer.startRestartGroup(954910501);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(abortMultiRideFlow) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(954910501, i6, -1, "dk.molslinjen.ui.views.screens.booking.shared.CheckoutMultiRideFlowTopBar (CheckoutMultiRideFlowTopBar.kt:26)");
            }
            startRestartGroup.startReplaceGroup(-907594390);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            AbortMultiRideFlowDialog(mutableState, abortMultiRideFlow, startRestartGroup, ((i6 << 3) & 112) | 6);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(ModifierExtensionsKt.defaultShadow(companion2, RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(0))), AppColor.INSTANCE.m3274getTagBlue0d7_KjU(), null, 2, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default);
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            float f5 = 16;
            float f6 = 10;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.multiRideFlow_banner, startRestartGroup, 6), RowScope.weight$default(RowScopeInstance.INSTANCE, PaddingKt.m315paddingqDBjuR0$default(companion2, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6), 0.0f, Dp.m2599constructorimpl(f6), 4, null), 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 0, 1572864, 65532);
            startRestartGroup.startReplaceGroup(-1547329374);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: a3.B
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CheckoutMultiRideFlowTopBar$lambda$3$lambda$2$lambda$1;
                        CheckoutMultiRideFlowTopBar$lambda$3$lambda$2$lambda$1 = CheckoutMultiRideFlowTopBarKt.CheckoutMultiRideFlowTopBar$lambda$3$lambda$2$lambda$1(MutableState.this);
                        return CheckoutMultiRideFlowTopBar$lambda$3$lambda$2$lambda$1;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(ClickableKt.m122clickableXHw0xAI$default(companion2, false, null, null, (Function0) rememberedValue2, 7, null), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6));
            String stringResource = StringResources_androidKt.stringResource(R.string.button_abort, startRestartGroup, 6);
            m2295copyp1EtxEg = r16.m2295copyp1EtxEg((r48 & 1) != 0 ? r16.spanStyle.m2255getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r16.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r16.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r16.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r16.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r16.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r16.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r16.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r16.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r16.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r16.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r16.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r16.spanStyle.getTextDecoration() : TextDecoration.INSTANCE.getUnderline(), (r48 & 8192) != 0 ? r16.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r16.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r16.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r16.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r16.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r16.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r16.platformStyle : null, (r48 & 1048576) != 0 ? r16.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r16.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r16.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? TypographyKt.getSubBold().paragraphStyle.getTextMotion() : null);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(stringResource, m312paddingVpY3zN4, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, m2295copyp1EtxEg, composer2, 0, 0, 65532);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: a3.C
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CheckoutMultiRideFlowTopBar$lambda$4;
                    CheckoutMultiRideFlowTopBar$lambda$4 = CheckoutMultiRideFlowTopBarKt.CheckoutMultiRideFlowTopBar$lambda$4(Function0.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CheckoutMultiRideFlowTopBar$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutMultiRideFlowTopBar$lambda$3$lambda$2$lambda$1(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckoutMultiRideFlowTopBar$lambda$4(Function0 function0, int i5, Composer composer, int i6) {
        CheckoutMultiRideFlowTopBar(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
