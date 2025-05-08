package dk.molslinjen.ui.views.screens.booking.departures.rows;

import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.buttons.IconTextButtonKt;
import dk.molslinjen.ui.views.screens.booking.departures.rows.CalendarSelectorHeaderViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a3\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lorg/threeten/bp/LocalDate;", "shownDate", "Lkotlin/Function0;", BuildConfig.FLAVOR, "showCalendar", "onOpenedDatePicker", "CalendarSelectorHeaderView", "(Lorg/threeten/bp/LocalDate;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CalendarSelectorHeaderViewKt {
    public static final void CalendarSelectorHeaderView(final LocalDate shownDate, final Function0<Unit> showCalendar, final Function0<Unit> onOpenedDatePicker, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(shownDate, "shownDate");
        Intrinsics.checkNotNullParameter(showCalendar, "showCalendar");
        Intrinsics.checkNotNullParameter(onOpenedDatePicker, "onOpenedDatePicker");
        Composer startRestartGroup = composer.startRestartGroup(-1024736209);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(shownDate) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(showCalendar) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(onOpenedDatePicker) ? 256 : 128;
        }
        int i7 = i6;
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1024736209, i7, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.CalendarSelectorHeaderView (CalendarSelectorHeaderView.kt:23)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            AppColor appColor = AppColor.INSTANCE;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(SizeKt.fillMaxHeight$default(SizeKt.m324defaultMinSizeVpY3zN4$default(BackgroundKt.m104backgroundbw27NRU$default(companion, appColor.m3281getWhite0d7_KjU(), null, 2, null), 0.0f, Dp.m2599constructorimpl(48), 1, null), 0.0f, 1, null), Dp.m2599constructorimpl(16), 0.0f, 2, null);
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
            float f5 = 8;
            TextKt.m940Text4IGK_g(LocalDateTimeExtensionsKt.toFormatWeekdayWithDate(shownDate), PaddingKt.m313paddingVpY3zN4$default(RowScope.weight$default(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null), 0.0f, Dp.m2599constructorimpl(f5), 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 0, 1572864, 65532);
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null);
            composer2 = startRestartGroup;
            composer2.startReplaceGroup(1882322209);
            boolean z5 = ((i7 & 896) == 256) | ((i7 & 112) == 32);
            Object rememberedValue = composer2.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: M2.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit CalendarSelectorHeaderView$lambda$2$lambda$1$lambda$0;
                        CalendarSelectorHeaderView$lambda$2$lambda$1$lambda$0 = CalendarSelectorHeaderViewKt.CalendarSelectorHeaderView$lambda$2$lambda$1$lambda$0(Function0.this, showCalendar);
                        return CalendarSelectorHeaderView$lambda$2$lambda$1$lambda$0;
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
            }
            composer2.endReplaceGroup();
            IconTextButtonKt.m3404IconTextButtonV9fs2A(m315paddingqDBjuR0$default, (Function0) rememberedValue, R.drawable.icon_calendar, R.string.departures_showCalendar, false, appColor.m3255getBrandBlue10d7_KjU(), composer2, 200070, 16);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: M2.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit CalendarSelectorHeaderView$lambda$3;
                    CalendarSelectorHeaderView$lambda$3 = CalendarSelectorHeaderViewKt.CalendarSelectorHeaderView$lambda$3(LocalDate.this, showCalendar, onOpenedDatePicker, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return CalendarSelectorHeaderView$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CalendarSelectorHeaderView$lambda$2$lambda$1$lambda$0(Function0 function0, Function0 function02) {
        function0.invoke();
        function02.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CalendarSelectorHeaderView$lambda$3(LocalDate localDate, Function0 function0, Function0 function02, int i5, Composer composer, int i6) {
        CalendarSelectorHeaderView(localDate, function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
