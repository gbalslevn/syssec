package com.kizitonwose.calendar.compose;

import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0003¨\u0006\u0003"}, d2 = {"CalendarSnapLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "snapLayoutInfoProvider", "compose_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CalendarDefaultsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final SnapLayoutInfoProvider CalendarSnapLayoutInfoProvider(final SnapLayoutInfoProvider snapLayoutInfoProvider) {
        return new SnapLayoutInfoProvider() { // from class: com.kizitonwose.calendar.compose.CalendarDefaultsKt$CalendarSnapLayoutInfoProvider$1
            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateApproachOffset(float velocity, float decayOffset) {
                return 0.0f;
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float calculateSnapOffset(float velocity) {
                return SnapLayoutInfoProvider.this.calculateSnapOffset(velocity);
            }
        };
    }
}
