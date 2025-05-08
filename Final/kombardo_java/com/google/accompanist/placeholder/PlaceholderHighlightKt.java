package com.google.accompanist.placeholder;

import androidx.compose.animation.core.InfiniteRepeatableSpec;
import com.google.accompanist.placeholder.PlaceholderHighlight;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a.\u0010\t\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"Lcom/google/accompanist/placeholder/PlaceholderHighlight$Companion;", "Landroidx/compose/ui/graphics/Color;", "highlightColor", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", BuildConfig.FLAVOR, "animationSpec", "Lcom/google/accompanist/placeholder/PlaceholderHighlight;", "fade-bw27NRU", "(Lcom/google/accompanist/placeholder/PlaceholderHighlight$Companion;JLandroidx/compose/animation/core/InfiniteRepeatableSpec;)Lcom/google/accompanist/placeholder/PlaceholderHighlight;", "fade", "placeholder_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PlaceholderHighlightKt {
    @Deprecated
    /* renamed from: fade-bw27NRU, reason: not valid java name */
    public static final PlaceholderHighlight m2907fadebw27NRU(PlaceholderHighlight.Companion fade, long j5, InfiniteRepeatableSpec<Float> animationSpec) {
        Intrinsics.checkNotNullParameter(fade, "$this$fade");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        return new Fade(j5, animationSpec, null);
    }

    /* renamed from: fade-bw27NRU$default, reason: not valid java name */
    public static /* synthetic */ PlaceholderHighlight m2908fadebw27NRU$default(PlaceholderHighlight.Companion companion, long j5, InfiniteRepeatableSpec infiniteRepeatableSpec, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            infiniteRepeatableSpec = PlaceholderDefaults.INSTANCE.getFadeAnimationSpec();
        }
        return m2907fadebw27NRU(companion, j5, infiniteRepeatableSpec);
    }
}
