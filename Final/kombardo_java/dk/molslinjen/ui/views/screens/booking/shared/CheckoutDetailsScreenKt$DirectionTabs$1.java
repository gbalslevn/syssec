package dk.molslinjen.ui.views.screens.booking.shared;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class CheckoutDetailsScreenKt$DirectionTabs$1 implements Function3<DepartureDirection, Composer, Integer, Unit> {
    final /* synthetic */ Function1<DepartureDirection, Unit> $changedSelectedDirection;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public CheckoutDetailsScreenKt$DirectionTabs$1(Function1<? super DepartureDirection, Unit> function1) {
        this.$changedSelectedDirection = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$1$lambda$0(Function1 function1) {
        function1.invoke(DepartureDirection.Outbound);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3$lambda$2(Function1 function1) {
        function1.invoke(DepartureDirection.Return);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(DepartureDirection departureDirection, Composer composer, Integer num) {
        invoke(departureDirection, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(DepartureDirection selectedDirection, Composer composer, int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(selectedDirection, "selectedDirection");
        if ((i5 & 6) == 0) {
            i6 = i5 | (composer.changed(selectedDirection) ? 4 : 2);
        } else {
            i6 = i5;
        }
        if ((i6 & 19) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(930891797, i6, -1, "dk.molslinjen.ui.views.screens.booking.shared.DirectionTabs.<anonymous> (CheckoutDetailsScreen.kt:242)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier defaultShadow$default = ModifierExtensionsKt.defaultShadow$default(PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(24), 0.0f, 2, null), null, 1, null);
        AppColor appColor = AppColor.INSTANCE;
        Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(defaultShadow$default, appColor.m3281getWhite0d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium());
        final Function1<DepartureDirection, Unit> function1 = this.$changedSelectedDirection;
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer, 0);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m103backgroundbw27NRU);
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
        Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
        DepartureDirection departureDirection = DepartureDirection.Outbound;
        Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(weight$default, selectedDirection == departureDirection ? appColor.m3255getBrandBlue10d7_KjU() : appColor.m3281getWhite0d7_KjU(), null, 2, null);
        composer.startReplaceGroup(1201901093);
        boolean changed = composer.changed(function1);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.shared.c
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$4$lambda$1$lambda$0;
                    invoke$lambda$4$lambda$1$lambda$0 = CheckoutDetailsScreenKt$DirectionTabs$1.invoke$lambda$4$lambda$1$lambda$0(Function1.this);
                    return invoke$lambda$4$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        float f5 = 12;
        Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(ClickableKt.m122clickableXHw0xAI$default(m104backgroundbw27NRU$default, false, null, null, (Function0) rememberedValue, 7, null), 0.0f, Dp.m2599constructorimpl(f5), 1, null);
        String stringResource = StringResources_androidKt.stringResource(R.string.departures_tab_outbound, composer, 6);
        long m3281getWhite0d7_KjU = selectedDirection == departureDirection ? appColor.m3281getWhite0d7_KjU() : appColor.m3253getBrandBlack10d7_KjU();
        TextAlign.Companion companion3 = TextAlign.INSTANCE;
        TextKt.m940Text4IGK_g(stringResource, m313paddingVpY3zN4$default, m3281getWhite0d7_KjU, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer, 0, 1572864, 65016);
        Modifier weight$default2 = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
        DepartureDirection departureDirection2 = DepartureDirection.Return;
        Modifier m104backgroundbw27NRU$default2 = BackgroundKt.m104backgroundbw27NRU$default(weight$default2, selectedDirection == departureDirection2 ? appColor.m3255getBrandBlue10d7_KjU() : appColor.m3281getWhite0d7_KjU(), null, 2, null);
        composer.startReplaceGroup(1201921571);
        boolean changed2 = composer.changed(function1);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.shared.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$4$lambda$3$lambda$2;
                    invoke$lambda$4$lambda$3$lambda$2 = CheckoutDetailsScreenKt$DirectionTabs$1.invoke$lambda$4$lambda$3$lambda$2(Function1.this);
                    return invoke$lambda$4$lambda$3$lambda$2;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        Modifier m313paddingVpY3zN4$default2 = PaddingKt.m313paddingVpY3zN4$default(ClickableKt.m122clickableXHw0xAI$default(m104backgroundbw27NRU$default2, false, null, null, (Function0) rememberedValue2, 7, null), 0.0f, Dp.m2599constructorimpl(f5), 1, null);
        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.departures_tab_returning, composer, 6), m313paddingVpY3zN4$default2, selectedDirection == departureDirection2 ? appColor.m3281getWhite0d7_KjU() : appColor.m3253getBrandBlack10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion3.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), composer, 0, 1572864, 65016);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
