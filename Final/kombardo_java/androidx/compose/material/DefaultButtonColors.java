package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001b\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017¢\u0006\u0002\u0010\fJ\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/material/DefaultButtonColors;", "Landroidx/compose/material/ButtonColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledBackgroundColor", "disabledContentColor", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", BuildConfig.FLAVOR, "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DefaultButtonColors implements ButtonColors {
    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;

    public /* synthetic */ DefaultButtonColors(long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, j7, j8);
    }

    @Override // androidx.compose.material.ButtonColors
    public State<Color> backgroundColor(boolean z5, Composer composer, int i5) {
        composer.startReplaceGroup(-655254499);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-655254499, i5, -1, "androidx.compose.material.DefaultButtonColors.backgroundColor (Button.kt:587)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1481boximpl(z5 ? this.backgroundColor : this.disabledBackgroundColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return rememberUpdatedState;
    }

    @Override // androidx.compose.material.ButtonColors
    public State<Color> contentColor(boolean z5, Composer composer, int i5) {
        composer.startReplaceGroup(-2133647540);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2133647540, i5, -1, "androidx.compose.material.DefaultButtonColors.contentColor (Button.kt:592)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1481boximpl(z5 ? this.contentColor : this.disabledContentColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return rememberUpdatedState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || DefaultButtonColors.class != other.getClass()) {
            return false;
        }
        DefaultButtonColors defaultButtonColors = (DefaultButtonColors) other;
        return Color.m1487equalsimpl0(this.backgroundColor, defaultButtonColors.backgroundColor) && Color.m1487equalsimpl0(this.contentColor, defaultButtonColors.contentColor) && Color.m1487equalsimpl0(this.disabledBackgroundColor, defaultButtonColors.disabledBackgroundColor) && Color.m1487equalsimpl0(this.disabledContentColor, defaultButtonColors.disabledContentColor);
    }

    public int hashCode() {
        return (((((Color.m1493hashCodeimpl(this.backgroundColor) * 31) + Color.m1493hashCodeimpl(this.contentColor)) * 31) + Color.m1493hashCodeimpl(this.disabledBackgroundColor)) * 31) + Color.m1493hashCodeimpl(this.disabledContentColor);
    }

    private DefaultButtonColors(long j5, long j6, long j7, long j8) {
        this.backgroundColor = j5;
        this.contentColor = j6;
        this.disabledBackgroundColor = j7;
        this.disabledContentColor = j8;
    }
}
