package androidx.compose.material3;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJB\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001b\u0010\u001aR\u001d\u0010\u0005\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001d\u0010\u0006\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u001d\u0010\u0007\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/material3/TopAppBarColors;", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/Color;", "containerColor", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "<init>", "(JJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "copy-t635Npw", "(JJJJJ)Landroidx/compose/material3/TopAppBarColors;", "copy", BuildConfig.FLAVOR, "colorTransitionFraction", "containerColor-vNxB06k$material3_release", "(F)J", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "J", "getContainerColor-0d7_KjU", "()J", "getScrolledContainerColor-0d7_KjU", "getNavigationIconContentColor-0d7_KjU", "getTitleContentColor-0d7_KjU", "getActionIconContentColor-0d7_KjU", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TopAppBarColors {
    private final long actionIconContentColor;
    private final long containerColor;
    private final long navigationIconContentColor;
    private final long scrolledContainerColor;
    private final long titleContentColor;

    public /* synthetic */ TopAppBarColors(long j5, long j6, long j7, long j8, long j9, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, j7, j8, j9);
    }

    /* renamed from: containerColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m984containerColorvNxB06k$material3_release(float colorTransitionFraction) {
        return ColorKt.m1506lerpjxsXWHM(this.containerColor, this.scrolledContainerColor, EasingKt.getFastOutLinearInEasing().transform(colorTransitionFraction));
    }

    /* renamed from: copy-t635Npw, reason: not valid java name */
    public final TopAppBarColors m985copyt635Npw(long containerColor, long scrolledContainerColor, long navigationIconContentColor, long titleContentColor, long actionIconContentColor) {
        return new TopAppBarColors(containerColor != 16 ? containerColor : this.containerColor, scrolledContainerColor != 16 ? scrolledContainerColor : this.scrolledContainerColor, navigationIconContentColor != 16 ? navigationIconContentColor : this.navigationIconContentColor, titleContentColor != 16 ? titleContentColor : this.titleContentColor, actionIconContentColor != 16 ? actionIconContentColor : this.actionIconContentColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof TopAppBarColors)) {
            return false;
        }
        TopAppBarColors topAppBarColors = (TopAppBarColors) other;
        return Color.m1487equalsimpl0(this.containerColor, topAppBarColors.containerColor) && Color.m1487equalsimpl0(this.scrolledContainerColor, topAppBarColors.scrolledContainerColor) && Color.m1487equalsimpl0(this.navigationIconContentColor, topAppBarColors.navigationIconContentColor) && Color.m1487equalsimpl0(this.titleContentColor, topAppBarColors.titleContentColor) && Color.m1487equalsimpl0(this.actionIconContentColor, topAppBarColors.actionIconContentColor);
    }

    /* renamed from: getActionIconContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getActionIconContentColor() {
        return this.actionIconContentColor;
    }

    /* renamed from: getNavigationIconContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getNavigationIconContentColor() {
        return this.navigationIconContentColor;
    }

    /* renamed from: getTitleContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getTitleContentColor() {
        return this.titleContentColor;
    }

    public int hashCode() {
        return (((((((Color.m1493hashCodeimpl(this.containerColor) * 31) + Color.m1493hashCodeimpl(this.scrolledContainerColor)) * 31) + Color.m1493hashCodeimpl(this.navigationIconContentColor)) * 31) + Color.m1493hashCodeimpl(this.titleContentColor)) * 31) + Color.m1493hashCodeimpl(this.actionIconContentColor);
    }

    private TopAppBarColors(long j5, long j6, long j7, long j8, long j9) {
        this.containerColor = j5;
        this.scrolledContainerColor = j6;
        this.navigationIconContentColor = j7;
        this.titleContentColor = j8;
        this.actionIconContentColor = j9;
    }
}
