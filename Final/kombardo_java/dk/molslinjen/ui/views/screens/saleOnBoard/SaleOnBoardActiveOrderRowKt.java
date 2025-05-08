package dk.molslinjen.ui.views.screens.saleOnBoard;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.RippleKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.constants.Constants;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardActiveOrderRowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a+\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a!\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0003¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\u000f\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0001\u001a\u00020\u0000H\u0003¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;", "order", "Lkotlin/Function1;", BuildConfig.FLAVOR, "showOrderDetails", "SaleOnBoardActiveOrderRow", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, Constants.IntentExtra.PushTitle, "subtitle", "TitlesView", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/runtime/MutableState;", BuildConfig.FLAVOR, "headerRowHeightPx", "HeaderRow", "(Landroidx/compose/runtime/MutableState;Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardOrder;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardActiveOrderRowKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void HeaderRow(final MutableState<Integer> mutableState, final SaleOnBoardOrder saleOnBoardOrder, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-279331957);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(mutableState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(saleOnBoardOrder) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-279331957, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.HeaderRow (SaleOnBoardActiveOrderRow.kt:215)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            startRestartGroup.startReplaceGroup(1869193670);
            boolean z5 = (i6 & 14) == 4;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: e4.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit HeaderRow$lambda$5$lambda$4;
                        HeaderRow$lambda$5$lambda$4 = SaleOnBoardActiveOrderRowKt.HeaderRow$lambda$5$lambda$4(MutableState.this, (LayoutCoordinates) obj);
                        return HeaderRow$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) rememberedValue), 0.0f, Dp.m2599constructorimpl(12), 1, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_ferry, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(22)), Color.INSTANCE.m1501getUnspecified0d7_KjU(), startRestartGroup, 3456, 0);
            String str = saleOnBoardOrder.getDeparture().getDepartureHarborName() + " - " + saleOnBoardOrder.getDeparture().getArrivalHarborName();
            float f5 = 8;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null);
            TextStyle sub = TypographyKt.getSub();
            AppColor appColor = AppColor.INSTANCE;
            TextKt.m940Text4IGK_g(str, m315paddingqDBjuR0$default, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, sub, startRestartGroup, 432, 1572864, 65528);
            float f6 = 4;
            BoxKt.Box(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.m331size3ABfNKs(ClipKt.clip(PaddingKt.m311padding3ABfNKs(companion, Dp.m2599constructorimpl(f5)), RoundedCornerShapeKt.getCircleShape()), Dp.m2599constructorimpl(f6)), appColor.m3266getGrey30d7_KjU(), null, 2, null), startRestartGroup, 0);
            TextKt.m940Text4IGK_g(LocalDateTimeExtensionsKt.toFormatWithFullMonthWithoutYear(saleOnBoardOrder.getDeparture().getDate()), null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 384, 1572864, 65530);
            BoxKt.Box(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.m331size3ABfNKs(ClipKt.clip(PaddingKt.m311padding3ABfNKs(companion, Dp.m2599constructorimpl(f5)), RoundedCornerShapeKt.getCircleShape()), Dp.m2599constructorimpl(f6)), appColor.m3266getGrey30d7_KjU(), null, 2, null), startRestartGroup, 0);
            String str2 = LocalDateTimeExtensionsKt.toFormatTime(saleOnBoardOrder.getDeparture().getDepartureTime()) + " - " + LocalDateTimeExtensionsKt.toFormatTime(saleOnBoardOrder.getDeparture().getArrivalTime());
            TextStyle sub2 = TypographyKt.getSub();
            long m3264getGrey10d7_KjU = appColor.m3264getGrey10d7_KjU();
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(str2, null, m3264getGrey10d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, sub2, composer2, 384, 1572864, 65530);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: e4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit HeaderRow$lambda$7;
                    HeaderRow$lambda$7 = SaleOnBoardActiveOrderRowKt.HeaderRow$lambda$7(MutableState.this, saleOnBoardOrder, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return HeaderRow$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderRow$lambda$5$lambda$4(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HeaderRow$lambda$7(MutableState mutableState, SaleOnBoardOrder saleOnBoardOrder, int i5, Composer composer, int i6) {
        HeaderRow(mutableState, saleOnBoardOrder, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void SaleOnBoardActiveOrderRow(final SaleOnBoardOrder order, final Function1<? super SaleOnBoardOrder, Unit> showOrderDetails, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(order, "order");
        Intrinsics.checkNotNullParameter(showOrderDetails, "showOrderDetails");
        Composer startRestartGroup = composer.startRestartGroup(507659620);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(order) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(showOrderDetails) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(507659620, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardActiveOrderRow (SaleOnBoardActiveOrderRow.kt:63)");
            }
            startRestartGroup.startReplaceGroup(-824510694);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Animatable animatable = (Animatable) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            CompositionLocalKt.CompositionLocalProvider(RippleKt.getLocalRippleConfiguration().provides(null), ComposableLambdaKt.rememberComposableLambda(2034092196, true, new SaleOnBoardActiveOrderRowKt$SaleOnBoardActiveOrderRow$1(((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope(), animatable, showOrderDetails, order), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: e4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardActiveOrderRow$lambda$1;
                    SaleOnBoardActiveOrderRow$lambda$1 = SaleOnBoardActiveOrderRowKt.SaleOnBoardActiveOrderRow$lambda$1(SaleOnBoardOrder.this, showOrderDetails, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardActiveOrderRow$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardActiveOrderRow$lambda$1(SaleOnBoardOrder saleOnBoardOrder, Function1 function1, int i5, Composer composer, int i6) {
        SaleOnBoardActiveOrderRow(saleOnBoardOrder, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TitlesView(final String str, final String str2, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-922551529);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        int i7 = i6;
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-922551529, i7, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.TitlesView (SaleOnBoardActiveOrderRow.kt:198)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(str, PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), composer2, (i7 & 14) | 48, 1572864, 65532);
            if (str2 != null) {
                TextKt.m940Text4IGK_g(str2, PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 13, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, ((i7 >> 3) & 14) | 432, 1572864, 65528);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: e4.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TitlesView$lambda$3;
                    TitlesView$lambda$3 = SaleOnBoardActiveOrderRowKt.TitlesView$lambda$3(str, str2, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TitlesView$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TitlesView$lambda$3(String str, String str2, int i5, Composer composer, int i6) {
        TitlesView(str, str2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
