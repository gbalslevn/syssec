package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a7\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\" \u0010\u0011\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalArrangement", "Landroidx/compose/ui/Alignment$Horizontal;", "horizontalAlignment", "Landroidx/compose/ui/layout/MeasurePolicy;", "columnMeasurePolicy", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", BuildConfig.FLAVOR, "isPrioritizing", BuildConfig.FLAVOR, "mainAxisMin", "crossAxisMin", "mainAxisMax", "crossAxisMax", "Landroidx/compose/ui/unit/Constraints;", "createColumnConstraints", "(ZIIII)J", "DefaultColumnMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "getDefaultColumnMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "getDefaultColumnMeasurePolicy$annotations", "()V", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ColumnKt {
    private static final MeasurePolicy DefaultColumnMeasurePolicy = new ColumnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart());

    public static final MeasurePolicy columnMeasurePolicy(Arrangement.Vertical vertical, Alignment.Horizontal horizontal, Composer composer, int i5) {
        MeasurePolicy measurePolicy;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1089876336, i5, -1, "androidx.compose.foundation.layout.columnMeasurePolicy (Column.kt:106)");
        }
        if (Intrinsics.areEqual(vertical, Arrangement.INSTANCE.getTop()) && Intrinsics.areEqual(horizontal, Alignment.INSTANCE.getStart())) {
            composer.startReplaceGroup(345962472);
            composer.endReplaceGroup();
            measurePolicy = DefaultColumnMeasurePolicy;
        } else {
            composer.startReplaceGroup(346016319);
            boolean z5 = ((((i5 & 14) ^ 6) > 4 && composer.changed(vertical)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i5 & 48) == 32);
            Object rememberedValue = composer.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new ColumnMeasurePolicy(vertical, horizontal);
                composer.updateRememberedValue(rememberedValue);
            }
            measurePolicy = (ColumnMeasurePolicy) rememberedValue;
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return measurePolicy;
    }

    public static final long createColumnConstraints(boolean z5, int i5, int i6, int i7, int i8) {
        return !z5 ? ConstraintsKt.Constraints(i6, i8, i5, i7) : Constraints.INSTANCE.m2585fitPrioritizingHeightZbe2FdA(i6, i8, i5, i7);
    }
}
