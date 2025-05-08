package dk.molslinjen.ui.views.reusable.buttons;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0003\u0010\fJ\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0004\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0016¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/ui/views/reusable/buttons/BaseButtonColors;", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/Color;", "containerColor", "contentColor", "disabledContainerColor", "disabledContentColor", "<init>", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", BuildConfig.FLAVOR, "enabled", "Landroidx/compose/runtime/State;", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "J", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BaseButtonColors {
    private final long containerColor;
    private final long contentColor;
    private final long disabledContainerColor;
    private final long disabledContentColor;

    public /* synthetic */ BaseButtonColors(long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, j7, j8);
    }

    public final State<Color> containerColor(boolean z5, Composer composer, int i5) {
        composer.startReplaceGroup(-202657225);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-202657225, i5, -1, "dk.molslinjen.ui.views.reusable.buttons.BaseButtonColors.containerColor (BaseButtonColors.kt:20)");
        }
        State<Color> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m1481boximpl(z5 ? this.containerColor : this.disabledContainerColor), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return rememberUpdatedState;
    }

    public final State<Color> contentColor(boolean z5, Composer composer, int i5) {
        composer.startReplaceGroup(307644095);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(307644095, i5, -1, "dk.molslinjen.ui.views.reusable.buttons.BaseButtonColors.contentColor (BaseButtonColors.kt:26)");
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
        if (!(other instanceof BaseButtonColors)) {
            return false;
        }
        BaseButtonColors baseButtonColors = (BaseButtonColors) other;
        return Color.m1487equalsimpl0(this.containerColor, baseButtonColors.containerColor) && Color.m1487equalsimpl0(this.contentColor, baseButtonColors.contentColor) && Color.m1487equalsimpl0(this.disabledContainerColor, baseButtonColors.disabledContainerColor) && Color.m1487equalsimpl0(this.disabledContentColor, baseButtonColors.disabledContentColor);
    }

    public int hashCode() {
        return (((((Color.m1493hashCodeimpl(this.containerColor) * 31) + Color.m1493hashCodeimpl(this.contentColor)) * 31) + Color.m1493hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m1493hashCodeimpl(this.disabledContentColor);
    }

    public String toString() {
        return "BaseButtonColors(containerColor=" + Color.m1494toStringimpl(this.containerColor) + ", contentColor=" + Color.m1494toStringimpl(this.contentColor) + ", disabledContainerColor=" + Color.m1494toStringimpl(this.disabledContainerColor) + ", disabledContentColor=" + Color.m1494toStringimpl(this.disabledContentColor) + ")";
    }

    private BaseButtonColors(long j5, long j6, long j7, long j8) {
        this.containerColor = j5;
        this.contentColor = j6;
        this.disabledContainerColor = j7;
        this.disabledContentColor = j8;
    }

    public /* synthetic */ BaseButtonColors(long j5, long j6, long j7, long j8, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, (i5 & 4) != 0 ? j5 : j7, (i5 & 8) != 0 ? j6 : j8, null);
    }
}
