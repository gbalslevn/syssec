package com.kizitonwose.calendar.compose;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\bJ\r\u0010\t\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/kizitonwose/calendar/compose/CalendarDefaults;", BuildConfig.FLAVOR, "<init>", "()V", "pagedFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/FlingBehavior;", "continuousFlingBehavior", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/FlingBehavior;", "flingBehavior", "isPaged", BuildConfig.FLAVOR, "(ZLandroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/FlingBehavior;", "compose_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CalendarDefaults {
    public static final CalendarDefaults INSTANCE = new CalendarDefaults();

    private CalendarDefaults() {
    }

    private final FlingBehavior continuousFlingBehavior(Composer composer, int i5) {
        composer.startReplaceGroup(-13625824);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-13625824, i5, -1, "com.kizitonwose.calendar.compose.CalendarDefaults.continuousFlingBehavior (CalendarDefaults.kt:31)");
        }
        FlingBehavior flingBehavior = ScrollableDefaults.INSTANCE.flingBehavior(composer, ScrollableDefaults.$stable);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return flingBehavior;
    }

    private final FlingBehavior pagedFlingBehavior(LazyListState lazyListState, Composer composer, int i5) {
        composer.startReplaceGroup(1175704889);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1175704889, i5, -1, "com.kizitonwose.calendar.compose.CalendarDefaults.pagedFlingBehavior (CalendarDefaults.kt:22)");
        }
        composer.startReplaceGroup(-1237914445);
        boolean z5 = (((i5 & 14) ^ 6) > 4 && composer.changed(lazyListState)) || (i5 & 6) == 4;
        Object rememberedValue = composer.rememberedValue();
        if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = CalendarDefaultsKt.CalendarSnapLayoutInfoProvider(LazyListSnapLayoutInfoProviderKt.SnapLayoutInfoProvider(lazyListState, SnapPosition.Start.INSTANCE));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        TargetedFlingBehavior rememberSnapFlingBehavior = SnapFlingBehaviorKt.rememberSnapFlingBehavior((SnapLayoutInfoProvider) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return rememberSnapFlingBehavior;
    }

    public final FlingBehavior flingBehavior(boolean z5, LazyListState state, Composer composer, int i5) {
        FlingBehavior continuousFlingBehavior;
        Intrinsics.checkNotNullParameter(state, "state");
        composer.startReplaceGroup(1210294436);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1210294436, i5, -1, "com.kizitonwose.calendar.compose.CalendarDefaults.flingBehavior (CalendarDefaults.kt:34)");
        }
        if (z5) {
            composer.startReplaceGroup(-1333228278);
            continuousFlingBehavior = pagedFlingBehavior(state, composer, (i5 >> 3) & 126);
        } else {
            composer.startReplaceGroup(-1333227286);
            continuousFlingBehavior = continuousFlingBehavior(composer, (i5 >> 6) & 14);
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return continuousFlingBehavior;
    }
}
