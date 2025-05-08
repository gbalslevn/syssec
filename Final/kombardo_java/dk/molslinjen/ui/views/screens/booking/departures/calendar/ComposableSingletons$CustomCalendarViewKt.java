package dk.molslinjen.ui.views.screens.booking.departures.calendar;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.kizitonwose.calendar.core.CalendarMonth;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$CustomCalendarViewKt {
    public static final ComposableSingletons$CustomCalendarViewKt INSTANCE = new ComposableSingletons$CustomCalendarViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function5<ColumnScope, CalendarMonth, Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> f170lambda1 = ComposableLambdaKt.composableLambdaInstance(-6617249, false, new Function5<ColumnScope, CalendarMonth, Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.calendar.ComposableSingletons$CustomCalendarViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, CalendarMonth calendarMonth, Function2<? super Composer, ? super Integer, ? extends Unit> function2, Composer composer, Integer num) {
            invoke(columnScope, calendarMonth, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope HorizontalCalendar, CalendarMonth month, Function2<? super Composer, ? super Integer, Unit> content, Composer composer, int i5) {
            Intrinsics.checkNotNullParameter(HorizontalCalendar, "$this$HorizontalCalendar");
            Intrinsics.checkNotNullParameter(month, "month");
            Intrinsics.checkNotNullParameter(content, "content");
            if ((i5 & 384) == 0) {
                i5 |= composer.changedInstance(content) ? 256 : 128;
            }
            if ((i5 & 1153) == 1152 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-6617249, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.calendar.ComposableSingletons$CustomCalendarViewKt.lambda-1.<anonymous> (CustomCalendarView.kt:90)");
            }
            Modifier clip = ClipKt.clip(ModifierExtensionsKt.defaultShadow$default(PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m2599constructorimpl(16), 0.0f, 2, null), null, 1, null), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(8)));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, clip);
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            content.invoke(composer, Integer.valueOf((i5 >> 6) & 14));
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function5<ColumnScope, CalendarMonth, Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> m3459getLambda1$app_kombardoProd() {
        return f170lambda1;
    }
}
