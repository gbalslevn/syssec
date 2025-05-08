package dk.molslinjen.ui.views.screens.booking.shared;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.extensions.domain.PriceFormatExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.shared.components.AnimatedCounterKt;
import dk.molslinjen.ui.views.shared.passengers.PassengersInfoViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class CheckoutButtonSheetBottomBarKt$CheckoutButtonSheetBottomBar$1$2 implements Function3<FlowRowScope, Composer, Integer, Unit> {
    final /* synthetic */ boolean $isEditing;
    final /* synthetic */ PassengerInfo $passengerInfo;
    final /* synthetic */ Function0<Unit> $showDetails;
    final /* synthetic */ PriceTotal $totalPrice;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CheckoutButtonSheetBottomBarKt$CheckoutButtonSheetBottomBar$1$2(Function0<Unit> function0, PassengerInfo passengerInfo, boolean z5, PriceTotal priceTotal) {
        this.$showDetails = function0;
        this.$passengerInfo = passengerInfo;
        this.$isEditing = z5;
        this.$totalPrice = priceTotal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$8$lambda$5$lambda$4(MutableState mutableState, int i5, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (((Number) mutableState.getValue()).intValue() == 0) {
            mutableState.setValue(Integer.valueOf(IntSize.m2661getWidthimpl(it.mo1948getSizeYbymL2g()) + i5));
        } else if (IntSize.m2661getWidthimpl(it.mo1948getSizeYbymL2g()) > ((Number) mutableState.getValue()).intValue()) {
            mutableState.setValue(Integer.valueOf(IntSize.m2661getWidthimpl(it.mo1948getSizeYbymL2g())));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$8$lambda$7$lambda$6(String str, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, str);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(FlowRowScope flowRowScope, Composer composer, Integer num) {
        invoke(flowRowScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(FlowRowScope FlowRow, Composer composer, int i5) {
        int i6;
        Object obj;
        boolean z5;
        int i7;
        boolean z6;
        int i8;
        Composer composer2;
        int i9;
        Composer composer3;
        String stringResource;
        int i10;
        Object obj2;
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        if ((i5 & 6) == 0) {
            i6 = i5 | (composer.changed(FlowRow) ? 4 : 2);
        } else {
            i6 = i5;
        }
        if ((i6 & 19) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(263692741, i6, -1, "dk.molslinjen.ui.views.screens.booking.shared.CheckoutButtonSheetBottomBar.<anonymous>.<anonymous> (CheckoutButtonSheetBottomBar.kt:58)");
        }
        Function0<Unit> function0 = this.$showDetails;
        composer.startReplaceGroup(-75034187);
        if (function0 == null) {
            obj = null;
            z5 = false;
            i7 = 16;
            z6 = 2;
            i8 = 6;
            composer2 = composer;
        } else {
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 8;
            float f6 = 16;
            Modifier weight$default = RowScope.weight$default(FlowRow, SizeKt.m338widthInVpY3zN4$default(PaddingKt.m312paddingVpY3zN4(companion, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f5)), Dp.m2599constructorimpl(80), 0.0f, 2, null), 1.0f, false, 2, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, weight$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            if (composer.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier m331size3ABfNKs = SizeKt.m331size3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 11, null), Dp.m2599constructorimpl(f6));
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_up_arrow, composer, 6);
            String skip = Accessibility.INSTANCE.getSkip();
            AppColor appColor = AppColor.INSTANCE;
            obj = null;
            z5 = false;
            i7 = 16;
            z6 = 2;
            i8 = 6;
            composer2 = composer;
            IconKt.m857Iconww6aTOc(painterResource, skip, m331size3ABfNKs, appColor.m3265getGrey20d7_KjU(), composer, 3456, 0);
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.checkout_buttonBar_showDetails, composer2, 6), null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer, 384, 1572864, 65530);
            composer.endNode();
            Unit unit = Unit.INSTANCE;
        }
        composer.endReplaceGroup();
        PassengerInfo passengerInfo = this.$passengerInfo;
        composer2.startReplaceGroup(-75006026);
        if (passengerInfo == null) {
            i9 = i8;
            composer3 = composer2;
        } else {
            float f7 = 8;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m2599constructorimpl(i7), Dp.m2599constructorimpl(f7), 0.0f, Dp.m2599constructorimpl(f7), 4, null);
            i9 = i8;
            composer3 = composer2;
            PassengersInfoViewKt.PassengersInfoView(RowScope.weight$default(FlowRow, m315paddingqDBjuR0$default, 1.0f, false, 2, null), passengerInfo, composer3, 0, 0);
            Unit unit2 = Unit.INSTANCE;
        }
        composer.endReplaceGroup();
        composer3.startReplaceGroup(-74997306);
        if (this.$passengerInfo == null && this.$showDetails == null) {
            SpacerKt.Spacer(RowScope.weight$default(FlowRow, Modifier.INSTANCE, 1.0f, false, 2, null), composer3, 0);
        }
        composer.endReplaceGroup();
        Modifier.Companion companion3 = Modifier.INSTANCE;
        float f8 = 8;
        Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(companion3, Dp.m2599constructorimpl(i7), Dp.m2599constructorimpl(f8));
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        boolean z7 = this.$isEditing;
        PriceTotal priceTotal = this.$totalPrice;
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer3, 48);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, m312paddingVpY3zN4);
        ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer3.createNode(constructor2);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion4.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        if (z7) {
            composer3.startReplaceGroup(1875176547);
            stringResource = StringResources_androidKt.stringResource(R.string.priceDetails_changePrice, composer3, i9);
            composer.endReplaceGroup();
        } else {
            composer3.startReplaceGroup(1875179203);
            stringResource = StringResources_androidKt.stringResource(R.string.checkout_buttonBar_totalPrice, composer3, i9);
            composer.endReplaceGroup();
        }
        TextKt.m940Text4IGK_g(stringResource, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer, 0, 1572864, 65534);
        if (priceTotal == null) {
            composer.startReplaceGroup(-1998762781);
            TextKt.m940Text4IGK_g("-", PaddingKt.m315paddingqDBjuR0$default(companion3, Dp.m2599constructorimpl(f8), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer, 54, 1572864, 65532);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-1998521911);
            composer.startReplaceGroup(1875194347);
            Object rememberedValue = composer.rememberedValue();
            Composer.Companion companion5 = Composer.INSTANCE;
            if (rememberedValue == companion5.getEmpty()) {
                i10 = 2;
                obj2 = null;
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                composer.updateRememberedValue(rememberedValue);
            } else {
                i10 = 2;
                obj2 = null;
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            composer.endReplaceGroup();
            final int dpToPx = ComposeExtensionsKt.dpToPx(8, composer, 6);
            final String formatted$default = PriceFormatExtensionsKt.formatted$default(priceTotal, (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext()), false, false, 6, null);
            Modifier m338widthInVpY3zN4$default = SizeKt.m338widthInVpY3zN4$default(PaddingKt.m315paddingqDBjuR0$default(companion3, Dp.m2599constructorimpl(f8), 0.0f, 0.0f, 0.0f, 14, null), ComposeExtensionsKt.pxToDp(((Number) mutableState.getValue()).intValue(), composer, 0), 0.0f, i10, obj2);
            composer.startReplaceGroup(1875208210);
            boolean changed = composer.changed(dpToPx);
            Object rememberedValue2 = composer.rememberedValue();
            if (changed || rememberedValue2 == companion5.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.shared.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        Unit invoke$lambda$8$lambda$5$lambda$4;
                        invoke$lambda$8$lambda$5$lambda$4 = CheckoutButtonSheetBottomBarKt$CheckoutButtonSheetBottomBar$1$2.invoke$lambda$8$lambda$5$lambda$4(MutableState.this, dpToPx, (LayoutCoordinates) obj3);
                        return invoke$lambda$8$lambda$5$lambda$4;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(m338widthInVpY3zN4$default, (Function1) rememberedValue2);
            composer.startReplaceGroup(1875220080);
            boolean changed2 = composer.changed(formatted$default);
            Object rememberedValue3 = composer.rememberedValue();
            if (changed2 || rememberedValue3 == companion5.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.shared.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        Unit invoke$lambda$8$lambda$7$lambda$6;
                        invoke$lambda$8$lambda$7$lambda$6 = CheckoutButtonSheetBottomBarKt$CheckoutButtonSheetBottomBar$1$2.invoke$lambda$8$lambda$7$lambda$6(formatted$default, (SemanticsPropertyReceiver) obj3);
                        return invoke$lambda$8$lambda$7$lambda$6;
                    }
                };
                composer.updateRememberedValue(rememberedValue3);
            }
            composer.endReplaceGroup();
            AnimatedCounterKt.AnimatedCounter(formatted$default, SemanticsModifierKt.clearAndSetSemantics(onGloballyPositioned, (Function1) rememberedValue3), TypographyKt.getSubBold(), null, composer, 384, 8);
            composer.endReplaceGroup();
        }
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
