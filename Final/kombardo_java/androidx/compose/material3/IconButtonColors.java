package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ8\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0003\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0004\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019R\u001d\u0010\u0005\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\u001d\u0010\u0006\u001a\u00020\u00028\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/IconButtonColors;", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/Color;", "containerColor", "contentColor", "disabledContainerColor", "disabledContentColor", "<init>", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "copy-jRlVdoo", "(JJJJ)Landroidx/compose/material3/IconButtonColors;", "copy", BuildConfig.FLAVOR, "enabled", "containerColor-vNxB06k$material3_release", "(Z)J", "contentColor-vNxB06k$material3_release", "other", "equals", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "hashCode", "()I", "J", "getContainerColor-0d7_KjU", "()J", "getContentColor-0d7_KjU", "getDisabledContainerColor-0d7_KjU", "getDisabledContentColor-0d7_KjU", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IconButtonColors {
    private final long containerColor;
    private final long contentColor;
    private final long disabledContainerColor;
    private final long disabledContentColor;

    public /* synthetic */ IconButtonColors(long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j5, j6, j7, j8);
    }

    /* renamed from: containerColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m851containerColorvNxB06k$material3_release(boolean enabled) {
        return enabled ? this.containerColor : this.disabledContainerColor;
    }

    /* renamed from: contentColor-vNxB06k$material3_release, reason: not valid java name */
    public final long m852contentColorvNxB06k$material3_release(boolean enabled) {
        return enabled ? this.contentColor : this.disabledContentColor;
    }

    /* renamed from: copy-jRlVdoo, reason: not valid java name */
    public final IconButtonColors m853copyjRlVdoo(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor) {
        return new IconButtonColors(containerColor != 16 ? containerColor : this.containerColor, contentColor != 16 ? contentColor : this.contentColor, disabledContainerColor != 16 ? disabledContainerColor : this.disabledContainerColor, disabledContentColor != 16 ? disabledContentColor : this.disabledContentColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof IconButtonColors)) {
            return false;
        }
        IconButtonColors iconButtonColors = (IconButtonColors) other;
        return Color.m1487equalsimpl0(this.containerColor, iconButtonColors.containerColor) && Color.m1487equalsimpl0(this.contentColor, iconButtonColors.contentColor) && Color.m1487equalsimpl0(this.disabledContainerColor, iconButtonColors.disabledContainerColor) && Color.m1487equalsimpl0(this.disabledContentColor, iconButtonColors.disabledContentColor);
    }

    /* renamed from: getContentColor-0d7_KjU, reason: not valid java name and from getter */
    public final long getContentColor() {
        return this.contentColor;
    }

    public int hashCode() {
        return (((((Color.m1493hashCodeimpl(this.containerColor) * 31) + Color.m1493hashCodeimpl(this.contentColor)) * 31) + Color.m1493hashCodeimpl(this.disabledContainerColor)) * 31) + Color.m1493hashCodeimpl(this.disabledContentColor);
    }

    private IconButtonColors(long j5, long j6, long j7, long j8) {
        this.containerColor = j5;
        this.contentColor = j6;
        this.disabledContainerColor = j7;
        this.disabledContentColor = j8;
    }
}
